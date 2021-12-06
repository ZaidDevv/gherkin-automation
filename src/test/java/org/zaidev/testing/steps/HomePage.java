package org.zaidev.testing.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver webDriver;

    public WebElement getLoginLink() {
        return loginLink;
    }

    @FindBy(className = "login")
    private WebElement loginLink;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(id = "submitMessage")
    private WebElement sendMessageButton;

    @FindBy(id = "search_query_top")
    private WebElement searchBar;

    @FindBy(className = "product-name")
    private List<WebElement> featuredProducts;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void openPage() {
        webDriver.get(Constants.PAGE_URL);
        PageFactory.initElements(webDriver,this);
    }

    public void searchBarSubmit(){
        searchBar.submit();
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getContactUsButton() {
        return contactUsButton;
    }

    public WebElement getSendMessageButton() {
        return sendMessageButton;
    }
    public List<WebElement> getFeaturedProducts() {
        return featuredProducts;
    }

    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return webDriver.findElement(locator);
    }

}
