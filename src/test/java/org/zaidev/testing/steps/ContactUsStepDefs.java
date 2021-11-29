package org.zaidev.testing.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Optional;

import static org.junit.Assert.fail;

public class ContactUsStepDefs extends AbstractStepDefs{
    @And("the Contact Us form link is clicked")
    public void theContactUsFormLinkIsClicked() {
        homePage.getContactUsButton().click();
    }

    @Given("{string} is filled")
    public void headingIsFilled(String str) {
        Select drpdown = new Select(homePage.getDropDown(By.id("id_contact")));
        if (drpdown.getOptions().contains(homePage.getDropDown(By.id("id_contact")))) {
            drpdown.selectByVisibleText(str);
        } else {
            drpdown.selectByIndex(0);
        }
    }

    @And("the {string} is filled")
    public void theEmailIsFilled(String str) {
        homePage.fillField("email",str);
    }

    @And("the {string} is also filled")
    public void theMessageIsFilled(String str) {
        homePage.fillField("message",str);
    }


    @When("the form is submitted")
    public void theFormIsSubmitted() {
        homePage.getSendMessageButton().click();
    }

    @Then("this {string} is shown")
    public void thisErrorsIsShown(String str) {
        Optional<String> errorMessage = homePage.getContactError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(str, errorMessage.get());
        } else {
            fail();
        }
    }
}
