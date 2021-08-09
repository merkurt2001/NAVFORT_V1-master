package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehicleCreatePage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement subtitle;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement addModel;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> availableModels;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement SaveAndCloseButton;

    @FindBy(xpath = "//label[1]")
    public WebElement LicensePlateButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement LicensePlateInbox;

    @FindBy(xpath = "(//div/label)[2]")
    public WebElement TagsButton;

    @FindBy(xpath = "( //div[@class='oro-clearfix']")
    public WebElement JuniorTagsCheckbox;

    @FindBy(xpath = "//input[starts-with(@data-name,'field_')]")
    public WebElement DriverCheckBox;



}
