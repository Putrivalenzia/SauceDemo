package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}