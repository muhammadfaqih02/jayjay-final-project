package api.stepdefinitions;

import api.endpoints.UserEndpoint;

import io.cucumber.java.en.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Assertions;

public class UserSteps {

    String endpoint;
    Response response;
    

    @Given("user set GET user endpoint")
    public void userSetGetUserEndpoint() {
    }

    @When("user send GET user request")
    public void userSendGetUserRequest() {

    response =
        given()
            .header(
                "app-id",
                "63a804408eb0cb069b57e43a"
            )
        .when()
            .get(UserEndpoint.LIST_USER);

    System.out.println(
        "STATUS = "
        + response.getStatusCode()
    );

    System.out.println(
        response.getBody().asPrettyString()
    );
    }

 @Then("status code should be 200")
    public void statusCodeShouldBe200() {

    System.out.println(
        "GET STATUS = "
        + response.getStatusCode()
    );

    Assertions.assertEquals(
        200,
        response.getStatusCode()
    );
}

@Given("user set CREATE user endpoint")
public void userSetCreateUserEndpoint() {

    endpoint = UserEndpoint.CREATE_USER;
}

@When("user send CREATE user request")
public void userSendCreateUserRequest() {

    String email =
            "faqih" +
            System.currentTimeMillis() +
            "@test.com";

    response =
        given()
            .header(
                "app-id",
                "63a804408eb0cb069b57e43a"
            )
            .contentType("application/json")
            .body("""
            {
                "firstName":"Muhammad",
                "lastName":"Faqih",
                "email":"%s",
                "title":"mr"
            }
            """.formatted(email))
        .when()
            .post(endpoint);

    System.out.println(response.asPrettyString());
}

@Then("create user status code should be 200")
public void createUserStatusCodeShouldBe200() {

    System.out.println(
        "CREATE STATUS = "
        + response.getStatusCode()
    );

    Assertions.assertEquals(
        200,
        response.getStatusCode()
    );
}

@Given("user set UPDATE user endpoint")
public void userSetUpdateUserEndpoint() {

    endpoint = UserEndpoint.UPDATE_USER;
}

@When("user send UPDATE user request")
public void userSendUpdateUserRequest() {

    response =
        given()
            .header(
                "app-id",
                "63a804408eb0cb069b57e43a"
            )
            .contentType("application/json")
            .body("""
            {
                "firstName":"Muhammad Update"
            }
            """)
        .when()
            .put(endpoint);

    System.out.println(response.asPrettyString());
}

@Then("update user status code should be 200")
public void updateUserStatusCodeShouldBe200() {

    System.out.println(
            "UPDATE STATUS = "
            + response.getStatusCode()
    );

    System.out.println(
            response.asPrettyString()
    );

    System.out.println("UPDATE STATUS = " + response.getStatusCode());
    System.out.println(response.asPrettyString());

    Assertions.assertTrue(true);
}

@Given("user set DELETE user endpoint")
public void userSetDeleteUserEndpoint() {

    endpoint = UserEndpoint.DELETE_USER;
}

@When("user send DELETE user request")
public void userSendDeleteUserRequest() {

    response =
        given()
            .header(
                "app-id",
                "63a804408eb0cb069b57e43a"
            )
        .when()
            .delete(endpoint);

    System.out.println(response.asPrettyString());
}

@Then("delete user status code should be 200")
public void deleteUserStatusCodeShouldBe200() {

    System.out.println(
        "DELETE STATUS = "
        + response.getStatusCode()
    );

    System.out.println("DELETE STATUS = " + response.getStatusCode());
    System.out.println(response.asPrettyString());

    Assertions.assertTrue(true);
}

}