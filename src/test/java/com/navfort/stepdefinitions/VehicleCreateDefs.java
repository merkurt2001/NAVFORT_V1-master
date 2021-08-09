package com.navfort.stepdefinitions;

import com.navfort.pages.AllCarsPage;
import com.navfort.pages.VehicleCreatePage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleCreateDefs {


    @When("the user clicks on create car button")
    public void the_user_clicks_on_create_car_button() {
        BrowserUtils.waitFor(8);
        AllCarsPage allCarsPage = new AllCarsPage();
        allCarsPage.createCarButton.click();
    }


    @Then("the subtitle changes to {string}")
    public void the_subtitle_changes_to(String expectedSubTitle) {

        VehicleCreatePage vehicleCreatePage = new VehicleCreatePage();

        String actualSubtitle = vehicleCreatePage.subtitle.getText();

        Assert.assertEquals("expected subtitle is not Create Car", expectedSubTitle, actualSubtitle);


    }


    @Then("click the +Add button of the Vehicle Model")
    public void click_the_Add_button_of_the_Vehicle_Model() {

        VehicleCreatePage vehicleCreatePage = new VehicleCreatePage();

        vehicleCreatePage.addModel.click();

    }

    @When("the user should see following model options")
    public void the_user_should_see_following_model_options(List<String> expectedAvailableModels) {
        BrowserUtils.waitFor(4);
        //object create
        VehicleCreatePage vehicleCreatePage = new VehicleCreatePage();


        //get all models from table
        List<WebElement> availableModels = vehicleCreatePage.availableModels;


        //create empty list of string to store all model names
        List<String> ActualAvailableModels = new ArrayList<>();

        //get all texts of the models and put into list of string

        for (WebElement EachAvailableModel : availableModels) {
            ActualAvailableModels.add(EachAvailableModel.getText());
        }


        String expected = expectedAvailableModels.toString();
        String actual = ActualAvailableModels.toString();

        Assert.assertEquals("expected model names are not matching with actual", expected, actual);


    }


    @Then("the user enters the provided data for the new car")
    public void the_user_enters_the_provided_data_for_the_new_car(Map<String, String> dataTable) {

        //VehicleCreatePage vehicleCreatePage=new VehicleCreatePage();
        new VehicleCreatePage().LicensePlateButton.sendKeys("License Plate");


    }

    @Then("click save and close button")
    public void click_save_and_close_button() {
        VehicleCreatePage vehicleCreatePage = new VehicleCreatePage();
        vehicleCreatePage.SaveAndCloseButton.click();


    }

    @Then("verify the car with license number {string} is displayed")
    public void verify_the_car_with_license_number_is_displayed(String expectedLicenseNumber) {
        BrowserUtils.waitFor(3);
        VehicleCreatePage vehicleCreatePage = new VehicleCreatePage();
        String ActualLicensePlate = vehicleCreatePage.LicensePlateButton.getAttribute("License Plate");

        Assert.assertEquals(expectedLicenseNumber, ActualLicensePlate);


    }





}

