package assignment02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagentoTestCases extends Parameter {

	@BeforeTest
	public void setUp() {
		driver.get(MagentoUrl);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		driver.get(SignupUrl);

		WebElement firstNameField = driver.findElement(By.id("firstname"));
		WebElement lastNameField = driver.findElement(By.id("lastname"));
		WebElement emailField = driver.findElement(By.id("email_address"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement confirmPasswordField = driver.findElement(By.id("password-confirmation"));
		WebElement createAccountBtn = driver.findElement(By.className("submit"));

		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(Email);
		passwordField.sendKeys(Password);
		confirmPasswordField.sendKeys(Password);
		createAccountBtn.click();

		Thread.sleep(2000);

		String welcomeMsg = driver.findElement(By.xpath("//div[@class='panel header']")).getText();
		softAssert.assertEquals(welcomeMsg.contains("Welcome"), true , "Validation the signup process");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void logout() throws InterruptedException {

		driver.get(LogoutUrl);
		Thread.sleep(10000);

		softAssert.assertEquals(driver.getCurrentUrl(), MagentoUrl,"Validation of the website url after the logout process");
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void login() throws InterruptedException {

		driver.get(LoginUrl);
		WebElement loginEmailField = driver.findElement(By.id("email"));
		WebElement loginPasswordField = driver.findElement(By.id("pass"));
		WebElement loginBtn = driver.findElement(By.id("send2"));

		loginEmailField.sendKeys(Email);
		loginPasswordField.sendKeys(Password);
		loginBtn.click();
		
		Thread.sleep(2000);
		
		softAssert.assertEquals(driver.getCurrentUrl(), MagentoUrl,"validation of the website url after the login process");
		softAssert.assertAll();
		

	}

	@AfterTest
	public void afterTest() {

	}
}
