package pages;

import businessLogic.BaseClass;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalPage extends BasePage {

    String text = "";
    public ModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "simpleModal")
    protected WebElement simpleModal;



    @FindBy(id = "formModal")
    protected WebElement formModal;


    @FindBy(xpath = "//*[@id='popmake-1318']/div[2]/p")
    protected WebElement simpleModalText;


   @FindBy(xpath = "//*[@id='popmake-1318']/button")
    protected WebElement closeModalButton;


   @FindBy(xpath = "//*[@id='popmake-674']/button")
    protected WebElement formModalCloseButton;


    @FindBy(xpath = "//*[@id='contact-form-1051']/form/p[1]/button")
    protected WebElement formModalSubmitButton;


    @FindBy(id = "g1051-name")
    public WebElement name;


    @FindBy(id = "g1051-email")
    public WebElement email;


    @FindBy(id = "contact-form-comment-g1051-message")
    public WebElement message;



   public void clickModal(String element) throws InterruptedException {
       switch (element)
           {
               case "Simple Modal":
                   BaseClass.waitForElement(simpleModal, 30);
                   BaseClass.searchForElement(simpleModal);
                   break;
               case "Form Modal":
                    BaseClass.waitForElement(formModal, 30);
                    BaseClass.searchForElement(formModal);
                   break;
               default:
                   System.out.println("Invalid modal option");
           }

   }

   public void closeModal(){
       closeModalButton.click();
   }

   public void verifyModalText(String element) throws InterruptedException {

       BaseClass.waitForElement(simpleModalText, 20);

       if(simpleModalText.isDisplayed()){
           text = simpleModalText.getText();
       }

       BaseClass.valueisTrue(element, text);

   }

   public void setName(String userName){
       name.sendKeys(userName);
   }

   public void setEmail(String userEmail){
       email.sendKeys(userEmail);
   }

   public void setMessage(String userMessage){
       message.sendKeys(userMessage);
   }

   //close form modal button
    public void closeFormModal(){
       formModalCloseButton.click();
   }

   //submit form modal button
    public void submitFormModal(){
       formModalSubmitButton.click();
   }




}
