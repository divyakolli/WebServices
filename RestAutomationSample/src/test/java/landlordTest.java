import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;

public class landlordTest{
/*
 	//Dependencies - rest-assured, hamcrest, jackson-databind and TestNG
 
 	given()
 		-Request body
 		-Parameters
 		-Headers
 		-authentication
	when()
		-GET,POST,PUT,DELETE
	then()
		-Validation - status codes, respense body, hamcrest matchers
		
		
	This whole three methods are called gerkins structure
*/
/*	@Test(priority=1)
	public void GET_Landlord() {
	given()
	.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:8080/landlords")
	.then()
	.extract().response().prettyPrint();
	}
	
	@Test(priority=2)
	public void POST_landlord() {
		landlord input1 = new landlord("Divya", "Kolli", true);
		String str = given()
					 .contentType(ContentType.JSON)
					 .body(input1)
					 .when()
					 .post("http://localhost:8080/landlords")
					 .then()
					 .statusCode(201)
					 .extract().response().body().prettyPrint();
		
		JsonPath path = new JsonPath(str);
		String ID = path.getString("id");
		System.out.println(ID);
		
		given()
		.pathParam("id",ID)
		.when()
		.get("http://localhost:8080/landlords/{id}")
		.then()
		.extract().response().body().prettyPrint();
		
		given()
		 .contentType(ContentType.JSON)
		 .pathParam("id",ID)
		 .when()
		 .post("http://localhost:8080/landlords/{id}")
		 .then()
		 .extract().response().body().prettyPrint();
	}
	
	@Test(priority=3)
	public void PUT_landlord() {
		//landlord input = new landlord("Divya", "Kolli", true);
		String str = given()
					 .contentType(ContentType.JSON)
					 //.body(input)
					 .when()
					 .get("http://localhost:8080/landlords")
					 .then()
					 .statusCode(200)
					 .extract().response().body().prettyPrint();
		
		JsonPath path = new JsonPath(str);
		String ID = path.getString("[0].id");
		System.out.println(ID);
		
		landlord input1 = new landlord("Div", "Kolli", true);
		given()
		.contentType(ContentType.JSON)
		.body(input1)
		.pathParam("id",ID)
		.when()
		.put("http://localhost:8080/landlords/{id}")
		.then()
		.statusCode(200)
		.extract().response().body().prettyPrint();
		
		given()
		.contentType(ContentType.JSON)
		.pathParam("id",ID)
		.when()
		.get("http://localhost:8080/landlords/{id}")
		.then()
		.extract().response().body().prettyPrint();
	}
	
	@Test(priority=4)
	public void DELETE_landlord() {
		String str = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.when()
					.get("http://localhost:8080/landlords")
					.then()
					.statusCode(200)
					.extract().response().body().prettyPrint();
		
		JsonPath path = new JsonPath(str);
		String ID = path.getString("[0].id");
		System.out.println(ID);
		
		given()
		.contentType(ContentType.JSON)
		.pathParam("id", ID)
		.when()
		.delete("http://localhost:8080/landlords/{id}")
		.then()
		.statusCode(200)
		.extract().response().body().prettyPrint();	
	}
*/	
	@Test(priority=5)
	public void POST_Apartments() {
		String str = given()
					.contentType(ContentType.JSON)
					.when()
					.get("http://localhost:8080/landlords")
					.then()
					.statusCode(200)
					.extract().response().body().prettyPrint();
		
		JsonPath path = new JsonPath(str);
		//String name = path.getString("firstName");
		//System.out.println(name);
		String ID = path.getString("[0].id");
		System.out.println(ID);
		
	/*	String ID = "";
		for(int i=0; i<str.length(); i++) {
			ID = path.getString("["+i+"]"+".id");	
			System.out.println(ID);
		} 
	*/	
		landlord apartment_input = new landlord("330 Crescent cir", 100000, 1400, true);
		
		//Doing apartment details POST method
		given()
		.contentType(ContentType.JSON)
		.log().headers()
		.body(apartment_input)
		.pathParam("id", ID)
		.when()
		.post("http://localhost:8080/landlords/{id}/apartments")
		.then()
		.statusCode(201)
		.extract().response().body().prettyPrint();	
	}
	
/*	@Test(priority=6)
	public void GET_Apartments() {
		String ID = "p2W63vtV";
		String str = given()
					.contentType(ContentType.JSON)
					.pathParam("id", ID)
					.queryParam("minSq", 1200)
					.queryParam("maxSq", 1400)
					.when()
					.get("http://localhost:8080/landlords/{id}/apartments?minSq=1200&maxSq=1400")
					.then()
					.statusCode(200)
					.extract().response().getBody().prettyPrint();
	}
	
	@Test(priority=7)
	public void GET_Apartment_ID() {
		String str = given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:8080/landlords")
				.then()
				.statusCode(200)
				.extract().response().body().prettyPrint();
		
		JsonPath path = new JsonPath(str);
		String ID = path.getString("[0].id");
		System.out.println(ID);
		String apartment_ID = path.getString("[0].apartments[0].id");
		System.out.println(apartment_ID);
		
		given()
		.contentType(ContentType.JSON)
		.pathParam("id", ID)
		.pathParam("apartmentId", apartment_ID)
		.when()
		.get("http://localhost:8080/landlords/{id}/apartments/{apartmentId}")
		.then()
		.statusCode(200)
		.extract().response().body().print();
	}
	
	@Test(priority=8)
	public void DELETE_Apartment_ID() {
		String str = given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:8080/landlords")
				.then()
				.statusCode(200)
				.extract().response().body().prettyPrint();
		
		JsonPath path = new JsonPath(str);
		String ID = path.getString("[0].id");
		System.out.println(ID);
		String apartment_ID = path.getString("[0].apartments[0].id");
		System.out.println(apartment_ID);
		
		given()
		.contentType(ContentType.JSON)
		.pathParam("id", ID)
		.pathParam("apartmentId", apartment_ID)
		.when()
		.delete("http://localhost:8080/landlords/{id}/apartments/{apartmentId}")
		.then()
		.statusCode(200)
		.extract().response().body().print();
	}
	
	@Test(priority=9)
	public void PUT_Apartment_ID() {
		String str = given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:8080/landlords")
				.then()
				.statusCode(200)
				.extract().response().body().prettyPrint();
		
		JsonPath path = new JsonPath(str);
		String ID = path.getString("[0].id");
		System.out.println(ID);
		String apartment_ID = path.getString("[0].apartments[0].id");
		System.out.println(apartment_ID);

		landlord apartment_input = new landlord("330 Crescent circle", 100000, 1400, true);
		
		//Doing apartment details PUT method
		given()
		.contentType(ContentType.JSON)
		.body(apartment_input)
		.pathParam("id", ID)
		.pathParam("apartmentId", apartment_ID)
		.when()
		.put("http://localhost:8080/landlords/{id}/apartments/{apartmentId}")
		.then()
		.statusCode(200)
		.extract().response().body().prettyPrint();	
	}
*/
}
