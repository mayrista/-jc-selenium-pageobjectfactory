package com.juaracoding.pages;

import com.juaracoding.drivers.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RecruitmentPage {
    private WebDriver driver;
    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']")
    private WebElement btnRecruitment;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    private WebElement middleName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;
    @FindBy(xpath = "\"//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']\"")
    private WebElement vacancy;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    private WebElement email;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    private WebElement contact;
    @FindBy(xpath = "//div[@class='oxd-file-input-div']")
    private WebElement resume;
    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    private WebElement keyword;
    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    private WebElement dateOfApplication;
    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    private WebElement notes;
    @FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    private WebElement ceklisKeepData;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;

    public void recruitmentKlik(){
        btnRecruitment.click();
        btnAdd.click();
    }
    public void recruitmentIsi(String firstName,String middleName, String lastName, int vacancyIndex ,String email, String contact, String resume, String keywords, String dop, String notes) {
        this.firstName.sendKeys(firstName);
        this.middleName.sendKeys(middleName);
        this.lastName.sendKeys(lastName);
        Select vacancySelect = new Select(vacancy);
        vacancySelect.selectByIndex(2);
        this.email.sendKeys(email);
        this.contact.sendKeys(contact);
        this.resume.sendKeys(resume);
        this.keyword.sendKeys(keywords);
        this.dateOfApplication.sendKeys(dop);
        this.notes.sendKeys(notes);
    }
    public void keepData (){
        ceklisKeepData.click();
    }
    public void submitSave(){
        btnSave.click();
    }
}

