import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;

public class WebServicesExam {

	@Test
	public void GET_method() throws IOException{
		SoftAssert assertion = new SoftAssert();
		
		//Getting the json
		String response =  given()
					  	  .contentType(ContentType.JSON)
					  	  //.queryParam("userId", 7)
					  	  .when()
					  	  .get("https://jsonplaceholder.typicode.com/posts")
					  	  .then()
					  	  .assertThat().statusCode(200)
					  	  .extract().response().prettyPrint();	

		//File json = new File("C:\\Users\\divya\\OneDrive\\Desktop\\Selenium\\WebServices\\posts.json");
		ObjectMapper mapper = new ObjectMapper();
		WebServicesExam_POJO[] values = mapper.readValue(response, WebServicesExam_POJO[].class);
		
		//Printing all the titles of userId : 7
		for(int i=0; i<=values.length; i++) {
			if((values[i].getUserId()).equals("7")){
				System.out.println(values[i].getTitle());
			}
			
			//Failing the test
			assertion.assertEquals(1, 2);
			assertion.assertAll();
		}
	}
}