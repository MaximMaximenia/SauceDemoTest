package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;
@Listeners(TestListener.class)
public class CartTest extends BaseTest {
    @Test
    public void testRedMarkWithAmountItemIntoCart() {
        loginPage.openPage().
                loginPositive( System.getProperty("user"),   System.getProperty("password")).
                addProduct("Sauce Labs Backpack").
                addProduct("Sauce Labs Bolt T-Shirt").
                checkRedMarkerAmount("2").
                checkCart(2).deleteItemIntoCart("Sauce Labs Bolt T-Shirt").checkRedMarkerAmount("1");

    }

    @Test
    public void itemShouldBeAddedIntoCart() {
        loginPage.openPage().
                loginPositive(USER, PASS).
                addProduct("Sauce Labs Backpack").
                checkCartByName("Sauce Labs Backpack").checkCart(1);

    }

    @Test
    public void someItemShouldBeAddedIntoCart() {
        loginPage.openPage().
                loginPositive(USER, PASS).
                addProduct("Sauce Labs Backpack").
                addProduct("Sauce Labs Bolt T-Shirt").
                checkCart(2);
    }

    @Test
    public void deleteItemIntoCart() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .deleteItemIntoCart("Sauce Labs Backpack")
                .checkCart(1);
    }

    @Test
    public void deleteItemIntoProductList() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .deleteItemIntoProductPage("Sauce Labs Bolt T-Shirt")
                .checkCart(1);
    }

    @Test
    public void continueShoppingButtonTest() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .toCart().continueShopping().
                expectedURL("https://www.saucedemo.com/inventory.html");

    }
}
