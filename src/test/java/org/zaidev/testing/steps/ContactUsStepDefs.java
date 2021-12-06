package org.zaidev.testing.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

public class ContactUsStepDefs extends AbstractStepDefs{
    @And("the Contact Us form link is clicked")
    public void theContactUsFormLinkIsClicked() {
        homePage.getContactUsButton().click();
    }


    @Given("the Subject heading is filled with {string}")
    public void theSubjectHeadingIsFilledWithSubjectHeading(String str) {
        Select drpdown = new Select(homePage.getField(By.id("id_contact")));
        List<String> options = drpdown.getOptions().stream().map(o -> o.getText()).collect(Collectors.toList());
        if (options.contains(str)) {
            drpdown.selectByVisibleText(str);
        }
        else{
            drpdown.selectByIndex(0);
        }
    }


    @And("the message is filled with {string}")
    public void theMessageIsFilledWithMessage(String str) {
        homePage.fillField("message",str);
    }

    @When("the form is submitted")
    public void theFormIsSubmitted() {
        homePage.getSendMessageButton().click();
    }

}
