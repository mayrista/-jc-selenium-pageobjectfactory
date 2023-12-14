package com.juaracoding;

import com.juaracoding.drivers.strategies.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecruitmentTest {
    private WebDriver driver;

    private RecruitmentPage recruitmentPage;
    private LoginPage loginPage;
    @BeforeClass
    public void SetUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @Test(priority = 1)
    public void testLogin (){
        loginPage.login("Admin","admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }
    @Test(priority = 2)
    public void testAddCandidate(){
        loginPage.login("Admin","admin123");
        recruitmentPage.recruitmentKlik();
        recruitmentPage.recruitmentIsi("Mayrista","Hanul","Fadhillah",2,"mayrista@gmail.com","08123456789","C:\\Users\\Mayrista\\Documents\\Akreditasi jurusan SI.pdf","QA","2023-12-15","this notes for u");
        recruitmentPage.keepData();
        recruitmentPage.submitSave();
    }
}
