package com.iteratrlearning.testing.problems.m3_good_tests;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: 1. remove ignore
//@Disabled
public class FileSwapperTest
{
    private FileSwapper fileSwapper;
    private File left;
    private File right;

    // TODO: 2. Add an @BeforeEach method to make the test pass
    // write "left" into the left file
    // write "right" into the right file
    @BeforeEach
    public void setUp() throws IOException {
        fileSwapper = new FileSwapper();
        left = new File("left");
        right = new File("right");
        writeLine(left, "left");
        writeLine(right, "right");
    }

    // TODO: 3. Add @After to cleanup the files after the test runs
    @AfterEach
    public void tearDown() {
        left.deleteOnExit();
        right.deleteOnExit();
    }

    @Test
    public void shouldSwapFiles() throws IOException
    {
        fileSwapper.swapFiles(left, right);

        assertEquals("right", readLine(left));
        assertEquals("left", readLine(right));
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
