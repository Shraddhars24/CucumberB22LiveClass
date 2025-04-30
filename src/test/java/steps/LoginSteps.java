package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class LoginSteps extends CommonMethods {
    /*public static WebDriver driver;*/

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        WebElement userNameField=driver.findElement(By.id("txtUsername"));
//        userNameField.sendKeys("admin");
        sendText("admin",userNameField);

        WebElement passwordField=driver.findElement(By.id("txtPassword"));
//        passwordField.sendKeys("Hum@nhrm123");
        sendText("Hum@nhrm123",passwordField);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton= driver.findElement(By.id("btnLogin"));
        loginButton.click();

    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("Test passed");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));

//        usernameField.sendKeys("admin321");
        sendText("admin321",usernameField);

//        passwordField.sendKeys("ghsnertuldnf");
        sendText("ghsnertuldnf",passwordField);
    }
    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        System.out.println("error is shown");
    }
}
