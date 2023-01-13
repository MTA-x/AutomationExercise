package AutomationExercise01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.WebDriverFactory;

public class RegisterUser {
    WebDriver driver;

    @BeforeClass
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        //Navigate to url "http://automationexercise.com"
        WebDriverFactory.invokeBrowser(driver , "http://automationexercise.com" , 10);
    }

    @AfterClass
    public void tearsDown(){
        driver.quit();
    }
}
