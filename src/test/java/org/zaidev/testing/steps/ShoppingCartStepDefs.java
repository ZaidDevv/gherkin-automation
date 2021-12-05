package org.zaidev.testing.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

public class ShoppingCartStepDefs extends AbstractStepDefs{
    @Given("the user is on the {string} product page")
    public void theUserIsOnTheProductProductPage(String str){
        List<WebElement> products = homePage.getFeaturedProducts();
        for(WebElement prod : products){
            if(prod.getText().equals(str)){
                driver.navigate().to(prod.getAttribute("href"));
                return ;
            }
        }
        fail();
    }

    @And("inputs the products {string}")
    public void inputsTheProductsQuantity(String str) {
        homePage.fillField("quantity_wanted",str);
    }

    @And("selects the {string} size")
    public void selectsTheSizeSize(String str) {
        Select drpdown = new Select(homePage.getField(By.xpath("//*[@id=\"group_1\"]")));
        List<String> options = drpdown.getOptions().stream().map(o -> o.getText()).collect(Collectors.toList());
        if (options.contains(str)) {
            drpdown.selectByVisibleText(str);
        }
        else{
            drpdown.selectByIndex(0);
        }
    }

    @And("picks the {string} color")
    public void picksTheColorColor(String str) {
        List<WebElement> colors = driver.findElements(By.className("color_pick"));
        for(WebElement element : colors){
            if(element.getAttribute("title").equals(str))
                element.click();
        }
    }

    @When("the user adds the item to the cart")
    public void theUserAddsTheItemToTheCart() throws InterruptedException {
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(2000);

    }

    @Then("the {string} should be added to the cart")
    public void theProductShouldBeAddedToTheCart(String str) {
        driver.navigate().to("http://automationpractice.com/index.php?controller=order");
        List<WebElement> prods = driver.findElements(By.className("product-name"));
        for(WebElement element : prods){
            if(element.getText().equals(str)){
                return ;
            }
        }
        fail();
    }

}
