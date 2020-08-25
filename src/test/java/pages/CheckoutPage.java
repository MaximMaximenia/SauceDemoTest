package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.BaseTest;

import java.util.Random;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=\"error\"]");
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        driver.findElement(By.cssSelector(".btn_action")).click();
    }

    public void checkout(String firstName, String lastname, String zipcode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastname);
        driver.findElement(ZIP_CODE).sendKeys(zipcode);

    }

    public void continueButtonClick() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void finishButtonClick() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void checkErrorMessage(String errorMessage) {
        Assert.assertEquals(driver.findElement(ERROR_MESSAGE).getText(), errorMessage);

    }

    public void cancelCheckout() {
        driver.findElement(CANCEL_BUTTON).click();


    }

}
