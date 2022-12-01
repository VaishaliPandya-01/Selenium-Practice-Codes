package shoping;

//import java.time.Duration;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class Test {
	public static void switchWindows() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//		driver.get("https://juice-shop.herokuapp.com/#/register");
//		Actions action =new Actions(driver);
//		
//		String currentWIndowID = driver.getWindowHandle(); // Will give the window id of the current window
//		
//		System.out.println("First Window ID : "+ currentWIndowID);
//		
//		
////		WebElement linkToOpenWindow = driver.findElement(by.linkText("Click Me to open New Window"));
////		
////		action.moveToElement(linkToOpenWindow);
//		
//		JavascriptExecutor jse =  (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,2000)", "");
////		
////		linkToOpenWindow.click();	
////		
////		//Getting Number of Windows
////		Set<String> windows = driver.getWindowHandles(); // Will give the window ids of all opened windows
////		
//		System.out.println("Number of Windows opened currently : "+ driver.getWindowHandles().size());
//		
//		//Printing the title of the current Window
//		System.out.println("Title of the current window : " + driver.getTitle());
//				
//		String newWindow=null;
//		
//
//		for (String win : windows) {
//			
//			//System.out.println(win);
//			if (!(win.equalsIgnoreCase(currentWIndowID))) //
//			{
//				newWindow = win;
//				break;
//			}			
//		} 
//		
//		//switching to new window
//		driver.switchTo().window(newWindow);
//		System.out.println("========= Switching Windows ========= ");
//		
//		//Printing the title of the new Window
//		System.out.println("Title of the New window : " + driver.getTitle());
//			
//		//Getting the name of the new Window
//		System.out.println("Name of the New window : " + newWindow);
//		
//		
//		jse.executeScript("window.scrollBy(0,2000)", "");
//		
//		
//		//clicking link to open another window
//		//WebElement linkToOpenThirdWindow = driver.findElement(By.linkText("Click Me To Open Third Window"));
//		//linkToOpenThirdWindow.click();
//		
//		windows = driver.getWindowHandles();
//		System.out.println("number of windows after clicking third window link " + windows.size());
//		
//		 for(String w :windows) {
//			 driver.switchTo().window(w);
//			
//			 System.out.println("###### Randomly switching to an window...! #####");
//			 System.out.println("Window id of random window is : "+ driver.getWindowHandle());
//			
//			 
//			 if(driver.getTitle().contains("3rd Window")) {
//					System.out.println("switched to third window");
//					break;
//					}
//		 }
//		 
//		System.out.println("Title of the latest window : " + driver.getTitle());
//		
//		driver.switchTo().window(currentWIndowID);
//		
//		System.out.println("Title of the latest window : " + driver.getTitle());
//
//		
	}
	

}
