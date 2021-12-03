package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	
		
		@Test
		public void Postcall() {

			Logger logger = Logger.getLogger("APILogs");
	        PropertyConfigurator.configure("log4j.properties");
	        logger.setLevel(Level.DEBUG);
	        logger.info("********* started the post call***********");
			
			Map<String, Object> PostBody = new HashMap<String, Object>();
			PostBody.put("id", 100);
			PostBody.put("email", "abc@xyz.com");
			PostBody.put("first_name", "Nik");
			PostBody.put("last_name", "Shah");
			PostBody.put("avatar", "https://reqres.in/img/faces/1-image.jpg");
			
			
		  RestAssured.given()
					    .baseUri("https://reqres.in")
					    .contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(PostBody)
					    .when()
					    .post("api/users")
					    .then()
					    .statusCode(201)
					    .log()
					    .all();
		
		
		
		}
}
