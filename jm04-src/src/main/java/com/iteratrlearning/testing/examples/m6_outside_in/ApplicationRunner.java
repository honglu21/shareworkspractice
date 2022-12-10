package com.iteratrlearning.testing.examples.m6_outside_in;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ApplicationRunner
{
    public String run(String... arguments)
    {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(byteStream);
        SalesReportRunner.run(output, arguments);
        try
        {
            return byteStream.toString("UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
