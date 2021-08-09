package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEventPage extends BasePage   {

//    @FindBy(xpath = "//h1[contains(text(),'Create Car')")
//    public WebElement subtitle;

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


}

