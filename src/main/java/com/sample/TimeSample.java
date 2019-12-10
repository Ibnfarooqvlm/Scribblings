package com.sample;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeSample {

	public static void main(String...arg)
	{
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.getNano()/1000);
		try {
			Thread.sleep(1540);
		}catch(Exception ex) {}
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println(ChronoUnit.MILLIS.between(ldt, ldt2));
		System.out.println(ChronoUnit.NANOS.between(ldt, ldt2));
	}
}
