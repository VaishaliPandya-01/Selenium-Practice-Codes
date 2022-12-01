package shoping;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Store {

	public static void main(String[] args)  {
		
		try {
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver d = new ChromeDriver ();
		d.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		
		
		//Selecting Currency
	  d.findElement(By.xpath("//form[@id='form-currency']//i")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//button[@name='EUR']")));
	  d.findElement(By.xpath("//ul[@class='dropdown-menu']//button[@name='EUR']")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']//a[contains(text(),'Canon EOS 5D')]")));
	  System.out.println("Currency changed to Euro");
		
			
			 
			//Error Message
			 d.findElement(By.xpath("//*[@id='content']//a[contains(text(),'Canon EOS 5D')]")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='option[226]']")));
			 WebElement DropDown = d.findElement(By.xpath("//*[@name='option[226]']"));
			  Select option =new Select(DropDown);
			  option.getFirstSelectedOption();
			  
			  d.findElement(By.id("button-cart")).click();
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product']//div[@class='text-danger']")));
			  WebElement errorMessage = d.findElement(By.xpath("//*[@id='product']//div[@class='text-danger']"));
			 
			  System.out.println("Error Message :- "+ errorMessage.getText());
			  
			  d.navigate().back();
			  
			  //Adding 2 iphone to cart
			  d.findElement(By.xpath("//*[@id='content']//a[contains(text(),'iPhone')]")).click();
			  wait.until(ExpectedConditions.elementToBeClickable(By.id("input-quantity")));
			 WebElement EnterQty1 = d.findElement(By.id("input-quantity"));
			 EnterQty1.clear();
			 EnterQty1.sendKeys("2");
			 d.findElement(By.id("button-cart")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-total")));
			 System.out.println("Item added succesfully");
			 
			 d.findElement(By.id("cart-total")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cart']//a//strong")));
			 d.findElement(By.xpath("//*[@id='cart']//a//strong")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']//input")));
			 WebElement EnterQty2 = d.findElement(By.xpath("//*[@id='content']//input"));
			 EnterQty2.clear();
			 EnterQty2.sendKeys("3");
			 d.findElement(By.xpath("//*[@id='content']//i")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='checkout-cart']/div")));
			 WebElement printMsg = d.findElement(By.xpath("//*[@id='checkout-cart']/div"));
			 System.out.println(printMsg.getText());
			 
			 //print Eco Tax and VAT Amount
			 d.findElement(By.id("cart-total")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-menu pull-right']//table//tr[2]//td[2]")));
			 WebElement EcoTax = d.findElement(By.xpath("//*[@class='dropdown-menu pull-right']//table//tr[2]//td[2]"));
			 System.out.println("Eco tax :- "+EcoTax.getText());
			 WebElement VatAmount = d.findElement(By.xpath("//*//*[@class='dropdown-menu pull-right']//table//tr[3]//td[2]"));
			 System.out.println("VAT Amount :- "+VatAmount.getText());
			d.findElement(By.xpath("//*[@id='cart']//a[2]//strong")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='checkout-cart']//div")));
			WebElement ErrorMessageOfCheckout = d.findElement(By.xpath("//*[@id='checkout-cart']//div"));
			System.out.println(ErrorMessageOfCheckout.getText());
			 d.findElement(By.id("cart-total")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-danger btn-xs']")));
			 d.findElement(By.xpath("//*[@class='btn btn-danger btn-xs']")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='error-not-found']//i")));
			 
			 //Adding Mac book
			d.findElement(By.xpath("//*[@id='error-not-found']//i")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']//div[@class='caption']//a")));
			 d.findElement(By.xpath("//*[@id='content']//div[@class='caption']//a")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.id("input-quantity")));
			 String Quantity =d.findElement(By.id("input-quantity")).getAttribute("value");
			 if(Quantity.charAt(0) == '1') {
					System.out.println(Quantity.charAt(0));
					d.findElement(By.id("button-cart")).click();
					 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-product']/div[contains(text(),'Success: ')]")));
					 WebElement SucessMessage= d.findElement(By.xpath("//*[@id='product-product']/div[contains(text(),'Success: ')]"));
						System.out.println(SucessMessage.getText());
			}
			 
			 //Shopping cart adding coupon code
			 d.findElement(By.xpath("//*[@id='top-links']//li[4]//span")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']//*[@class='panel-title']//a")));
			 d.findElement(By.xpath("//*[@id='content']//*[@class='panel-title']//a")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.id("input-coupon")));
			 d.findElement(By.id("input-coupon")).sendKeys("ABCD123");
			 d.findElement(By.id("button-coupon")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='checkout-cart']/div[contains(text(),' Warning: ')]")));
			String Error=d.findElement(By.xpath("//*[@id='checkout-cart']/div[contains(text(),' Warning: ')]")).getText();
			System.out.println(Error);
			d.findElement(By.id("input-coupon")).clear();	
			  Thread.sleep(500);
			  
			//Gift Code
			d.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]/h4/a")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.id("input-voucher")));
			 d.findElement(By.id("input-voucher")).sendKeys("AXDFGH123");
			d.findElement(By.id("button-voucher")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='checkout-cart']/div[contains(text(),' Warning: ')]")));
			 String ErrorMsg=d.findElement(By.xpath("//*[@id='checkout-cart']/div[1]")).getText();
				System.out.println(ErrorMsg);
				 d.findElement(By.id("input-voucher")).clear();
			 
		    //Clear value &checkout	
		   d.findElement(By.linkText("Checkout")).click();
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("button-account")));
			
		   //Select register account option
		   d.findElement(By.id("button-account")).click();
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-firstname")));
		   d.findElement(By.id("input-payment-firstname")).sendKeys("ABC");
		   d.findElement(By.id("input-payment-lastname")).sendKeys("XYZ");
		   d.findElement(By.id("input-payment-email")).sendKeys("gkdgdj@xz.com");
		   d.findElement(By.id("input-payment-telephone")).sendKeys("1234567891");
		   d.findElement(By.id("input-payment-address-1")).sendKeys("1223 XYZ Apt");
		   d.findElement(By.id("input-payment-city")).sendKeys("WonderWorld"); 
		   d.findElement(By.id("input-payment-postcode")).sendKeys("22334");
		  Select Country = new Select (d.findElement(By.id("input-payment-country")));
		  Country.selectByVisibleText("United States");
		  Thread.sleep(500);
		  Select State = new Select (d.findElement(By.id("input-payment-zone")));
		  State.selectByValue("3613"); 
		  d.findElement(By.id("input-payment-password")).sendKeys("Allwell1");
		  d.findElement(By.id("input-payment-confirm")).sendKeys("Allwell1");
		  d.findElement(By.xpath("//*[@name='agree']")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("button-register")));
		  d.findElement(By.id("button-register")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='comment']")));
		  
		  //Add comment
		  d.findElement(By.xpath("//*[@name='comment']")).sendKeys("I want to do payment");
		   d.findElement(By.xpath("//*[@name='agree']")).click();
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
		  d.findElement(By.id("button-payment-method")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='alert alert-danger alert-dismissible']")));
		   WebElement ErrorMsg1 =d.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']"));
		   System.out.println(ErrorMsg1.getText());
		   
		   d.findElement(By.linkText("Contact Us")).click();
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("input-name")));
		   d.findElement(By.id("input-name")).clear();
		   d.findElement(By.id("input-name")).sendKeys("ssss");
		   d.findElement(By.id("input-email")).clear();
		   d.findElement(By.id("input-email")).sendKeys("ghsd@dg.com");
		   d.findElement(By.id("input-enquiry")).sendKeys("Not able to do payment");
		   d.findElement(By.xpath("//*[@value='Submit']")).click();
		   d.findElement(By.linkText("Continue")).click();
		   
		d.quit();	 
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		   
		 }	
		
	 }
		
	

