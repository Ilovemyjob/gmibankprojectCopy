package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_015_Manage_Account {

    public US_015_Manage_Account() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "account-menu")
    public WebElement dropDown;

    @FindBy(linkText = "Register")
    public WebElement registerButton;


    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signin;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement Password;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    public WebElement Sign_in_enter;

    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement My_Operation;

    @FindBy(xpath = "//a[contains(text(),'My Accounts')]")
    public WebElement My_Account;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> Account_Types;

    @FindBy(xpath = "//td[3]")
    public WebElement Balance;

    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> Transaction;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> ViewTransaction;



}
