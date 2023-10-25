package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class fizztest {

	@Test
	void test() {
		fizzbuzz obj1 = new fizzbuzz();
		String output = obj1.fb(3);
		assertEquals("Fizz", output);
	}
	@Test
	void test2() {
		fizzbuzz obj1 = new fizzbuzz();
		String output = obj1.fb(5);
		assertEquals("Buzz", output);
	}
	@Test
	void test3() {
		fizzbuzz obj1 = new fizzbuzz();
		String output = obj1.fb(15);
		assertEquals("FizzBuzz", output);
	}
	@Test
	void test4() {
		fizzbuzz obj1 = new fizzbuzz();
		String output = obj1.fb(7);
		assertEquals("7", output);
	}
}
