package tests;

import org.openqa.selenium.ElementClickInterceptedException;

import org.testng.annotations.Test;

public class BurgerMenuTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void testAllItemButton() {
        loginPage.openPage()
                .loginPositive(USER, PASS)
                .toCart();
        burgerMenu.open().
                allItems().
                expectedURL("https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void testAboutButton() {
        loginPage.openPage()
                .loginPositive(USER, PASS);

        burgerMenu.open().
                about().
                expectedURL("https://saucelabs.com/");

    }

    @Test
    public void testLogoutButton() {
        loginPage.openPage()
                .loginPositive(USER, PASS);
        burgerMenu.open()
                .logout()
                .expectedURL("https://www.saucedemo.com/index.html");
    }

    @Test
    public void testResetButton() throws ElementClickInterceptedException {
        loginPage.openPage()
                .loginPositive(USER, PASS)
                .addProduct("Sauce Labs Backpack").checkCart(1).toCart();

        burgerMenu.open().reset();

        productPage.checkCart(0);


    }
}
