package com.practice.pages;

import com.practice.utilities.BrowserUtils;
import com.practice.utilities.ConfigurationReader;
import com.practice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public Login_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //LOCATORS
    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement usernameField;
    // username field text box
    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordField;
    // password field text box
    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement logInButton;
    // log in button
    @FindBy(xpath = "//input[@id='USER_REMEMBER']")
    public WebElement rememberMe;
    // remember me box element
    @FindBy(xpath = "//label[.='Remember me on this computer']")
    public WebElement rememberMeText;
    // remember me text
    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errMessage;
    // error message
    @FindBy(xpath = "//input[@type='password']")
    public WebElement maskedAttribute;

    //METHODS

    // Log in with valid credentials
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        BrowserUtils.sleep(3);
        logInButton.click();
        // verification that we logged
    }


    // Log in with a specific userType
    public void loginAsUserType(String userType) {
        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        logInButton.click();
    }

}
