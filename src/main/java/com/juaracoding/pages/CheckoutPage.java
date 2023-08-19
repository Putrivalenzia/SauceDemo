package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//input[@id='first-name']")
    WebElement fieldFirstName;
    @FindBy (xpath = "//input[@id='last-name']")
    WebElement fieldLastName;
    @FindBy (xpath = "//input[@id='postal-code']")
    WebElement fieldPostalCode;
    @FindBy (xpath = "//input[@id='continue']")
    WebElement btnContinue;
    @FindBy (xpath = "//button[@id='finish']")
    WebElement btnFinish;
    @FindBy (xpath = "//h2[@class='complete-header']")
    WebElement txtSuccess;
    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement txtLastNameRequired;
    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement txtFirstNameRequired;
    @FindBy (xpath = "//button[@id='checkout']")
    WebElement btnCheckout;

    public void checkout (String paramsFirstName, String paramsLastName, String paramsPostalCode){
        fieldFirstName.sendKeys(paramsFirstName);
        fieldLastName.sendKeys(paramsLastName);
        fieldPostalCode.sendKeys(paramsPostalCode);
        btnContinue.click();
    }
    public  void btnCheckout(){
        btnCheckout.click();
    }
    public  void btnFinish(){
        btnFinish.click();
    }
    public String getTxtSuccess(){
        return txtSuccess.getText();
    }
    public String getTxtFirstNameRequired(){
        return txtFirstNameRequired.getText();
    }
    public String getTxtLastNameRequired(){
        return txtLastNameRequired.getText();
    }





}
