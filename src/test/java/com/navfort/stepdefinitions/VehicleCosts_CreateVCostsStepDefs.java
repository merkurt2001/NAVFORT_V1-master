package com.navfort.stepdefinitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.VehicleCosts_CreateVCosts;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class VehicleCosts_CreateVCostsStepDefs {

    @When("the user choose date as {string}")
    public void the_user_choose_date_as(String string) {

        VehicleCosts_CreateVCosts vehicleCosts_createVCosts = new VehicleCosts_CreateVCosts();
        vehicleCosts_createVCosts.dateInbox.click();

        BrowserUtils.waitFor(3);
        vehicleCosts_createVCosts.currentDay.click();
    }
/*
//Get Today's number
        String today = vehicleCosts_createVCosts.getCurrentDay();


        //Click and open the datepickers
        driver.findElement(By.xpath(".//*[fusion_builder_container hundred_percent="yes" overflow="visible"][fusion_builder_row][fusion_builder_column type="1_1" background_position="left top" background_color="" border_size="" border_color="" border_style="solid" spacing="yes" background_image="" background_repeat="no-repeat" padding="" margin_top="0px" margin_bottom="0px" class="" id="" animation_type="" animation_speed="0.3" animation_direction="left" hide_on_mobile="no" center_content="no" min_height="none"][@id='godate']")).click();

        //This is from date picker table
        WebElement dateWidgetFrom = driver.findElement(By.xpath(".//*[@id='calendar-100000000']/div[3]/table/tbody"));

        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {

            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }

        //Wait for 4 Seconds to see Today's date selected.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

*/
}
