package com.sample;

public class NullSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//throw new NullPointerException("No VINs available");
			throw new NullPointerException();
		}catch(NullPointerException ne)
		{
			System.out.println(ne.getMessage());
			String msg = ne.getMessage()+"";
			if(msg.toLowerCase().equals("No VINs available".toLowerCase()))
				System.out.println("retry");
			else
				throw ne;
		}
	}

}
