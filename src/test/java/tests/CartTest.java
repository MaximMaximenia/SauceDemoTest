package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {
    @Test
    public void testRedMarkWithAmountItemIntoCart(){
        loginPage.login(USER, PASS);
        List noRedMark = driver.findElements(By.cssSelector(".fa-layers-counter"));
        Assert.assertEquals(noRedMark.size(),0);
        productPage.addProduct("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(driver.findElement(By.cssSelector(".fa-layers-counter")).getText(),"1");
        productPage.addProduct("Sauce Labs Bike Light");
        Assert.assertEquals(driver.findElement(By.cssSelector(".fa-layers-counter")).getText(),"2");

    }
    @Test
    public void itemShouldBeAddedIntoCart() {
        loginPage.login(USER, PASS);
        productPage.addProduct("Sauce Labs Backpack");
        productPage.checkCart(1);
    }

    @Test
    public void someItemShouldBeAddedIntoCart() {
        loginPage.login(USER, PASS);
        productPage.addProduct("Sauce Labs Backpack");
        productPage.addProduct("Sauce Labs Bolt T-Shirt");
        productPage.checkCart(2);
    }
    @Test
    public void deleteItemIntoCart() {
        loginPage.login(USER, PASS);
        productPage.addProduct("Sauce Labs Backpack");
        productPage.addProduct("Sauce Labs Bolt T-Shirt");
        productPage.deleteProduct("Sauce Labs Backpack");
        productPage.checkCart(1);
    }
    @Test
    public void deleteItemIntoProductList() {
        loginPage.login(USER, PASS);
        productPage.addProduct("Sauce Labs Backpack");
        productPage.addProduct("Sauce Labs Bolt T-Shirt");
        productPage.addProduct("Sauce Labs Bolt T-Shirt");
        productPage.checkCart(1);
    }
    @Test
    public void continueShoppingButtonTest() {
        loginPage.login(USER, PASS);
        productPage.toCart();
        driver.findElement(By.xpath("//*[text()=\"Continue Shopping\"]")).click();
       Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
