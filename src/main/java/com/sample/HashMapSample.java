package com.sample;

import java.util.HashMap;

public class HashMapSample {

	public enum VEHICLE_INFO_KEYS
	{
		TAG,
		VIN,
		MILES_IN,
		CUSTOMER_RFID_TAG,
		MAKE,
		YEAR,
		MODEL,
		TRIM,
		COLOR,
		LICENSE,
		PRODUCTION_DATE,
		IN_SERVICE_DATE
	}

	public static void main(String...strings)
	{
		HashMap<VEHICLE_INFO_KEYS,String> map = new HashMap<HashMapSample.VEHICLE_INFO_KEYS, String>();
		if(map.get(VEHICLE_INFO_KEYS.TAG)==null)
			System.out.println("Null");
		else
			System.out.println(map.get(VEHICLE_INFO_KEYS.TAG));
	}
}
