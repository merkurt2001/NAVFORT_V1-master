package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeDynamicButton extends BasePage{

//    @FindBy(xpath = "//a[@title='Create Car']")
//    public WebElement createCar;
//
//    @FindBy(xpath = "//a[@title='Edit Car']")
//    public WebElement editCar;
//
//    @FindBy(xpath = "//a[@title='Delete Car']")
//    public WebElement dleteCaer;
//
//    @FindBy(xpath = "//a[@title='Add an event to this record']")
//    public WebElement editCar;


    public void clickButton(String buttonTitle) {

        try {
            BrowserUtils.waitFor(3);
            String locatorwithATag = "//a[@title='"+buttonTitle+"']";

            Driver.get().findElement(By.xpath(locatorwithATag)).click();

        }catch (Exception e){
            BrowserUtils.waitFor(3);
            String locatorwithButtonTag = "//button[contains(text(),"+buttonTitle+")]";

            Driver.get().findElement(By.xpath(locatorwithButtonTag)).click();
        }
    }








}
