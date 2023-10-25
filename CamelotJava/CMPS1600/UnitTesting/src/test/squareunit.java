package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class squareunit {

	@Test
	void test() {
		unittesting obj1 = new unittesting();
		int output = obj1.square(0);
		assertEquals(0, output);
	}

	@Test
	void test2() {
		unittesting obj1 = new unittesting();
		int output = obj1.square(2);
		assertEquals(4, output);
	}

	@Test
	void test3() {
		unittesting obj1 = new unittesting();
		int output = obj1.square(12);
		assertEquals(144, output);
	}
}