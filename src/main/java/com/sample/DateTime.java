package com.sample;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dateTime = "February 28, 2019";
		String pattern = "MMMM dd, yyyy";
		String dateTimeModified = formatZonedDateTime(getDateTimeFromCurrentTimeZone(), pattern);
		System.out.println(dateTimeModified);
	}

	public static String formatZonedDateTime(ZonedDateTime objZonedDateTime,String pattern)
	{
		String dateTime = null;
		try {
		dateTime = objZonedDateTime.format(DateTimeFormatter.ofPattern(pattern));
		}catch(Exception ex)
		{}
		return dateTime;
	}
	
	public static ZonedDateTime getDateTimeFromCurrentTimeZone()
	{
		ZonedDateTime zoneNow = ZonedDateTime.now(TimeZone.getTimeZone("UTC").toZoneId());
		return zoneNow;
	}
}
