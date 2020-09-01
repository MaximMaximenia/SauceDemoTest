package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        loginPage.openPage().
                loginPositive("standard_user", "secret_sauce");
        productPage.isPageOpened();
    }

    @Test
    public void emptyLogin() {
        loginPage.openPage().
                loginWithoutRedirect("", "").
                checkErrorMessage("Epic sadface: Username is required")
                .isPageOpened();
    }

    @Test
    public void emptyPassword() {
        loginPage.openPage().
                loginWithoutRedirect("ssda", "")
                .checkErrorMessage("Epic sadface: Password is required")
                .isPageOpened();
    }

    @Test
    public void nonexistentUser() {
        loginPage.openPage().
                loginWithoutRedirect("ssda", "dsds").
                checkErrorMessage("Epic sadface: Username and password do not match any user in this service")
                .isPageOpened();
    }

    @Test
    public void lockedUserTest() {
        loginPage.openPage().
                loginWithoutRedirect("locked_out_user", "secret_sauce").
                checkErrorMessage("Epic sadface: Sorry, this user has been locked out.")
                .isPageOpened();
    }

    @Test
    public void closeErrorMessage() {
        loginPage.openPage().
                loginWithoutRedirect("locuser23", "secsauce").
                closeErrorMessage().
                isPageOpened();


    }
}
