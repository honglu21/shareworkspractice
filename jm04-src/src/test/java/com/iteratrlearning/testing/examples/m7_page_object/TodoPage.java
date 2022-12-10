package com.iteratrlearning.testing.examples.m7_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodoPage
{
    private final WebDriver driver;

    private final By p = By.tagName("p");
    private final By title = By.id("title");
    private final By description = By.id("description");
    private final By add = By.id("add");

    public TodoPage(final WebDriver driver)
    {
        this.driver = driver;
    }

    public TodoPage typeTitle(final String titleText)
    {
        titleInput().sendKeys(titleText);

        return this;
    }

    public TodoPage typeDescription(final String descriptionText)
    {
        descriptionInput().sendKeys(descriptionText);

        return this;
    }

    public TodoPage clickAdd()
    {
        addButton().click();

        return this;
    }

    public TodoEntry getEntry(final int index)
    {
        return new TodoEntry(driver.findElements(p), index);
    }

    public WebElement addButton()
    {
        return driver.findElement(add);
    }

    public WebElement titleInput()
    {
        return driver.findElement(title);
    }

    public WebElement descriptionInput()
    {
        return driver.findElement(description);
    }
}
