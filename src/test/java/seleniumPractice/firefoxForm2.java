package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class firefoxForm2 {
public static void test02() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/geckodriver.exe");
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		firefoxDriver.findElement(By.name("firstname")).sendKeys("ABC");
		    
		firefoxDriver.findElement(By.name("lastname")).sendKeys("XYZ");
	        
		firefoxDriver.findElement(By.xpath("//input[@value='Female']")).click();
			
		firefoxDriver.findElement(By.xpath("//input[@value='2']")).click();
		
		firefoxDriver.findElement(By.xpath("//input[@value='Manual Tester']")).click();
			
		firefoxDriver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		
			WebElement dropDownParent = firefoxDriver.findElement(By.name("continents"));//Parent element
			Select continentsDropdown = new Select (dropDownParent);
			continentsDropdown.selectByVisibleText("North America");//child element
			
			
			WebElement SelectOption = firefoxDriver.findElement(By.name("selenium_commands"));
			Select seleniumcommandsOption = new Select (SelectOption);
			seleniumcommandsOption.selectByVisibleText("WebElement Commands");
			
			
		}
		
	public static void main(String[] args) {
			
		test02();

	}
	

}
