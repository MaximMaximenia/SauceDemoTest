package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckoutTest extends BaseTest{
    @Test
    public void cancelCheckout(){
        loginPage.login(USER, PASS);
        productPage.toCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.cancelCheckout();
        checkoutPage.checkURL("https://www.saucedemo.com/cart.html");
    }
    @Test
    public void standardCheckout(){
        loginPage.login(USER, PASS);
        productPage.toCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.checkout("Max","Maximenia","228");
        checkoutPage.continueButtonClick();
        checkoutPage.checkURL("https://www.saucedemo.com/checkout-step-two.html");
        checkoutPage.finishButtonClick();
        checkoutPage.checkURL("https://www.saucedemo.com/checkout-complete.html");
    }
    @Test
    public void firstnameError(){
        loginPage.login(USER, PASS);
        productPage.toCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.checkout("","Maximenia","228");
        checkoutPage.continueButtonClick();
        checkoutPage.checkErrorMessage("Error: First Name is required");

} @Test
    public void lastnameError(){
        loginPage.login(USER, PASS);
        productPage.toCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.checkout("Max","","228");
        checkoutPage.continueButtonClick();
        checkoutPage.checkErrorMessage("Error: Last Name is required");

} @Test
    public void zipcodeError(){
        loginPage.login(USER, PASS);
        productPage.toCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.checkout("Max","Maximenia","");
        checkoutPage.continueButtonClick();
        checkoutPage.checkErrorMessage("Error: Postal Code is required");

}
@Test
    public void closeErrorMessage(){
        loginPage.login(USER, PASS);
        productPage.toCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.checkout("Max","Maximenia","");
        checkoutPage.continueButtonClick();
        driver.findElement(By.cssSelector(".error-button")).click();
        List errors = driver.findElements(By.cssSelector("[data-test=\"error\"]"));
Assert.assertEquals(errors.size(),0);
}}
