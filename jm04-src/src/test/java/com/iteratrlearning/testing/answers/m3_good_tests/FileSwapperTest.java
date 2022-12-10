package com.iteratrlearning.testing.answers.m3_good_tests;

import com.iteratrlearning.testing.problems.m3_good_tests.FileSwapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSwapperTest
{
    private FileSwapper fileSwapper;
    private File left;
    private File right;

    @BeforeEach
    public void setUp() throws IOException
    {
        fileSwapper = new FileSwapper();
        left = new File("left");
        right = new File("right");
        writeLine(left, "left");
        writeLine(right, "right");
    }

    @Test
    public void shouldSwapFiles() throws IOException
    {
        fileSwapper.swapFiles(left, right);

        assertEquals("right", readLine(left));
        assertEquals("left", readLine(right));
    }

    @AfterEach
    public void tearDown() throws Exception
    {
        left.delete();
        right.delete();
    }

    private void writeLine(final File file, final String value) throws IOException
    {
        try (FileWriter writer = new FileWriter(file))
        {
            writer.write(value);
        }
    }

    private String readLine(final File file) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            return reader.readLine();
        }
    }
}
