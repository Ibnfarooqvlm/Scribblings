package com.sample;

import java.text.DecimalFormat;

public class MoneyToDouble {

	static DecimalFormat format = new DecimalFormat("#.00");
	
	public static void main(String...arg)
	{
		String strMoney = "$ 87.50";
		System.out.println(format.format(convertMoneyToDouble(strMoney)));
	}
	
	public static double convertMoneyToDouble(String strMoney)
	{
		double d = -1;
		try {
			strMoney = strMoney.replace("$", "").trim();
			strMoney = strMoney.replace(",","").trim();
			d = Double.parseDouble(format.format(Double.parseDouble(strMoney)));
		}catch(NumberFormatException ne)
		{
			//can be ignored as -1 will be sent.
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return d;
	}
}
