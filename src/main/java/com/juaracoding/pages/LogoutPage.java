package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private WebDriver driver;
    public LogoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@id='react-burger-menu-btn']")
    WebElement burgerMenu;
    @FindBy (xpath = "//a[@id='logout_sidebar_link']")
    WebElement logout;
    public void logout (){
       burgerMenu.click();
       logout.click();
    }


}
