package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VisaConfirmationPage extends TestBase {
StartPage startPage;
WorkTypePage workTypePage;
SelectNationalityPage selectNationalityPage;
ResultPage resultPage;
ResponseForTravelPage responseForTravelPage;
FamilyImmigrationStatusPage familyImmigrationStatusPage;
DurationOfStayPage durationOfStayPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage=new StartPage();
        workTypePage=new WorkTypePage();
        selectNationalityPage=new SelectNationalityPage();
        resultPage=new ResultPage();
        responseForTravelPage=new ResponseForTravelPage();
        familyImmigrationStatusPage=new FamilyImmigrationStatusPage();
        durationOfStayPage=new DurationOfStayPage();

    }

    @Test(priority = 1,groups = {"smoke","regression"})
    public void anAustralianComingToUKForTourism(){
        /*
Click on start button
	Select a Nationality 'Australia'
	Click on Continue button
	Select reason 'Tourism'
	Click on Continue button
	verify result 'You will not need a visa to come to the UK'
 */  startPage.acceptCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickNextStepButton();
        responseForTravelPage.selectReasonForVisit("Tourism");
        responseForTravelPage.clickNextStepButton();
        String exp="You will not need a visa to come to the UK";
        resultPage.confirmResultMessage(exp);



    }
    @Test(priority = 2,groups = {"smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){
     /*   Click on start button
        Select a Nationality 'Chile'
        Click on Continue button
        Select reason 'Work, academic visit or business'
        Click on Continue button
        Select intendent to stay for 'longer than 6 months'
        Click on Continue button
        Select have planning to work for 'Health and care professional'
        Click on Continue button
        verify result 'You need a visa to work in health and care'

      */
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickNextStepButton();
        responseForTravelPage.selectReasonForVisit("Work,academic visit or business");
        responseForTravelPage.clickNextStepButton();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType("Health and care professional");
        workTypePage.clickNextStepButton();
        String exp="You need a visa to work in health and care";
        resultPage.confirmResultMessage(exp);


    }
    @Test(priority = 3,groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
/*
	Click on start button
	Select a Nationality 'Colombia'
	Click on Continue button
	Select reason 'Join partner or family for a long stay'
	Click on Continue button
	Select state My partner of family member have uk immigration status 'yes'
	Click on Continue button
	verify result 'You’ll need a visa to join your family or partner in the UK'

 */
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Colombia");
        selectNationalityPage.clickNextStepButton();
        responseForTravelPage.selectReasonForVisit("Join partner or family for long stay");
        responseForTravelPage.clickNextStepButton();
        familyImmigrationStatusPage.selectImmigrationStatus("yes");
        familyImmigrationStatusPage.clickNextStepButton();
        String exp="You’ll need a visa to join your family or partner in the UK";
        resultPage.confirmResultMessage(exp);

    }
}
