import org.json.JSONObject;
import org.json.XML;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;

public class JSONtoXML {

	public static void main(String[] args) {
		String json_data = "{\"student\":{\"name\":\"Divya Kolli\", \"address\":\"330 Cescent Village Cir\"}}";
	/*	landlord data = new landlord("Divya", "Kolli", true);
		String data1 = given()
					.contentType(ContentType.JSON)
					.body(data)
					.when()
					.post("http://localhost:8080/landlords")
					.then()
					.extract().response().prettyPrint();
	*/				
		JSONObject obj = new JSONObject(json_data);
		String xml_data = XML.toString(obj);
				
		System.out.println(obj);
		System.out.println(xml_data);
	}
}
