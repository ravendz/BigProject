package testCase;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;

import static pages.loginPage.logOutButton;
import static pages.loginPage.panelLogout;

public class LP_LoginPageTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Called openBrowser");
        System.setProperty("webdriver.chrome.driver", "D://qa//chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void LP01_Verifyifadminwillbeabletologinwithavalidusernameandvalidpassword () throws  Throwable {
        loginPage login = new loginPage(driver,wait);
        driver.manage().window().maximize();
        login.adminLoginWithValidData();
        Thread.sleep(1000);
        panelLogout.click();
        Thread.sleep(1000);
        logOutButton.click();

    }
    @Test
    public void LP02_Verifyifaadmincannotloginwithavalidusernameandaninvalidpassword () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.adminLoginWithInvalidPassword();
        Assert.assertTrue(login.invalidCredentials());

    }

    @Test
    public void LP03_VerifytheloginpageforbothwhenthefieldisblankandSubmitbuttonisclicked () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.loginWithEmptyField();
        Assert.assertTrue(login.usernamePasswordCannotBeEmpty());
    }
    @Test
    public void LP04_Verifyifadminadmincannotloginwithinvalidusernameandvalidpassword () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.loginWithInvalidUsername();
        Assert.assertTrue(login.invalidCredentials());
    }
    @Test
    public void LP05_Verifyifadmincannotloginwithinvalidusernameandinvalidpassword () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.loginWithInvalidData();
        Assert.assertTrue(login.invalidCredentials());
    }
//    @Test
//    public void LP06_VerifyiftheEnterkeyofthekeyboardisworkingcorrectlyontheloginpage () throws  Throwable {
//        loginPage login = new loginPage(driver, wait);
//        driver.manage().window().maximize();
//        login.verifyEnterKey();
//    }
    @Test
    public void LP07_Verifyifadminuserloginonlyinputusername () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.loginWithUsernameOnly();
        Assert.assertTrue(login.PasswordCannotBeEmpty());
    }
    @Test
    public void LP08_Verifyifuserloginonlyinputpassword () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.loginWithPasswordOnly();
        Assert.assertTrue(login.usernameCannotBeEmpty());
    }
    @Test
    public void LP15_Verifyifaemployeewillbeabletologinwithavalidusernameandvalidpassword () throws  Throwable {
        loginPage login = new loginPage(driver, wait);
        driver.manage().window().maximize();
        login.employeeLoginWithValidData();
        Thread.sleep(5000);
        panelLogout.click();
        Thread.sleep(5000);
        login.logOutButton.click();
    }
//    @Test
//    public void LP10_Verifysocialmedialinkedinlogobutton () throws  Throwable {
//        loginPage login = new loginPage(driver, wait);
//        driver.manage().window().maximize();
//        login.adminLoginWithInvalidPassword();
//    }
//    @Test
//    public void LP11_Verifysocialmediafacebooklogobutton () throws  Throwable {
//        loginPage login = new loginPage(driver, wait);
//        driver.manage().window().maximize();
//        JavascriptExecutor jsx = (JavascriptExecutor)driver;
//        jsx.executeScript("window.scrollBy(0,1000)", "");
//        Thread.sleep(5000);
//        login.checkFacebookLogoButton();
//        Assert.assertTrue(login.facebookPageIsDisplayed());
//    }
//    @Test
//    public void LP12_Verifysocialmediatwitterlogobutton () throws  Throwable {
//        loginPage login = new loginPage(driver, wait);
//        driver.manage().window().maximize();
//        login.checkTwitterLogoButton();
//        Assert.assertTrue(login.twitterPageIsDisplayed());
//    }
//    @Test
//    public void LP13_Verifysocialmediayoutubelogobutton () throws  Throwable {
//        loginPage login = new loginPage(driver, wait);
//        driver.manage().window().maximize();
//        login.checkYoutubeLogoButton();
//        Assert.assertTrue(login.youtubePageIsDisplayed());
//    }

    @AfterTest
    public void aftertest() { driver.quit();}

}

