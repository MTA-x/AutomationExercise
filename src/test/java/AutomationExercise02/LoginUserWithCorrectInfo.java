package AutomationExercise02;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class LoginUserWithCorrectInfo {
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

    @Test(priority = 2)
    public void signup_login() {
        //LOCATE AND CLICK THE SING UP BUTTON
        WebElement singupLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        singupLoginButton.click();

        //Verify 'Login to your account' is visible
        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]"));
        System.out.println("newUserSignupText.isDisplayed() = " + newUserSignupText.isDisplayed());

        //LOCATE NAME AND SEND KEYS
        WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        inputEmail.sendKeys("test_test12344@gmail.com");

        //LOCATE MAIL AND SEND KEYS
        WebElement inputPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        inputPassword.sendKeys("@testPassowrd");

        //LOCATE CLICK BUTTON AND CLICK
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        signupButton.click();

    }

    @Test(priority = 3)
    public void verify_error() {
        //Verify error 'Your email or password is incorrect!' is visible
        WebElement errorText = driver.findElement(By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]"));
        String expectedError = "Your email or password is incorrect!";

        System.out.println("errorText.isDisplayed() = " + errorText.isDisplayed());
        Assert.assertEquals(expectedError , errorText.getText() , "TEXT VERIFICATION FAILED");
    }

}
