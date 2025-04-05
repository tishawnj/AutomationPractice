package businessLogic;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class BaseClass {

    static Logger logger;
   private static WebDriver driver;
    // public static final String propertyFilePath = "src/test/resources/config.properties";
    public static Properties properties;


    public static WebDriver initializeBrowser() throws IOException {

        properties = getProperties();
        BaseClass.getLogger().info("Loading properties!");
        driver = new ChromeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        return driver;

    }

    public static WebDriver getDriver() throws IOException {
        return driver;
    }

    public BaseClass() {
        logger.info("BaseClass constructor called");
    }

    public static void baseMethod() {
        logger.info("BaseClass baseMethod called");
    }

    public static Logger getLogger() {
       //Log4j
        logger = LogManager.getLogger();
        return logger;
    }

    public static void waitForAlert() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //assert equals
    public static void valueisTrue(String expected, String actual)
    {
        assertEquals(expected, actual);
        BaseClass.getLogger().info("True");
    }

    public static void waitForElement(WebElement element, long seconds ) throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        BaseClass.getLogger().info("Element found");


    }


    public static Properties getProperties() throws IOException
    {
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        properties=new Properties();
        properties.load(file);
        return properties;
    }




    public static void movetoElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }



    //scroll to webElement
    private static void scrollToElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void searchForElement(WebElement element)
    {
        try{
            BaseClass.getLogger().info("Attempting to search for button");
            movetoElement(element);
            element.click();
            BaseClass.getLogger().info("Button found and clicked");
        }
        catch (NotFoundException e)
        {
            e.getLocalizedMessage();
        }
    }
}

