package hospital;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample {


	
	public static void main(String[] args) {
		
		try {
			
		
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
		
		WebElement ListOfZone = driver.findElement(By.id("ddlZone"));
		Select obj = new Select(ListOfZone);
	    int Hoszone = obj.getOptions().size();
		for (int j=1;j<=Hoszone;j++) {
			
			obj = new Select(driver.findElement(By.id("ddlZone")));
			obj.selectByIndex(j);
			Thread.sleep(500);
			
			
		List<WebElement> hosps= driver.findElements(By.xpath("//div[@class='card custom-card']"));
		int numberofhosps=hosps.size();
		
		for(int i=1;i<=numberofhosps;i++)
		{
			
			System.out.println();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card custom-card']["+i+"]//a")));
			WebElement parentcard=  driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//a"));
			String hospname=  parentcard.getText();
			System.out.println(hospname);
			
			String totalbed=  driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[@class='caption-text total-vacant-bed ']/span")).getText();
			System.out.println("The total available bed are :"+totalbed);
		
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='HDU(O2)']/following-sibling::div")));
			driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[@class='caption-text total-vacant-bed ']/span")).click();
			////wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='HDU(O2)']/following-sibling::div")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='HDU(O2)']/following-sibling::div")));
			String o2bed=driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='HDU(O2)']/following-sibling::div")).getText();
			System.out.println("The available o2  are:"+ o2bed);
			
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='Ventilator']/following-sibling::div")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='Ventilator']/following-sibling::div")));
			String vent=driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='Ventilator']/following-sibling::div")).getText();
			System.out.println("The available ventilator  are:"+ vent);
			
			//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//a")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card custom-card']["+i+"]//a")));
			Actions act= new Actions(driver);
			WebElement cntactbtn= driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//a"));
			act.moveToElement(cntactbtn).click().perform();
			Thread.sleep(500);
		
			String add = null;
			String phone= null;
			if(driver.findElement(By.id("lblhosaddress")).isDisplayed()) {
				add= driver.findElement(By.id("lblhosaddress")).getText();
				System.out.println("The complete address of the hospital is:"+add);
			}else {
				System.out.println("Address not available for "+hospname);
			}
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("lblhosCno")));
			
			if(driver.findElement(By.id("lblhosCno")).isDisplayed()) {
				phone= driver.findElement(By.id("lblhosCno")).getText();
				System.out.println("The contact number of the hospital is :"+phone);
			}else {
				System.out.println("Contact number not available for "+hospname);
			}
			
			
			
			
			
			if(driver.findElement(By.xpath("//button[@class='close']/span")).isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='close']/span")));
			WebElement closebtn= driver.findElement(By.xpath("//button[@class='close']/span"));
			act.moveToElement(closebtn).click().perform();
			}
			System.out.println();
			
		
		}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			
			
			
		}

}
}
