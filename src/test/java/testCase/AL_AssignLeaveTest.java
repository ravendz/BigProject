package testCase;


import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.addEmployeePage;
import pages.assignLeavePage;
import pages.loginPage;

public class AL_AssignLeaveTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Called openBrowser");
        System.setProperty("webdriver.chrome.driver", "D://qa//chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void AL02_VerifyusercantAssignleavewithemptyemployeename () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.adminLoginWithValidData();
        assignLeavePage leavePage = new assignLeavePage(driver, wait);
        driver.manage().window().maximize();
        leavePage.assignWithEmptyEmployeeName();
        Thread.sleep(1000);
        Assert.assertTrue(leavePage.employeeNameMessage());
    }

    @Test
    public void AL03_Verifyusercantassignleavewithinvalidemployeename () throws  Throwable {
        assignLeavePage leavePage = new assignLeavePage(driver, wait);
        driver.manage().window().maximize();
        leavePage.assignWithInvalidEmployeeName();
        Thread.sleep(1000);
        Assert.assertTrue(leavePage.employeeNameMessage2());
    }
    @Test
    public void AL04_Verifyusercantassignwithnoselectedleavetype () throws  Throwable {
        assignLeavePage leavePage = new assignLeavePage(driver, wait);
        driver.manage().window().maximize();
        leavePage.assignWithNoSelectedType();
        Thread.sleep(1000);
        Assert.assertTrue(leavePage.leaveTypeMessage());
    }
    @Test
    public void AL05_Verifyusercantassignwithnoselectedfromdate () throws  Throwable {
        assignLeavePage leavePage = new assignLeavePage(driver, wait);
        driver.manage().window().maximize();
        leavePage.assignWithNoFromDate();
        Thread.sleep(1000);
        Assert.assertTrue(leavePage.fromDateMessages());
    }
    @Test
    public void AL06_Verifyusercantassignwithnoselectedtodate () throws  Throwable {
        assignLeavePage leavePage = new assignLeavePage(driver, wait);
        driver.manage().window().maximize();
        leavePage.assignWithNoToDate();
        Thread.sleep(1000);
        Assert.assertTrue(leavePage.toDateMessages());
    }
    @Test
    public void AL07_VerifyUsershouldbeselectedtodateafterfromdate () throws  Throwable {
        assignLeavePage leavePage = new assignLeavePage(driver, wait);
        driver.manage().window().maximize();
        leavePage.assignWithfalseTodate();
        Thread.sleep(2000);
        Assert.assertTrue(leavePage.toDateMessages2());
    }
    @Test
    public void AL08_Verifyusercanbeassignleavewithvaliddata () throws  Throwable {
        assignLeavePage leavePage = new assignLeavePage(driver, wait);
        driver.manage().window().maximize();
        leavePage.assignWithValidData();
        Thread.sleep(1000);
    }

    @AfterTest
    public void aftertest() { driver.quit();}
}
