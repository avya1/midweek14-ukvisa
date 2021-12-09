package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
//nextStepButton, lessThanSixMonths, moreThanSixMonths locators and create methods
//  'void selectLengthOfStay(String moreOrLess)'
//  (Note: use switch statement for select moreOrLess stay) and
//  'void clickNextStepButton()'
    public DurationOfStayPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(className = "gem-c-button govuk-button gem-c-button--bottom-margin")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(id="response-0")
    WebElement lessThanSixMonths;
    @CacheLookup
    @FindBy(id="response-1")
    WebElement moreThenSixMonth;
    public void selectLengthOfStay(String moreOrLess){
        //use switch statement for select moreOrLess stay

        switch (moreOrLess){
            case "6 months or less":
                CustomListeners.node.log(Status.PASS, "duration is : " + lessThanSixMonths.getText());
                Reporter.log("duration is" +lessThanSixMonths.getText() + "<br>");
                clickOnElement(lessThanSixMonths);
                break;
            case "longer than 6 months":
                CustomListeners.node.log(Status.PASS, "duration is : " + moreThenSixMonth.getText());
                Reporter.log("duration is" +moreThenSixMonth.getText() + "<br>");
                clickOnElement(moreThenSixMonth);
                break;
            default:
                System.out.println("not a valid selection");

        }

    }
    public void clickNextStepButton(){
        CustomListeners.node.log(Status.PASS, "click on continue : " + nextStepButton.getText());
        Reporter.log("click on continue " +nextStepButton.getText() + "<br>");
        clickOnElement(nextStepButton);

    }


}

