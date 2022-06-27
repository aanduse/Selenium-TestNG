package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonSignInPage {

    public AmazonSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy( id = "nav-link-accountList-nav-line-1")
    public WebElement signInTab;

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//h4")
    public WebElement warningMessage;

    @FindBy(xpath = "//span[@class='a-expander-prompt']")
    public WebElement needHelp;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;
    @FindBy(xpath = "//h1")
    public WebElement passwordAssistance;

    @FindBy(id = "createAccountSubmit")
    public WebElement createAccountButton;

    @FindBy(xpath = "//h1")
    public WebElement createAccountText;


}