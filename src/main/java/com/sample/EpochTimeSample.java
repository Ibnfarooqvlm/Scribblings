package com.sample;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EpochTimeSample {

	public static void main(String...arg)
	{
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime zdt = ldt.atZone(ZoneId.of("Asia/Kolkata"));
		ZonedDateTime zdtUtc = zdt.withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println(zdt);
		System.out.println(zdt.toLocalDate().atStartOfDay(zdt.getZone()));
		System.out.println(Instant.from(zdt.toLocalDate().atStartOfDay(ZoneId.of("UTC"))).toEpochMilli());
		System.out.println(zdt.toLocalDate().atStartOfDay(zdt.getZone()).minusNanos(1));
		System.out.println(Instant.from(zdt.toLocalDate().atStartOfDay(zdtUtc.getZone()).minusNanos(1)).toEpochMilli());
		System.out.println(zdtUtc);
		
		//long l = Instant.from(zdtUtc).toEpochMilli();
		long l1 = 1561334400000l;
		long l2 = 1561420799999l;
		ZonedDateTime zdtInstant1 = Instant.ofEpochMilli(l1).atZone(ZoneId.of("UTC"));
		ZonedDateTime zdtInstant3 = zdtInstant1.plusDays(1).minusNanos(1);
		ZonedDateTime zdtInstant2 = Instant.ofEpochMilli(l2).atZone(ZoneId.of("UTC"));
		System.out.println(zdtInstant1);
		System.out.println(zdtInstant2);
		System.out.println(zdtInstant3);
		zdtInstant3 = zdtInstant3.toLocalDate().atStartOfDay(zdtInstant3.getZone());
		System.out.println(zdtInstant3);
		System.out.println(Instant.from(zdtInstant3).toEpochMilli());
		
	}
}
