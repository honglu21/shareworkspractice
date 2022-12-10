package com.iteratrlearning.testing.answers.m7_page_object;

import com.iteratrlearning.PortFinder;
import com.iteratrlearning.testing.examples.m7_page_object.StaticServerResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class LoginTest
{
    private static final WebDriver webDriver = new HtmlUnitDriver(true);

    private static final int PORT = PortFinder.findPort();
    @RegisterExtension
    static final StaticServerResource resource = new StaticServerResource(PORT);

    private LoginPage loginPage;

    @BeforeEach
    public void setUp()
    {
        webDriver.get("http://localhost:" + PORT + "/login.html");
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void shouldLoginWithCorrectCredentials()
    {
        final Page nextPage =
            loginPage.typeUsername("Richard")
                     .typePassword("Raoul")
                     .login();

        assertThat(nextPage, instanceOf(LoginSuccessPage.class));
    }

    @Test
    public void shouldNotLoginWithInCorrectCredentials()
    {
        final Page nextPage =
                loginPage.typeUsername("username")
                         .typePassword("password")
                         .login();

        assertThat(nextPage, instanceOf(LoginFailPage.class));
    }
}
