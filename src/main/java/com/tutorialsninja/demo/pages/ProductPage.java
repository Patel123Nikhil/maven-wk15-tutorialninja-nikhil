package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ProductPage extends Utility {
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }
@CacheLookup
        @FindBy(xpath = "//div[@id = 'content']//h1")
        WebElement productText;

    By calendarButton = By.xpath("//div[@class = 'input-group date']//button");

    By monthAndYearText = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By nextButton = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
   List<WebElement> dateList;
   // By dateList = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
   @CacheLookup
           @FindBy(css = "#input-quantity")
          WebElement qtyField;
    //By qtyField = By.cssSelector("#input-quantity");
    @CacheLookup
    @FindBy(xpath= "//button[@id='button-cart']")
    WebElement addToCartButton;

   @CacheLookup
   @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
   WebElement successMessage;
   // By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
   @CacheLookup
   @FindBy(xpath= "//a[contains(text(),'shopping cart')]")
   WebElement shoppingCartLink;
  //  By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
  @CacheLookup
  @FindBy(xpath= "//div[@class = 'input-group date']//button")
  WebElement datePicker;
    //By datePicker = By.xpath("//div[@class = 'input-group date']//button");


    public String getProductText() {

        return getTextFromElement(productText);
    }

    public void selectDeliveryDate() {
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(datePicker);
        //clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("//th[@class='picker-switch']")).getText();

            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {

                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
                break;
            } else
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
        }


        //Select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='table-condensed']//td"));
        for (WebElement ele : allDates) {
            String dt = ele.getText();
            if (dt.equalsIgnoreCase(date)) {
                ele.click();
                break;


            }

        }
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Clicking on Add to cartButton " + addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessage() {
        Reporter.log("get product success Message " + successMessage.toString());
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        Reporter.log("click on shopping cart link"+shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
    }

public void clearQauntity(){
    WebElement qty = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/input[1]"));
    qty.sendKeys(Keys.CONTROL + "a");
    qty.sendKeys(Keys.DELETE);
}
    public void enterQuantity(String qty) {
       // clearTextOnElement((By) qtyField);
        sendTextToElement(qtyField, qty);
    }
}


