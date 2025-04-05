package pages;

import businessLogic.BaseClass;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/*
     * Class representing the Home Page of the website.
     * Extends BasePage class to inherit common functionality.
     *
     * @param driver WebDriver instance for interacting with the browser.
     * @author Your Name Here
     * @since 1.0.0
     * @version 1.0.0
     * @see BasePage#BasePage(WebDriver)
   This Page is the entry point for the application it will have all the webelements which will lead to other pages
 */

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//*[@id='post-36']/div/div[2]/div/div[3]/div[1]/div/a") @CacheLookup
    protected WebElement popUpsPage;

    @FindBy(xpath = "//*[@id='post-36']/div/div[2]/div/div[3]/div[2]/div/a") @CacheLookup
    protected WebElement modalsPage;


    @FindBy(xpath="(//a[normalize-space()='Form Fields'])[1]") @CacheLookup
    protected WebElement formFields;

    //actions

    public void clickLink(String link) throws InterruptedException {
        switch (link){
            case "popup":
                popUpsPage.click();
                break;
            case "modal":
                BaseClass.searchForElement(modalsPage);
                break;
            case "formFields":
                formFields.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid link type");

        }
    }


}

