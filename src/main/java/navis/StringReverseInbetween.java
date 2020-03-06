package navis;

public class StringReverseInbetween {

	public static void main(String[] args) {
		String s = "..abc...def..ghi.jkl....";
		
		String sArr[] = s.split("[.]");
		for(int i=0;i<sArr.length;i++) {
			String before = sArr[i];
			String after = new StringBuffer(before).reverse().toString();
			s = s.replace(before, after);
		}
		
		System.out.println(s);
	}
}
