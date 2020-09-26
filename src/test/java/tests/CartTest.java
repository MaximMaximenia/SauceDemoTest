package tests;

import io.qameta.allure.Description;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Description("ПРОВЕРКА КРАСНОГО КРАСНОГО МАРКЕРА С КОЛИЧЕСТВОМ ТОВАРОВ НАД ИКОНКОЙ КОРЗИНЫ")
    @Test
    public void testRedMarkWithAmountItemIntoCart() {
        loginPage.openPage().
                loginPositive( System.getProperty("user"),   System.getProperty("password")).
                addProduct("Sauce Labs Backpack").
                addProduct("Sauce Labs Bolt T-Shirt").
                checkRedMarkerAmount("2").
                checkCart(2).deleteItemIntoCart("Sauce Labs Bolt T-Shirt").checkRedMarkerAmount("1");

    }
    @Description("ПРОВЕРКА ЧТО ТОВАР ДОБАВЛСЯЕТСЯ В КОРЗИНУ")
    @Test
    public void itemShouldBeAddedIntoCart() {
        loginPage.openPage().
                loginPositive(USER, PASS).
                addProduct("Sauce Labs Backpack").
                checkCartByName("Sauce Labs Backpack").checkCart(1);

    }
    @Description("ПРОВЕРКА ЧТО НЕСКОЛЬКО ТОВАРОВ ДОБАВЛЯЕТСЯ В КОРЗИНУ")
    @Test
    public void someItemShouldBeAddedIntoCart() {
        loginPage.openPage().
                loginPositive(USER, PASS).
                addProduct("Sauce Labs Backpack").
                addProduct("Sauce Labs Bolt T-Shirt").
                checkCart(2);
    }
    @Description("ПРОВЕРКА ЧТО ТОВАР УДАЛЯЕТСЯ С КОРЗИНЫ.")
    @Test
    public void deleteItemIntoCart() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .deleteItemIntoCart("Sauce Labs Backpack")
                .checkCart(1);
    }
    @Description("ПРОВЕРКА ЧТО ТОВАР УДАЛЯЕТСЯ СО СТРАНИЦЫ С ТОВАРАМИ")
    @Test
    public void deleteItemIntoProductList() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .deleteItemIntoProductPage("Sauce Labs Bolt T-Shirt")
                .checkCart(1);
    }
    @Description("ПРОВЕРКА КНОПКИ \"Continue Shopping\" В КОРЗИНЕ")
    @Test
    public void continueShoppingButtonTest() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .toCart().continueShopping().
                expectedURL("https://www.saucedemo.com/inventory.html");

    }
}
