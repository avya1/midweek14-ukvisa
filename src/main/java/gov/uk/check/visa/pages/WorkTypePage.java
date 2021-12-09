package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WorkTypePage extends Utility {
    //nextStepButton, selectJobTypeList locators and create methods  'void selectJobType(String job)'
    //  and 'void clickNextStepButton()'
    public WorkTypePage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(className = "gem-c-button govuk-button gem-c-button--bottom-margin")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(id="response-0")//for chile
    WebElement selectJobTypeList;
    public void selectJobType(String job){
        if(job.contains("Health and care professional")){
            CustomListeners.node.log(Status.PASS, "job type is : " + selectJobTypeList.getText());
            Reporter.log("job type is" +selectJobTypeList.getText() + "<br>");
            clickOnElement(selectJobTypeList);
        }else {
            System.out.println("not a valid selection");

        }

    }
    public void clickNextStepButton(){
        CustomListeners.node.log(Status.PASS, "Click on loginLink : " + nextStepButton.getText());
        Reporter.log("Clicking on login link " +nextStepButton.getText() + "<br>");
        clickOnElement(nextStepButton);
    }
}
