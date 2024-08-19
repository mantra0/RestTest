package stepDefinitions;

import TestData.TestBuildData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import payload.RequestBody;
import utils.Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepDefinitions extends Utility {

    RequestSpecification request;
    Response response;

    @Given("Create the add place payload")
    public void createPayloadForAddPlace(List<Map<String, String>> map) throws IOException {
        request = createAddPlacePayload(map);
    }

    @When("Trigger the {string} request")
    public void triggeringRequest(String event){
        response = hitPostRequest(event);
    }

    @Then("Validate the status code for the response is 200")
    public void validateStatusCode(){
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("Validate {string} in response is {string}")
    public void validateResponse(String key, String value){
        Assert.assertEquals(validateResponseValues(key), value);
    }
}