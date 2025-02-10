package steps;

import businessLogic.BaseClass;
import io.cucumber.java.*;
import org.jsoup.Connection;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import java.io.IOException;

import static businessLogic.BaseClass.properties;

public class Hooks {

    WebDriver driver;


    @Before
    public void setup() throws IOException {

        BaseClass.getLogger().info("Opening the Web Browser.....");
      driver = BaseClass.initializeBrowser();
      driver.manage().window().maximize();

    }




    @After
    public void tearDown() {
        BaseClass.getLogger().info("Closing the Web Browser");
        driver.quit();
    }






    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException{
        if (scenario.isFailed()) {
            BaseClass.getLogger().info("Taking screenshot for failed scenario");
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
    }
}
