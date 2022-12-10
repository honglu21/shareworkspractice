package com.iteratrlearning.testing.problems.m7_page_object;

import com.iteratrlearning.PortFinder;

import com.iteratrlearning.testing.examples.m7_page_object.LoginPage;
import com.iteratrlearning.testing.examples.m7_page_object.Page;
import com.iteratrlearning.testing.examples.m7_page_object.StaticServerResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO; refactor this example in order to extract a page object to
// model the LoginPage
// NB: you can see the page by running the StaticServer class and browsing to localhost:9090
public class LoginTest
{
    private static final WebDriver webDriver = new HtmlUnitDriver(true);

    private static final int PORT = PortFinder.findPort();
    @RegisterExtension
    static final StaticServerResource resource = new StaticServerResource(PORT);

    private LoginPage loginPage;

    @BeforeEach
    public void setUp() throws Exception
    {
        webDriver.get("http://localhost:" + PORT + "/login.html");
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void shouldLoginWithCorrectCredentials()
    {
        Page myPage = loginPage.typeUsername("Richard").typePassword("Raoul").login();

        //assertEquals(myPage, instanceOf(loginPage.getClass()));
        assertTrue(webDriver.getCurrentUrl().endsWith("login_success.html"));
    }

    @Test
    public void shouldNotLoginWithInCorrectCredentials()
    {
        loginPage.typeUsername("username");
        loginPage.typePassword("password");
        loginPage.login();

        assertTrue(webDriver.getCurrentUrl().endsWith("login_fail.html"));
    }
}
