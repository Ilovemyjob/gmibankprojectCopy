package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "account-menu")
    public WebElement userIcon;

    @FindBy(linkText = "Register")
    public WebElement registerButton;

    @FindBy(id="ssn")
    public WebElement ssnBox;

    @FindBy(id = "firstname")
    public WebElement firstnameBox;

    @FindBy(id="lastname")
    public WebElement lastnameBox;

    @FindBy(id="address")
    public WebElement addressBox;

    @FindBy(id="mobilephone")
    public WebElement mobilePhoneBox;

    @FindBy(id="username")
    public WebElement usernameBox;

    @FindBy(id="email")
    public WebElement emailBox;


    @FindBy(id = "firstPassword")
    public WebElement firstPassword;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/ul[1]/li[1]")
    public WebElement level_1;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/ul[1]/li[2]")
    public WebElement level_2;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/ul[1]/li[3]")
    public WebElement level_3;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/ul[1]/li[4]")
    public WebElement level_4;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/ul[1]/li[5]")
    public WebElement level_5;

    @FindBy(id = "register-title")
    public WebElement registerTitle;



}





