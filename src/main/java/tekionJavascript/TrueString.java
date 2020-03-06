package tekionJavascript;

public class TrueString {

	public static void main(String[] args) {
		String input = "++d+===+c++=+a+";

		validateInput(input);
	}

	public static void validateInput(String input) {
		char prevChar = ' ';
		char thisChar = ' ';
		char nextChar = ' ';
		int i=0;
		int result = -1;
		while(i<input.length()) {
			thisChar = input.charAt(i);
			if(thisChar != '+' && thisChar != '=') {
				if(result == -1)
					result = 1;
				nextChar = ' ';
				if(i+1 < input.length()) {
					nextChar = input.charAt(i+1);
				}
				
				if(prevChar == '+' && nextChar == '+')
					result *= 1;
				else
					result *= 0;
			}
			i++;
			prevChar = thisChar;
		}
		
		if(result == 1) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}
}
