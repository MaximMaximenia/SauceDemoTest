package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;
public class BaseTest {
    public final static String USER = "standard_user";
    public final static String PASS = "secret_sauce";
    WebDriver driver;
    LoginPage loginPage;
    ProductListPage productPage;
    BurgerMenu burgerMenu;
    CartPage cartPage;

    @BeforeMethod
    public void setBrowser(ITestContext context) {

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productPage = new ProductListPage(driver);
        burgerMenu = new BurgerMenu(driver);
        cartPage = new CartPage(driver);
        context.setAttribute("driver",driver);

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() { driver.quit(); }
}

