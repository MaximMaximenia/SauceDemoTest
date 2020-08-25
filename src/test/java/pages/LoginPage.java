package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_LABEL = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void checkErrorMessage(String expectedErrorMessage) {

        Assert.assertEquals(driver.findElement(ERROR_LABEL).getText(),expectedErrorMessage);
    }

    public boolean closeErrorMessage() {
        driver.findElement(By.cssSelector(".error-button")).click();
        List error = driver.findElements(By.cssSelector("[data-test=\"error\"]"));
        if (error.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}

