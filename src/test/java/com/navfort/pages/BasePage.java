package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public abstract class  BasePage {

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;





    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }



    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void goToMyUser(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myUser, 5).click();

    }




    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }

    /**
     *
     * @param inputBoxText: get the text from html
     * @param value : the string value that you want to sent
     *
     * Note: put some wait before first usage
     */
    public void sentKeysToInputBox(String inputBoxText, String value){


            String locator = "//label[contains(text(),'" + inputBoxText + "')]/../..//input";

        Driver.get().findElement(By.xpath(locator)).sendKeys(value);

    }

    /**
     *
     * @param buttonIdentifier: it should be title attribute of button if it starts with <a> tag
     *                          it should be text attribute of button if it starts with <button> tag
     */
    public void clickButton(String buttonIdentifier){
        try {

            BrowserUtils.waitFor(3);
            String location = "//*[@title='" + buttonIdentifier + "']";

            WebElement button = Driver.get().findElement(By.xpath(location));
            button.click();

            //a[@title='"+buttonIdentifier+"']


        } catch (Exception e) {

            String location = "//button[contains(.,'" + buttonIdentifier + "')]";

            WebElement button = Driver.get().findElement(By.xpath(location));
            button.click();

        }
    }

   public void clickButtonIfNotSelected(String identifier){

        String locator = "//i[contains(text(),'"+identifier+"')]";
       WebElement button = Driver.get().findElement(By.xpath(locator));

       if(!button.isSelected()){
           button.click();
       }else{
           System.out.println("button is already selected");
       }
       BrowserUtils.waitFor(3);

    }


    /**
     *
     * @param identifier: Recent emails , Sticky Note or Task list
     */
    public void clickOnAddButtonInWidgets(String identifier){
        BrowserUtils.waitFor(5);
        BrowserUtils.waitForClickablility(new VehiclePage().plusButton, 10);
        new VehiclePage().plusButton.click();
        String locator1 = ("(//strong[.='" + identifier +"']/../..//a)[2]");


        BrowserUtils.waitFor(1);
        WebElement button1= Driver.get().findElement(By.xpath(locator1));
        button1.click();
        Driver.get().findElement(By.xpath("//a[contains(text(),'Close')]")).click();
        BrowserUtils.waitFor(2);
    }


    public String findMessageForSpecificField(String identifier){
        String locator = "(//label[contains(.,'"+identifier+"')]/../..//span)[2]";
        return Driver.get().findElement(By.xpath(locator)).getText();
    }

    public boolean findIfAnyMessageForSpecificField(String identifier){
        String locator = "(//label[contains(.,'"+identifier+"')]/../..//span)[2]";

       return Driver.get().findElement(By.xpath(locator)).isDisplayed();
    }

    /**
     *
     * @param buttonIdentifier: it should be title attribute of button if it starts with <a> tag
     *                          it should be text attribute of button if it starts with <button> tag
     */
    public boolean checkIfButtonIsThere(String buttonIdentifier) { // Add an event to this record
        try {

            BrowserUtils.waitFor(3);
            String location = "//*[@title='" + buttonIdentifier + "']";

            WebElement button = Driver.get().findElement(By.xpath(location));

            return button.isDisplayed();


        } catch (Exception e) {

            String location = "//button[contains(.,'" + buttonIdentifier + "')]";

            WebElement button = Driver.get().findElement(By.xpath(location));

            return button.isDisplayed();

        }

    }


    //Get The Current Day


    public String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
    }






}

