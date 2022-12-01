package shoping;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressShop {
	
	static By SelectCatagory = (By.xpath("//*[@id='block_top_menu']//li/a"));
	static By ExpandField = (By.xpath("//*[@id='categories_block_left']/div/ul/li[2]/span"));
	static By SelectDressType = (By.xpath("//*[@id='categories_block_left']//ul//*[@style='display: block;']//*[@class='last']/a"));
	static By SelectSize = (By.xpath("//*[@id='uniform-layered_id_attribute_group_2']"));
	static By AddToCartbtn = (By.xpath("//div[@class='right-block']//a[contains(text(),'Printed Chiffon Dress')]/../..//*[contains(@title,'Add to cart')]//span"));
	static By ContinueShopping = (By.xpath("//*[@id='layer_cart']//*[@title='Continue shopping']/span"));
	static By HomePageBtn = (By.className("icon-home"));
	static By Searchtxt = (By.id("search_query_top"));
	static By Searchbtn = (By.name("submit_search"));
	static By AddToCompare = (By.className("add_to_compare"));
	static By AddToCompare1 = (By.xpath("//*[@id='center_column']/ul/li[2]/div/div[3]/div[2]/a"));
	static By Comparebtn = (By.xpath("//*[@class='top-pagination-content clearfix']//span"));
	static By Dress1 = (By.xpath("//*[@id='product_comparison']//*[@title='Faded Short Sleeve T-shirts']//..//..//*[@class='prices-container']/span"));
	static By Dress2 =	(By.xpath("//*[@id='product_comparison']//*[@title='Printed Dress']//..//..//*[@class='prices-container']/span"));
	static By AddtoCart1 = (By.xpath("//*[@title='Faded Short Sleeve T-shirts']//..//..//div[@class='button-container']//span"));
	static By Trash = (By.xpath("//*[@title='Printed Dress']//..//..//*/a/i"));
	static By AddtoCart2 = (By.xpath("//*[@title='Printed Dress']//..//..//div[@class='button-container']//span"));
	static By Trash2 = (By.xpath("//*[@title='Faded Short Sleeve T-shirts']//..//..//*/a/i"));
	static By Checkout = (By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span"));
	static By Pcheckout = (By.xpath("//*[@class='cart_navigation clearfix']//*[@title='Proceed to checkout']/span"));
	static By Email = (By.id("email_create"));
	static By FirstName = (By.id("customer_firstname"));
	static By LastName = (By.id("customer_lastname"));
	static By Address = (By.id("address1"));
	static By CityName = (By.id("city"));
	static By ZipCode = (By.id("postcode"));
	static By Phone = (By.id("phone_mobile"));
	static By UpdateAddress = (By.xpath("//*[@id='address_delivery']//*[@title='Update']"));
	static By HomePhn = (By.id("phone"));
	static By Save = (By.id("submitAddress"));
	
	
	public static void ActionOnItems() throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver d = new ChromeDriver ();
		d.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(d, Duration.ofSeconds(20));
	    d.get("http://automationpractice.com/index.php");
	    Actions actions = new Actions (d);
	
	//Search for the any summer dress by applying search criteria in catalog and add to cart
	    
	d.findElement(SelectCatagory).click();
	wait.until(ExpectedConditions.elementToBeClickable(ExpandField));
	d.findElement(ExpandField).click();
	wait.until(ExpectedConditions.elementToBeClickable(SelectDressType));
	d.findElement(SelectDressType).click();
	wait.until(ExpectedConditions.elementToBeClickable(SelectSize));
	d.findElement(SelectSize).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-block']//a[contains(text(),'Printed Chiffon Dress')]")));
	WebElement SelectDress = d.findElement(By.xpath("//div[@class='right-block']//a[contains(text(),'Printed Chiffon Dress')]"));
	actions.moveToElement(SelectDress).perform();
	d.findElement(AddToCartbtn).click();
	wait.until(ExpectedConditions.elementToBeClickable(ContinueShopping));
	d.findElement(ContinueShopping).click();
	
	
	// Compare Faded Short Sleeve T-shirts and Printed Dress using Add to compare option, add the higher price into cart and remove the another one
	d.findElement(HomePageBtn).click();
	wait.until(ExpectedConditions.elementToBeClickable(Searchtxt));
	d.findElement(Searchtxt).sendKeys("Faded Short Sleeve T-shirts");
	d.findElement(Searchbtn).click();
	WebElement SelectDress1 = d.findElement(By.xpath("//div[@class='right-block']//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
	actions.moveToElement(SelectDress1).perform();
	wait.until(ExpectedConditions.elementToBeClickable(AddToCompare));
	d.findElement(AddToCompare).click();
	Thread.sleep(2000);
	d.findElement(Searchtxt).clear();
	d.findElement(Searchtxt).sendKeys("Printed Dress");
	d.findElement(Searchbtn).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-block']//a[contains(text(),'Printed Dress')]")));
	WebElement SelectDress2 = d.findElement(By.xpath("//div[@class='right-block']//a[contains(text(),'Printed Dress')]"));
	actions.moveToElement(SelectDress2).perform();
	d.findElement(AddToCompare1).click();
	Thread.sleep(1000);
	d.findElement(Comparebtn).click();
	Thread.sleep(1000);
	
	String TDressPrice = d.findElement(Dress1).getText().replace("$","");
	String PDressPrice = d.findElement(Dress2).getText().replace("$","");
	
	if (Double.valueOf(TDressPrice)  > Double.valueOf(PDressPrice)) {
		
		d.findElement(Trash).click();
		wait.until(ExpectedConditions.elementToBeClickable(AddtoCart1));
		d.findElement(AddtoCart1).click();
		wait.until(ExpectedConditions.elementToBeClickable(Checkout));
		d.findElement(Checkout).click();
		Thread.sleep(500);
		
	}
	else {
		d.findElement(Trash2).click();
		wait.until(ExpectedConditions.elementToBeClickable(AddtoCart2));
		d.findElement(AddtoCart2).click();
		wait.until(ExpectedConditions.elementToBeClickable(Checkout));
		d.findElement(Checkout).click();
		Thread.sleep(500);		
	}
	
	
	//Register
	d.findElement(Pcheckout).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));
	d.findElement(Email).sendKeys("ttrek32334@gh.com");
	d.findElement(By.id("SubmitCreate")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
	d.findElement(By.id("id_gender2")).click();
	d.findElement(FirstName).sendKeys("asd");
	d.findElement(LastName).sendKeys("sdas");
	d.findElement(By.id("passwd")).sendKeys("sdxcvcvhs");
	
	Select Day = new Select(d.findElement(By.id("days")));
	Day.selectByValue("4");
	Select Month = new Select(d.findElement(By.id("months")));
	Month.selectByValue("1");
	Select years = new Select(d.findElement(By.id("years")));
	years.selectByValue("1990");
	
	d.findElement(Address).sendKeys("jfhsjf jhfkjs");
	d.findElement(CityName).sendKeys("Tampa");
	Select State = new Select (d.findElement(By.id("id_state")));
	State .selectByVisibleText("Florida");	
	d.findElement(ZipCode).sendKeys("23456");
	d.findElement(Phone).sendKeys("2345678923");
	d.findElement(By.id("submitAccount")).click();
	wait.until(ExpectedConditions.elementToBeClickable(UpdateAddress));
	
	//Update Address
	d.findElement(UpdateAddress).click();
	wait.until(ExpectedConditions.elementToBeClickable(Address));
	d.findElement(Address).clear();
	d.findElement(Address).sendKeys("agdjagdjgdasjhgdaj");
	d.findElement(CityName).clear();
	d.findElement(CityName).sendKeys("Orlando");
	d.findElement(HomePhn).sendKeys("4243242");
	d.findElement(Save).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='processAddress']/span")));
	d.findElement(By.xpath("//*[@name='processAddress']/span")).click();
	d.findElement(By.id("cgv")).click();
	d.findElement(By.xpath("//*[@name='processCarrier']/span")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='cheque']")));
	
	//Pay Option
	d.findElement(By.xpath("//*[@class='cheque']")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button btn btn-default button-medium']/span")));
	d.findElement(By.xpath("//*[@class='button btn btn-default button-medium']/span")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Back to orders']")));
	
	//Reference ID
	d.findElement(By.xpath("//*[@title='Back to orders']")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='color-myaccount']")));
	WebElement ReferenceId = d.findElement(By.xpath("//*[@class='color-myaccount']"));
	System.out.println("Reference Id :- " +ReferenceId.getText() );
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='history_detail footable-last-column']//a/span")));
	
	//Order History
	
	d.findElement(By.xpath("//*[@class='history_detail footable-last-column']//a/span")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='last_item alternate_item']//span")));
	WebElement Status= d.findElement(By.xpath("//tr[@class='last_item alternate_item']//span"));
	System.out.println("Order Status :- " +Status.getText() );
	WebElement Total= d.findElement(By.xpath("//tr[@class='totalprice item']//span"));
	System.out.println("Total :- " +Total.getText() );
	WebElement Tax= d.findElement(By.xpath("//*[contains(text(),'Items (tax incl.) ')]//..//..//span"));
	System.out.println("Tax Amount :- " +Tax.getText() );
	d.findElement(By.xpath("//*[@class='logout']")).click();
	
	System.out.println("Test Completed");
	

		

		
	}
	
	public static void main(String[] args) throws InterruptedException {
		ActionOnItems();
	}
	

}
