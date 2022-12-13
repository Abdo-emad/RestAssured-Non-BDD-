import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PostData {
    public static void main(String[] args) {

        RestAssured.baseURI= "https://reqres.in/api/users";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json; charset=utf-8");
        request.body("{\n" +
                "    \"name\": \"Abdelrhman\",\n" +
                "    \"job\": \"Engineer\"\n" +
                "}");
        Response response = request.post();
        response.prettyPeek();
       String statusLine= response.getStatusLine();
       Assert.assertEquals(statusLine,"HTTP/1.1 201 Created");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
       long time= response.getTimeIn(TimeUnit.MILLISECONDS);
       Assert.assertTrue(time <5000);

       // assert response body and how to ger value from body
        JsonPath path = response.jsonPath();
       String id = path.get("id");
        System.out.println(id);





    }
}
