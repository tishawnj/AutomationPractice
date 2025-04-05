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

    public void selectDrinks(String drink){
        switch(drink){
            case "Water":
                drinks.get(0).click();
                break;
            case "Milk":
                drinks.get(1).click();
                break;
            case "Coffee":
                drinks.get(2).click();
                break;
            case "Wine":
                drinks.get(3).click();
                break;
            case "Ctrl-Alt-Delight":
                drinks.get(4).click();
                break;
            default:
                System.out.println("Invalid drink selection");
                break;

        }

    }

    public void selectColors(String color) {
        switch (color) {
            case "Red":
                colors.get(0).click();
                break;
            case "Blue":
                colors.get(1).click();
                break;
            case "Yellow":
                colors.get(2).click();
                break;
            case "Green":
                colors.get(3).click();
                break;
            case "#FFC0CB":
                colors.get(4).click();
                break;
            default:
                System.out.println("Invalid color selection");
                break;
        }
    }

    public void selectAnswer(String answer){

        Select select = new Select(this.automation);
        switch (answer){
            case "Yes":
                select.selectByVisibleText("Yes");
                break;
            case "No":
                select.selectByVisibleText("No");
                break;
            case "Undecided":
                select.selectByVisibleText("Undecided");
                break;
            default:
                System.out.println("Invalid answer selection");
                break;
        }

    }





    }

