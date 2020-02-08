package com.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamSample {

	public static void main(String... arg) {
		reduce();
	}
	
	public static void reduce() {
		List<Integer> number = Arrays.asList(2,3,4,5,5,6);
		int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)->
		{
			System.out.println("Ans = " + ans);
			System.out.println("i = " + i);
			return ans+i;	
		});
		System.out.println(even);
		
		System.out.println(number.stream().distinct().collect(Collectors.toList()));
		
		Optional<Integer> max = number.stream().max((a,b) -> a-b );
		System.out.println("Max = " + max.get());
			
	}
}
