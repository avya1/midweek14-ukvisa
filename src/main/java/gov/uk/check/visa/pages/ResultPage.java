package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class ResultPage extends Utility {
// resultMessage locator and create methods 'String getResultMessage()'
// and 'void confirmResultMessage(String expectedMessage)' (Note Use Assert.assertTrue)
public ResultPage(){
    PageFactory.initElements(driver, this);
}
    @CacheLookup
    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")//string expected=You need a visa to work in health and care for chile
    WebElement resultMessage;
    @CacheLookup
    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultMessage1;//String exp ="You’ll need a visa to join your family or partner in the UK" for columbia
    public String getResultMessage(){

        CustomListeners.node.log(Status.PASS, "Result Text is  : " + resultMessage.getText());
        Reporter.log("Result Text is" +resultMessage.getText() + "<br>");
        String result= resultMessage.getText();
        return result;
    }
    public void confirmResultMessage(String expectedMessage){
        Assert.assertTrue(expectedMessage.equals(getResultMessage()));

    }
}
