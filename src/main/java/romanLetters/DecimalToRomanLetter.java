package romanLetters;

import java.util.Scanner;

public class DecimalToRomanLetter {

	int decimal;
	String roman;
	public static void main(String[] args) {
		DecimalToRomanLetter decimalToRomanLetter = new DecimalToRomanLetter();
		decimalToRomanLetter.input();
		decimalToRomanLetter.process();
		decimalToRomanLetter.output();
	}
	
	public void input() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter Decimal:");
			decimal = scanner.nextInt();
			scanner.nextLine();
		}catch(Throwable t) {
			throw t;
		}finally {
			scanner.close();
		}
	}
	
	public void output() {
		System.out.println("The roman letter of " + decimal + " is : " + roman);
	}
	
	public void process() {
		int temp = decimal;
		int position = 0;
		roman = "";
		while(temp > 0) {
			int digit = temp%10;
			int tens = (int) Math.pow(10, position);
			
			roman = getRoman(digit,tens) + roman;
			temp = temp/10;
			position++;
		}
	}
	
	public String getRoman(int digit,int tens) {
		switch(digit) {
		case 1:
			switch(tens) {
			case 1:
				return "I";
			case 10:
				return "X";
			case 100:
				return "C";
			case 1000:
				return "M";
			}
			
		case 2:
			switch(tens) {
			case 1:
				return "II";
			case 10:
				return "XX";
			case 100:
				return "CC";
			case 1000:
				return "MM";
			}
			
		case 3:
			switch(tens) {
			case 1:
				return "III";
			case 10:
				return "XXX";
			case 100:
				return "CCC";
			case 1000:
				return "MMM";
			}
			
		case 4:
			switch(tens) {
			case 1:
				return "IV";
			case 10:
				return "XL";
			case 100:
				return "CD";			
			}
			
		case 5:
			switch(tens) {
			case 1:
				return "V";
			case 10:
				return "L";
			case 100:
				return "D";			
			}
			
		case 6:
			switch(tens) {
			case 1:
				return "VI";
			case 10:
				return "LX";
			case 100:
				return "DC";			
			}
			
		case 7:
			switch(tens) {
			case 1:
				return "VII";
			case 10:
				return "LXX";
			case 100:
				return "DCC";			
			}
			
		case 8:
			switch(tens) {
			case 1:
				return "VIII";
			case 10:
				return "LXXX";
			case 100:
				return "DCCC";			
			}
			
		case 9:
			switch(tens) {
			case 1:
				return "IX";
			case 10:
				return "XC";
			case 100:
				return "CM";			
			}
		}
		return "";
	}	
}
