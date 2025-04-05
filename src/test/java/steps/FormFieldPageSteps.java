package steps;

import businessLogic.BaseClass;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.FormFieldsPage;

import java.io.IOException;

public class FormFieldPageSteps {

    WebDriver driver = BaseClass.getDriver();
    FormFieldsPage formFieldPage;

    public FormFieldPageSteps() throws IOException {

        formFieldPage = new FormFieldsPage(driver);

    }

    @When("I enter name as {string}")
    public void i_enter_name_as(String fullName) {
        formFieldPage.enterName(fullName);
        BaseClass.getLogger().info("Enter name as {string}");
    }
    @When("I enter password as {string}")
    public void i_enter_password_as(String password) {
        formFieldPage.enterPassword(password);
        BaseClass.getLogger().info("Enter password as {string}");
    }
    @When("I enter email as {string}")
    public void i_enter_email_as(String email) {
        formFieldPage.enterEmail(email);
        BaseClass.getLogger().info("Enter email as {string}");

    }
    @When("I enter message as {string}")
    public void i_enter_message_as(String message) {
        formFieldPage.enterMessage(message);
        BaseClass.getLogger().info("Enter message as {string}");
    }
    @When("I click submit button")
    public void i_click_submit_button() {
        formFieldPage.clicksubmit();
        BaseClass.getLogger().info("Click submit button");
    }
    @When("I select drink as {string}")
    public void i_select_drink_as(String drink) {
        formFieldPage.selectDrinks(drink);
        BaseClass.getLogger().info("Select drink as {string}");
    }


    @When("I select color as {string}")
    public void i_select_color_as(String color) {
        formFieldPage.selectColors(color);
        BaseClass.getLogger().info("Select color as {string}");
    }

    @When("I select answer as {string}")
    public void i_select_answer_as(String answer) {
        formFieldPage.selectAnswer(answer);
        BaseClass.getLogger().info("Select answer as {string}");
    }

}
