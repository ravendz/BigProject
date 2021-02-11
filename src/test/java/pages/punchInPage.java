package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class punchInPage {
    private WebDriver driver;

    private static String PUNCHIN_URL="https://qa.cilsy.id/symfony/web/index.php/attendance/punchIn";
    public punchInPage (WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        driver.get(PUNCHIN_URL);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "note")
    @CacheLookup
    public static WebElement noteField;

    @FindBy(how = How.ID, using = "btnPunch")
    @CacheLookup
    public static WebElement inButton;

    @FindBy(how = How.ID, using = "btnPunch")
    @CacheLookup
    public static WebElement outButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[1]/h1")
    @CacheLookup
    public static WebElement punchOutHeader;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/div")
    @CacheLookup
    public static WebElement punchSuccessMessage;

    public void canPunchIn (){
        noteField.sendKeys("bocor");
        inButton.click();

    }

    public void canPunchOut () {
        noteField.sendKeys("sakit perut");
        outButton.click();
    }

    public boolean succesMessagePunch(){
        return punchSuccessMessage.getText().toString().contains("Successfully Saved");
    }

    public boolean punchOutDisplayed() {
        punchOutHeader.isDisplayed();
        return  true;

    }






}
