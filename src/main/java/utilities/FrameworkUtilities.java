package utilities;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FrameworkUtilities {

	private static JsonNode payload;

	public static JsonNode setPayload(String jsonFilePath) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		payload = objectMapper.readTree(new File(jsonFilePath));
		return payload;
	}


}
