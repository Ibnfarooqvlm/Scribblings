package com.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonSample {

	public static void main(String[] args) throws Throwable {
		String resStrBody = "{\n" + 
				"    \"data\": {\n" + 
				"        \"5cc080572eb406a8b479b153\": \"https://xyz-tekioncloud-dms-stage.s3.us-west-1.amazonaws.com/cacargroup/20/5bacefd4-70f5-4f2d-9b30-cada9d13e390/9e87780e-18d9-4bcc-872a-2c2379a119f7.zpl?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200130T050329Z&X-Amz-SignedHeaders=host&X-Amz-Expires=900&X-Amz-Credential=AKIARTX6TDNMFLJIMMNQ%2F20200130%2Fus-west-1%2Fs3%2Faws4_request&X-Amz-Signature=bec5e8f94676a5e72de79843b5bf7f5cb6bc0643f337881a4c3ebe7931e9ba03\"\n" + 
				"    },\n" + 
				"    \"status\": \"success\"\n" + 
				"}";

		JsonNode node  = new ObjectMapper().readValue(resStrBody, JsonNode.class);
		JsonNode statusNode = node.get("status");			
		String status = statusNode.asText();
		System.out.println("status - " + status);
		JsonNode dataNode = node.get("data");
		Iterator<Entry<String, JsonNode>> fields = dataNode.fields();
		while(fields.hasNext()) {
			Entry<String, JsonNode> entry = fields.next();
			System.out.println("key " + entry.getKey());
			System.out.println("value " + entry.getValue());
		}
	}
}
