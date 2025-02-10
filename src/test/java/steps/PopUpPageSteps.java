package steps;

import businessLogic.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PopUpPage;

import java.io.IOException;

public class PopUpPageSteps {

    WebDriver driver = BaseClass.getDriver();
    PopUpPage popUpPage;

    public PopUpPageSteps() throws IOException {
        popUpPage = new PopUpPage(driver);
    }


    @When("I verify text {string} on alert popup")
    public void i_verify_text_on_alert_popup(String string) throws InterruptedException {
        BaseClass.getLogger().info("I verify text {string} on alert!");
        popUpPage.verifyAlertPopup(string);
    }

    @Then("I click ok on alert popup")
    public void i_click_ok_on_alert_popup() {
        BaseClass.getLogger().info("I click ok on alert!");
        popUpPage.acceptAlert();
    }

    //click cancel on alert popup
    @When("I click cancel on alert popup")
    public void iClickCancelOnAlertPopup() {
        BaseClass.getLogger().info("I click cancel on alert!");
        popUpPage.dismissAlert();
    }

    @Then("I verify text {string} on confirm popup")
    public void iVerifyTextOnConfirmPopup(String string) {
        BaseClass.getLogger().info("I verify text {string} on confirm!");
        popUpPage.verifyConfirmPopup(string);
    }
    //when i click on prompt popup link
    //enter alertprompt
    @When("I enter {string} in alert prompt")
    public void iEnterAlertPrompt(String string) throws InterruptedException {
        BaseClass.getLogger().info("I enter {string} in alert prompt!");
        popUpPage.enterAlertPrompt(string);

    }
    // when i verify ok or cancel on prompt popup
    @Then("I verify {string} on prompt popup")
    public void iVerifyOnPromptPopup(String string) throws InterruptedException {
        BaseClass.getLogger().info("I verify {string} on prompt!");
        popUpPage.verifyokOrCancel(string);
    }
    @When("I click on {string} Popup link")
    public void iClickOnPopupLink(String arg0) throws InterruptedException {
        BaseClass.getLogger().info("I click on {string} popup!");
        popUpPage.clickonPopup(arg0);
    }

}
