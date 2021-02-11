package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignLeavePage {
    private WebDriver driver;

    private static String assignLeave_URL="https://qa.cilsy.id/symfony/web/index.php/leave/assignLeave";
    public assignLeavePage (WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        driver.get(assignLeave_URL);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using = "//*[@id=\"assignleave_txtEmployee_empName\"]")
    @CacheLookup
    public static WebElement employeeNameField;

    @FindBy(how = How.ID, using = "assignleave_txtLeaveType")
    @CacheLookup
    public static WebElement leaveTypeField;

    @FindBy(how = How.ID, using = "assignleave_txtFromDate")
    @CacheLookup
    public static WebElement fromDate;

    @FindBy(how = How.ID, using = "assignleave_txtToDate")
    @CacheLookup
    public static WebElement toDate;

    @FindBy(how = How.ID, using = "assignleave_txtComment")
    @CacheLookup
    public static WebElement commentField;

    @FindBy(how = How.ID, using = "assignBtn")
    @CacheLookup
    public static WebElement assignBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[1]/span")
    @CacheLookup
    public static WebElement RequiredMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[1]/span")
    @CacheLookup
    public static WebElement InvalidMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[2]/span")
    @CacheLookup
    public static WebElement requiredMessageLeaveType;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[4]/span")
    @CacheLookup
    public static WebElement fromDateMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/span")
    @CacheLookup
    public static WebElement toDateMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/span")
    @CacheLookup
    public static WebElement toDateMessage2;


    @FindBy(how = How.XPATH, using = "/html/body/div[6]/ul/li[1]")
    @CacheLookup
    public static WebElement chooseName;


    public void select_type (String status){
        Select statusDropdown=new Select(leaveTypeField);
        statusDropdown.selectByVisibleText(status);
    }

    public void assignWithEmptyEmployeeName () {
        employeeNameField.sendKeys();
        select_type("Sakit");
        fromDate.clear();
        fromDate.sendKeys("2021-02-10");
        toDate.clear();
        toDate.sendKeys("2021-02-14");
        commentField.sendKeys("turu");
        assignBtn.click();
    }
    public void assignWithInvalidEmployeeName () {
        employeeNameField.sendKeys("pol");
        select_type("Sakit");
        fromDate.clear();
        fromDate.sendKeys("2021-02-10");
        toDate.clear();
        toDate.sendKeys("2021-02-14");
        commentField.sendKeys("turu");
        assignBtn.click();
    }
    public void assignWithNoSelectedType () {
        employeeNameField.sendKeys("Yasmine");
        chooseName.click();
        select_type("--Select--");
        fromDate.clear();
        fromDate.sendKeys("2021-02-10");
        toDate.clear();
        toDate.sendKeys("2021-02-14");
        commentField.sendKeys("turu");
        assignBtn.click();
    }
    public void assignWithNoFromDate () {
        employeeNameField.sendKeys();
        select_type("Sakit");
        fromDate.clear();
        fromDate.sendKeys("");
        toDate.clear();
        toDate.sendKeys("2021-02-14");
        commentField.sendKeys("turu");
        assignBtn.click();
    }
    public void assignWithNoToDate () {
        employeeNameField.sendKeys();
        select_type("Sakit");
        fromDate.clear();
        fromDate.sendKeys("2021-02-10");
        toDate.clear();
        toDate.sendKeys("");
        commentField.sendKeys("turu");
        assignBtn.click();
    }
    public void assignWithfalseTodate () {
        employeeNameField.sendKeys();
        select_type("Sakit");
        fromDate.clear();
        fromDate.sendKeys("2021-02-27");
        toDate.clear();
        toDate.sendKeys("2021-02-01");
        commentField.sendKeys("turu");
        assignBtn.click();
    }
    public void assignWithValidData () {
        employeeNameField.sendKeys("Yasmine");
        chooseName.click();
        select_type("Sakit");
        fromDate.clear();
        fromDate.sendKeys("2021-02-10");
        toDate.clear();
        toDate.sendKeys("2021-02-14");
        commentField.sendKeys("turu");
        assignBtn.click();
    }

    public boolean employeeNameMessage () {
        return RequiredMessage.getText().toString().contains("Required");
    }
    public boolean employeeNameMessage2 () {
        return InvalidMessage.getText().toString().contains("Invalid");
    }
    public boolean leaveTypeMessage() {
        return requiredMessageLeaveType.getText().toString().contains("Required");
    }
    public boolean fromDateMessages () {
        return fromDateMessage.getText().toString().contains("Should be a valid date in yyyy-mm-dd format");
    }
    public boolean toDateMessages () {
        return toDateMessage.getText().toString().contains("Should be a valid date in yyyy-mm-dd format");
    }
    public boolean toDateMessages2() {
        return toDateMessage2.getText().toString().contains("To date should be after from date");
    }




}
