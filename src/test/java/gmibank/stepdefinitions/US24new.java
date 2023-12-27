package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.State;
import gmibank.pojos.States;
import gmibank.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class US24new {
    Response responseGet;
    Response responsePost;

    @Given("user read data from endpoint with valid token")
    public void userReadDataFromEndpointWithValidToken() {
        responseGet = given().
                auth().
                oauth2(ConfigReader.getProperty("token")).
                when().
                get(ConfigReader.getProperty("endpoint_states"));

     //   responseGet.prettyPrint();
    }

    @Given("status code should be {int} and content type json")
    public void statusCodeShouldBeAndContentTypeJson(int status) {
        responseGet.then().assertThat().statusCode(status).contentType(ContentType.JSON);
    }

    @Given("Create anew state")
    public void createAnewState() {
//        ObjectMapper objectMapper = new ObjectMapper();
//
        States state = new States();
        state.setName("aliosman");

        responsePost = given().
                auth().
                oauth2(ConfigReader.getProperty("token")).
                body(state).
                when().
                post(ConfigReader.getProperty("endpoint_states"));


    }

    @Then("validate new state is created")
    public void validateNewStateIsCreated() throws IOException {

       ObjectMapper objectMapper = new ObjectMapper();
     //  States[] states = objectMapper.readValue(responsePost.asString(),States[].class);
       // System.out.println(states.toString());

        List<String> listOfStates = responsePost.as(ArrayList.class);

        System.out.println(listOfStates);
//        for (int i = 0; i <states.length; i++) {
//            if(listOfStates.contains("emrah"))
//            Assert.assertEquals("emrah",states[i]);
//        }

        Assert.assertTrue(listOfStates.contains("emrah"));
       // Assert.assertEquals("emrah",responsePost.get);
    }
}
