package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Locator @FindBy
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;
    @FindBy(xpath = "//span[@class='title']")
    WebElement txtDashboard;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtInvalidCredential;
    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement txtPasswordRequired;
    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement txtUsernameRequired;

    // Custom Method

    public void login (String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        btnLogin.click();

    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
    public String getTxtInvalidCredential(){
        return txtInvalidCredential.getText();
    }
    public String getTxtPasswordRequired(){
        return txtPasswordRequired.getText();
    }
    public String getTxtUsernameRequired(){
        return txtUsernameRequired.getText();
    }
}
