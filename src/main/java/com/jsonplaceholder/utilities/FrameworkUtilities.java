package com.jsonplaceholder.utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FrameworkUtilities {

	private static JsonNode payload;

	public static JsonNode setPayload(String jsonFilePath) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		payload = objectMapper.readTree(new FileReader(jsonFilePath));
		return payload;
	}
	
	public static Map<String, Object> jsonToMap(JsonNode payload) {
		ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(payload, Map.class);
		return map;
	}
	
	public static JsonNode mapToJson(Map<String, Object> payload) {
		ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.convertValue(payload, JsonNode.class);
		return jsonNode;
	}


}
