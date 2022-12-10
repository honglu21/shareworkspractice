package com.iteratrlearning.testing.examples.m1_junit_intro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

/**
 * Demonstrate JUnit5's approach.
 */
public class HelloWorldTest {

	String target;

	@BeforeAll
	public static void preClassInit() {
		System.out.println("HelloWorldTest.setup");
		// empty - would normally be used for factory init, etc.
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("HelloWorldTest.setup");
		target = "Hello World";
	}

	@Test
	public void testSubstring() {
		System.out.println("HelloWorldTest.testSubstring");
		assertEquals("World", target.substring(6));
	}

	@Test
	@Disabled("Un-disable to see what failure looks like")
	public void testDeliberateFailure() {
		assertEquals("one", "two", "buckle my shoe");
	}

	@AfterAll
	public static void tearDownClass() {
		System.out.println("HelloWorldTest.tearDownClass()");
	}
}
