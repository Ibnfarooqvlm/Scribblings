package com.sample;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

public class RandomGender {

	public static String getGender()
	{
		String[] genderArray = {"Male","Female","Other"};
		int n = new Random().nextInt(3);
		return genderArray[n];
	}

	public static void main(String...arg)
	{
		System.out.println(getBirthdayDate(16));
	}

	public static String getColor()
	{
		String color = new Faker().color().name();
		return color;
	}

	public static ZonedDateTime getBirthdayDate(int age)
	{
		DateAndTime dateTime = new Faker().date();
		Date objDate = dateTime.birthday(age+1,age+1);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(objDate);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int year = calendar.get(Calendar.YEAR);
		ZonedDateTime zdt = parseDateTimeToUTCTimeZone(date + "-" + (month+1) + "-" + year + " | " + "00:00:00 am", "d-M-yyyy | hh:mm:ss a");
		return zdt;
	}

	public static ZonedDateTime parseDateTimeToUTCTimeZone(String dateTime,String pattern)
	{
		try {
			dateTime = dateTime.replace("AM", "am");
			dateTime = dateTime.replace("PM", "pm");
			LocalDateTime objLocalDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
			System.out.println(objLocalDateTime);
			ZonedDateTime objZonedDateTime = objLocalDateTime.atZone(ZoneId.of(ZoneOffset.UTC.getId()));
			return objZonedDateTime;
		}catch(Exception ex)
		{
			return null;
		}
	}

	public static LocalDateTime convertCalendarToLocalDateTime(Calendar calendar)
	{
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int year = calendar.get(Calendar.YEAR);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		String am_pm = "";
		if(calendar.get(Calendar.AM_PM) == 0)
			am_pm = "am";
		else
			am_pm = "pm";
		LocalDateTime objLocalDateTime = LocalDateTime.parse(date + "-" + (month+1) + "-" + year + " | " + hour + ":" + minute + ":" + sec + " " + am_pm , DateTimeFormatter.ofPattern("d-M-yyyy | h:m:s a"));
		return objLocalDateTime;
	}

	public static String getState()
	{
		Faker faker = new Faker(new Locale("en-US"));
		String state = faker.address().state();
		return state;
	}

	public static String getStreetAddress()
	{
		Faker faker = new Faker(new Locale("en-US"));
		String streetAddress = faker.address().streetAddress();
		return streetAddress;
	}

}
