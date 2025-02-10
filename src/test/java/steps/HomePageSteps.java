package steps;

import businessLogic.BaseClass;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.io.IOException;

public class HomePageSteps {
    WebDriver driver = BaseClass.getDriver();
    HomePage homePage;

    public HomePageSteps() throws IOException {
        homePage = new HomePage(driver);
    }



    @Given("I click on {string} link")
    public void iClickOnLink(String arg0) throws InterruptedException {

        homePage.clickLink(arg0);
        BaseClass.getLogger().info("Clicking on HomePage link");


    }



}
