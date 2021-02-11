package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addEmployeePage {
    private WebDriver driver;

    private static String addEmployee_URL="https://qa.cilsy.id/symfony/web/index.php/pim/addEmployee";
    public addEmployeePage (WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        driver.get(addEmployee_URL);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "firstName")
    @CacheLookup
    public static WebElement firstNameField;

    @FindBy(how = How.ID, using = "middleName")
    @CacheLookup
    public static WebElement middleNameField;

    @FindBy(how = How.ID, using = "lastName")
    @CacheLookup
    public static WebElement lastNameField;

    @FindBy(how = How.ID, using = "employeeId")
    @CacheLookup
    public static WebElement employeeIdField;

    @FindBy(how = How.ID, using = "chkLogin")
    @CacheLookup
    public static WebElement chkLoginDetails;

    @FindBy(how = How.ID, using = "user_name")
    @CacheLookup
    public static WebElement user_nameDetailsField;

    @FindBy(how = How.ID, using = "user_password")
    @CacheLookup
    public static WebElement user_passwordDetailsField;

    @FindBy(how = How.ID, using = "re_password")
    @CacheLookup
    public static WebElement re_passwordDetailsField;

    @FindBy(how = How.ID, using = "status")
    @CacheLookup
    public static WebElement statusSelectDetailsField;

    @FindBy(how = How.ID, using = "btnSave")
    @CacheLookup
    public static WebElement btnSave;


    @FindBy(how = How.XPATH, using = "//*[@id=\"addEmployeeTbl\"]/div")
    @CacheLookup
    public static WebElement FailedToSaveEmployeeIdExists ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmAddEmp\"]/fieldset/ol/li[1]/ol/li[1]/span")
    @CacheLookup
    public static WebElement firstNameMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"frmAddEmp\"]/fieldset/ol/li[1]/ol/li[3]/span")
    @CacheLookup
    public static WebElement lastNameMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pdMainContainer\"]/div[1]/h1")
    @CacheLookup
    public static WebElement personalDetailsPagetitle;


    public void addEmployeeValidDataNoLogindetails () {
        firstNameField.isEnabled();
        firstNameField.clear();
        firstNameField.sendKeys("ini");
        middleNameField.sendKeys("bapak");
        lastNameField.sendKeys("budi");
        employeeIdField.sendKeys();
        btnSave.click();
    }

    public void addEmployeeWithEmptyFirstname (){
        firstNameField.isEnabled();
        firstNameField.clear();
        middleNameField.sendKeys("bapak");
        lastNameField.sendKeys("budi");
        employeeIdField.sendKeys();
        btnSave.click();
    }
    public void  addEmployeeWithEmptyLastName () {
        firstNameField.isEnabled();
        firstNameField.clear();
        firstNameField.sendKeys("ini");
        middleNameField.sendKeys("bapak");
        employeeIdField.sendKeys();
        btnSave.click();
    }
    public void addEmployeeWithExistId () {
        firstNameField.isEnabled();
        firstNameField.clear();
        firstNameField.sendKeys("ini");
        middleNameField.sendKeys("bapak");
        lastNameField.sendKeys("budi");
        employeeIdField.clear();
        employeeIdField.sendKeys("666");
        btnSave.click();
    }
    public void addEmployeeDetails () {
        firstNameField.isEnabled();
        firstNameField.clear();
        firstNameField.sendKeys("ini");
        middleNameField.sendKeys("bapak");
        lastNameField.sendKeys("budi");
        employeeIdField.sendKeys();
        chkLoginDetails.click();
        user_nameDetailsField.sendKeys("inibudi1");
        user_passwordDetailsField.sendKeys("Maju_terus21");
        re_passwordDetailsField.sendKeys("Maju_terus21");
        select_list("Disabled");
        btnSave.click();
    }
    public void select_list(String status){
        Select statusDropdown=new Select(statusSelectDetailsField);
        statusDropdown.selectByVisibleText(status);
    }


    public boolean requiredMessageFirstName() {
        return firstNameMessage.getText().toString().contains("Required");
    }

    public boolean requiredMessageLastName() {
        return lastNameMessage.getText().toString().contains("Required");
    }

    public boolean messageExistId () {
        return FailedToSaveEmployeeIdExists.getText().toString().contains("Failed To Save: Employee Id Exists");
    }

    public boolean personalDetailsTitle () {
        personalDetailsPagetitle.isDisplayed();
        return true;

    }









}
