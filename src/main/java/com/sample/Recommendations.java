package com.sample;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Recommendations {

	public static void main(String...arg)
	{
		String label = "Recommendation Mobile  $49 $12.12 SHAMPOO Labor+Parts+Misc Add to cart";
		String[] labels = label.split("\\s+");
		String addToCart = labels[labels.length-3] + " " + labels[labels.length-2] + " " + labels[labels.length-1];
		String type = labels[labels.length-4];
		String opcode = labels[labels.length-5];
		String offerPrice = labels[labels.length-6];
		String originalPrice = labels[labels.length-7];
		String desc = "";
		for(int i=0;i<labels.length-7;i++)
			desc += labels[i] +" ";
		System.out.println();
	}
}
