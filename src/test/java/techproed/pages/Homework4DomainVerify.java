package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class Homework4DomainVerify {
    public Homework4DomainVerify(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath= "(//table)[9]//tbody//tr//td[1]")
    public List<WebElement> validDomainList;

}

