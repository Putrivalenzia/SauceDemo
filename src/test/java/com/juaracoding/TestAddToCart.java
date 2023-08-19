package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddToCartPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAddToCart {
    WebDriver driver;
    AddToCartPage addToCartPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get(" https://www.saucedemo.com");
        addToCartPage = new AddToCartPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void addToCart(){
        addToCartPage.addToCart();
        Assert.assertEquals(addToCartPage.getTxtCartOne(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(addToCartPage.getTxtCartTwo(), "Sauce Labs Backpack");
       }
}
