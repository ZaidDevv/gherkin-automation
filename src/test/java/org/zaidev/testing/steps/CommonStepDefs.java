package org.zaidev.testing.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CommonStepDefs extends AbstractStepDefs{
    @Given("The home page is opened")
    public void theHomePageIsOpened() {
            homePage.openPage();
            assertEquals("My Store",driver.getTitle());
        }

    @Then("this {string} is shown")
    public void thisErrorsIsShown(String str) {
        WebElement element = driver.findElement(By.className("alert-danger"));
        List<WebElement> errors = element.findElements(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
        if (errors.size() > 0) {
            assertEquals(str, errors.get(0).getText());
        } else {
            fail();
        }
    }

    @And("the email is filled with {string}")
    public void theEmailIsFilledWithEMail(String str) {
        homePage.fillField("email",str);
    }

    @Then("the output message {string} is shown")
    public void theOutputMessageOutputMessageIsShown(String str) {
        Optional<WebElement> element = Optional.of(driver.findElement(By.xpath(Constants.OUTPUT)));
        if (element.isPresent()) {
            assertTrue(element.get().getText().contains(str));
        } else {
            fail();
        }
    }
}
