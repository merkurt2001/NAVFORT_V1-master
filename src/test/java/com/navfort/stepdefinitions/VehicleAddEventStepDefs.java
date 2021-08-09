package com.navfort.stepdefinitions;

import com.navfort.pages.VehicleDetailPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VehicleAddEventStepDefs {

    @When("the user selects the vehicle with licence plate {string}")
    public void the_user_selects_the_vehicle_with_licence_plate(String licencePlate) throws Exception {
        String locator = "//td[.='" + licencePlate + "']";
        //BrowserUtils.waitFor(5);
        Thread.sleep(4000);


        try {
            Driver.get().findElement(By.xpath("//button[@title='close']")).click();
            Thread.sleep(4000);
        } catch (Exception e) {
          // throw new Exception("sacmalama");
        }
        Driver.get().findElement(By.xpath(locator)).click();

        VehicleDetailPage vehicleDetailPage = new VehicleDetailPage();
        String actualSubtitle = vehicleDetailPage.subtitle.getText();

        Assert.assertTrue("expected that subtitle contains licence plate, but not found", actualSubtitle.contains(licencePlate));


    }

    @When("the user clicks on Add Event button")
    public void the_user_clicks_on_Add_Event_button() throws InterruptedException {

        VehicleDetailPage vehicleDetailPage = new VehicleDetailPage();
        //BrowserUtils.waitFor(4);
        Thread.sleep(4000);
        vehicleDetailPage.addEventButton.click();

    }

    @Then("the user verifies add event page")
    public void the_user_verifies_add_event_page() throws InterruptedException {
        //BrowserUtils.waitFor(6);
        Thread.sleep(4000);
        Assert.assertEquals("add event wimdow cannot found", "Add Event", new VehicleDetailPage().addEventWindowTitle.getText());
    }

    @When("the user fills title as {string} and description as {string}")
    public void the_user_fills_title_as_and_description_as(String title, String description) {

        VehicleDetailPage vehicleDetailPage = new VehicleDetailPage();

        vehicleDetailPage.titleInputBox.sendKeys(title);


        Driver.get().switchTo().frame(new VehicleDetailPage().descriptionIframe);
        BrowserUtils.waitFor(2);
        vehicleDetailPage.descriptionInputBox.sendKeys(description);
        Driver.get().switchTo().defaultContent();

    }

    @When("the user clicks on save button")
    public void the_user_clicks_on_save_button() {
        new VehicleDetailPage().addEventSaveButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the user should see {string} message")
    public void the_user_should_see_message(String message) {

        String actualSuccessMessage = new VehicleDetailPage().successMessage.getText();

        Assert.assertEquals("success message is not present or not matching", message, actualSuccessMessage);

    }


}
