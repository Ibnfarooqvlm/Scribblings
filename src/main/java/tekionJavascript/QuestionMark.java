package tekionJavascript;

public class QuestionMark {

	public static void main(String[] args) {
		String input = "arrb6???3xxbl5??eee5";

		questionMark(input);
	}

	public static void questionMark(String input) {
		int i = 0;
		int prevInt = -1;
		int thisInt = -1;
		int questionMarkCount = 0;
		boolean status = false;
		while(i < input.length()) {
			if(Character.isDigit(input.charAt(i))) {
				thisInt = Integer.parseInt(input.charAt(i)+"");

				if(questionMarkCount >= 3) {
					questionMarkCount =0;
					if(prevInt + thisInt >= 10) {
						status = true;
						break;
					}
				}				
			}
			if(prevInt != -1 && input.charAt(i) == '?') {
				questionMarkCount++;
			}

			i++;
			prevInt = thisInt;
		}

		System.out.println(status);
	}
}
