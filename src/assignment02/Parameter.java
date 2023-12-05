package assignment02;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Parameter {

	static WebDriver driver = new ChromeDriver();
	SoftAssert softAssert = new SoftAssert();

	Random rand = new Random();
	int RandomNumberForEmail = rand.nextInt(999);

	static String MagentoUrl = "https://magento.softwaretestingboard.com/";
	static String SignupUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
	static String LogoutUrl = "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";
	static String LoginUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/";
	
	static String FirstNames[] = { "Khadijah", "Sabah", "Eman" };
	static String LastNames[] = { "Ahmad", "Saleh", "Ali" };
	int RandomNumberForNameIndex = rand.nextInt(3);

	String firstName = FirstNames[RandomNumberForNameIndex];
	String lastName = LastNames[RandomNumberForNameIndex];

	String Email = firstName + lastName + RandomNumberForEmail + "@gmail.com";

	String Password = "KH022&@17";

}
