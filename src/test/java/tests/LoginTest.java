package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    @Description("ПРОВЕРКА АВТОРИЗАЦИИ")
    @Test
    public void loginTest() {
        loginPage.openPage().
                loginPositive("standard_user", "secret_sauce");
        productPage.isPageOpened();
    }

    @Description("ПРОВЕРКА ОШИБКИ ПРИПУСТОМ ЛОГИНЕ")
    @Test
    public void emptyLogin() {
        loginPage.openPage().
                loginWithoutRedirect("", "").
                checkErrorMessage("Epic sadface: Username is required")
                .isPageOpened();
    }

    @Description("ПРОВЕРКА ОШИБКИ ПРИ ПУСТОМ ПАРОЛЕ")
    @Test
    public void emptyPassword() {
        loginPage.openPage().
                loginWithoutRedirect("ssda", "")
                .checkErrorMessage("Epic sadface: Password is required")
                .isPageOpened();
    }

    @Description("ПРОВЕРКА ОШИБКИ ПРИ ВВОДЕ НЕСУЩЕСТВУЮЩЕГО ПОЛЬЗОВАТЕЛЯ")
    @Test
    public void nonexistentUser() {
        loginPage.openPage().
                loginWithoutRedirect("ssda", "dsds").
                checkErrorMessage("Epic sadface: Username and password do not match any user in this service")
                .isPageOpened();
    }

    @Description("ПРОВЕРКА ОШИБКИ ПРИ ВВОДЕ ЗАБЛОКИРОВАНОГО ПОЛЬЗОВАТЕЛЯ")
    @Test
    public void lockedUserTest() {
        loginPage.openPage().
                loginWithoutRedirect("locked_out_user", "secret_sauce").
                checkErrorMessage("Epic sadface: Sorry, this user has been locked out.")
                .isPageOpened();
    }

    @Description("ПРОВЕРКА ЧТО СООБЩЕНИЕ ОБ ОШИБКЕ КОРРЕКТНО ЗАКРЫВАЕТСЯ ")
    @Test
    public void closeErrorMessage() {
        loginPage.openPage().
                loginWithoutRedirect("locuser23", "secsauce").
                closeErrorMessage().
                isPageOpened();


    }
}
