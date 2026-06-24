package web.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.DriverManager;
import web.pages.LoginPage;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("user open SauceDemo login page")
        public void userOpenSauceDemoLoginPage() {

        System.out.println("OPENING SAUCEDEMO");

        driver.get("https://www.saucedemo.com/");
    }

@Given("user already login to SauceDemo")
public void userAlreadyLoginToSauceDemo() {

    driver.get("https://www.saucedemo.com/");

    loginPage.inputUsername("standard_user");
    loginPage.inputPassword("secret_sauce");
    loginPage.clickLoginButton();

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(
            ExpectedConditions.urlContains("inventory")
    );

    System.out.println(
            "LOGIN SUCCESS URL = "
            + driver.getCurrentUrl()
    );
}

    @When("user input username {string}")
    public void userInputUsername(String username) {

        loginPage.inputUsername(username);
    }
    @When("user click Add to Cart button")
    public void userClickAddToCartButton() {

    loginPage.clickAddToCartButton();

    System.out.println(
        "ADD TO CART CLICKED"
    );
    System.out.println(driver.getPageSource());
}

    @When("user checkout product")
public void userCheckoutProduct() {

    System.out.println(
        "BEFORE CHECKOUT URL = "
        + driver.getCurrentUrl()
    );

    // System.out.println(driver.getPageSource());
    

    loginPage.clickCheckoutButton();

    loginPage.inputFirstName("Muhammad");
    loginPage.inputLastName("Faqih");
    loginPage.inputPostalCode("12345");

    loginPage.clickContinueButton();
    loginPage.clickFinishButton();
}

    @And("user input password {string}")
    public void userInputPassword(String password) {

        loginPage.inputPassword(password);
    }

    @And("click login button")
    public void clickLoginButton() {

        loginPage.clickLoginButton();
    }

    @And("user open shopping cart")
    public void userOpenShoppingCart() {

    System.out.println(
    "PAGE TITLE = "
    + driver.getTitle()
    );
    // System.out.println(driver.getPageSource());
    System.out.println(
    "CURRENT URL BEFORE CART = "
    + driver.getCurrentUrl()
    );
    loginPage.clickCartIcon();

    System.out.println(
        "AFTER CART URL = "
        + driver.getCurrentUrl()
    );

    // Assertions.assertTrue(
    //     driver.getCurrentUrl().contains("cart.html")
    // );
}



@Then("user should be redirected to products page")
public void userShouldBeRedirectedToProductsPage() {

    Assertions.assertTrue(
            driver.getCurrentUrl().contains("inventory.html")
    );

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    
}

    @Then("cart badge should display {string}")
public void cartBadgeShouldDisplay(String expectedValue) {

    Assertions.assertEquals(
            expectedValue,
            loginPage.getCartBadgeText()
    );

        
    }


    @Then("order should be completed successfully")
    public void orderShouldBeCompletedSuccessfully() {

    Assertions.assertEquals(
            "Thank you for your order!",
            loginPage.getCompleteHeader()
    );

    
}

}