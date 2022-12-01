package shoping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JuiceShop_Register {
	
	static By dismissBtn = By.xpath("//button//span[text()='Dismiss']");
	static By emailID = By.id("emailControl");
	static By passwordTxt = By.id("passwordControl");
	static By confirmPassword = By.id("repeatPasswordControl");
	static By secQnBox = By.xpath("//div[@id='mat-select-value-1']/span");
	static By secQn = By.xpath("//span[text()=' Your eldest siblings middle name? ']");
	static By secQnAns = By.id("securityAnswerControl");
	
@Test
	public static void register() {
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://juice-shop.herokuapp.com/#/register");
		
		driver.findElement(dismissBtn).click();
		driver.findElement(emailID).sendKeys("vijay@bharathi.com");
		driver.findElement(passwordTxt).sendKeys("bharathi.1234");
		driver.findElement(confirmPassword).sendKeys("bharathi.1234");
		driver.findElement(secQnBox).click();
		driver.findElement(secQn).click();
		driver.findElement(secQnAns).sendKeys("vijay");
	}
	public static void main(String[] args) {
		register();
	}

}
