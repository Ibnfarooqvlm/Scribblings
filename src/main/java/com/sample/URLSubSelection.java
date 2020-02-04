package com.sample;

public class URLSubSelection {

	public static void main(String[] args) {
		String url = "https://xyz-tekioncloud-dms-stage.s3.us-west-1.amazonaws.com/af633813-b24f-4c6c-8e7b-a2a86751d369/2477_1580302563699.pdf?X-Amz-Security-Token=FwoGZXIvYXdzEE4aDJS2kL5RcB67JcmJwCLWATk1V9Z6L%2Fep9UAHwNNadfkyDhCWWMaZflEE9MmGahUk5hc9Sa1y81gvTq%2FTgGQN5f%2BdQQ9wwYReoiZjIYUsNyRgp1QDUROa7zSIggovAZNTFDBEpSuuEDOL2tC1BtNfdznFhx91HpV5PQ1wb4A8kVPhSw41UyKh8axvvAwv9jlF0Qz1RcfWI5Je8VL7s3XY8nVL%2BoZLOTTMGVQYGvvwG90aKpRB0mUoF05aAZxxhP79uWnWyaMNNojUZ0K3nkIpwF9lcjTyU%2BG4uVGGTMTpAe5GYfDVz18o7YHG8QUyKcJMBqS6sIlSGMBQ4whSCIASqv32UaZ081qfubD1j0vRJMOdKCIMJ9Fl&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200129T125613Z&X-Amz-SignedHeaders=host&X-Amz-Expires=900&X-Amz-Credential=ASIARTX6TDNMB3ZB4L25%2F20200129%2Fus-west-1%2Fs3%2Faws4_request&X-Amz-Signature=244ab683ad18f0bcd8f1debdaadfd38c1e60d22df4b893f41c85d0a4242320c2";
		
		int pdfIndex = url.indexOf(".pdf");
		url = url.substring(0, pdfIndex);
		int slashIndex = url.lastIndexOf("/");
		String fileName = url.substring(slashIndex+1)+".pdf";
		System.out.println(fileName);
	}
}
