package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class StartPage extends Utility {
    //startNowButton locators and create method 'void clickStartNow()'
    public StartPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(className ="gem-c-button govuk-button govuk-button--start")
    WebElement startNowButton;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Accept additional cookies']")
    WebElement cookies;

    public void acceptCookies(){
        CustomListeners.node.log(Status.PASS, "click on cookies: " + cookies.getText());
        Reporter.log("click on cookies " +cookies.getText() + "<br>");
        clickOnElement(cookies);
    }
    public void clickStartNow(){

        CustomListeners.node.log(Status.PASS, "Click on start now Link : " + startNowButton.getText());
        Reporter.log("Clicking on start now link " +startNowButton.getText() + "<br>");
        clickOnElement(startNowButton);
    }

}
