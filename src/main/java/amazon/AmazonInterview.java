package amazon;

public class AmazonInterview
{
	public static void main(String[] args) {

		String input = "bcBDcdCb";
		StringBuffer sb = new StringBuffer(input);
		
		int i=0;
		while(i<sb.length()){

			char base = sb.charAt(i);
			int j = i+1;		

			if(j == sb.length())
				break;

			while(j < sb.length()-1){
				char first = sb.charAt(j);
				boolean flag = false;

				if(Character.toUpperCase(base) == Character.toUpperCase(first))
					flag = true;
				else {
					int k = j+1;				
					while(k < sb.length()) {
						char second = sb.charAt(k);

						if(Character.toUpperCase(base) == Character.toUpperCase(second)) {
							swap(sb,j,k);
							flag = true;
							break;
						}
						k++;
					}
				}

				if(flag)
					j++;
				else
					break;
			}

			i++;
		}
		
		System.out.println(sb);

	}

	public static void swap(StringBuffer sb, int x, int y) {
		
		char charX = sb.charAt(x);
		char charY = sb.charAt(y);
		sb.setCharAt(x, charY);
		sb.setCharAt(y, charX);
		/*String result = "";
		for(int i=0; i<sb.length(); i++){
			if(i == x)
				result += charY;
			else if(i == y)
				result += charX;
			else
				result += sb.charAt(i);
		}

		return result;*/
	}
}
