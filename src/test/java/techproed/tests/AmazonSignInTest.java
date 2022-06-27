package techproed.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonSignInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class AmazonSignInTest {

    AmazonSignInPage amazonSignInPage = new AmazonSignInPage();

    @Test
    public void amazonSignInTest(){
//        Go to the Amazon website
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
//        Click on sign in button
        amazonSignInPage.signInTab.click();
//        Send e mail by using faker
        amazonSignInPage.emailBox.sendKeys(Faker.instance().internet().emailAddress());
//        Click on continue
        amazonSignInPage.continueButton.click();
//        Assert "There was a problem"  message
        String warningMessageText = amazonSignInPage.warningMessage.getText();
        Assert.assertEquals(warningMessageText,"There was a problem");
//        Click on "Need help?"
        amazonSignInPage.needHelp.click();
//        Click on "Forgot your Password?"
        amazonSignInPage.forgotPasswordLink.click();
//        Verify the text "Password assistance"
        Assert.assertTrue(amazonSignInPage.passwordAssistance.isDisplayed());
//        Navigate back
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();

//        Click on "Create your account" button
        amazonSignInPage.createAccountButton.click();

//        Verify the text "Create account"
        String createAccountText =  amazonSignInPage.createAccountText.getText();
        Assert.assertEquals(createAccountText,"Create account");

    }

}
