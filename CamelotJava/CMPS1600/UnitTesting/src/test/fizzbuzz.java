package test;

public class fizzbuzz {
	public String empty;
	public String fb(int n) {
		if (n%3 == 0 && n%5 != 0) {
			return "Fizz";
		}
		if (n%5 == 0 && n%3 != 0) {
			return "Buzz";
		}
		if (n%3 == 0 && n%5 == 0) {
			return "FizzBuzz";
		}
		else {
			empty = "";
			return empty+n;
		}
	}
}
