package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductListPage extends BasePage {
    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    String deleteItemInCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='cart_item_label']//button";
String getPrices = "//*[@class=\"inventory_list\"]/div[%s]/div[3]//*[@class='inventory_item_price']";

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void toCart() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

    }

    public void addProduct(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();

    }

    public void deleteProduct(String productName) {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.xpath(String.format(deleteItemInCartLocator, productName))).click();

    }

    public void checkCart(int expectedQuantityItems) {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        List allProductInCart = driver.findElements(By.cssSelector(".cart_item_label"));
        Assert.assertEquals(allProductInCart.size(), expectedQuantityItems);
    }

    public String getPriceString(){
        String allPrices =
       driver.findElement(By.xpath(String.format(getPrices, 1))).getText()+" "+
       driver.findElement(By.xpath(String.format(getPrices, 2))).getText()+" "+
       driver.findElement(By.xpath(String.format(getPrices, 3))).getText()+" "+
       driver.findElement(By.xpath(String.format(getPrices, 4))).getText()+" "+
       driver.findElement(By.xpath(String.format(getPrices, 5))).getText()+" "+
       driver.findElement(By.xpath(String.format(getPrices, 6))).getText();
        return allPrices;
    }




}
