import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;import sun.awt.SunHints.Value;

public class ParseJSON {
	
	@Test
	public void response() {
	Response response =  given()
						.contentType(ContentType.JSON)
						.when()
						.get("https://jsonplaceholder.typicode.com/users")
						.then()
						.extract().response();
	
	List<String> jsonResponse = response.jsonPath().getList("$");
	//List<Integer> jsonResponse = response.jsonPath().getList("$");
	//System.out.println(jsonResponse.get(2));
	
	String jsonResponse_names = response.jsonPath().getString("name");
	
	//all ID's from JSON
	String jsonResponse_ids = response.jsonPath().getString("id");
	
	//particular ID from JSON
	String jsonResponse_Particualr_id = response.jsonPath().getString("[0].id");
	
	String jsonResponse_address = response.jsonPath().getString("[0].address");
	
	System.out.println(jsonResponse);
	System.out.println(jsonResponse.size());
	System.out.println(jsonResponse_names);
	System.out.println(jsonResponse_ids);
	System.out.println(jsonResponse_Particualr_id);
	System.out.println(jsonResponse_address);
	}
}
