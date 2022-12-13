import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUser {
    public static void main(String[] args) {
        // RestAssured With Non Behaviour Driven Development (BDD)
        RestAssured.baseURI="https://reqres.in/api/users/2";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get();
        JsonPath jsonPath = response.jsonPath();
        String url =jsonPath.getString("support.url");
        System.out.println(url);

    }
}
