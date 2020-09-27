package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class ProductSortTest extends BaseTest {

    @Description("ПРОВЕРКА СОРТИРОВКИ ПО ЦЕНЕ ОТ МИНИМАЛЬНОЙ К МАКСИМАЛЬНОЙ.")
    @Test
    public void sortByMinToHighPrice() {
        loginPage.openPage().loginPositive(USER, PASS)
                .sortBy("Price (low to high)").
                checkPrice(2, "9.99");

    }
    @Description("ПРОВЕРКА СОРТИРОВКИ ПО ЦЕНЕ ОТ МИНИМАЛЬНОЙ К МАКСИМАЛЬНОЙ.")
    @Test
    public void sortByHighToMin() {
        loginPage.openPage().loginPositive(USER, PASS)
                .sortBy("Price (high to low)").
                checkPrice(3, "15.99");

    }

    @Description("ПРОВЕРКА СОРТИРОВКИ ПО АЛФАВИТУ ОТ A ДО Z")
    @Test
    public void sortByAtoZ() {
        loginPage.openPage().loginPositive(USER, PASS)
                .sortBy("Name (A to Z)").
                checkPrice(4, "49.99");

    }

    @Description("ПРОВЕРКА СОРТИРОВКИ ПО АЛФАВИТУ ОТ Z ДО A")
    @Test
    public void sortByZtoA() {
        loginPage.openPage().loginPositive(USER, PASS).
                sortBy("Name (Z to A)").
                checkPrice(3, "49.99");

    }
}
