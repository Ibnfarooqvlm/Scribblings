package com.sample;

public class SearchText {

	public static void main(String[] args) {
		String searchText = "CR-~!@#$%^&*() {}|:?><'2432V";
		searchText = searchText.replaceAll("[^\\d\\sA-Za-z]", " ");
		System.out.println(searchText);
	}
}
