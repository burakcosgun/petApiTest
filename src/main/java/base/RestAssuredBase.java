package client;


import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase {

    public RestAssuredBase(String baseUrl){
        RestAssured.baseURI = baseUrl;
    }

    public Response get(String path, Object params) {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames())).relaxedHTTPSValidation().log().all(true).log().all();

        requestSpecification.baseUri(RestAssured.baseURI);
        requestSpecification.header("Content-type", "application/json");
        return requestSpecification.get(path + params);
    }

    public Response post(String path, Object params) {
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation().log().all(true);
        requestSpecification.baseUri(RestAssured.baseURI);
        requestSpecification.header("Content-type", "application/json");
        requestSpecification.request().body(params).log();
        return requestSpecification.post(path);
    }

    public Response put(String path, Object params) {
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation().log().all(true);
        requestSpecification.baseUri(RestAssured.baseURI);
        requestSpecification.header("Content-type", "application/json");
        requestSpecification.request().body(params).log();
        return requestSpecification.put(path);
    }

    public Response delete(String path, Object params) {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames())).relaxedHTTPSValidation().log().all(true);

        requestSpecification.baseUri(RestAssured.baseURI);
        requestSpecification.header("Content-type", "application/json");
        return requestSpecification.delete(path + params);
    }
}
