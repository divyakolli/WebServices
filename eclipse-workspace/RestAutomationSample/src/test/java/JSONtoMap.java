import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONtoMap {
	public static void main(String[] args) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		//By using string
		//String json = "{\"firstName\":\"Divya\", \"lastName\":\"Kolli\"}";

		//By using Json file
		File json = new File("C:\\Users\\divya\\Downloads\\map.json");
		
		// convert JSON string to Map.
		//We use mapper.readValue(json, HashMap.class) to convert a json string to a HashMap
		HashMap<String, String> Hashmap = mapper.readValue(json, HashMap.class);

		System.out.println(Hashmap);
		System.out.println("First name is : " + Hashmap.get("firstName"));
		System.out.println("Last name is : " + Hashmap.get("lastName"));
	}
}
