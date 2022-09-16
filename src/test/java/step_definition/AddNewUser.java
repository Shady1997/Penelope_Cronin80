package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utilites.GenerateData;

public class AddNewUser
{
    private String baseUri ,basePath , requestHeader , requestBody,temp;
    private String name,firstName,lastName,userName;
    private Response rquestResponse;
    @Given("having endpoint to ceate new user")
    public void userHaveValidEndpoint() {
        // set baseUri
        baseUri="https://620e3da1585fbc3359db4edf.mockapi.io";
        // set basePath
        basePath="/api/v1/users";
        // set requestHeader
        requestHeader="Application/Json";
        // format request body
        name=GenerateData.generateString(5);
        firstName=GenerateData.generateString(5);
        requestBody="[{\"name\": "+"\""+name+"\"" +",\"username\":"+"\""+GenerateData.generateString(5)+"\"" +",\"profile\":{\"firstName\":"+"\""+firstName+"\"" +",\"lastName\":"+"\""+GenerateData.generateString(5)+"\"" +",\"orders\": []}}]";
        // initiate response object
        rquestResponse=null;
        // set temp String
        temp=null;
    }

    @When("Send valid data in request body using post method")
    public void sendRequestWithPostMethod() {
        // Step 1: Call Endpoint and Store Response in Response Object
        rquestResponse= RestAssured.given().baseUri(baseUri).basePath(basePath).header("Content-Type",requestHeader).body(requestBody).when().post();
        // Step 2: print response
        rquestResponse.prettyPrint();
    }

    @Then("Status code of response should be 201")
    public void responseStatusCode() {
        SoftAssert softAssert=new SoftAssert();
        // Step 1: Assert Status Code of Response is 201
        softAssert.assertEquals(rquestResponse.getStatusCode(),201);
        // Step 2: get id from response and print it
            // 1- convert json to string
        JsonPath jsonPath= new JsonPath(rquestResponse.asString());
           // 2- store id in String variable
         String id=jsonPath.getString("id");
         temp=id;
           // 3- print data size
        System.out.println(id);
        // print first id in data array
        System.out.println(jsonPath.get("id").toString());
        softAssert.assertAll();
    }

    @Given("Create request user and have user id")
    public void createRequestUserAndHaveUserId() {
        // set baseUri
        baseUri="https://620e3da1585fbc3359db4edf.mockapi.io";
        // set basePath
        basePath="/api/v1/users";
       rquestResponse=null;
    }
    @When("Send request with user id using get method")
    public void sendRequestWithUserIdUsingGetMethod() {
        rquestResponse=RestAssured.given().baseUri(baseUri).basePath(basePath).queryParam("id",temp).when().get();
        rquestResponse.prettyPrint();
    }
    @Then("Status code of response should be 200")
    public void statusCodeOfResponseShouldBe() {
        // assert firstname after get request
        SoftAssert softAssert=new SoftAssert();
        // Step 1: Assert Status Code of Response is 201
        softAssert.assertEquals(rquestResponse.getStatusCode(),200);
        // Step 2: get firstname from response and print it
        // 1- convert json to string
        JsonPath jsonPath= new JsonPath(rquestResponse.asString());
        // 2- store id in String variable
        String getfirstName=jsonPath.getString("profile.firstName");
        // 3- print data size
        System.out.println(getfirstName);
        // Step 3: assert firstname
        softAssert.assertEquals(getfirstName,firstName);
    }
}
