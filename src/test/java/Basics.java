import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

    public static void main(String[] args) {

/*        given - all input details
          when - Submit the API -resource,http method
          Then - validate the response*/

/*        *//* Below google code is an example to test basic functionality*//*
        RestAssured.baseURI = "https://www.google.com/";
        given().log().all().queryParam("search?q", "India")
                .when().get()
                .then().log().all().assertThat().statusCode(200);*/

        /* ****************************Starting RAHUL SHETTY's API Course************************************ */

        RestAssured.baseURI ="https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(Payload.payLoad())
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

     //   System.out.println(response);

        //for parsing Json
        JsonPath js=new JsonPath(response);
        String placeId=js.getString("place_id");

        System.out.println(placeId);


    }

}
