package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import techproed.utilities.Driver;



public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //anasayfada sadece login butona tiklanacak. https://www.bluerentalcars.com/

    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginButton;

//Homework 5
@FindBy(xpath = "//select[@name='car']")
public  WebElement selectACar;
    @FindBy(xpath = "(//input[@placeholder='Select a place'])[1]")
    public WebElement pickUp;
    @FindBy(xpath = "(//input[@placeholder='Select a place'])[2]")
    public WebElement dropOff;
    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pickUpDate;
    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOffDate;
    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pickUpTime;
    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOffTime;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()='Please first login']")
    public WebElement reservationErrorMessage;


}
