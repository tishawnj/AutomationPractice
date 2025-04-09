package pages;

import businessLogic.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FormFieldsPage extends BasePage{


    public FormFieldsPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath="//input[@id='name-input']") @CacheLookup
    protected WebElement name;

    @FindBy(xpath="//input[@type='password']") @CacheLookup
    protected WebElement password;

     @FindBy(name="fav_drink") @CacheLookup
    protected List<WebElement> drinks;

    @FindBy(name="fav_color") @CacheLookup
    protected List<WebElement> colors;



    @FindBy(xpath="//select[@id='automation']")
    protected WebElement automation;

    @FindBy(xpath="//input[@id='email']") @CacheLookup
    protected WebElement email;

    @FindBy(xpath="//textarea[@id='message']") @CacheLookup
    protected WebElement message;

    @FindBy(xpath="//button[@id='submit-btn']") @CacheLookup
    protected WebElement submit;


    public void enterName(String fullName)
    {
        this.name.sendKeys(fullName);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void enterEmail(String email){
        this.email.sendKeys(email);

    }
    public void enterMessage(String message){
        this.message.sendKeys(message);
    }

    public void clicksubmit(){
        BaseClass.movetoElement(submit);
        submit.click();
    }

    public void selectDrinks(String drink) throws InterruptedException {
        switch(drink){
            case "Water":
                BaseClass.waitForElement(drinks.get(0), 20);
                BaseClass.searchForElement(drinks.get(0));
                break;
            case "Milk":
                BaseClass.waitForElement(drinks.get(1), 20);
                BaseClass.searchForElement(drinks.get(1));
                break;
            case "Coffee":
               BaseClass.waitForElement(drinks.get(2), 20);
                BaseClass.searchForElement(drinks.get(2));
                break;
            case "Wine":
                BaseClass.waitForElement(drinks.get(3), 20);
                BaseClass.searchForElement(drinks.get(3));
                break;
            case "Ctrl-Alt-Delight":
                BaseClass.waitForElement(drinks.get(4), 20);
                BaseClass.searchForElement(drinks.get(4));
                break;
            default:
                System.out.println("Invalid drink selection");
                break;

        }

    }

    public void selectColors(String color) throws InterruptedException {
        switch (color) {
            case "Red":
                BaseClass.waitForElement(colors.get(0), 20);
                BaseClass.searchForElement(colors.get(0));
                break;
            case "Blue":
                BaseClass.waitForElement(colors.get(1), 20);
                BaseClass.searchForElement(colors.get(1));
                break;
            case "Yellow":
                BaseClass.waitForElement(colors.get(2), 20);
                BaseClass.searchForElement(colors.get(2));
                break;
            case "Green":
                BaseClass.waitForElement(colors.get(3), 20);
                BaseClass.searchForElement(colors.get(3));
                break;
            case "#FFC0CB":
                BaseClass.waitForElement(colors.get(4), 20);
                BaseClass.searchForElement(colors.get(4));
                break;
            default:
                System.out.println("Invalid color selection");
                break;
        }
    }

    public void selectAnswer(String answer) throws InterruptedException {

        Select select = new Select(this.automation);
        switch (answer){
            case "Yes":
                BaseClass.waitForElement(automation, 20);
                select.selectByVisibleText("Yes");
                break;
            case "No":
                BaseClass.waitForElement(automation, 20);
                select.selectByVisibleText("No");
                break;
            case "Undecided":
                BaseClass.waitForElement(automation, 20);
                select.selectByVisibleText("Undecided");
                break;
            default:
                System.out.println("Invalid answer selection");
                break;
        }

    }





    }

