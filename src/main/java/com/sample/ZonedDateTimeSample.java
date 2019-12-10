package com.sample;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSample {

	public static void main(String...arg)
	{
		/*String dateTime = "Tuesday, June 25, 2019";
		String pattern = "EEEE, MMMM dd, yyyy";*/
		String dateTime =  "Tuesday, June 25, 2019 00:00:00 am";
		String pattern = "EEEE, MMMM dd, yyyy hh:mm:ss a";
		LocalDateTime objLocalDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
		ZonedDateTime objZonedDateTime = objLocalDateTime.atZone(ZoneId.of("UTC"));
		System.out.println(objZonedDateTime);
		System.out.println(objZonedDateTime.toLocalDate().atStartOfDay(ZoneId.of("UTC")));
	}
}
