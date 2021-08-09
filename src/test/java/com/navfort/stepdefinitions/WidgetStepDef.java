package com.navfort.stepdefinitions;

import com.navfort.pages.AllCarsPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class WidgetStepDef {


    @Then("the user verify the title {string}")
    public void the_user_verify_the_title(String expectedTitle) {

        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);
        expectedTitle= "Dashboard";  //sonradan
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }


    @Then("the value of {string} is increased by one when the user clicks on the add button near {string}")
    public void the_value_of_is_increased_by_one_when_the_user_clicks_on_the_add_button_near(String sideBarWidgets, String sideBarWidgets1) {


    }


    @When("the user clicks on the plus button")
    public void theUserClicksOnThePlusButton() {

        BrowserUtils.waitFor(4);

        //  new DashboardPage().sidePlusButton.click();
//        WebElement plusButton1= Driver.get().findElement(By.className("sidebar__add-widget"));
//        plusButton1.click();

        Driver.get().findElement(By.xpath("//button[@class='sidebar__add-widget']")).click();





//        String location = "//button[@class='sidebar__add-widget']"  + plusButton + "']";
//
//        WebElement button = Driver.get().findElement(By.xpath(location));
//        button.click();
    }


    @Then("the title is the same as the page title")
    public void the_title_is_the_same_as_the_page_title() {

//        WebDriver driver = new ChromeDriver();
//        driver.get(ConfigurationReader.get("url"));
//        // driver.get("https://qa.navfort.com/entity/Extend_Entity_Carreservation");
//
//        //Actual title
//        String favPageTitle= driver.getTitle();
//
//        //expected title
//        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
//
//        Assert.assertEquals(favPageTitle,expectedTitle);

        String expectedTitle;
        // System.out.println("expectedTitle = " + expectedTitle);
        expectedTitle = "Car - Entities";
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));




    }



    @Then("the pin holder is the same as the page title")
    public void thePinHolderIsTheSameAsThePageTitle () {
        String expectedTitle;
        // System.out.println("expectedTitle = " + expectedTitle);
        expectedTitle = "Car - Entities";
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));


    }

    @When("the user clicks on the top {string} button")
    public void theUserClicksOnTheTopButton(String PinBttn) {
        BrowserUtils.waitFor(4);

//        if(action=="Pin"){
//            new VehiclePage().pinButton.click();
//        }else if (action == "Favorite") {
//            new VehiclePage().favoriteButton.click();
//        }

        Driver.get().findElement(By.xpath("//*[@id=\"bookmark-buttons\"]/div/div/button[2]")).click();




    }
}
