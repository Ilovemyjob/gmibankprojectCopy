package gmibank.stepdefinitions;

import gmibank.pages.RegistrationPage;
import gmibank.pages.US_003_Registration_Password;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US_003_Registration_Password_sd {


    US_003_Registration_Password us_003_registration_password = new US_003_Registration_Password();
    RegistrationPage registrationPage = new RegistrationPage();
    public int level;


    @Given("user click to dropdown button")
    public void user_click_to_dropdown_button() {

        us_003_registration_password.dropDown.click();

    }

    @Then("user click to register button")
    public void user_click_to_register_button() {

        us_003_registration_password.registerButton.click();
    }

    @Then("user click to New Password button")
    public void user_click_to_New_Password_button() {

        registrationPage.firstPassword.click();
    }

    @Then("user type New {string}")
    public void user_type_New(String string) {

        Driver.waitAndSendText(registrationPage.firstPassword, string, 2);

    }

    @Then("check the bar level")
    public void check_the_bar_level() {

        if (registrationPage.level_1.getAttribute("style").contains("221")) {
            System.out.println("level =" + 0);
            level=0;

        }else if (registrationPage.level_2.getAttribute("style").contains("221")) {

            System.out.println("level ="+ 1);
            level=1;

        }
        else if (registrationPage.level_3.getAttribute("style").contains("221")){
            System.out.println("level ="+ 2);
            level=2;


        }else if (registrationPage.level_4.getAttribute("style").contains("221")) {
            System.out.println("level ="+ 3);
            level=3;


        }else if (registrationPage.level_5.getAttribute("style").contains("221")) {
            System.out.println("level ="+ 4);
            level=4;


        }else{
            System.out.println("level ="+ 5);
            level=5;

        }


    }

    @Then("verify level")
    public void verify_level() {

        Assert.assertTrue(level>1);

    }
}