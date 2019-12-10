package interview;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;
import java.util.Comparator;

public class Interview2 {

	public String s = "acBDbcAD";
	//output aAccBbDD
	
	public static void main(String...arg)
	{
		
		Interview2 n=new Interview2();
		int l1	=n.s.length();
		char[] c=n.s.toCharArray();
		//Arrays.sort(c);
		//System.out.println(c.toString());
		StringBuffer sb=new StringBuffer(l1);
		for(int i=0;i<l1-1;i++)
		{
			char n1=c[i];
			//int c1=0;
			for(int j=0;j<l1;j++)
			{
				//Object ;
				if(n1==c[j])
				{
					sb.append(c[j]);
				}
				else if(n1==c[j])
				{
					
					  					
				}
			}
			System.out.println(sb.toString());
			
		}
	}
}
