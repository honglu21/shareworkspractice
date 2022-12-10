package com.iteratrlearning.testing.examples.m7_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage implements Page
{
    private final WebDriver driver;

    private final By userName = By.id("username");
    private final By password = By.id("password");
    private final By login = By.id("login");

    public LoginPage(final WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage typeUsername(final String userNameText)
    {
        userNameInput().sendKeys(userNameText);

        return this;
    }

    public LoginPage typePassword(final String passwordText)
    {
        passwordInput().sendKeys(passwordText);

        return this;
    }

    public Page login()
    {
        loginButton().click();
        if (currentUrl().endsWith()) {
            return new LoginSuccessPage
        }

        return this;
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }


    public WebElement loginButton()
    {
        return driver.findElement(login);
    }

    public WebElement userNameInput()
    {
        return driver.findElement(userName);
    }

    public WebElement passwordInput()
    {
        return driver.findElement(password);
    }
}
