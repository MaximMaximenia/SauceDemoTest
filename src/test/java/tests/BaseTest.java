package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CheckoutPage;
import pages.LeftPanel;
import pages.LoginPage;
import pages.ProductListPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public final static String USER = "standard_user";
    public final static String PASS = "secret_sauce";
    WebDriver driver;
    LoginPage loginPage;
    ProductListPage productPage;
    LeftPanel leftPanel;
    CheckoutPage checkoutPage;
    @BeforeMethod
    public void setBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productPage = new ProductListPage(driver);
        leftPanel = new LeftPanel(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage.openPage();

    }
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.close();
    }
}

