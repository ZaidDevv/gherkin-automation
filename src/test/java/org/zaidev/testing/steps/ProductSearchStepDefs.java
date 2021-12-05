package org.zaidev.testing.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class ProductSearchStepDefs extends AbstractStepDefs{
    @Given("the user inputs {string} in the search bar")
    public void theUserInputsProductInTheSearchBar(String str) {
        homePage.fillField("search_query_top",str);
    }

    @When("the search button is clicked")
    public void theSearchButtonIsClicked() {
        homePage.searchBarSubmit();
    }

    @Then("the {string} is in the search results")
    public void theProductIsInTheSearchResults(String str) {
        List<WebElement> products = driver.findElements(By.className("product-name"));
        List<String> productNames = products.stream().map(WebElement::getText).collect(Collectors.toList());

        if(!productNames.contains(str)){
            fail();
        }
    }

    @Then("the search page should be displayed")
    public void theSearchPageShouldBeDisplayed(){
        assertEquals("My Store", driver.getTitle());
    }
}
