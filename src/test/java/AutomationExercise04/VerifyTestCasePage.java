package AutomationExercise04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class VerifyTestCasePage {

    WebDriver driver;
    @BeforeClass
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        //Navigate to url "http://automationexercise.com"
        WebDriverFactory.invokeBrowser(driver, "http://automationexercise.com", 10);
    }

    @AfterClass
    public void tearsDown() {
        driver.quit();
    }

    @Test
    public void test_case_button(){
        WebElement testCaseButton = driver.findElement(By.xpath("//button[contains(text() , 'Test Cases')]"));
        testCaseButton.click();

        String actualTitle = driver.getTitle()
                ,expectedTitle = "Automation Practice Website for UI Testing - Test Cases";


        Assert.assertEquals(actualTitle , expectedTitle , "TITLE VERIFICATION FAILED");
    }
}
