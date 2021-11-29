package org.zaidev.testing.steps;

import io.cucumber.java.en.Given;

public class CommonStepDefs extends AbstractStepDefs{
    @Given("The home page is opened")
    public void theHomePageIsOpened() {
            homePage.openPage();
        }
}
