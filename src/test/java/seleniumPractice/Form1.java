package seleniumPractice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form1 {
	
	public static void Test01() {
		
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		
		WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		
		
		/*WebElement firstnametxtbox=chromeDriver.findElement(By.name("firstname"));
		firstnametxtbox.sendKeys("Ram");
				
		WebElement lastnametxtbox=chromeDriver.findElement(By.name("lastname"));
		lastnametxtbox.sendKeys("Raman");*/
        
        chromeDriver.findElement(By.name("firstname")).sendKeys("ABC");
        chromeDriver.findElement(By.name("lastname")).sendKeys("XYZ");
		
		chromeDriver.findElement(By.xpath("//input[@value='Female']")).click();
		
		chromeDriver.findElement(By.xpath("//input[@value='2']")).click();
		
		//chromeDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("09/15/2022");
		
		//To select both checkbox.......
		/*List<WebElement> CheckAll = chromeDriver.findElements(By.name("profession"));
		for (WebElement profession:CheckAll){
			profession.click();
		}*/
		
		chromeDriver.findElement(By.xpath("//input[@value='Manual Tester']")).click();
		
		//To select All checkbox.......
				/*List<WebElement> CheckAll = chromeDriver.findElements(By.name("tool"));
				for (WebElement tool:CheckAll){
					tool.click();
				}*/
		
		chromeDriver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		
		
		//Dropdown
		WebElement dropDownParent = chromeDriver.findElement(By.name("continents"));//Parent element
		Select continentsDropdown = new Select (dropDownParent);
		continentsDropdown.selectByVisibleText("North America");//child element
		
		
		WebElement SelectOption = chromeDriver.findElement(By.name("selenium_commands"));
		Select seleniumcommandsOption = new Select (SelectOption);
		seleniumcommandsOption.selectByVisibleText("WebElement Commands");
		
		chromeDriver.findElement(By.name("submit")).submit();
		
	}
	
public static void main(String[] args) {
		
	Test01();

}
}
