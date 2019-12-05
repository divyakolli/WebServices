import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class ReadJSON {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser parser = new JSONParser();

		Reader reader = new FileReader("C:\\Users\\divya\\OneDrive\\Desktop\\Selenium\\WebServices\\owner.json");

		/*A JSONObject constructor can be used to convert an external form JSON text 
		 * into an internal form whose values can be retrieved with the get and opt 
		 * methods, or to convert values into a JSON text using the put and toString methods.
		*/
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		System.out.println(jsonObject);

		String firstName = (String) jsonObject.get("firstName");
		System.out.println(firstName);
		
		String lastName = (String) jsonObject.get("lastName");
		System.out.println(lastName);
		
		String age = (String) jsonObject.get("age");
		System.out.println(age);
		
		// loop array
        JSONArray msg = (JSONArray) jsonObject.get("messages");
        for(int i=0; i<msg.size(); i++) {
        	System.out.println(msg.get(i));
        }
	}
}
