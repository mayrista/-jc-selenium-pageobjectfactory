package com.juaracoding;

import com.juaracoding.drivers.strategies.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainApp {
    //jika mnggunakan final maka hurufnya besar semua
    private static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);

        //call method from pages
        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin","admin123");
        System.out.println(loginPage.getTxtDashboard());

        //INVALID
        loginPage.logout();
        loginPage.login("Adminn","admin123");
        System.out.println(loginPage.getTxtInvalidLogin());

        //REQUIRED
        loginPage.login("","");
        System.out.println(loginPage.getTxtRequired());

        //Recruitment
        loginPage.login("Admin","admin123");
        RecruitmentPage recruitmentPage = new RecruitmentPage();
        recruitmentPage.recruitmentKlik();
        recruitmentPage.recruitmentIsi("Mayrista","Hanul","Fadhillah",2,"mayrista@gmail.com","08123456789","C:\\Users\\Mayrista\\Documents\\Akreditasi jurusan SI.pdf","QA","2023-12-15","this notes for u");
        recruitmentPage.keepData();
        recruitmentPage.submitSave();


        //DELAY AND QUIT
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}