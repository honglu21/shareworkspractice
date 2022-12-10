package com.iteratrlearning.testing.problems.m3_good_tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSwapper
{
    private final Path tempPath;

    public FileSwapper()
    {
        tempPath = Paths.get(System.getProperty("java.io.tmpdir"), "fileSwapper");
        if (Files.exists(tempPath))
        {
            throw new IllegalStateException("Unable to start: " + tempPath + " in use");
        }
    }

    public void swapFiles(final File left, final File right) throws IOException
    {
        final Path leftPath = Paths.get(left.getAbsolutePath());
        final Path rightPath = Paths.get(right.getAbsolutePath());

        Files.move(leftPath, tempPath);
        Files.move(rightPath, leftPath);
        Files.move(tempPath, rightPath);
    }
}
