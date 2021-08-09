package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleDetailPage extends BasePage{

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement subtitle;

    @FindBy(css = "a[title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy(xpath = "//span[.='Add Event']")
    public WebElement addEventWindowTitle;

    @FindBy(xpath = "//*[@name='oro_calendar_event_form[title]']")
    public WebElement titleInputBox;

    @FindBy(css = "#tinymce")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "//*[@title='Rich Text Area. Press ALT-F9 for menu. Press ALT-F10 for toolbar. Press ALT-0 for help']")
    public WebElement descriptionIframe;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addEventSaveButton;

    @FindBy(xpath = "//*[.='Calendar event saved']")
    public WebElement successMessage;







}
