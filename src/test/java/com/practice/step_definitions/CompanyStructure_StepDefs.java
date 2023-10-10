package com.practice.step_definitions;

import com.practice.pages.CompanyStructure_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CompanyStructure_StepDefs {

    CompanyStructure_Page companyStructure_page = new CompanyStructure_Page();

    @And("user locates {string} menu and clicks")
    public void userLocatesMenuAndClicks(String menuItem) {
        companyStructure_page.employeesMenuItem.click();
    }

    @Then("user sees {string} is displayed")
    public void userSeesIsDisplayed(String pageTitle) {
        Assert.assertEquals("Incorrect page title","fail",companyStructure_page.companyStructure.getText());
    }


}
