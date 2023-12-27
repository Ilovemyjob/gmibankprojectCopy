package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_003_Registration_Password {

    public US_003_Registration_Password() {
        PageFactory.initElements(Driver.getDriver(), this);}
    //halloooooo



    @FindBy(id = "account-menu")
    public WebElement dropDown;

    @FindBy(linkText = "Register")
    public WebElement registerButton;



    @FindBy(id = "strengthBar")
    public WebElement strengthBar;






}



























