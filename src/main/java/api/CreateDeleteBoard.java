package api;

import base.BaseTestApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import util.Log;

import static io.restassured.RestAssured.given;

public class CreateDeleteBoard extends BaseTestApi {


    public String createBoard(String boardName , String key , String token) {

        Response response = given()
                .queryParam("name",boardName)
                .queryParam("key",key)
                .queryParam("token",token)
                .and()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post()
                .then().log().all()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(),200);


        String boardId = response.jsonPath().getString("id");
        Log.info("memberId  :     "+boardId);
        return boardId ;


    }

    public void deleteBoard(String boardId , String key , String token) {

        Response response = given()
                .queryParam("key",key)
                .queryParam("token",token)
                .and()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().log().all()
                .delete(boardId)
                .then().log().all()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(),200);

    }


}
