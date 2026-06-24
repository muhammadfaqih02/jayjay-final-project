package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By addToCartButton =
    By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge =
    By.className("shopping_cart_badge");
    private By cartIcon =
    By.cssSelector(".shopping_cart_link");

    private By checkoutButton =
        By.id("checkout");

    private By firstNameField =
        By.id("first-name");

    private By lastNameField =
        By.id("last-name");

    private By postalCodeField =
        By.id("postal-code");

    private By continueButton =
        By.id("continue");

    private By finishButton =
        By.id("finish");

    private By completeHeader =
        By.className("complete-header");

    public void inputUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickAddToCartButton() {

    driver.findElement(addToCartButton).click();

    System.out.println("ADD TO CART SUCCESS");
}

    public String getCartBadgeText() {

    System.out.println(
        "BADGE FOUND = "
        + driver.findElements(cartBadge).size()
    );

    return driver.findElement(cartBadge).getText();
}

   public void clickCartIcon() {

    WebElement cart =
        driver.findElement(cartIcon);

    System.out.println(
        "CART DISPLAYED = "
        + cart.isDisplayed()
    );

    ((JavascriptExecutor) driver)
        .executeScript(
            "arguments[0].click();",
            cart
        );

    try {
        Thread.sleep(3000);
    } catch (Exception e) {
    }

    System.out.println(
        "URL AFTER CLICK = "
        + driver.getCurrentUrl()
    );

    System.out.println(
        "BADGE FOUND = "
        + driver.findElements(cartBadge).size()
    );
}

public void clickCheckoutButton() {

    WebElement checkout =
        driver.findElement(checkoutButton);

    System.out.println(
        "CHECKOUT DISPLAYED = "
        + checkout.isDisplayed()
    );

    System.out.println(
        "CHECKOUT ENABLED = "
        + checkout.isEnabled()
    );

    checkout.click();

    try {
        Thread.sleep(3000);
    } catch (Exception e) {
    }

    System.out.println(
        "AFTER CHECKOUT CLICK = "
        + driver.getCurrentUrl()
    );
}

    public void inputFirstName(String firstName) {
    driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
    driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
    driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinueButton() {
    driver.findElement(continueButton).click();
    }

    public void clickFinishButton() {
    driver.findElement(finishButton).click();
    }

    public String getCompleteHeader() {
    return driver.findElement(completeHeader).getText();
    }
}