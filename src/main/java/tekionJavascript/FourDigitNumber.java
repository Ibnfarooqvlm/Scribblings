package tekionJavascript;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class FourDigitNumber {

	public static void main(String[] args) {
		int num = 3524;		
		int index = 1;

		while(true) {
			TreeSet<Integer> treeSet = separate(num);
			int ascNum = consolidate(treeSet);
			int descNum = consolidate(new TreeSet<Integer>(treeSet.descendingSet()));
			int result = descNum - ascNum;
			System.out.println("Asc Num = " + ascNum);
			System.out.println("Desc Num = " + descNum);
			System.out.println("result Num = " + result);
			if(result == 6174)
				break;
			else
				num = result;
			index ++;
		}
		
		System.out.println(index);
	}

	public static int consolidate(TreeSet<Integer> treeSet) {
		int num = 0;
		for(Integer i : treeSet) {
			num = num*10 + i;
		}
		return num;
	}

	public static TreeSet<Integer> separate(int num){
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		String input = num + "";				
		for(int i=0; i<input.length(); i++) {
			treeSet.add(Integer.parseInt(input.charAt(i) + ""));			
		}
		return treeSet;
	}

}
