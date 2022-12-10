package com.iteratrlearning.testing.answers.m7_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements Page
{
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By login = By.id("login");

    private final WebDriver webDriver;

    public LoginPage(final WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public LoginPage typeUsername(final String usernameText)
    {
        webDriver.findElement(username).sendKeys(usernameText);

        return this;
    }

    public LoginPage typePassword(final String passwordText)
    {
        webDriver.findElement(password).sendKeys(passwordText);

        return this;
    }

    public Page login()
    {
        webDriver.findElement(login).click();

        final String currentUrl = webDriver.getCurrentUrl();
        if (currentUrl.endsWith("login_fail.html"))
        {
            return new LoginFailPage(webDriver);
        }
        else if (currentUrl.endsWith("login_success.html"))
        {
            return new LoginSuccessPage(webDriver);
        }

        throw new IllegalStateException("Unknown URL: " + currentUrl);
    }
}
