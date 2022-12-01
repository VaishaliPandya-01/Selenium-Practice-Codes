package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form3 {
	
	public static void Test03() {
		System.setProperty("webdriver.chrome.driver", "/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://cosmocode.io/automation-practice/");
		
		chromeDriver.findElement(By.id("firstname")).sendKeys("Laxmi");
		chromeDriver.findElement(By.className("lastname")).sendKeys("Narayan");
		chromeDriver.findElement(By.xpath("//input[@value='Female']")).click();
		chromeDriver.findElement(By.xpath("//input[@value='java']")).click();
		chromeDriver.findElement(By.xpath("//input[@value='python ']")).click();
		chromeDriver.findElement(By.xpath("//input[@value='vbscript']")).click();
		
		WebElement Dropdown = chromeDriver.findElement(By.name("age"));
		Select Agedropdown = new Select(Dropdown);
		Agedropdown.selectByVisibleText("Under 40");
		
		//chromeDriver.findElement(By.linkText("Click here to reload this page")).click();
	}
	
public static void main(String[] args) {
	Test03();
}

}
