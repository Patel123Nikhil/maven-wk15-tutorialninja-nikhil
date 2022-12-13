package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;


    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;


    public String getShoppingCartText() {

        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log("Get Product name " +productName.toString());
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        Reporter.log("Get deleverydate" + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        Reporter.log("Get model" + model.toString());
        return getTextFromElement(model);
    }

    public String getTotal() {
        Reporter.log("Get total" + model.toString());
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        Reporter.log("change quantity" + qtyField.toString());
        sendTextToElement(qtyField, qty);
    }

    public void clickOnQtyUpdateButton() {
        Reporter.log("click on qty update button" + qtyUpdateBtn.toString());
        clickOnElement(qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() {
        Reporter.log("get success modified message" + successModifiedMessage.toString());
        return getTextFromElement(successModifiedMessage);
    }
}





