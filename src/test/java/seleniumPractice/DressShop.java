package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressShop {
	
	static WebDriver chromedriver;
	static WebElement firstresult;
	
	static By seartchtxt = By.id("search_query_top");
	static By searchbtn = By.name("submit_search");
	static By Addtocartbtn = By.xpath("//div[@class='right-block']//a[contains(text(),'Printed Chiffon Dress')]/../..//*[contains(@title,'Add to cart')]//span");		
	//static By Addtocomparebtn = By.xpath("//div[@class='functional-buttons clearfix']//a[contains(text(),'Add to Compare')]");
	static By Addtocomparebtn = By.xpath("//div[@id='center_column']//ul//li[4]//div//div[3]//div[2]//a");
	static By Addtocomparebtn2 = By.xpath("//div[@id='center_column']//ul//li[3]//div//div[3]//div[2]//a");
	static By comparebtn = By.xpath("//div[@class='top-pagination-content clearfix']//span" );
	static By comp_product1 = By.xpath("//table//tr[1]//td[2]//span[@class='price product-price']");
	static By comp_product2 = By.xpath("//table//tr[1]//td[3]//span[@class='price product-price']");
	static By Addcart_comp_product1 = By.xpath("//table//tr[1]//td[2]//div[@class='button-container']//a[contains(@title,'Add to cart')]");
	static By Addcart_comp_product2 = By.xpath("//table//tr[1]//td[3]//div[@class='button-container']//a[contains(@title,'Add to cart')]");
	static By product1_trash =By.xpath("//table//tr[1]//td[2]//i[@class='icon-trash']");
	static By product2_trash =By.xpath("//table//tr[1]//td[3]//i[@class='icon-trash']");
	static By ShopCart = By.xpath("//a[contains(@title,'View my shopping cart')]");
	static By Proceedtocheckout = By.xpath("//p[@class='cart_navigation clearfix']//a[contains(@title,'Proceed to checkout')]");
	static By Emailid = By.id("email_create");
	static By CreateAccnt = By.id("SubmitCreate");
	static By Gender1 = By.id("id_gender1");
	static By Gender2 = By.id("id_gender2");
	static By firstname = By.id("customer_firstname");
	static By Lastname = By.id("customer_lastname");
	static By password = By.id("passwd");
	static By update = By.xpath("//ul[@class='address item box']//a[contains(@title,'Update')]");
	static By Paybycheck = By.xpath("//a[contains(@title,'Pay by check.')]");
	static By confirmorder = By.xpath("//p[@class='cart_navigation clearfix']//button");
	static By OrderRef = By.xpath("//table//tr[1]//td//a");
	
	
	
	public static void addtocart() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		chromedriver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) chromedriver;
		WebDriverWait wait=new WebDriverWait(chromedriver, Duration.ofSeconds(20));
		chromedriver.get(" http://automationpractice.com/index.php");
		chromedriver.manage().window().maximize();
		chromedriver.findElement(seartchtxt).sendKeys("Summer Dress");
		chromedriver.findElement(searchbtn).click();	
		js.executeScript("window.scrollBy(0,90)");
		Actions actions = new Actions(chromedriver);
		WebElement MH = chromedriver.findElement(By.xpath("//div[@class='right-block']//a[contains(text(),'Printed Chiffon Dress')]"));
		actions.moveToElement(MH).perform();
		chromedriver.findElement(Addtocartbtn).click();
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.className("cross") ));
		chromedriver.findElement(By.className("cross")).click();
		
		/*Usecase 2*/
		
		js.executeScript("window.scrollBy(0,900)");
		WebElement MH1 = chromedriver.findElement(By.xpath("//div[@class='right-block']//a[contains(text(),'Faded Short Sleeve T-shirts')]"));	
		actions.moveToElement(MH1).perform();
		
		chromedriver.findElement(Addtocomparebtn).click();
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bottom-pagination-content clearfix']//strong[contains(text(),'1')]" )));
	
		js.executeScript("window.scrollBy(0,-700)");
		actions.moveToElement(MH).perform();
		chromedriver.findElement(Addtocomparebtn2).click();
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bottom-pagination-content clearfix']//strong[contains(text(),'2')]" )));
		chromedriver.findElement(comparebtn).click();
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Product Comparison')]" )));
		String product1_price = chromedriver.findElement(comp_product1).getText().replace("$","");
		System.out.println("Product 1 :"+product1_price);	
		String product2_price = chromedriver.findElement(comp_product2).getText().replace("$","");
		System.out.println("Product 2 :"+product2_price);
		if(Double.valueOf(product1_price) > Double.valueOf(product2_price)) {
			js.executeScript("window.scrollBy(0,700)");
			chromedriver.findElement(Addcart_comp_product1).click();
			firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.className("cross") ));
			chromedriver.findElement(By.className("cross")).click();
			chromedriver.findElement(product2_trash).click();
		}
			else  {
				js.executeScript("window.scrollBy(0,700)");
				chromedriver.findElement(Addcart_comp_product2).click();
				firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.className("cross") ));
				chromedriver.findElement(By.className("cross")).click();
				chromedriver.findElement(product1_trash).click();
			}
		
		/*Usecase 3*/
		
		chromedriver.findElement(ShopCart).click();
		chromedriver.findElement(Proceedtocheckout).click();
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Authentication')]" )));
		chromedriver.findElement(Emailid).sendKeys("xyyzx1133@gmail.com");
		chromedriver.findElement(CreateAccnt).click();
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Create an account')]" )));
		chromedriver.findElement(Gender1).click();
		chromedriver.findElement(firstname).sendKeys("xxxxx");
		chromedriver.findElement(Lastname).sendKeys("YYYYY");
		chromedriver.findElement(password).sendKeys("12345");
		js.executeScript("window.scrollBy(0,500)");
		Select day = new Select(chromedriver.findElement(By.id("days")));
		day.selectByVisibleText("19  ");
		Select Month = new Select(chromedriver.findElement(By.id("months")));
		Month.selectByVisibleText("July ");
		Select years = new Select(chromedriver.findElement(By.id("years")));
		years.selectByVisibleText("2000  ");
		chromedriver.findElement(By.id("firstname")).sendKeys("xxxxx");
		chromedriver.findElement(By.id("lastname")).sendKeys("xxxxx");
		chromedriver.findElement(By.id("company")).sendKeys("xxxxx");
		chromedriver.findElement(By.id("address1")).sendKeys("xxxxx");
		chromedriver.findElement(By.id("address2")).sendKeys("xxxxx");
		chromedriver.findElement(By.id("city")).sendKeys("xxxxx");
		Select state = new Select(chromedriver.findElement(By.id("id_state")));
		state.selectByVisibleText("Missouri");
		js.executeScript("window.scrollBy(0,500)");
		chromedriver.findElement(By.id("postcode")).sendKeys("63011");
		chromedriver.findElement(By.id("other")).sendKeys("xxxxx");
		//chromedriver.findElement(By.id("phone")).sendKeys("12345");
		chromedriver.findElement(By.id("phone_mobile")).sendKeys("987654");
		chromedriver.findElement(By.id("alias")).sendKeys("xxxxx");
		chromedriver.findElement(By.id("submitAccount")).click();
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Addresses')]" )));
		chromedriver.findElement(update).click();
		chromedriver.findElement(By.id("city")).clear();
		chromedriver.findElement(By.id("city")).sendKeys("zzzzzz");
		chromedriver.findElement(By.id("submitAddress")).click();
		chromedriver.findElement(By.name("processAddress")).click();
		chromedriver.findElement(By.id("cgv")).click();
		chromedriver.findElement(By.name("processCarrier")).click();
		chromedriver.findElement(Paybycheck).click();
		chromedriver.findElement(confirmorder).click();
		
		
		chromedriver.findElement(By.xpath("//a[contains(@title,'Back to orders')]")).click();
		String referenceid = chromedriver.findElement(OrderRef).getText();
		System.out.println("Reference number:"+referenceid);
		chromedriver.findElement(OrderRef).click();
		//Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,900)");
		firstresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='last_item alternate_item']//span")));
		String Status = chromedriver.findElement(By.xpath("//tr[@class='last_item alternate_item']//span")).getText();
		System.out.println("Status:"+Status);
		String TotalPrice = chromedriver.findElement(By.xpath("//tr[@class='totalprice item']//span")).getText();
		System.out.println("Totalprice:"+TotalPrice);	
		String AmountwithTax = chromedriver.findElement(By.xpath("//table[@class='table table-bordered']//tr[2]//span")).getText();
		System.out.println("AmountwithTax:"+AmountwithTax);
		
		chromedriver.findElement(By.xpath("//a[contains(@title,'Log me out')]")).click();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		addtocart();
	
	}
}
