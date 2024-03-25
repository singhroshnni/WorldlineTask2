package Features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAction {
	
	WebDriver driver;


	@Given("User is on Home Page")
	public void openApp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://demowebshop.tricentis.com/");
		  System.out.println("Browser opened successfully");
	}
	

@When("User navigate to Login Page")
public void user_navigate_to_login_page() {
	WebElement logbtn =driver.findElement(By.xpath("//a[@class='ico-login']"));
	logbtn.click();
    
}

@Then("User enters {string} and {string} keeping case as Valid")
public void user_enters_and_keeping_case_as_valid(String string, String string2) {
	WebElement email =driver.findElement(By.id("Email"));
	email.sendKeys(string);
	WebElement pas =driver.findElement(By.id("Password"));
	pas.sendKeys(string2);
	WebElement login =driver.findElement(By.xpath("//input[@value='Log in']"));
	login.click();
   
}

@Then("User should get logged in")
public void user_should_get_logged_in() {
	String expect="https://demowebshop.tricentis.com/";
	String actual =driver.getCurrentUrl();
	Assert.assertEquals(expect, actual);
    
}

@Then("Message displayed Login Successfully")
public void message_displayed_login_successfully() {
	System.out.println("Login successful");
    
}

@Then("User enters {string} and {string} keeping case as Invalid")
public void user_enters_and_keeping_case_as_invalid(String string, String string2) {
	WebElement email =driver.findElement(By.id("Email"));
	email.sendKeys(string);
	WebElement pas =driver.findElement(By.id("Password"));
	pas.sendKeys(string2);
	WebElement login =driver.findElement(By.xpath("//input[@value='Log in']"));
	login.click();
    
}

@Then("user will be asked to go back to login page")
public void user_will_be_asked_to_go_back_to_login_page() {
	String expect="https://demowebshop.tricentis.com/login";
	String actual =driver.getCurrentUrl();
	Assert.assertEquals(expect, actual);
	System.out.println("Invalid credentials! Go back to Login");
    
}

@Then("Provide correct credentials")
public void provide_correct_credentials() {
	WebElement email =driver.findElement(By.id("Email"));
	email.clear();
	email.sendKeys("jyotisingh01@gmail.com");
	WebElement pas =driver.findElement(By.id("Password"));
	pas.clear();
	pas.sendKeys("asdfgh");
	WebElement login =driver.findElement(By.xpath("//input[@value='Log in']"));
	login.click();
    
}
@After
public void close_browser() {
   
    driver.quit();
}
}
