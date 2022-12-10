package com.iteratrlearning.testing.examples.m7_page_object;

import com.iteratrlearning.PortFinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoodTodoListTest
{
    private static final WebDriver webDriver = new HtmlUnitDriver(true);

    private static final int PORT = PortFinder.findPort();
    @RegisterExtension
    static final StaticServerResource resource = new StaticServerResource(PORT);

    private TodoPage todoPage;

    @BeforeEach
    public void setUp() {
        webDriver.get("http://localhost:" + PORT + "/before.html");
        todoPage = new TodoPage(webDriver);
    }

    @Test
    public void shouldDisplayAddForm()
    {
        final WebElement add = todoPage.addButton();
        final WebElement title = todoPage.titleInput();
        final WebElement description = todoPage.descriptionInput();

        assertTrue(add.isDisplayed());
        assertTrue(title.isDisplayed());
        assertTrue(description.isDisplayed());
    }

    @Test
    public void shouldAddTodoItem()
    {
        final String titleText = "Write Test";
        final String descriptionText = "Implement the tests for this project";

        todoPage.typeTitle(titleText)
                .typeDescription(descriptionText)
                .clickAdd();

        final TodoEntry todoEntry = todoPage.getEntry(0);

        assertEquals(titleText, todoEntry.getTitleText());
        assertEquals(descriptionText, todoEntry.getDescriptionText());
    }

    @AfterEach
    public void tearDown()
    {
        // Empty
    }
}
