package com.iteratrlearning.testing.examples.m5_dependencies.before_refactor;

public class ReportRunner {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }

        SalesReport report = new SalesReport(System.out, args[0]);
        report.report();
    }

}
