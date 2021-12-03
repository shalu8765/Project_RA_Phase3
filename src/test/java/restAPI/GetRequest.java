package restAPI;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class GetRequest {
	
	@Test
	public void getcall() {
		
		Logger logger = Logger.getLogger("APILogs");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.info("********* started the get call***********");
		
		
	  RestAssured.given()
				    .baseUri("https://reqres.in")
				    .when()
				    .get("api/users")
				    .then()
				    .statusCode(200)
				    .log()
				    .all();
	
	
				   
	}
}




