package com.juaracoding.pages;

import com.juaracoding.drivers.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;


public class LoginPage {
    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    //Locator use Page Factory
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;
    @FindBy(xpath = "//h6[contains(@class,'topbar-header')]")
    private WebElement txtDashboard;
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement profile;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogout;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement txtInvalidLogin;
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    private WebElement txtRequired;


    //Step Action
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }
    //Step Validation
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
    //Method logout
    public void logout(){
        profile.click();
        btnLogout.click();
    }
    public String getTxtInvalidLogin(){
        return txtInvalidLogin.getText();
    }
    public String getTxtRequired(){
        return txtRequired.getText();
    }

}
