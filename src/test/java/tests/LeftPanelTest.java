package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;


public class LeftPanelTest extends BaseTest {

    @Test
    public void testAllItemButton() {
        loginPage.login(USER, PASS);
        productPage.toCart();
        leftPanel.open();
        leftPanel.allItems();
        leftPanel.checkURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testAboutButton() {
        loginPage.login(USER, PASS);
        leftPanel.open();
        leftPanel.about();
        leftPanel.checkURL("https://saucelabs.com/");
    }

    @Test
    public void testLogoutButton() {
        loginPage.login(USER, PASS);
        leftPanel.open();
        leftPanel.logout();
        leftPanel.checkURL("https://www.saucedemo.com/index.html");
    }

    @Test
    public void testResetButton() throws ElementClickInterceptedException {
        loginPage.login(USER, PASS);
        productPage.addProduct("Sauce Labs Backpack");
        leftPanel.open();
        leftPanel.reset();
        driver.get("https://www.saucedemo.com/cart.html");
        productPage.checkCart(0);


    }
}
