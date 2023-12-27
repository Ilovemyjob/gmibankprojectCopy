package gmibank.stepdefinitions;


import gmibank.pages.US_015_Manage_Account;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_015_Manege_Account_sd<WebElements> {



    US_015_Manage_Account us_015_manage_account= new US_015_Manage_Account();
    @Then("user click to Sign in button")
    public void user_click_to_Sign_in_button() {

          us_015_manage_account.signin.click();
    }

    @Then("user click User name button")
    public void user_click_User_name_button() {

        us_015_manage_account.username.click();
    }

    @Then("user type Username {string}")
    public void user_type_Username(String string) {

        Driver.waitAndSendText(us_015_manage_account.username,string,2);

    }

    @Then("user click to Password")
    public void user_click_to_Password() {

        Driver.waitForClickablility(us_015_manage_account.Password,2);

    }

    @Then("user type Password {string}")
    public void user_type_Password(String string) {

        Driver.waitAndSendText(us_015_manage_account.Password,string,2);

    }
    @Then("user click Sign in")
    public void user_click_Sign_in() {
        Driver.clickWithTimeOut(us_015_manage_account.Sign_in_enter,2);

    }

    @Then("user click My Operation button")
    public void user_click_My_Operation_button() {

        Driver.clickWithTimeOut(us_015_manage_account.My_Operation,2);
    }

    @Then("user click Manage Accounts button")
    public void user_click_Manage_Accounts_button() {

        us_015_manage_account.My_Account.click();
    }

    @Then("check all account types")
    public void check_all_account_types() {



   //     List<Object> element=Driver.getElementsText(us_015_manage_account.Account_Types);

        for (WebElement element:us_015_manage_account.Account_Types) {

            System.out.println("Account Types :" + element.getText());
            boolean account = element.isDisplayed();
            Assert.assertTrue("Test Passed", account);
            System.out.println(account);


//        List<String> expectedText = Arrays.asList("CHECKING", "SAVING", "CREDIT_CARD", "INVESTING");



//        List<Strings> webElements = Driver.getElementsText(us_015_manage_account.Account_Types);
//        List<String> actualText = new ArrayList<String>();
//
//        System.out.println(webElements);
//        for (WebElements each :
//                webElements) {
//            actualText.add(each);
//        }

            //      Assert.assertEquals(actualText,expectedText);
            //   }
            //    }
        }
    }
    @Then("check all balance")
    public void check_all_balance() {

//            for (WebElement element : us_015_manage_account.Balance.subList(0, 25)) {
//                System.out.println("Balance :" + element.getText());
//                boolean balance = element.isDisplayed();
//                Assert.assertTrue("Test Passed", balance);
//                System.out.println(balance);
//            }
    }

    @Then("user view transaction")
    public void user_view_transaction() {


        for (WebElement w : us_015_manage_account.ViewTransaction) {
            System.out.println(w.getText());
        }
        Assert.assertFalse(us_015_manage_account.ViewTransaction.isEmpty());
//        for (int i = 0; i < us_015_manage_account.ViewTransaction.size(); i++) {
//          //  us_015_manage_account.Transaction.get(i).click();
//            System.out.println(us_015_manage_account.ViewTransaction.get(i).getText());
//            boolean transaction = us_015_manage_account.ViewTransaction.isEmpty();
//            Assert.assertFalse("Test Passed", transaction);
//        }
    }
}





