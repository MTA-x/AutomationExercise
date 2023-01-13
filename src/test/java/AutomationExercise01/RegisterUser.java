package AutomationExercise01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Wait;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class RegisterUser {
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

        //VERIFY "New User Signup!" IS VISIBLE
        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[contains(text(), 'New User Signup!')]"));
        System.out.println("newUserSignupText.isDisplayed() = " + newUserSignupText.isDisplayed());

        //LOCATE NAME AND SEND KEYS
        WebElement inputName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        inputName.sendKeys("testName12346");

        //LOCATE MAIL AND SEND KEYS
        WebElement inputMail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        inputMail.sendKeys("test_test12344@gmail.com");

        //LOCATE CLICK BUTTON AND CLICK
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();

        //LOCATE AND VERIFY "ENTER ACCOUNT INFORMATION" IS VISIBLE
        WebElement enterAccountInformationText = driver.findElement(By.xpath("//b[contains(text(), 'Enter Account Information')]"));
        System.out.println("enterAccountInformationText.isDisplayed() = " + enterAccountInformationText.isDisplayed());
    }

    @Test(priority = 3)
    public void radioButton_test() {
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        radioButton.click();
        System.out.println("radioButton.isSelected() = " + radioButton.isSelected());
    }

    @Test(priority = 4)
    public void fill_input_details() {
        //Fill details:  Title, Name, Email, Password,
        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        List<String> xpahtListOfInput = new ArrayList<>(Arrays.asList("//input[@type='password']"
                , "//input[@data-qa='first_name']"
                , "//input[@data-qa='last_name']"
                , "//input[@data-qa='company']"
                , "//input[@data-qa='address']"
                , "//input[@data-qa='address2']"
                , "//input[@data-qa='state']"
                , "//input[@data-qa='city']"
                , "//input[@data-qa='zipcode']"
                , "//input[@data-qa='mobile_number']"));

        List<String> inputs = new ArrayList<>(Arrays.asList("testPassowrd"
                , "testetName"
                , "testLastName"
                , "testCompany"
                , "testAdress"
                , "testAdress2", "testState", "testCity", "123456", "911911911"));

        for (int i = 0; i < xpahtListOfInput.size(); i++) {
            WebElement inputAreas = driver.findElement(By.xpath(xpahtListOfInput.get(i)));
            inputAreas.sendKeys(inputs.get(i));
        }
    }

    @Test(priority = 5)
    public void checkbox_test() {
        //Select checkbox 'Sign up for our newsletter!'
        //Select checkbox 'Receive special offers from our partners!'
        List<String> xpathsOfCheckboxes = new ArrayList<>(Arrays.asList("//input[@id='newsletter']"
                , "//input[@id='optin']"));

        for (int i = 0; i < xpathsOfCheckboxes.size(); i++) {
            WebElement selectCheckboxes = driver.findElement(By.xpath(xpathsOfCheckboxes.get(i)));
            System.out.println("selectCheckboxes = " + selectCheckboxes);
            selectCheckboxes.click();
            Wait.sleep(1.5);
        }
    }

    @Test(priority = 6)
    public void select_dropdownList() {
        //Fill details: Date of birth
        List<String> xpathsOfDropdownList = new ArrayList<>(Arrays.asList("//select[@id='days']"
                , "//select[@id='months']"
                , "//select[@id='years']"
                , "//select[@id='country']"));

        List<String> valuesOfDropdownList = new ArrayList<>(Arrays.asList("1"
                , "January"
                , "2000"
                , "United States"));

        for (int i = 0; i < xpathsOfDropdownList.size(); i++) {
            Select selectDropdown = new Select(driver.findElement(By.xpath(xpathsOfDropdownList.get(i))));
            selectDropdown.selectByVisibleText(valuesOfDropdownList.get(i));
        }
    }

    @Test(priority = 7)
    public void create_account_button_test() {
        //Click 'Create Account button'
        ////button[@data-qa='create-account']
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(), 'Create Account')]"));
        createAccountButton.click();
    }

    @Test(priority = 8)
    public void account_created_text_test() {
        //Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedText = driver.findElement(By.xpath("//h2[contains(text(), 'New User Signup!')]"));
        System.out.println("accountCreatedText.isDisplayed() = " + accountCreatedText.isDisplayed());

        //Click 'Continue' button
        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();
    }

    @Test(priority = 9)
    public void logged_username() {
        //Verify that 'Logged in as username' is visible
        WebElement loggedAsUserNameText = driver.findElement(By.xpath("//a[contains(text() , ' Logged in as testUserName123')]"));
        System.out.println("loggedAsUserNameText.isDisplayed() = " + loggedAsUserNameText.isDisplayed());
    }

    @Test(priority = 10)
    public void delete_account() {
        //Click 'Delete Account' button
        WebElement deleteAccontButton = driver.findElement(By.xpath("//a[contains(text(), ' Delete Account')]"));
        deleteAccontButton.click();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedText = driver.findElement(By.xpath("//b[contains(text(), 'Account Deleted!')]"));
        System.out.println("accountDeletedText.isDisplayed() = " + accountDeletedText.isDisplayed());

    }
}
