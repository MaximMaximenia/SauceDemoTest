package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginTest() {
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }
    @Test
    public void emptyLogin() {
        loginPage.login("", "");
        loginPage.checkErrorMessage("Epic sadface: Username is required");
    }
    @Test
    public void emptyPassword() {
        loginPage.login("ssda", "");
       loginPage.checkErrorMessage("Epic sadface: Password is required");

    }
    @Test
    public void nonexistentUser() {
        loginPage.login("ssda", "dsds");
      loginPage.checkErrorMessage("Epic sadface: Username and password do not match any user in this service");

    }
    @Test
    public void lockedUserTest() {
        loginPage.login("locked_out_user", "secret_sauce");
       loginPage.checkErrorMessage("Epic sadface: Sorry, this user has been locked out.");

    }
    @Test
    public void closeErrorMessage() {
        loginPage.login("locuser23", "secsauce");
        Assert.assertEquals(loginPage.closeErrorMessage(), true);

    }}
