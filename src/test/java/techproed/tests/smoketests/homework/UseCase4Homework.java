package techproed.tests.smoketests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.Homework4DomainVerify;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import java.util.ArrayList;
import java.util.List;

public class UseCase4Homework {
    //    Name:
//      Login screen error messages
//    Description:
//      User should see error message when a valid email domain is not entered
//    Acceptance Criteria:
//      As admin or customer, I should be able to see error message, when I do not provide a complete email address in email address box
//      Error Message: email must be a valid email
//      WhenI enter a valid email domain, then I should not see the error message
//      https://email-verify.my-addr.com/list-of-most-popular-email-domains.php
    HomePage homePage ;
    LoginPage loginPage;
    Homework4DomainVerify homework4DomainVerify;
    @Test
    public void domainValidityCheck() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        homework4DomainVerify=new Homework4DomainVerify();
        Driver.getDriver().get(ConfigReader.getProperty("domain_url"));
        List<String> domainList =new ArrayList<>();
        for (WebElement eachItem:homework4DomainVerify.validDomainList){
            domainList.add(eachItem.getText());
        }
//        System.out.println(domainList.toString());
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //first homepage
        homePage.homeLoginButton.click();//go an click
        //next loginpage
        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username_wrong_domain"));
        String wrong= ConfigReader.getProperty("admin_username_wrong_domain").split("@")[1];
        Assert.assertTrue(loginPage.invalidEmailFormat.isDisplayed());
//        System.out.println(wrong);
//        boolean validDomain=false;
//        for (String eachItem:domainList){
////            System.out.println(eachItem);
//            if(wrong.equalsIgnoreCase(eachItem)){
//                validDomain=true;
//                break;
//            }
//        }
//        if(!validDomain){
//            System.out.println("email must be a valid email");
//        }
    }
}