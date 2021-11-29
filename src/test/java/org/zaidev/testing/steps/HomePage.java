package org.zaidev.testing.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class HomePage {
    private WebDriver webDriver;
    private static final String PAGE_URL = "http://automationpractice.com";

    private static final By CONTACT_ERROR = By.xpath("//*[@id=\"center_column\"]/div/ol/li");

    @FindBy(className = "login")
    private WebElement loginButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(id = "submitMessage")
    private WebElement sendMessageButton;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void openPage() {
        webDriver.get(PAGE_URL);
        PageFactory.initElements(webDriver,this);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickSendMessageButton(){
        sendMessageButton.click();
    }
    public void clickContactUsButton(){
        contactUsButton.click();
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


    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }

    public WebElement getField(By locator) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webDriver.findElement(locator);
    }
    public void fillDropDown(String field, String value) {
        getDropDown(By.id(field)).sendKeys(value);
    }

    public WebElement getDropDown(By locator) {
        return webDriver.findElement(locator);
    }



    public Optional<String> getContactError() {
        return getErrorMessage(CONTACT_ERROR);
    }


    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = webDriver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }
}
