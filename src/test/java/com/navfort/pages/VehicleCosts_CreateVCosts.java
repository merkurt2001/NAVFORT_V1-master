package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleCosts_CreateVCosts extends BasePage{

    @FindBy(xpath = "//button[contains(text(),'Today')]")
    public WebElement currentDay;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement dateInbox;



}
