# jm04-java-testing #

Code to accompany JM04 Java Testing.

## Getting Started

Tests are build with Maven and/or in your IDE (IntelliJ IDEa; Eclipse may work).
The first time you build with Maven or Gradle or IntelliJ there will be a massive downloading, so you should
build it as soon as you can after the start of class to have the dependencies ready when you need them.

## Java Versions

_Recommended_: Java 16 or 17, but others will work too:

These tests work on a Java 8 JDK, but you'd have to change java.se.version to 1.8 in pom.xml.

They work with warnings on Java 11. The warning is about the Reflection API, used by Mockito.

	[ERROR] WARNING: An illegal reflective access operation has occurred

The last line of the warning sounds drastic (and is):

	[ERROR] WARNING: All illegal access operations will be denied in a future release

The Java team actually did that (made formerly-legal accesses fail with an error), 
so we had to update the dependencies in the _pom.xml_ file.
See Ben Evans' discussion in
https://blogs.oracle.com/post/java-17-the-drive-to-encapsulate-the-java-runtime-internals

The tests _do work with Java 16 or 17_ because we use a 
version of Mockito that works in the new world.
