package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {
    //nextStepButton, yes, no locators and create methods 'void selectImmigrationStatus(String status)'
    //  (Note: Use switch statement for select immigration status) and 'void clickNextStepButton()'
    public FamilyImmigrationStatusPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(className = "gem-c-button govuk-button gem-c-button--bottom-margin")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(id="response-0")
    WebElement yes;
    @CacheLookup
    @FindBy(id="response-1")
    WebElement no;
    public void selectImmigrationStatus(String status){
        //use switch method for select Immigration

        switch (status){
            case "yes":
                CustomListeners.node.log(Status.PASS, "option selected is : " + yes.getText());
                Reporter.log("option selected is " +yes.getText() + "<br>");
                clickOnElement(yes);
                break;
            case "no":
                CustomListeners.node.log(Status.PASS, "option selected is  : " +no.getText());
                Reporter.log("option selected is  " +no.getText() + "<br>");
                clickOnElement(no);
                break;
            default:
                System.out.println(" Please select any of option");

        }

    }
    public void clickNextStepButton(){
        CustomListeners.node.log(Status.PASS, "click on continue button : " + nextStepButton.getText());
        Reporter.log("click on continue button " +nextStepButton.getText() + "<br>");
        clickOnElement(nextStepButton);
    }
}
