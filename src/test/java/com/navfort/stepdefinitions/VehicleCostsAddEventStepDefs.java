package com.navfort.stepdefinitions;

import com.navfort.pages.AddEventPage;
import com.navfort.pages.GeneralinfoPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VehicleCostsAddEventStepDefs {

    @When("the user selects the {string} row")
    public void the_user_selects_the_row(String options) {
        BrowserUtils.waitFor(3);

        String availableOPtions = "//td[contains(text(),'" + options + "')]";
        Driver.get().findElement(By.xpath(availableOPtions)).click();

        BrowserUtils.waitFor(3);

    }

    @Then("the user should see {string} button")
    public void the_user_should_see_button(String identifier) {

        new AddEventPage().checkIfButtonIsThere(identifier);
    }


//    @Then("the user should see {string} in {string} page")
//    public void the_user_should_see_in_page(String EventTitle, String Tabs) {
//
//
//       String EventName= "//strong[contains(text(),'"+EventTitle+"')]";
//       WebElement Event= Driver.get().findElement(By.xpath(EventName));     }


    @Then("verify {string} is displayed")
    public void verify_is_displayed(String EventName) {
        String EventLocator = "//strong[contains(text(),'" + EventName + "')]";
        WebElement Event = Driver.get().findElement(By.xpath(EventLocator));
        BrowserUtils.waitFor(2);
        Assert.assertTrue(false);
        

    }




}
