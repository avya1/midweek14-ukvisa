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

public class SelectNationalityPage extends Utility {
    //-nationalityDropDownList, nextStepButton locators and create methods  'void selectNationality(String nationality)'
    //  and 'void clickNextStepButton()'
    public SelectNationalityPage(){
         PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(id = "response")
    WebElement nationalityDropDownList;
    @CacheLookup
    @FindBy(className = "gem-c-button govuk-button gem-c-button--bottom-margin")
    WebElement nextStepButton;

    public void selectNationality(String nationality) {
       /* clickOnElement(nationalityDropDownList);
        if (nationality.equalsIgnoreCase("Australia")) {
            selectByVisibleTextFromDropDown(nationalityDropDownList, "Australia");
        } else if (nationality.equalsIgnoreCase("Colombia")) {
            selectByVisibleTextFromDropDown(nationalityDropDownList, "Colombia");
        } else if (nationality.equalsIgnoreCase("Chile")) {
            selectByVisibleTextFromDropDown(nationalityDropDownList, "Chile");
        }

        */
        selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
        CustomListeners.node.log(Status.PASS, "select Nationality : " + nationalityDropDownList.getText());
        Reporter.log("select Nationality" + nationalityDropDownList.getText() + "<br>");


    }

    public void clickNextStepButton() {
        CustomListeners.node.log(Status.PASS, "click on button  : " + nextStepButton.getText());
        Reporter.log("click on button" + nextStepButton.getText() + "<br>");
        clickOnElement(nextStepButton);
    }
}
