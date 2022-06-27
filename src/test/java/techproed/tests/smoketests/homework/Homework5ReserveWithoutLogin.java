package techproed.tests.smoketests.homework;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

/*
   Name:
   Require user to login for reservation
   Description:
   User should see a message when user tries to book a car while not logged in
   Acceptance Criteria:
   As customer, I should be able to see error message, when I try to book a car while not logged in
   Message: Please first log in
   Given user is on the login page
   And tries to book a car
   And click continue reservation
   Then user see the warning message: Please first log in
*/

public class Homework5ReserveWithoutLogin {

    HomePage homePage;
    @Test
    public void loginBeforeReservation(){
        homePage=new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        Select select=new Select(homePage.selectACar);
        select.selectByVisibleText("audi");
        homePage.pickUp.sendKeys("Toronto");
        homePage.dropOff.sendKeys("Kitchener");
        homePage.pickUpDate.sendKeys("10/09/2022");
        homePage.pickUpTime.sendKeys("11:36AM");
        homePage.dropOffDate.sendKeys("10/10/2022");
        homePage.dropOffTime.sendKeys("10:36PM");
        homePage.submitButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue((homePage.reservationErrorMessage.isDisplayed()));

    }

}
