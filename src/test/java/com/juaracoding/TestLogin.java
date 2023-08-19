package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddToCartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Driver;

public class TestLogin {
    WebDriver driver;
    LoginPage loginPage;
    AddToCartPage addToCartPage;
    CheckoutPage checkoutPage;
    LogoutPage logoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get(" https://www.saucedemo.com");
        loginPage = new LoginPage();
        addToCartPage = new AddToCartPage();
        checkoutPage = new CheckoutPage();
        logoutPage = new LogoutPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test (priority = 1)
    public void invalidCredentialTest(){
        loginPage.login("standard_user", "secret_sauc");
        Assert.assertEquals(loginPage.getTxtInvalidCredential(), "Epic sadface: Username and password do not match any user in this service");
        driver.navigate().refresh();
    }

    @Test (priority = 2)
    public void emptyPasswordTest(){
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getTxtPasswordRequired(), "Epic sadface: Password is required");
        driver.navigate().refresh();
    }

    @Test (priority = 3)
    public void emptyUsernameTest(){
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getTxtUsernameRequired(), "Epic sadface: Username is required");
        driver.navigate().refresh();
    }

    @Test (priority = 4)
    public void emptyUsernamePassword(){
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getTxtUsernameRequired(), "Epic sadface: Username is required");
        driver.navigate().refresh();
    }

    @Test (priority = 5)
    public void validLoginTest(){
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Products");
    }

    @Test (priority = 6)
    public void addToCart(){
        addToCartPage.addToCart();
        Assert.assertEquals(addToCartPage.getTxtCartOne(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(addToCartPage.getTxtCartTwo(), "Sauce Labs Backpack");
        checkoutPage.btnCheckout();
    }

    @Test (priority = 7)
    public void checkoutEmptyFirstName(){
        checkoutPage.checkout("", "tarigan", "12060");
        Assert.assertEquals(checkoutPage.getTxtFirstNameRequired(), "Error: First Name is required");
        driver.navigate().refresh();
    }

    @Test (priority = 8)
    public void checkoutEmptyLastName(){
        checkoutPage.checkout("putri", "", "12060");
        Assert.assertEquals(checkoutPage.getTxtLastNameRequired(), "Error: Last Name is required");
        driver.navigate().refresh();
    }

    @Test (priority = 9)
    public void checkout(){
        checkoutPage.checkout("putri", "tarigan", "12060");
        checkoutPage.btnFinish();
        Assert.assertEquals(checkoutPage.getTxtSuccess(), "Thank you for your order!");
    }

    @Test (priority = 10)
    public void logout(){
        logoutPage.logout();
    }



}
