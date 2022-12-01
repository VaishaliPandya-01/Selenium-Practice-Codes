package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class edgeForm1 {
	
public static void Test01() {
		
		System.setProperty("webdriver.edge.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/msedgedriver.exe");
		
		WebDriver edgeDriver = new EdgeDriver();
		edgeDriver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
	
        
		edgeDriver.findElement(By.name("firstname")).sendKeys("ABC");
		edgeDriver.findElement(By.name("lastname")).sendKeys("XYZ");
		
		edgeDriver.findElement(By.xpath("//input[@value='Female']")).click();
		
		edgeDriver.findElement(By.xpath("//input[@value='2']")).click();
		
		
		edgeDriver.findElement(By.xpath("//input[@value='Manual Tester']")).click();
		
		
		edgeDriver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		
		

		WebElement dropDownParent = edgeDriver.findElement(By.name("continents"));
		Select continentsDropdown = new Select (dropDownParent);
		continentsDropdown.selectByVisibleText("North America");
		
		
		WebElement SelectOption = edgeDriver.findElement(By.name("selenium_commands"));
		Select seleniumcommandsOption = new Select (SelectOption);
		seleniumcommandsOption.selectByVisibleText("WebElement Commands");
		
		edgeDriver.findElement(By.name("submit")).submit();
		
	}
	
public static void main(String[] args) {
		
	Test01();

}

}
