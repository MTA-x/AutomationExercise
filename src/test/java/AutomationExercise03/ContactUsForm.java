package AutomationExercise03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class ContactUsForm {

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

    @Test(priority = 1)
    public void homepage_visibility() {
        WebElement homePageButton = driver.findElement(By.linkText("Home"));
        System.out.println("homePageButton.isDisplayed() = " + homePageButton.isDisplayed());
    }

    
}
