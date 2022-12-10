package com.iteratrlearning.testing.examples.m7_page_object;

import org.openqa.selenium.WebElement;

import java.util.List;

public class TodoEntry
{
    private final WebElement title;
    private final WebElement description;

    public TodoEntry(final List<WebElement> elements, final int index)
    {
        final int pIndex = index * 2;
        title = elements.get(pIndex);
        description = elements.get(pIndex + 1);
    }

    public String getTitleText()
    {
        return title.getText();
    }

    public String getDescriptionText()
    {
        return description.getText();
    }
}
