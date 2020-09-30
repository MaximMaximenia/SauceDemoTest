package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class CartPage extends BasePage {

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary");
    public static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".btn_secondary");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=\"error\"]");
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage isPageOpened() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn_action.checkout_button")).isDisplayed());
        return this;
    }
    public CartPage openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
        isPageOpened();
        return this;
    }

    public CartPage clickCheckoutButton() {
        driver.findElement(By.cssSelector(".btn_action")).click();
        return this;
    }

    public CartPage checkout(String firstName, String lastname, String zipcode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastname);
        driver.findElement(ZIP_CODE).sendKeys(zipcode);
        return this;

    }

    public CartPage continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return this;
    }
    public CartPage continueCheckout() {
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public CartPage finishCheckout() {
        driver.findElement(FINISH_BUTTON).click();
        return this;
    }

    public void checkErrorMessage(String errorMessage) {
        Assert.assertEquals(driver.findElement(ERROR_MESSAGE).getText(), errorMessage);

    }

    public CartPage cancelCheckout() {
        driver.findElement(CANCEL_BUTTON).click();
        return this;


    }
    public void closeErrorMessage() {
        driver.findElement(By.cssSelector(".error-button")).click();
        List<WebElement> errors = driver.findElements(By.cssSelector("[data-test=\"error\"]"));
        Assert.assertEquals(errors.size(), 0);
    }
}
