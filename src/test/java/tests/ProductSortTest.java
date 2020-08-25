package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ProductSortTest extends BaseTest {
    String minToHigh = "$7.99 $9.99 $15.99 $15.99 $29.99 $49.99";
    String highToMin = "$49.99 $29.99 $15.99 $15.99 $9.99 $7.99";
    String byAtoZ = "$29.99 $9.99 $15.99 $49.99 $7.99 $15.99";
    String byZtoA = "$15.99 $7.99 $49.99 $15.99 $9.99 $29.99";

    @Test
    public void sortByMinToHighPrice() {
        loginPage.login(USER, PASS);
        driver.findElement(By.cssSelector(".product_sort_coCntainer")).click();
        driver.findElement(By.cssSelector("[value=\"lohi\"]")).click();
        Assert.assertEquals(productPage.getPriceString(), minToHigh);

    }

    @Test
    public void sortByHighToMin() {
        loginPage.login(USER, PASS);
        driver.findElement(By.cssSelector(".product_sort_container")).click();
        driver.findElement(By.cssSelector("[value=\"hilo\"]")).click();

        Assert.assertEquals(productPage.getPriceString(), highToMin);
    }

    @Test
    public void sortByAtoZ() {
        loginPage.login(USER, PASS);
        driver.findElement(By.cssSelector(".product_sort_container")).click();
        driver.findElement(By.cssSelector("[value=\"az\"]")).click();

        Assert.assertEquals(productPage.getPriceString(), byAtoZ);
    }

    @Test
    public void sortByZtoA() {
        loginPage.login(USER, PASS);
        driver.findElement(By.cssSelector(".product_sort_container")).click();
        driver.findElement(By.cssSelector("[value=\"za\"]")).click();

        Assert.assertEquals(productPage.getPriceString(), byZtoA);
    }
}
