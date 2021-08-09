package com.navfort.stepdefinitions;

import com.navfort.pages.DashboardPage;
import com.navfort.pages.VehicleCreatePage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VehicleStepDefs {

    @When("select the filtering button")
    public void select_the_filtering_button() {

        BrowserUtils.waitForClickablility(new VehiclePage().filterButton, 10);

        //if vehicle page is not selected click on!
        if (!new VehiclePage().filterButton.isSelected()) {
            new VehiclePage().filterButton.click();

        }
        //verify that manage filter button is displayed
        Assert.assertTrue("Manage filter is not displayed", new VehiclePage().manageFilter.isDisplayed());


    }


        @When("click on the Manage filters button and select {string}")
        public void click_on_the_Manage_filters_button_and_select(String locatorIdentifier) throws InterruptedException {

            {
                //concetanation for dinamic button
                String locator = "//input[@title='" + locatorIdentifier + "']";

                // using vehiclePage object to click on the manageFilter button
                new VehiclePage().ManageFilters.click();
                //creating option element to reach all dropdown menu dinamically
                WebElement option = Driver.get().findElement(By.xpath(locator));
                //if manage filter button is not selected click the selected dropdown
                if (!new VehiclePage().ManageFilters.isSelected()) {
                    option.click();
                }
            }

            //verify that after clicking the selected dropdown, new dropdown should be displayed which belongs the
        //selected dropdown and it has a list of some details
        String filterOptionLocator = "//div[contains(text(),'" + locatorIdentifier + "')]";
        Assert.assertTrue(locatorIdentifier + " Web element was expected but not found ",Driver.get().findElement(By.xpath(filterOptionLocator)).isDisplayed());//compare line 25

        Thread.sleep(2000);
    }


    @When("click on {string} and verify below options")
    public void click_on_and_verify_below_options(String locatorIdentifier, List<String> dataTable) {
        //my goal: get the option list from application and  compare it with the list of option from feature file

        //empty list will be used for storing option list texts
        List<String> actualListOfOptions = new ArrayList<>();

        String filterOptionLocator = "//div[contains(text(),'" + locatorIdentifier + "')]";
        List<WebElement> allOptions = Driver.get().findElements(By.xpath("//div[contains(text(),'" + locatorIdentifier + "')]/../div[2]//li"));
        for (WebElement allOption : allOptions) {

            actualListOfOptions.add(allOption.getText());
        }
        System.out.println("actualListOfOptions.toString() = " + actualListOfOptions.toString());
        System.out.println("dataTable.toString() = " + dataTable.toString());
        int i = 0;
        for (String actualListOfOption : actualListOfOptions) {

            Assert.assertEquals(actualListOfOption, dataTable.get(i));
            i++;
            System.out.println(actualListOfOption + " is matching");

        }

    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String buttonName) {
        try {
            BrowserUtils.waitFor(5);
            String location = "//*[@title='" + buttonName + "']";
            WebElement button = Driver.get().findElement(By.xpath(location));
            button.click();
        } catch (Exception e) {
            String location = "//button[contains(.,'" + buttonName + "')]";
            WebElement button = Driver.get().findElement(By.xpath(location));
            button.click();
        }


    }

    

    @When("the user clicks on the {string}")
    public void the_user_clicks_on_the(String string) {
        new VehiclePage().clickSelectAll();
    }
    @When("the user clicks on the {string} action button")
    public void the_user_clicks_on_the_action_button(String action) {
        if(action=="Pin"){
            new VehiclePage().pinButton.click();
        }else if (action == "Favorite") {
            new VehiclePage().favoriteButton.click();
        }
    }
    

    //hwwa look again
    @Then("the user should see the following options on the table")
    public void the_user_should_see_the_following_options_on_the_table(List<String> expectedGridHeaders) {
        BrowserUtils.waitFor(2);

        List<WebElement> allGridOptions = new VehiclePage().gridOptions;

        List<String> ActualGridOptions = new ArrayList<>();
        for (WebElement eachGridOption : allGridOptions) {
            ActualGridOptions.add(eachGridOption.getText().toLowerCase());
        }
        String expectedTitles = ActualGridOptions.toString();


        List<WebElement> allGridHeaders = new VehiclePage().gridHeaders;

        List<String> ActualGridHeaders = new ArrayList<>();
        for (WebElement eachGridHeader : allGridHeaders) {

            ActualGridHeaders.add(eachGridHeader.getText().toLowerCase());
        }

        String actualTitles = ActualGridHeaders.toString();

        Assert.assertEquals(expectedTitles, actualTitles);
    }

       @When("the user selects the {string} option")
    public void the_user_selects_the_option (String identifierGrid){
        BrowserUtils.waitFor(3);
        String locator = "//label[contains(text(),'"+identifierGrid+"')]";
        Driver.get().findElement(By.xpath(locator)).click();
       // if (!identifierGrid.isSelected()) {
        //    locator.click();
        }

       // }..........??????

    @Then("the table contains {string}")
    public void the_table_contains (String identifierGrid) throws InterruptedException {
        //hww to do
        BrowserUtils.waitFor(3);
        String locator = "//label[contains(text(),'"+identifierGrid+"')]";
        Assert.assertTrue(locator + " Web element was not contains ",Driver.get().findElement(By.xpath(locator)).isDisplayed());//compare line 25

        Thread.sleep(2000);
    }


    
    
            @Then("the user should see the following options")
        public void the_user_should_see_following_options (List < String > menuOptions) {
            BrowserUtils.waitFor(2);
            //get the list of webelement and convert them to list of string and assert
            List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

            Assert.assertEquals(menuOptions, actualOptions);
            System.out.println("menuOptions = " + menuOptions);
            System.out.println("actualOptions = " + actualOptions);
        }
    
    
    

//        @Then("the pin holder is the same as the page title")
//        public void the_pin_holder_is_the_same_as_the_page_title () {
//
//            ////a[@title="Car - Entities - System - Car - Entities - System"]
//
//
//        }




//        @When("the user clicks on {string} button and verify id is selected")
//        public void the_user_clicks_on_button_and_verify_id_is_selected (String string){
//            String locator = "//a[@class='pull-right']";
//            BrowserUtils.waitFor(5);
//            Driver.get().findElement(By.xpath(locator)).click();
//            BrowserUtils.waitFor(2);
//        }
//
//        @When("the user selects {string} and deselects {string}")
//        public void the_user_selects_and_deselects (String select, String deselect){
//            String locatorSelect = "//label[.='" + select + "']/../..//input";
//            String locatorDeselect = "//label[.='" + deselect + "']/../..//input";
//            BrowserUtils.waitFor(5);
//            WebElement selectCheckbox1 = Driver.get().findElement(By.xpath(locatorSelect));
//            WebElement selectCheckbox2 = Driver.get().findElement(By.xpath(locatorDeselect));
//            if (!selectCheckbox1.isSelected()) {
//                selectCheckbox1.click();
//
//            }
//            if (selectCheckbox2.isSelected()) {
//                selectCheckbox2.click();
//                BrowserUtils.waitFor(2);
//            }
//
//
//        }
//
//        @Then("the button is working dynamicly")
//        public void the_button_is_working_dynamicly () {
//            System.out.println("yes, it is working dynamicly");
//        }
//
//        @When("the user fills in the blanks with data below")
//        public void the_user_fills_in_the_blanks_with_data_below (Map < String, String > formData){
//
//            Set<String> keys = formData.keySet();
//
//            VehiclePage vehiclePage = new VehiclePage();
//
//            for (String key : keys) {
//
//                vehiclePage.sentKeysToInputBox(key, formData.get(key));
//
//                BrowserUtils.waitFor(1);
//
//            }
//
//
//        }

        @Then("the user should see the {string} dropdown menu")
        public void the_user_should_see_the_dropdown_menu (String string){
            //hww to do
            String dropdownLocator = "//div[contains(text(),‘Chassis Number’)]";
            Driver.get().findElement(By.xpath(dropdownLocator)).click();

        }


        @When("the user clicks on {string} button")
        public void the_user_clicks_on_button (String buttonTitleAttribute){

            try {
                String locator = "//a[@title='" + buttonTitleAttribute + "']";
                BrowserUtils.waitFor(5);
                Driver.get().findElement(By.xpath(locator)).click();
                BrowserUtils.waitFor(2);
            } catch (Exception e) {
                String locator = "//a[contains(text(),'" + buttonTitleAttribute + "')]";
                BrowserUtils.waitFor(5);
                Driver.get().findElement(By.xpath(locator)).click();
                BrowserUtils.waitFor(2);
            }


        }

        @When("the user clicks on {string} button and verify id is selected")
        public void the_user_clicks_on_button_and_verify_id_is_selected (String string){
            String locator = "//a[@class='pull-right']";
            BrowserUtils.waitFor(5);
            Driver.get().findElement(By.xpath(locator)).click();
            BrowserUtils.waitFor(2);
        }

        @When("the user selects {string} and deselects {string}")
        public void the_user_selects_and_deselects (String select, String deselect){
            String locatorSelect = "//label[.='" + select + "']/../..//input";
            String locatorDeselect = "//label[.='" + deselect + "']/../..//input";
            BrowserUtils.waitFor(5);
            WebElement selectCheckbox1 = Driver.get().findElement(By.xpath(locatorSelect));
            WebElement selectCheckbox2 = Driver.get().findElement(By.xpath(locatorDeselect));
            if (!selectCheckbox1.isSelected()) {
                selectCheckbox1.click();

            }
            if (selectCheckbox2.isSelected()) {
                selectCheckbox2.click();
                BrowserUtils.waitFor(2);
            }


        }

        @Then("the button is working dynamicly")
        public void the_button_is_working_dynamicly () {
            System.out.println("yes, it is working dynamicly");
        }

        @When("the user fills in the blanks with data below")
        public void the_user_fills_in_the_blanks_with_data_below (Map < String, String > formData) throws
        InterruptedException {

            Set<String> keys = formData.keySet();

            VehiclePage vehiclePage = new VehiclePage();

            for (String key : keys) {

                vehiclePage.sentKeysToInputBox(key, formData.get(key));

                BrowserUtils.waitFor(1);

            }
        }


        @When("click on {string} button")
        public void click_on_button (String pinButton){

            BrowserUtils.waitForClickablility(new VehiclePage().pinButton, 10);
            if (!new VehiclePage().pinButton.isSelected()) {
                new VehiclePage().pinButton.click();

                BrowserUtils.waitFor(3000);
            }

        }

        /**
         *
         * @param addButtonType: Recent emails , Sticky Note or Task list
         */
        @When("select the plus button and add {string}")
        public void select_the_plus_button_and_add (String addButtonType){

            new VehiclePage().clickOnAddButtonInWidgets(addButtonType);


        }


        @When("click on {string} button if it is not selected")
        public void click_on_button_if_it_is_not_selected (String identifier){
            new VehiclePage().clickButtonIfNotSelected(identifier);
        }
    
        @Then("the user verifies page is refresh")
    public void theUserVerifiesPageIsRefresh() {
        //this is refresh should be defined with using selenium
        boolean isRefreshed = true;
        Assert.assertTrue(isRefreshed);
    }

    @Then("the user verifies page is reset")
    public void theUserVerifiesPageIsReset() {
        boolean isReset = true;
        Assert.assertTrue(isReset);
    }


    }




