package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BurgerMenu extends BasePage {
    public BurgerMenu(WebDriver driver) {
        super(driver);
    }

    public BasePage isPageOpened() {
        return null;
    }

    public BasePage openPage() {
        return null;
    }

    public static final By OPEN = By.cssSelector(".bm-burger-button");
    public static final By ALL_ITEMS = By.cssSelector("#inventory_sidebar_link");
    public static final By ABOUT = By.cssSelector("#about_sidebar_link");
    public static final By LOGOUT = By.cssSelector("#logout_sidebar_link");
    public static final By RESET = By.cssSelector("#reset_sidebar_link");
@Step("ОТКРЫТИЕ МЕНЮШКИ")
    public BurgerMenu open() {
        driver.findElement(OPEN).click();
        return this;
    }
@Step("НАЖАТИЕ НА КНОКУ ALLI TEMS")
    public BurgerMenu allItems() {
        driver.findElement(ALL_ITEMS).click();return this;
    }
    @Step("НАЖАТИЕ НА КНОКУ ABOUT")
    public BurgerMenu about() {
        driver.findElement(ABOUT).click();return this;
    }
    @Step("НАЖАТИЕ НА КНОКУ LOGUT")
    public BurgerMenu logout() {
        driver.findElement(LOGOUT).click();return this;
    }
    @Step("НАЖАТИЕ НА КНОКУ RESET...")
    public BurgerMenu reset() {
        driver.findElement(RESET).click();return this;
    }
}