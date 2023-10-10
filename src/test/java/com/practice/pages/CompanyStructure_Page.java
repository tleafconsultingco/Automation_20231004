package com.practice.pages;

import com.practice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyStructure_Page {

    public CompanyStructure_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //LOCATORS

    @FindBy(xpath="//a[@title='Employees']")
    public WebElement employeesMenuItem;

    @FindBy(xpath="//span[@id='pagetitle']")
    public WebElement companyStructure;

}
