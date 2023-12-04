package assignment01;

import org.openqa.selenium.chrome.*;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_01 {

	WebDriver driver = new ChromeDriver();
	String SauceUrl = "https://www.saucedemo.com/v1/";
	String UserName = "standard_user";
	String Password = "secret_sauce";

	@BeforeTest
	public void setUp() {

		driver.get(SauceUrl);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginTest() {

		WebElement userNameInput = driver.findElement(By.id("user-name"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));

		userNameInput.sendKeys(UserName);
		passwordInput.sendKeys(Password);
		loginBtn.click();
	}

	@Test(priority = 2)
	public void addToCartProcess() {

		List<WebElement> addBtnList = driver.findElements(By.className("btn_primary"));
		List<WebElement> itemNameList = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> itemPriceList = driver.findElements(By.className("inventory_item_price"));

		for (int i = 0; i < addBtnList.size(); i++) {

			addBtnList.get(i).click();

			String Price = itemPriceList.get(i).getText().replace("$", "");
			double PriceToDouble = Double.parseDouble(Price); // convert string to double
			double TaxValue = PriceToDouble * .10;
			double PriceAfterTax = TaxValue + PriceToDouble;
			int PriceTaxToInteger = (int) PriceAfterTax; // casting (convert double to int)

			if (PriceTaxToInteger % 2 == 0) {
				System.out.println(itemNameList.get(i).getText() + "\n" + " > Price = " + PriceToDouble
						+ " $ > Price with Tax = " + PriceAfterTax + " $ > It's Even Number");
				System.out.println("_____________________________________________________________________________");
			} else {
				System.out.println(itemNameList.get(i).getText() + "\n" + " > Price = " + PriceToDouble
						+ " $ > Price with Tax = " + PriceAfterTax + " $ > It's Odd Number");
				System.out.println("_____________________________________________________________________________");
			}

		}
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
