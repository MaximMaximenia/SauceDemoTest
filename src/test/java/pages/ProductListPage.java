package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductListPage extends BasePage {
    String addProductLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    String deleteItemIntoProductPage = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='REMOVE']";
    String deleteItemIntoCart = "//*[contains(text(),'%s')]/ancestor::div[@class='cart_item_label']//button";
    String checkItemIntoCart = "//div[contains(text(),'%s')]";
    public static final By SORT_SELECT = By.cssSelector(".product_sort_container");

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public ProductListPage isPageOpened() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".product_sort_container")).isDisplayed());
        return this;
    }
    public  ProductListPage cartIsOpened(){
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn_action.checkout_button")).isDisplayed());
        return this;
    }

    public ProductListPage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        isPageOpened();
        return this;
    }

    public CartPage toCart() {
        driver.get("https://www.saucedemo.com/cart.html");
        cartIsOpened();
        return new CartPage(driver);

    }

    public ProductListPage addProduct(String productName) {
        driver.findElement(By.xpath(String.format(addProductLocator, productName))).click();
        return this;

    }

    public ProductListPage deleteItemIntoCart(String productName) {
        toCart();
        driver.findElement(By.xpath(String.format(deleteItemIntoCart, productName))).click();
        return this;

    }
    public ProductListPage deleteItemIntoProductPage(String productName) {

        driver.findElement(By.xpath(String.format(deleteItemIntoProductPage, productName))).click();
        return this;

    }

    public ProductListPage checkCart(int expectedQuantityItems) {
        toCart();
        List allProductInCart = driver.findElements(By.cssSelector(".cart_item_label"));
        Assert.assertEquals(allProductInCart.size(), expectedQuantityItems);
        driver.get("https://www.saucedemo.com/inventory.html");
        return this;
    }
    public ProductListPage checkCartByName(String itemName) {
        Assert.assertTrue(driver.findElement(By.xpath(String.format(checkItemIntoCart, itemName))).isDisplayed());
        toCart();
        driver.get("https://www.saucedemo.com/inventory.html");
        return this;
    }

    public ProductListPage sortBy(String sortByTo) {
        driver.findElement(SORT_SELECT);
        Select select = new Select(driver.findElement(SORT_SELECT));
        select.selectByVisibleText(sortByTo);
        return this;
    }

    public ProductListPage checkPrice (int id,String expectedPrice) {
        List<WebElement> allPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(allPrices.get(id-1).getText().replaceAll("\\$",""),expectedPrice);
        return this;
    }

    public ProductListPage checkRedMarkerAmount(String expectedAmount){
       Assert.assertEquals(driver.findElement(By.cssSelector(".fa-layers-counter")).getText(),expectedAmount);
       return this;
    }



}
