package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.Test;

public class BurgerMenuTest extends BaseTest {
    @Description("ПРОВЕРКА КНОПКИ ALL ITEM")
    @Test()
    public void testAllItemButton() {
        loginPage.openPage()
                .loginPositive(USER, PASS)
                .toCart();
        burgerMenu
                .open().
                allItems().
                expectedURL("https://www.saucedemo.com/inventory.html");

    }
    @Description("ПРОВЕРКА КНОПКИ ABOUT.")
    @Test
    public void testAboutButton() {
        loginPage.openPage()
                .loginPositive(USER, PASS);

        burgerMenu.open().
                about().
                expectedURL("https://saucelabs.com/");

    }
    @Description("ПРОВЕРКА КНОПКИ LOGOUT")
    @Test
    public void testLogoutButton() {
        loginPage.openPage()
                .loginPositive(USER, PASS);
        burgerMenu.open()
                .logout()
                .expectedURL("https://www.saucedemo.com/index.html");
    }
    @Description("ПРОВЕРКА КНОПКИ RESET...")
    @Test
    public void testResetButton() throws ElementClickInterceptedException {
        loginPage.openPage()
                .loginPositive(USER, PASS)
                .addProduct("Sauce Labs Backpack").checkCart(1).toCart();

        burgerMenu.open().reset();

        productPage.checkCart(0);


    }
}
