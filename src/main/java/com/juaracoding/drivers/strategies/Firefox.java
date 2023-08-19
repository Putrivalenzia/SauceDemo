package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    @Override
    public WebDriver setStrategy(){
        String path = "C:\\Users\\PC LENOVO\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        WebDriver driver = new FirefoxDriver();
        return  driver;
    }
}
