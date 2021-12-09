package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ResponseForTravelPage extends Utility {
    //nextStepButton, reasonForVisitList locators and create methods  'void selectReasonForVisit(String reason)'
    //and  'void clickNextStepButton()'
    public ResponseForTravelPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(className = "gem-c-button govuk-button gem-c-button--bottom-margin")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(id = "response-1")//select reason to visit chile
    WebElement reasonForVisitList;
    @CacheLookup
    @FindBy(id = "response-0")
    WebElement reasonForVisitList2;//for australia
    @CacheLookup
    @FindBy(id = "response-4")
    WebElement reasonForVisitList1;//for columbia

    public void selectReasonForVisit(String reason) {
        if (reason.contains("Work, academic visit or business")) {
            CustomListeners.node.log(Status.PASS, "reason for visit is  : " + reasonForVisitList.getText());
            Reporter.log("Reason for visit is" +reasonForVisitList.getText() + "<br>");
            clickOnElement(reasonForVisitList);
        } else if (reason.contains("Tourism")) {
            CustomListeners.node.log(Status.PASS, "reason for visit is  : " + reasonForVisitList2.getText());
            Reporter.log("Reason for visit is" +reasonForVisitList2.getText() + "<br>");
            clickOnElement(reasonForVisitList2);
        } else if (reason.contains("Join partner or family for a long stay")) {
            CustomListeners.node.log(Status.PASS, "reason for visit is  : " + reasonForVisitList1.getText());
            Reporter.log("Reason for visit is" +reasonForVisitList1.getText() + "<br>");
            clickOnElement(reasonForVisitList1);
        }

    }

    public void clickNextStepButton() {
        CustomListeners.node.log(Status.PASS, "click on continue : " + nextStepButton.getText());
        Reporter.log("click on continue" +nextStepButton.getText() + "<br>");
        clickOnElement(nextStepButton);
    }
}
