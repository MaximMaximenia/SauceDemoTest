package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CheckoutTest extends BaseTest {
    @Test
    public void cancelCheckout() {
        loginPage.openPage()
                .loginPositive(USER, PASS)
                .toCart().clickCheckoutButton()
                .cancelCheckout()
                .expectedURL("https://www.saucedemo.com/cart.html");
    }

    @Test
    public void standardCheckout() {
        loginPage.openPage().loginPositive(USER, PASS)
                .toCart()
                .clickCheckoutButton()
                .checkout("Max", "Maximenia", "228")
                .continueCheckout()
                .expectedURL("https://www.saucedemo.com/checkout-step-two.html");
        cartPage.finishCheckout().
                expectedURL("https://www.saucedemo.com/checkout-complete.html");
    }

    @Test
    public void firstnameError() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .toCart()
                .clickCheckoutButton()
                .checkout("", "Maximenia", "228")
                .continueCheckout()
                .checkErrorMessage("Error: First Name is required");


    }

    @Test
    public void lastnameError() {
        loginPage.openPage().
                loginPositive(USER, PASS)
                .toCart().clickCheckoutButton()
                .checkout("Max", "", "228")
                .continueCheckout()
                .checkErrorMessage("Error: Last Name is required");

    }

    @Test
    public void zipcodeError() {
        loginPage.openPage()
                .loginPositive(USER, PASS)
                .toCart()
                .clickCheckoutButton()
                .checkout("Max", "Maximenia", "")
                .continueCheckout()
                .checkErrorMessage("Error: Postal Code is required");

    }

    @Test
    public void closeErrorMessage() {
        loginPage.openPage()
                .loginPositive(USER, PASS)
                .toCart()
                .clickCheckoutButton()
                .checkout("Max", "Maximenia", "")
                .continueCheckout().
                closeErrorMessage();
    }
}
