package utils;

import TestData.TestBuildData;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Utility {

    TestBuildData data = new TestBuildData();
    static RequestSpecification request;
    static ResponseSpecification resSpec;
    Response response;
    JsonPath jsonPath;
    Properties properties;
//    Resource resource = Res;


    public String propertiesFileReader(String input) throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/TestData.properties");
        properties.load(fis);
        return properties.getProperty(input);
    }

    public RequestSpecification createAddPlacePayload(List<Map<String, String>> map) throws IOException {
        PrintStream stream = new PrintStream(new FileOutputStream("Logs.txt"));
        request = new RequestSpecBuilder().setBaseUri(propertiesFileReader("baseUrl"))
                .addQueryParam("key", "qaclick123")
                .setBody(data.setData(map))
                .addFilter(RequestLoggingFilter.logRequestTo(stream))
                .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .setContentType(ContentType.JSON).build();
        return request;
    }

    public ResponseSpecification responseSpecification(){
        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        return resSpec;
    }

    public Response hitPostRequest(String value){
        Resource resource = Resource.valueOf(value);
        response = RestAssured.given().spec(request).when().post(resource.getResource())
                .then().spec(responseSpecification()).extract().response();
        return response;
    }

    public String validateResponseValues(String key){
        jsonPath = new JsonPath(response.asString());
        return jsonPath.getString(key);
    }
}
