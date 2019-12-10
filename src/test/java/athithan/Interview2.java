package athithan;

public class Interview2 {

	String all = "All(10)";
	String my = "My(6)";
	
	public static void main(String...arg)
	{
		Interview2 a=new  Interview2();
		String sample=a.all.substring(a.all.indexOf("("),a.all.length()).replace(")"	, "").replace("(", "")	;
		System.out.println(sample);
		String sample2=a.my.substring(a.my.indexOf("("),a.my.length()).replace(")"	, "").replace("(", "")	;;
		System.out.println(sample2);
		int result=Integer.parseInt(sample)-Integer.parseInt(sample2);
		System.out.println(result);
	}
}
