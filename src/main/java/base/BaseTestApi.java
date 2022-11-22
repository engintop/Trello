package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTestApi {

    @BeforeSuite
    public void setup(){
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "https://api.trello.com/1/boards/";
    }
}
