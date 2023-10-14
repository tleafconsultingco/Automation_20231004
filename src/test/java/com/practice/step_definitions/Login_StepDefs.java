package com.practice.step_definitions;

import com.practice.pages.Login_Page;
import com.practice.utilities.BrowserUtils;
import com.practice.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.devtools.v116.browser.Browser;

public class Login_StepDefs {

    Login_Page loginPage = new Login_Page();

    @When("user logs in as {string}")
    public void userLogsInAs(String userType) {
        loginPage.loginAsUserType(userType);
    }

    @Then("user is on Home page with {string} in title")
    public void userIsOnHomePageWithInTitle(String title) {
        Assert.assertTrue("NO TITLE", Driver.getDriver().getTitle().contains(title));
        System.out.println("Successfully logged in");
    }

    @When("user logs in as {string},{string}")
    public void userLogsInAs(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("user sees error message {string}")
    public void userSeesErrorMessage(String errorMessage) {
        Assert.assertEquals("Not match",errorMessage,loginPage.errMessage.getText());
        System.out.println("Error message");
    }

    @When("user logs in with one empty text field {string},{string}")
    public void userLogsInWithOneEmptyTextField(String username, String password) {
        loginPage.login(username,password);
    }

    @When("user is on login page")
    public void userIsOnLoginPage() {
    }

    @Then("user sees {string} box")
    public void userSeesBox(String rememberMe) {
        rememberMe = "Remember me on this computer";
        Assert.assertTrue("No element", loginPage.rememberMe.isDisplayed());
        Assert.assertTrue("No text",loginPage.rememberMeText.isDisplayed());
    }

    @And("user can click Remember Me checkbox")
    public void userCanClickRememberMeCheckbox() {
        loginPage.rememberMe.click();
        Assert.assertTrue("Not selected", loginPage.rememberMe.isSelected());
        System.out.println("Remember me box is present and clickable, and text is present");
    }

    @Then("password should be masked")
    public void passwordShouldBeMasked() {
        BrowserUtils.sleep(3);
        Assert.assertEquals("negative","password", loginPage.maskedAttribute.getAttribute("type"));
        System.out.println("password masked");
    }
}
