package tekionJavascript;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeepestKey {

	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) throws JsonParseException, JsonMappingException, Exception {		
		int deep = 1;
		String source = "{"
				+ "\"a\":{"
				+ "\"b\":{"
				+ "\"c\":{},"
				+ "\"d\":{\"e\":{}},"
				+ "\"f\":{\"g\":{\"h\":{}}"
				+ "}"
				+ "}"
				+ "}"
				+ "}";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readValue(source, JsonNode.class);
		traverse(jsonNode,deep);
		
		for(String key : map.keySet()) {
			System.out.println(key + " - " + map.get(key));
		}
	}
	
	public static void traverse(JsonNode jsonNode, int deep) {
		Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
		while(fields.hasNext()) {
			Entry<String, JsonNode> next = fields.next();
			String key = next.getKey();
			map.put(key, deep);
			if(next.getValue().isContainerNode());{
				JsonNode value = next.getValue();
				traverse(value,deep+1);
			}
		}
	}
}
