package pages;

import businessLogic.BaseClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.By.xpath;

/*
     * Class representing the Pop-up Page of the website.
     * Extends BasePage class to inherit common functionality.
     *
     * @param driver WebDriver instance for interacting with the browser.
     * @author Tishawn Jones
     * @since 1.0.0
     *  This class is the for the Pop-up Page of the website
     * This page consists of Three main  WebElements AlertPopup, ConfirmPopup and PromptPopup
     *
        Alert Popup has two actions verify the text and click ok button
        Alert Popup  has an alert saying Hey there, pal with an "Ok" button

        Confirm Popup has three actions Ok and Cancel and verify Text
        A alert popup with Ok and Cancel button create two actions for each
        when clicking ok button - text should appear Ok, it is
        when clicking cancel button -text should appear "Cancel, it is.

        Prompt Popup - Has four Actions Ok and Cancel buttons Text Field to enter name and verify Text
        We have a dialog popup where we can enter some text with Ok and cancel button
        When we enter text in the field and click ok we should see "Nice to meet you, (whatever we typed)
        When we click Ok without typing a name text appears "Fine, be that way....
        When we click Cancel button text also appears "Fine be that way.....
 */

public class PopUpPage extends BasePage {

    Alert alert;

    public PopUpPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = ("//*[@id='alert']/b"))
    protected WebElement alertPopup;

    @FindBy(xpath = ("//*[@id='confirm']"))
    protected WebElement confirmPopup;

    @FindBy(xpath = ("//*[@id='prompt']/b"))
    protected WebElement promptPopup;

    @FindBy(xpath = ("//*[@id='confirmResult']"))
    protected WebElement confirmResult;

    @FindBy(xpath = ("//*[@id='promptResult']"))
    protected WebElement promptResult;


    //helper methods
    public void acceptAlert() {
        driver.switchTo().alert().accept(); //accept the alert popup
    }

    private void switchToAlert() {
        alert = driver.switchTo().alert();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
        BaseClass.getLogger().info("Alert dismissed!");
    }

    //-----ACTIONS  --------------------------------

    //Alert Popup Methods


    public void clickonPopup(String popup) throws InterruptedException {
        switch (popup) {
            case "Alert":
                waitForElement(alertPopup);
                alertPopup.click();
                break;
            case "Confirm":
                waitForElement(confirmPopup);
                confirmPopup.click();
                break;
            case "Prompt":
                waitForElement(promptPopup);
                promptPopup.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid popup type");
        }
    }

    public void verifyAlertPopup(String expectedText) {
        try {
            BaseClass.waitForAlert();
            switchToAlert();
            String actualText = alert.getText();
            BaseClass.valueisTrue(actualText, expectedText);
            BaseClass.getLogger().info("Text is equal");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//Confirm Popup Action Methods

    //click on confirm popup


    public void verifyConfirmPopup(String expectedText) {
        String text = confirmResult.getText();
        BaseClass.getLogger().info(text);
        Assert.assertEquals(expectedText, text);
        BaseClass.getLogger().info("Confirm popup text verification passed!");

    }

//Prompt Popup Action Methods ----------------------------------------


    public void enterAlertPrompt(String text) throws InterruptedException {

        BaseClass.getLogger().info("Verifying prompt popup");
        BaseClass.waitForAlert();
        switchToAlert();
        alert.sendKeys(text);
        BaseClass.getLogger().info("Text entered: " + text);

    }

    public void cancelPromptPopUp() {
        try {
            driver.switchTo().alert().dismiss();
            BaseClass.getLogger().info("Prompt popup dismissed");
            verifyPromptText();

        } catch (UnhandledAlertException e) {
            BaseClass.getLogger().error("An alert was not displayed");
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        }
    }

    public void verifyokOrCancel(String selection) throws InterruptedException {

        switch (selection) {
            case "ok":
                BaseClass.getLogger().info("Verifying Ok button");
                acceptPromptPopUp();
                verifyPromptText();
                BaseClass.getLogger().info("Ok button verification passed!");
                break;
            case "cancel":
                BaseClass.getLogger().info("Verifying Cancel button");
                cancelPromptPopUp();
                verifyPromptText();
                BaseClass.getLogger().info("Cancel button verification passed!");
                break;
            default:
                BaseClass.getLogger().error("Invalid selection: " + selection);
                break;
        }

    }


    // Click Ok on Propmpt message
    public void acceptPromptPopUp() throws InterruptedException {
        driver.switchTo().alert().accept();
        BaseClass.getLogger().info("Prompt popup accepted");

    }

    //---------------------Verification Methods


    private void verifyPromptText() throws InterruptedException {
        String text = promptResult.getText();
        BaseClass.getLogger().info(text);
        Assert.assertEquals(text, promptResult.getText());
        BaseClass.getLogger().info("Prompt popuptext verification passed!");
    }

    private void waitForElement(WebElement element) throws InterruptedException {
        BaseClass.waitForElement(element, 20);
    }

}

