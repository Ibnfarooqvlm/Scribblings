package com.sample;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DurationSample 
{
	public static void main(String...arg)
	{
		ZonedDateTime zdtCurrent = ZonedDateTime.now();
		ZonedDateTime zdtStart = LocalDate.from(ZonedDateTime.now()).atStartOfDay(zdtCurrent.getZone());
		ZonedDateTime zdtEnd = zdtStart.plusMinutes(5);
		zdtEnd = zdtEnd.plusSeconds(6);
		zdtEnd = zdtEnd.plusHours(2);
		
		System.out.println("Start - "+zdtStart);
		System.out.println("End - "+zdtEnd);
		
		System.out.println("Hours = "+ChronoUnit.HOURS.between(zdtStart, zdtEnd));
		System.out.println("Minutes = "+ChronoUnit.MINUTES.between(zdtStart, zdtEnd));
		System.out.println("Seconds = "+ChronoUnit.SECONDS.between(zdtStart, zdtEnd));
		
	}
}
