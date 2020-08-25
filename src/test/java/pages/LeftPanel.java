package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class LeftPanel extends BasePage {
    public LeftPanel(WebDriver driver) {
        super(driver);
    }
    public static final By OPEN =  By.cssSelector(".bm-burger-button");
    public static final By ALL_ITEMS =By.cssSelector("#inventory_sidebar_link");
    public static final By ABOUT = By.cssSelector("#about_sidebar_link");
    public static final By LOGOUT =By.cssSelector("#logout_sidebar_link");
    public static final By RESET =  By.cssSelector("#reset_sidebar_link");

public void open(){
    driver.findElement(OPEN).click();
}public void allItems(){
    driver.findElement(ALL_ITEMS).click();
}public void about(){
    driver.findElement(ABOUT).click();
}public void logout(){
    driver.findElement(LOGOUT).click();
}public void reset(){
    driver.findElement(RESET).click();
}}