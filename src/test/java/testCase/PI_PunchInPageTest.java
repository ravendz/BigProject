package testCase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.punchInPage;

public class PI_PunchInPageTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Called openBrowser");
        System.setProperty("webdriver.chrome.driver", "D://qa//chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void PI02_Verifyusercanpunchin () throws  Throwable {
        loginPage login = new loginPage(driver,wait);
        driver.manage().window().maximize();
        login.adminLoginWithValidData();
        punchInPage punchIn = new punchInPage(driver,wait);
        driver.manage().window().maximize();
        punchIn.canPunchIn();
        Assert.assertTrue(punchIn.punchOutDisplayed());

    }

    @Test
    public void PI03_Verifyusercanpunchout () throws  Throwable {
        punchInPage punchIn = new punchInPage(driver,wait);
        driver.manage().window().maximize();
        punchIn.canPunchOut();
        Thread.sleep(2000);


    }




    @AfterTest
    public void aftertest() { driver.quit();}
}
