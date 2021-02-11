package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public baseClass(WebDriver driver, WebDriverWait wait) {

        baseClass.driver = driver;
        baseClass.wait = wait;
    }
}
