package tests;
import org.testng.annotations.Test;
public class ProductSortTest extends BaseTest {


    @Test
    public void sortByMinToHighPrice() {
        loginPage.openPage().loginPositive(USER, PASS)
                .sortBy("Price (low to high)").
                checkPrice(2, "9.99");

    }

    @Test
    public void sortByHighToMin() {
        loginPage.openPage().loginPositive(USER, PASS)
                .sortBy("Price (high to low)").
                checkPrice(3, "15.99");

    }

    @Test
    public void sortByAtoZ() {
        loginPage.openPage().loginPositive(USER, PASS)
                .sortBy("Name (A to Z)").
                checkPrice(4, "49.99");

    }

    @Test
    public void sortByZtoA() {
        loginPage.openPage().loginPositive(USER, PASS).
                sortBy("Name (Z to A)").
                checkPrice(3, "49.99");

    }
}
