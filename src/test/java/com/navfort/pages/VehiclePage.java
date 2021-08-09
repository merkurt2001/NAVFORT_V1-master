package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;


import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class VehiclePage extends BasePage {

    @FindBy(xpath = "//a[@title='Filters']")
    public WebElement filterButton;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement manageFilter;

    @FindBy(xpath = "((//div[@class='dropdown-menu']/div)[3]/a)[1]")
    public WebElement selectAllButton;


    @FindBy(xpath = "//button[@title='Pin/unpin the page']")
    public WebElement pinButton;

    @FindBy(xpath = "//i[contains(text(),'Favorites')]")
    public WebElement starButton;

    @FindBy(xpath = "//span[@class='grid-header-cell__label']")
    public List<WebElement> gridHeaders;

    @FindBy(xpath = "//td[@class='title-cell']/label")
    public List<WebElement> gridOptions;

    @FindBy(xpath = "//button[starts-with(@title,'Mark')]")
    public WebElement favoriteButton;
    @FindBy(xpath = "//a[contains(text(),'Manage filters')]")
    public WebElement ManageFilters;

    @FindBy(xpath = "//*[@class='grid-scrollable-container']//tr[2]")
    public WebElement carInfo;

//    @FindBy(xpath = "//i[@class=\"fa-chevron-right hide-text\"]") //   this sighs are right?\\\
//    public WebElement rightArrow;

    @FindBy(xpath = "//input[@type=\"number\"]")
    public WebElement pageNum;

    @FindBy(xpath = "//div[@class=\"btn-group open\"]")
    public WebElement ViewPage;

    @FindBy(xpath = "//*[@id=\"grid-custom-entity-grid-2066207567\"]/div[2]/div[1]/div/div[3]/div[2]/div/div/ul/li[3]/a")
    public WebElement dropDown50;
    //
    @FindBy(xpath = "//*[@id=\"grid-custom-entity-grid-322056678\"]/div[2]/div[1]/div/div[5]")
    public WebElement see50;


    //50 assert:
    //*[@id="grid-custom-entity-grid-2066207567"]/div[2]/div[1]/div/div[3]/div[2]/div/div/button


    @FindBy(xpath = "//a[@title=\"CSV\"]")
    public WebElement Cvs;

    @FindBy(className = "fa-upload")
    ////i[@class="fa-upload"]
    public WebElement exportGrid;

    @FindBy(className = "oro-subtitle" )
    ////h1[@class="oro-subtitle"]
    public WebElement AllCars;

//    @FindBy(xpath = "//td[contains(@class,'LicensePlate')]")
//    public WebElement PlateV;

    @FindBy(xpath = "//h5[@class=\"user-fieldset\"]")
    public WebElement GeneralInfo;

    @FindBy(xpath = "//div[@class=\"flash-messages-holder\"]")
    public WebElement exportSuccess;

    @FindBy(xpath = "//button[@class='sidebar__add-widget']")
    public WebElement plusButton;


    public void clickSelectAll() {

        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(selectAllButton);

    }
    public void navigateExpo(String Extab, String Cmodule){
        String ExportLocator = "//a[normalize-space()='\" + Extab + \" ' and contains(@class, 'action')]";
        String CmoduleLocator = "//a[normalize-space()='" + Cmodule+"' and contains(@title,'CSV')]";

        try {
            BrowserUtils.waitForClickablility(By.xpath(ExportLocator), 3);
            WebElement ExpoElement = Driver.get().findElement(By.xpath(ExportLocator));
            new Actions(Driver.get()).moveToElement(ExpoElement).pause(200).click(ExpoElement).build().perform();

        }catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(ExportLocator),2);
        }
        try {
            BrowserUtils.waitForClickablility(By.xpath(CmoduleLocator), 3);
            WebElement CmoduleElement = Driver.get().findElement(By.xpath(CmoduleLocator));
            new Actions(Driver.get()).moveToElement(CmoduleElement).pause(200).click(CmoduleElement).build().perform();

        }catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(ExportLocator),2);
        }



    }

}





