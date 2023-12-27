package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagement {

    public UserManagement() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//li[@id='admin-menu']")
    public WebElement Administration;

    @FindBy(xpath = "//span[contains(text(),'User management')]")
    public WebElement User_management;


    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[2]")})
    public List<WebElement> allUsers;

//    @FindBy(xpath = "//table/tbody/tr/td[4]")
//    public List<WebElement> Activate;

    @FindBy(xpath = "//table/tbody/tr/td[6]")
    public List<WebElement> allRoles;

    @FindBy(xpath = "//table[1]/tbody[1]/tr/td[10]/div[1]/a[1]")
    public List<WebElement> allView;

    @FindBy(xpath = "//table[1]/tbody[1]/tr/td[10]/div[1]/a[2]")
    public List<WebElement> allEdit;

    @FindBy(xpath = "//table[1]/tbody[1]/tr/td[10]/div[1]/a[3]")
    public List<WebElement> allDelete;

//    @FindBy(xpath = "//*[@class='page-item']")
//    public List<WebElement> pages;

    @FindAll({@FindBy(xpath = "//*[@class='page-item']")})
    public List<WebElement> pages;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[4]")})
    public List<WebElement> Activate;

}
