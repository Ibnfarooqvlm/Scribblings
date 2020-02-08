package romanLetters;

import java.util.Scanner;

public class RomanLetterToDecimal {

	String romanLetter;
	int decimal;

	public void input() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter Roman Letter:");
			romanLetter = scanner.nextLine();
		}catch(Throwable t) {
			throw t;
		}finally {
			scanner.close();
		}
	}

	public void process() {		
		decimal = 0;
		int i=0;
		String thisChar = "";
		int thisCharValue = 0;
		int previousCharValue = 0;
		while(i<romanLetter.length()) {
			thisChar = romanLetter.charAt(i)+"";
			thisCharValue = getValue(thisChar);			
			if(previousCharValue < thisCharValue)
				decimal += thisCharValue - previousCharValue - previousCharValue;
			else
				decimal += thisCharValue;
			previousCharValue = thisCharValue;
			i++;
		}		
	}

	public int getValue(String c) {
		switch(c.toUpperCase()) {
		case "I":
			return 1;
		case "X":
			return 10;
		case "L":
			return 50;
		case "C":
			return 100;
		case "D":
			return 500;
		case "M":
			return 1000;
		default:
			return 0;
		}
	}

	public void output() {
		System.out.println(decimal);
	}

	public static void main(String[] args) {
		RomanLetterToDecimal romanLetterToDecimal = new RomanLetterToDecimal();
		romanLetterToDecimal.input();
		romanLetterToDecimal.process();
		romanLetterToDecimal.output();
	}
}
