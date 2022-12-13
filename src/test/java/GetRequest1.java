import io.restassured.RestAssured;
import io.restassured.internal.TestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class GetRequest1 {
    public static void main(String[] args) {
        RestAssured.baseURI= "https://reqres.in/api/users";
        RequestSpecification requestSpecification = RestAssured.given();

         requestSpecification.queryParam("delay","3");
        Response response= requestSpecification.get();
        response.prettyPeek();
        response.then().statusCode(200);
        response.then().body("data[0].id", Matchers.equalTo(1));

    }
}
