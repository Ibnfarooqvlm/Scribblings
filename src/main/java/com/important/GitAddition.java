package com.important;

public class GitAddition {

	static String text = 
			"	src/main/java/com/api/dms/response/partsDistributeBulk/Context.java\n" + 
			"	src/main/java/com/api/dms/response/partsDistributeBulk/ErrorDetails.java\n" + 
			"	src/main/java/com/api/dms/response/partsDistributeBulk/HoldError.java\n" + 
			"	src/main/java/com/api/modules/PartsIndividualApiModules.java\n" + 
			"	src/main/resources/json/NoLookupApi.json\n" + 
			"	src/main/resources/json/PartsIndividual.json\n" + 
			"	src/test/java/com/api/testcases/PartsIndividualApiTestCases.java\n" + 
			"	testngXmls_API/PartsIndividualApi.xml\n"
			+ "modified:   src/main/java/com/api/dms/modules/PartsDistributeBulkModule.java\n" + 
			"	modified:   src/main/java/com/api/dms/modules/PartsGetAllSorModule.java\n" + 
			"	modified:   src/main/java/com/api/dms/response/partsDistributeBulk/Data.java\n" + 
			"	modified:   src/main/java/com/api/dms/response/partsGetAllSor/SorDatum.java\n" + 
			"	modified:   src/main/java/com/api/modules/NonOEMPart.java\n" + 
			"	modified:   src/main/java/com/api/modules/PartsApiModules.java\n" + 
			"	modified:   src/main/java/com/mobile/pages/Mobile_Appointments_Page.java\n" + 
			"	modified:   src/main/java/com/utilities/BaseFunctions.java\n" + 
			"	modified:   src/main/java/com/utilities/DataProviders.java\n" + 
			"	modified:   src/main/java/com/utilities/Mobile_BaseFunctions.java";

	public static void main(String...arg)
	{
		text = text.replace("both modified", "");
		text = text.replace("deleted by us", "");
		text = text.replace("deleted by them", "");
		text = text.replace("modified", "");
		text = text.replace("deleted", "");
		text = text.replace(":", "");
		text = text.replace("\t", "");
		text = text.replace(" ", "");
		text = text.replace("\n", " ");
		System.out.println("git add " + text);
	}
}