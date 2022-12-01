package shoping;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class JuiceShop_Register_PF {
	
	@FindBy (xpath = "//button//span[text()='Dismiss']") WebElement dismissBtn;
	@FindBy (id = "emailControl") WebElement emailID;
	@FindBy (id = "passwordControl") WebElement passwordTxt;
	@FindBy (id = "repeatPasswordControl") WebElement confirmPassword;
	@FindBy (xpath = "//div[@id='mat-select-value-1']/span") WebElement secQnBox;
	@FindBy (xpath = "//span[text()=' Your eldest siblings middle name? ']") WebElement secQn;
	@FindBy (id = "securityAnswerControl") WebElement secQnAns;

	
	@Test
	public void register() {
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://juice-shop.herokuapp.com/#/register");
		
		PageFactory.initElements(driver, this);
		
		dismissBtn.click();
		emailID.sendKeys("vijay@bharathi.com");
		passwordTxt.sendKeys("bharathi.1234");
		confirmPassword.sendKeys("bharathi.1234");
		secQnBox.click();
		secQn.click();
		secQnAns.sendKeys("vijay");
		
		secQnAns.getText();
		
	}

}
