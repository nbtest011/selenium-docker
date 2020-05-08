package com.newtours.pages;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastnameTxt;

    @FindBy(name= "email")
    private WebElement usernameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait  = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void goTo() {
        this.driver.get("http://www.newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));

    }

    public void enterUserDetails(String firstname,String lastname){
        this.firstNameTxt.sendKeys(firstname);
        this.lastnameTxt.sendKeys(lastname);
    }

    public void enterUserCredentials(String username, String password){
        this.usernameTxt.sendKeys(username);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void submit(){
        this.submitBtn.click();
    }


}
