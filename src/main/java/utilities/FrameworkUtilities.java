package utilities;


import java.io.FileReader;
import java.io.IOException;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FrameworkUtilities {

	private static JsonNode payload;

	public static JsonNode setPayload(String jsonFilePath) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		payload = objectMapper.readTree(new FileReader(jsonFilePath));
		return payload;
	}


}
