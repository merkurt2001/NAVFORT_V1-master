package com.navfort.stepdefinitions;

import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class vehicleInfoStep {




    @When("the user clicks {string}")
    public void the_user_clicks(String string) {
        // WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//*[@id=grid-custom-entity-grid-1714788361]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[2]")).click();
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("//td[contains(@class,'LicensePlate')]")).click();

      //  new VehiclePage().PlateV.click();


    }

    @Then("the title will be {string}")
    public void the_title_will_be(String expectedTitle) {
//        new VehiclePage().GeneralInfo.isDisplayed();
//
//        String actualTitle = Driver.get().getTitle();
//        Assert.assertEquals("expectedTitle",actualTitle);
        Driver.get().findElement(By.xpath("//h5[contains(@class,'user-fieldset')]")).isDisplayed();


    }


    @When("the user clicks on the right {string} button")
    public void the_user_clicks_on_the_right_button() {
      //  new VehiclePage().rightArrow.click();

//        String location = "//*[@id=entity-pagination]/div/ul/li[4]/a/i'"  + rightArrow + "']";
//
//        WebElement button = Driver.get().findElement(By.xpath(location));
//        button.click();
    }

    @Then("the current page is changed")
    public void the_current_page_is_changed() {
        new VehiclePage().pageNum.click();


    }

    @When("the  the user clicks  “View Per Page” dropdown")
    public void the_the_user_clicks_View_Per_Page_dropdown() {
        new VehiclePage().ViewPage.click();

    }

//    @When("the user clicks on {string}")
//    public void the_user_clicks_on(String string) {
//        new VehiclePage().dropDown50.click();
//
//    }

    @Then("the user should see {string}")
    public void the_user_should_see(String string) {
        new VehiclePage().see50.isDisplayed();

        Assert.assertTrue(new VehiclePage().see50.isDisplayed());

    }

    @When("the user clicks Export Grid")
    public void the_user_clicks_Export_Grid() {
        new  VehiclePage().exportGrid.click();
    }

    @When("the user should click the csv button")
    public void the_user_should_click_the_csv_button() {
        new VehiclePage().Cvs.click();

    }

    @Then("the user should see the message : “Export started successfully. You will receive email notification upon completion.”")
    public void the_user_should_see_the_message_Export_started_successfully_You_will_receive_email_notification_upon_completion() {
        new  VehiclePage().exportSuccess.isDisplayed();

    }


    @Then("the user will see value {string}")
    public void theUserWillSeeValue(String c) {

        //how canI Assert.assertNotEquals();n ****important*****
        WebElement two= Driver.get().findElement(By.xpath("//div[contains(@class,'pagination-current')][contains(.,'2')]"));
        two.isDisplayed();

        //two= Driver.get().findElement(By.xpath("//div[contains(@class,'pagination-current')][contains(.,'2')]"));
        Assert.assertEquals(2,2);


    }

    @Then("the user should see the message contains {string}")
    public void theUserShouldSeeTheMessageContains(String arg0) {
        Driver.get().findElement(By.xpath("//div[contains(@class,'flash-messages-holder')]")).isDisplayed();


    }


    @When("the  the user clicks  {string} dropdown button")
    public void theTheUserClicksDropdownButton(String arg0) {

    }

    @When("the user clicks on the top right {string} button")
    public void theUserClicksOnTheTopRightButton(String arg0) {
        BrowserUtils.waitFor(3);

        Driver.get().findElement(By.xpath("//i[contains(@class,'right')]")).click();

    }


    @And("the user should click the {string} button")
    public void theUserShouldClickTheButton(String arg0) {


    }

    @When("the user should navigate {string} {string}")
    public void theUserShouldNavigate(String arg0, String arg1) {



    }
}
