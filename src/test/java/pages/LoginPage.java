package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_LABEL = By.cssSelector("[data-test=error]");
    public static final By CLOSE_ERROR_MESSAGE_BUTTON = By.cssSelector(".error-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage isPageOpened() {
        Assert.assertTrue(driver.findElement(LOGIN_BUTTON).isDisplayed());
        return this;
    }
    public LoginPage openPage() {
    driver.get("https://www.saucedemo.com/");
    isPageOpened();
    return this;
}

    public ProductListPage loginPositive(String username, String password) {
        loginWithoutRedirect(username, password);
        return new ProductListPage(driver);

    }

    public LoginPage loginWithoutRedirect(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage checkErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(driver.findElement(ERROR_LABEL).getText(), expectedErrorMessage);
        return this;
    }

    public LoginPage closeErrorMessage() {
       Assert.assertTrue(driver.findElement(ERROR_LABEL).isDisplayed());
        driver.findElement(CLOSE_ERROR_MESSAGE_BUTTON).click();
       List<WebElement> error = driver.findElements(ERROR_LABEL);
       Assert.assertEquals(error.size(),0);
        return this;
    }
}

