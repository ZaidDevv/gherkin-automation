package org.zaidev.testing.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LoginStepDefs extends AbstractStepDefs{
    @And("the Login button is clicked")
    public void theLoginButtonIsClicked() {
        homePage.getLoginLink().click();
    }

    @And("the password is filled with {string}")
    public void thePasswordIsFilledWithAsd(String arg0) {
        homePage.fillField("passwd",arg0);
    }

    @When("the user clicks on sign-in")
    public void theUserClicksOnSignIn() {
        homePage.getLoginButton().click();
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        Optional<WebElement> heading = Optional.of(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")));
        if(heading.isPresent()){
            assertEquals("MY ACCOUNT",heading.get().getText());
        }
    }
}
