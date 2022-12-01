package seleniumHelloWorld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hello_World {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		
		WebDriver chromedriver=new ChromeDriver();
		
		chromedriver.get("https://gmail.com");
	}
	

}
