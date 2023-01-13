package AutomationExercise05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class SearchProduct {
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

    @Test (priority = 2)
    public void locate_click_product(){
        WebElement product = driver.findElement(By.xpath("//a[contains(text() , ' Products')]"));
        product.click();
    }

    @Test (priority = 3)
    public void verify_navigation(){
        WebElement titleText = driver.findElement(By.xpath("//title[contains(text() , 'Automation Exercise - All Products')]"));

        String actualTitle = driver.getTitle()
                ,expectedTitle = titleText.getText();

        Assert.assertEquals(actualTitle , expectedTitle , "TITLE VERIFICATION FAILED \nNAVIGATION FAILED");
    }

    @Test (priority = 4)
    public void verify_searchProduct_text(){
        WebElement searchProductText = driver.findElement(By.xpath("input[@id='search_product']"));

        Assert.assertTrue(searchProductText.isDisplayed());
    }


}
