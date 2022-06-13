package com.bridgelabz.generatelogs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {


    WebDriver driver;
    Logger log = Logger.getLogger(LoginTest.class);


    @BeforeMethod
    public void setup(){
        log.info("****************** Starting test cases execution  **************************");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash Udikeri\\IdeaProjects\\" +
                "CFP - Automation Testing\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        log.info("launching chrome broswer");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.freecrm.com/");
        log.info("entering application URL");
        log.warn("Hey this just a warning message");
        log.fatal("hey this is just fatal error message");
        log.debug("this is debug message");
    }


    @Test(priority=1)
    public void freeCrmTitleTest(){
        log.info("****************************** starting test case *****************************************");
        log.info("****************************** freeCrmTitleTest *****************************************");
        String title = driver.getTitle();
        System.out.println(title);
        log.info("login page title is--->"+title);
        Assert.assertEquals(title,"Free CRM software for customer relationship management, sales," +
                " marketing campaigns and support.");

        log.info("****************************** ending test case *****************************************");
        log.info("****************************** freeCrmTitleTest *****************************************");

    }

    @Test(priority=2)
    public void freemCRMLogoTest(){
        log.info("****************************** starting test case *****************************************");
        log.info("****************************** freemCRMLogoTest *****************************************");

        boolean b = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
        Assert.assertTrue(b);

        log.info("****************************** ending test case *****************************************");
        log.info("****************************** freemCRMLogoTest *****************************************");

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
        log.info("****************************** Browser is closed *****************************************");
    }
}

//Mvn Clean Install - terminal command - 22:00
