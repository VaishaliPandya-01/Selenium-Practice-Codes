package hospital;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HospitalZoneDetails {
	
	public static void main(String[] args) throws InterruptedException{
		try {
		
	System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver ();
	driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
	
	
	WebElement ListOfZone = driver.findElement(By.id("ddlZone"));
	Select obj = new Select(ListOfZone);
    int Hoszone = obj.getOptions().size();
	for (int j=1;j<Hoszone;j++) 

		
	{
		
		obj = new Select(driver.findElement(By.id("ddlZone")));
		obj.selectByIndex(j);
		System.out.println("Zone :- " +j);
		Thread.sleep(500);
		
		
	
	int NoOfhospitals = driver.findElements(By.xpath("//div[@class='card custom-card']")).size();

     for(int i=1;i<=NoOfhospitals;i++) {
    	 
    	 System.out.println();
	
	WebElement HospitalName=driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//a"));
	 System.out.println("Name of the hospital :"+HospitalName.getText());
	 
	WebElement NoOfBeds =driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//span[@class='count-text pr-2']"));
	 System.out.println(NoOfBeds.getText());
	 
    WebElement O2Bed = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//li[2]//div[@class='count-text']"));
    System.out.println("Oxyzen Bed - "+O2Bed.getAttribute("innerHTML"));
    
    WebElement Ventialtoravailability = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//li[4]//div[@class='count-text']"));
    System.out.println("Ventialtors availability - "+Ventialtoravailability.getAttribute("innerHTML"));
    
    HospitalName.click();
    Thread.sleep(500);
	
	WebElement address = driver.findElement(By.id("lblhosaddress"));
	System.out.println("Address : " + address.getText() );

	WebElement contact = driver.findElement(By.id("lblhosCno"));
	System.out.println("contact : " + contact.getText() );


	if(driver.findElement(By.xpath("//button[@class='close']/span")).isDisplayed()) {
	driver.findElement(By.xpath("//button[@class='close']/span")).click();
	
	}
	
	Thread.sleep(500);
	System.out.println();

     }
	}
	
	driver.quit();
	
	}
	catch(Exception e) {
		e.printStackTrace();	
	}
}
}
