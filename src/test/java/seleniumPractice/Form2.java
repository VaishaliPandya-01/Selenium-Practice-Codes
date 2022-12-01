package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form2 {
	
	public static void test02() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver chromeDriver =new ChromeDriver ();
		chromeDriver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		    chromeDriver.findElement(By.name("firstname")).sendKeys("ABC");
		    
	        chromeDriver.findElement(By.name("lastname")).sendKeys("XYZ");
	        
			chromeDriver.findElement(By.xpath("//input[@value='Female']")).click();
			
			chromeDriver.findElement(By.xpath("//input[@value='2']")).click();
			
			chromeDriver.findElement(By.xpath("//input[@value='Manual Tester']")).click();
			
			chromeDriver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		
			WebElement dropDownParent = chromeDriver.findElement(By.name("continents"));//Parent element
			Select continentsDropdown = new Select (dropDownParent);
			continentsDropdown.selectByVisibleText("North America");//child element
			
			
			WebElement SelectOption = chromeDriver.findElement(By.name("selenium_commands"));
			Select seleniumcommandsOption = new Select (SelectOption);
			seleniumcommandsOption.selectByVisibleText("WebElement Commands");
			
			chromeDriver.findElement(By.linkText("Click here to Download File")).click();
			
		}
		
	public static void main(String[] args) {
			
		test02();

	}
	

	}


