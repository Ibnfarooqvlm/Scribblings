package com.sample;

public class HamburgerValidation {

	String hamburgerText = "Temp Temp Add Customer Notes Update Customer Info 2018 Ford C-Max Hybrid Copy VIN - 1FADP5AU7JL102641 Service History - 1FADP5AU7JL102641 Current Mileage - 1814 Service Advisor - Service 1 Advisor 1";
	
	public static void main(String...arg)
	{
		String text1 = "Current Mileage - 100";
		String label = "Howell Muller Add Customer Notes Update Customer Info 2018 Ford Escape Copy VIN - 1FMCU0F70JUB14673 Service History - 1FMCU0F70JUB14673 Current Mileage - 100 Service Advisor - Service 1 Advisor 1";
		
		if(label.contains(text1))
			System.out.println("contains");
	}
}
