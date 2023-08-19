package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
    private WebDriver driver;

    public AddToCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement backpack;
    @FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement shirt;
    @FindBy (xpath = "//a[@class='shopping_cart_link']")
    WebElement cart;

    @FindBy (xpath = "//div[normalize-space()='Sauce Labs Backpack']")
    WebElement itemBackpack;
    @FindBy (xpath = "//div[normalize-space()='Sauce Labs Bolt T-Shirt']")
    WebElement itemShirt;


    public void addToCart (){
        backpack.click();
        shirt.click();
        cart.click();
    }
    public String getTxtCartOne(){
        return itemShirt.getText();
    }
    public String getTxtCartTwo(){
        return itemBackpack.getText();
    }


}
