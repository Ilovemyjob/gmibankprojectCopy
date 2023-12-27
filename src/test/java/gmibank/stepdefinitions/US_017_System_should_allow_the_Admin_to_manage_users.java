package gmibank.stepdefinitions;

import gmibank.pages.UserManagement;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class US_017_System_should_allow_the_Admin_to_manage_users {

    UserManagement userManagement = new UserManagement();

    @Then("Click on Administration button")
    public void click_on_Administration_button() {

        Driver.waitAndClick(userManagement.Administration, 2);
    }

    @Then("Click on User Management button")
    public void click_on_User_Management_button() {
        Driver.waitAndClick(userManagement.User_management, 2);
    }

    @Then("Click on deactivated button as user")
    public void click_on_deactivated_button_as_user() throws Exception {

        int lastIndex = userManagement.pages.size() - 3;
        System.out.println(userManagement.pages.get(lastIndex).getText());
        int iterateTimes = Integer.parseInt(userManagement.pages.get(lastIndex).getText());

        int current = 0;
        boolean flag = false;

        String expectedUser = "" +
                "" +
                "" +
                "  ";
        String lastPage = "";

//        List<String> activateButton = Driver.getElementsText(userManagement.Activate);
//        List<String> allRoles = Driver.getElementsText(userManagement.allRoles);


        for (int i = 1; i <=iterateTimes; i++) {
            Thread.sleep(1000);
            int activationindex = 1;
            if(flag)break;
            System.out.println("current page=" + i);
            Thread.sleep(1000);
            Driver.waitForClickablility(Driver.getDriver().findElement(By.xpath("//*[text()='" + i + "']")), 2);
            Driver.getDriver().findElement(By.xpath("//*[text()='" + i + "']")).click();

            System.out.println(i);

             for (WebElement eachElement : userManagement.allUsers) {
                 Thread.sleep(1000);
                 System.out.println(eachElement.getText());
                 if (eachElement.getText().equalsIgnoreCase(expectedUser)) {
                     Thread.sleep(2000);
                   //  Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='" +eachElement.getText()  + "']/following::td[2]")).isSelected());
                  //  System.out.println(Driver.getDriver().findElement(By.xpath("//*[text()='" + eachElement.getText() + "']/following::td[2]")).getText());
                     Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='" + eachElement.getText() + "']/following::td[2]")).isEnabled());
                     Thread.sleep(3000);

                     Driver.getDriver().findElement(By.xpath("//*[text()='" + eachElement.getText() + "']/following::td[2]/button[1]")).click();
                     flag = true;
                     break;
                 }
                 activationindex++;
             }
//            if (allRoles.get(i).contains("ROLE_USER")) {
//                if (activateButton.get(i).contains("Deactivated")) {
//                    Assert.assertTrue(userManagement.Activate.get(i).isEnabled());
//                    Driver.waitAndClick(userManagement.Activate.get(i), 2);
//                    System.out.println(i + ". user is now activated");
//                } else {
//                    System.out.println(i + ". user is Already activated");
//                }
//
//            }
        }
    }
    @Then("Click on deactivated button as employee")
    public void click_on_deactivated_button_as_employee() {
//        List<String> activateButton=Driver.getElementsText(userManagement.Activate);
//        List<String> allRoles=Driver.getElementsText(userManagement.allRoles);
//
//
//        for (int i = 0; i < userManagement.allRoles.size(); i++) {
//
//            if (activateButton.get(i).contains("Deactivated")&&allRoles.get(i).contains("ROLE_USER")){
//                Assert.assertTrue(userManagement.Activate.get(i).isEnabled());
//                Driver.waitAndClick(userManagement.Activate.get(i),2);
//                System.out.print( i+". user is now activated");
//            }else{
//                System.out.print( i+". user is Already activated");
//            }



    //    }

    }

    @Then("Click on deactivated button as manager")
    public void click_on_deactivated_button_as_manager() {
//        List<String> activateButton=Driver.getElementsText(userManagement.Activate);
//        List<String> allRoles=Driver.getElementsText(userManagement.allRoles);
//
//
//        for (int i = 0; i < userManagement.allRoles.size(); i++) {
//
//            if (activateButton.get(i).contains("Deactivated")&&allRoles.get(i).contains("ROLE_USER")){
//                Assert.assertTrue(userManagement.Activate.get(i).isEnabled());
//                Driver.waitAndClick(userManagement.Activate.get(i),2);
//                System.out.print( i+". user is now activated");
//            }else{
//                System.out.print( i+". user is Already activated");
//            }



   //     }

    }

    @Then("Click on deactivated button as admin")
    public void click_on_deactivated_button_as_admin() {
//        List<String> activateButton=Driver.getElementsText(userManagement.Activate);
//        List<String> allRoles=Driver.getElementsText(userManagement.allRoles);
//
//
//        for (int i = 0; i < userManagement.allRoles.size(); i++) {
//
//            if (activateButton.get(i).contains("Deactivated")&&allRoles.get(i).contains("ROLE_USER")){
//                Assert.assertTrue(userManagement.Activate.get(i).isEnabled());
//                Driver.waitAndClick(userManagement.Activate.get(i),2);
//                System.out.print( i+". user is now activated");
//            }else{
//                System.out.print( i+". user is Already activated");
//            }
//
//
//
//        }

    }

    @Then("Admin should see all View button")
    public void admin_should_see_all_View_button() {


        List<WebElement> allView=userManagement.allView;
        for (WebElement each :
                allView) {
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @Then("Admin should see all Edit button")
    public void admin_should_see_all_Edit_button() {
        List<WebElement> allView=userManagement.allEdit;
        for (WebElement each :
                allView) {
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @Then("Admin should see all Delete button")
    public void admin_should_see_all_Delete_button() {
        List<WebElement> allView=userManagement.allDelete;
        for (WebElement each :
                allView) {
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }
    }





}
