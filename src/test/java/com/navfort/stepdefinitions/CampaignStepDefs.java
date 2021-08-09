package com.navfort.stepdefinitions;

import com.navfort.pages.CampaignPage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CampaignStepDefs {
    @Then("the user sent keys to {string} field as {string}")
    public void the_user_sent_keys_to_field_as(String textOfFiels, String value) {
        BrowserUtils.waitFor(3);
        new CampaignPage().sentKeysToInputBox(textOfFiels,value);

    }

    @Then("there should be NO warning message under {string} field")
    public void there_should_be_NO_warning_message_under_field(String identifier) {
        boolean ifAnyMessageForSpecificField = new CampaignPage().findIfAnyMessageForSpecificField(identifier);
        Assert.assertFalse(ifAnyMessageForSpecificField);
    }


    @Then("the user verifies the message as {string} under {string}")
    public void theUserVerifiesTheMessageAsUnder(String expectedMessage, String fieldName) {
        String actualmessage = new CampaignPage().findMessageForSpecificField(fieldName);

        Assert.assertEquals("actual and expected is not matching",actualmessage,expectedMessage);


    }
}
