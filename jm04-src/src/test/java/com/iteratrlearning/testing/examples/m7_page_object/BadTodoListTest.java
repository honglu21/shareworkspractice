package com.iteratrlearning.testing.examples.m7_page_object;

import com.iteratrlearning.PortFinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: 1. Show the before.html and after.html pages in the web browser
// TODO: refactor the test to use the after.html page and show the difficulty of
// Changing it.
// TODO: 2. refactor to be like the GoodTodoListTest
public class BadTodoListTest
{
    private static final WebDriver webDriver = new HtmlUnitDriver(true);

    private static final int PORT = PortFinder.findPort();
    @RegisterExtension
    static final StaticServerResource resource = new StaticServerResource(PORT);

    @BeforeEach
    public void setUp()
    {
        webDriver.get("http://localhost:" + PORT + "/before.html");
    }

    @Test
    public void shouldDisplayAddForm()
    {
        final List<WebElement> inputs = webDriver.findElements(By.tagName("input"));
        final WebElement add = inputs.get(0);
        final WebElement title = inputs.get(1);
        final WebElement description = inputs.get(2);

        assertTrue(add.isDisplayed());
        assertTrue(title.isDisplayed());
        assertTrue(description.isDisplayed());
    }

    @Test
    public void shouldAddTodoItem()
    {
        final List<WebElement> inputs = webDriver.findElements(By.tagName("input"));
        final WebElement add = inputs.get(0);
        final WebElement title = inputs.get(1);
        final WebElement description = inputs.get(2);

        final String titleText = "Write Test";
        final String descriptionText = "Implement the tests for this project";

        title.sendKeys(titleText);
        description.sendKeys(descriptionText);
        add.click();

        final List<WebElement> entries = webDriver.findElements(By.tagName("p"));
        final WebElement titleEntry = entries.get(0);
        final WebElement descriptionEntry = entries.get(1);

        assertEquals(titleText, titleEntry.getText());
        assertEquals(descriptionText, descriptionEntry.getText());
    }

    @AfterEach
    public void tearDown()
    {
        // Empty
    }
}
