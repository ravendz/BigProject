package testCase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.addEmployeePage;
import pages.loginPage;

public class AE_AddEmployeeTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Called openBrowser");
        System.setProperty("webdriver.chrome.driver", "D://qa//chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void AE15_addEmployeeValidDataNoLogindetails () throws  Throwable {
        loginPage login = new loginPage(driver,wait);
        driver.manage().window().maximize();
        login.adminLoginWithValidData();
        addEmployeePage addEmployee = new addEmployeePage(driver,wait);
        driver.manage().window().maximize();
        addEmployee.addEmployeeValidDataNoLogindetails();
        Thread.sleep(3000);
        Assert.assertTrue(addEmployee.personalDetailsTitle());

    }
    @Test
    public void AE16_addemployeewithemptyfirstnamefield () throws  Throwable {
        addEmployeePage addEmployee = new addEmployeePage(driver,wait);
        driver.manage().window().maximize();
        addEmployee.addEmployeeWithEmptyFirstname();
        Assert.assertTrue(addEmployee.requiredMessageFirstName());

    }
    @Test
    public void AE17_addemployeewithemptylastnamefield () throws  Throwable {
        addEmployeePage addEmployee = new addEmployeePage(driver,wait);
        driver.manage().window().maximize();
        addEmployee.addEmployeeWithEmptyLastName();
        Assert.assertTrue(addEmployee.requiredMessageLastName());

    }
    @Test
    public void AE18_addemployeewithexistemployeeId () throws  Throwable {
        addEmployeePage addEmployee = new addEmployeePage(driver,wait);
        driver.manage().window().maximize();
        addEmployee.addEmployeeWithExistId();
        Thread.sleep(1000);
        Assert.assertTrue(addEmployee.messageExistId());

    }
//    @Test
//    public void AE19_addemployeeaddedlogindetailswithvaliddata () throws  Throwable {
//        loginPage login = new loginPage(driver,wait);
//        driver.manage().window().maximize();
//        login.adminLoginWithValidData();
//        addEmployeePage addEmployee = new addEmployeePage(driver,wait);
//        driver.manage().window().maximize();
//        addEmployee.addEmployeeDetails();
//        Thread.sleep(3000);
//        Assert.assertTrue(addEmployee.personalDetailsTitle());
//
//    }


    @AfterTest
    public void aftertest() { driver.quit();}


}
