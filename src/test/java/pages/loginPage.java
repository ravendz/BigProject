package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.baseClass;

public class loginPage {
    private WebDriver driver;

    private static String PAGE_URL="https://qa.cilsy.id/symfony/web/index.php/dashboard";
    public loginPage (WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "txtUsername")
    @CacheLookup
    public static WebElement usernameField;

    @FindBy(how = How.ID, using = "txtPassword")
    @CacheLookup
    public static WebElement passwordField;

    @FindBy(how = How.ID, using = "btnLogin")
    @CacheLookup
    public static WebElement buttonLogin;

    @FindBy(how = How.ID, using = "forgotPasswordLink")
    @CacheLookup
    public static WebElement forgotPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"social-icons\"]/a[1]/img")
    @CacheLookup
    public static WebElement linkedinLogo;

    @FindBy(how = How.CSS, using = "div:nth-child(1) div:nth-child(5) div:nth-child(2) a:nth-child(2) > img:nth-child(1)")
    @CacheLookup
    public static WebElement facebookLogo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"social-icons\"]/a[3]/img")
    @CacheLookup
    public static WebElement twitterLogo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"social-icons\"]/a[4]/img")
    @CacheLookup
    public static WebElement youtubeLogo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"spanMessage\"]")
    @CacheLookup
    public static WebElement errorMessageInvalidCredentials;

    @FindBy(how = How.XPATH, using = "//*[@id=\"spanMessage\"]")
    @CacheLookup
    public static WebElement passwordCannotBeEmpty;

    @FindBy(how = How.XPATH, using = "//*[@id=\"spanMessage\"]")
    @CacheLookup
    public static WebElement usernameCannotBeEmpty;

    @FindBy(how = How.XPATH, using = "//*[@id=\"spanMessage\"]")
    @CacheLookup
    public static WebElement linkedinAssert;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mount_0_0\"]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/h2/span/span")
    @CacheLookup
    public static WebElement facebookAssert;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div[2]/div/div/div[1]/div/span[1]/span")
    @CacheLookup
    public static WebElement twitterAssert;

    @FindBy(how = How.XPATH, using = "//*[@id=\"text\"]")
    @CacheLookup
    public static WebElement youtubeAssert;

    @FindBy(how = How.XPATH, using = "//*[@id=\"welcome\"]")
    @CacheLookup
    public static WebElement panelLogout;

    @FindBy(how = How.XPATH, using = "//*[@id=\"welcome-menu\"]/ul/li[3]/a")
    @CacheLookup
    public static WebElement logOutButton;




    public void fillUsernameValid() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("admin");
    }
    public void fillPasswordValid() {
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys("s3Kol4HQA!*");
    }
    public void clickLoginButton() {
        buttonLogin.isEnabled();
        buttonLogin.click();
    }

    public void adminLoginWithValidData() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("admin");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("s3Kol4HQA!*");
        buttonLogin.click();
    }

    public boolean invalidCredentials(){
        return errorMessageInvalidCredentials.getText().toString().contains("Invalid credentials");
    }
    public boolean PasswordCannotBeEmpty(){
        return passwordCannotBeEmpty.getText().toString().contains("Password cannot be empty");
    }
    public boolean usernameCannotBeEmpty(){
        return usernameCannotBeEmpty.getText().toString().contains("Username cannot be empty");
    }
    public boolean usernamePasswordCannotBeEmpty(){
        return usernameCannotBeEmpty.getText().toString().contains("Username and password cannot be empty");
    }


    public void adminLoginWithInvalidPassword() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("admin");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("s3Kol4HQA!*12");
        buttonLogin.click();
    }
    public void loginWithEmptyField() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("");
        buttonLogin.click();
    }
    public void loginWithInvalidUsername() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("admins");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("s3Kol4HQA!*");
        buttonLogin.click();
    }
    public void loginWithInvalidData() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("admins");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("s3Kol4HQA!*123");
        buttonLogin.click();
    }
    public void verifyEnterKey() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("admin");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("s3Kol4HQA!*");
        passwordField.sendKeys(Keys.ENTER);
        panelLogout.click();
        logOutButton.click();
    }
    public void loginWithUsernameOnly() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("admin");
        usernameField.sendKeys(Keys.ENTER);
    }
    public void loginWithPasswordOnly() {
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys("s3Kol4HQA!*");
        passwordField.sendKeys(Keys.ENTER);
    }
    public void employeeLoginWithValidData() {
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys("kamusiapa");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Maju_terus21");
        passwordField.sendKeys(Keys.ENTER);
    }

    public void checklinkedinLogoButton() {
        linkedinLogo.click();
    }
    public void checkFacebookLogoButton() {
        facebookLogo.click();
    }
    public void checkTwitterLogoButton() {
        twitterLogo.click();
    }
    public void checkYoutubeLogoButton() {
        youtubeLogo.click();
    }




    public boolean facebookPageIsDisplayed() {
        facebookAssert.isDisplayed();
        return  true;

    }
    public boolean twitterPageIsDisplayed() {
        twitterAssert.isDisplayed();
        return  true;

    }
    public boolean youtubePageIsDisplayed() {
        youtubeAssert.isDisplayed();
        return  true;

    }




}


