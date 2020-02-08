package amazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonInterview2 {

	static String input = "BdcDCBb";
	static List<Character> list = new ArrayList<Character>();
	static List<Character> result = new ArrayList<Character>();
	
	public static void main(String[] args) {
		
		for(int i=0; i<input.length();i++)
			list.add(input.charAt(i));
		
		for(int i=0; i<list.size(); i++) {
			char ithChar = list.get(i);
			result.add(ithChar);
			
			int j= i+1;
			while(j<list.size()) {
				char jthChar = list.get(j);
				if(Character.toUpperCase(ithChar) == Character.toUpperCase(jthChar)) {
					result.add(jthChar);
					list.set(j, ' ');
				}
				j++;
			}
		}
		
		for(int i=0; i<result.size(); i++)
			System.out.print(result.get(i));
	}
}
