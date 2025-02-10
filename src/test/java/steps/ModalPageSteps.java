package steps;

import businessLogic.BaseClass;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import pages.ModalPage;

import java.io.IOException;
import java.util.Map;

public class ModalPageSteps {

    WebDriver driver = BaseClass.getDriver();
    ModalPage modalPage;

    public ModalPageSteps() throws IOException {

        modalPage = new ModalPage(driver);
    }

    //then i click on a modal {string} link
    @When("I click on a modal {string} link")
    public void i_click_on_a_modal_link(String modalLinkText) throws InterruptedException {

        modalPage.clickModal(modalLinkText);;
    }

    //close the modal
    @When("I close the simple modal")
    public void i_close_the_simple_modal() {
        modalPage.closeModal();
        BaseClass.getLogger().info("Simple Modal closed");
    }


    //i close the form modal
    @When("I close the form modal")
    public void i_close_the_form_modal() {
        modalPage.closeFormModal();
        BaseClass.getLogger().info("Form modal closed");
    }

    // And i verify modal text
    @When("I verify modal text {string}")
    public void i_verify_modal_text(String expectedText) throws InterruptedException {
        modalPage.verifyModalText(expectedText);
    }
    // and i submit the form modal
    @When("I submit the form modal")
    public void i_submit_the_form_modal() {
        modalPage.submitFormModal();
        BaseClass.getLogger().info("Form modal submitted");
    }


    @When("I enter first name email and message")
    public void iEnterFirstNameEmailAndMessage(DataTable dataTable) {
        BaseClass.getLogger().info("Entering first name email and message");
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        modalPage.setName(dataMap.get("firstname"));
        modalPage.setEmail(dataMap.get("email"));
        modalPage.setMessage(dataMap.get("message"));

    }
}
