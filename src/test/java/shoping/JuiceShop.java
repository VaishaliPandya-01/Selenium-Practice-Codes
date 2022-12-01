	package shoping;

import java.time.Duration;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class JuiceShop {
	//mat-cell[contains(text(),'One Day Delivery')]/../mat-cell/mat-radio-button

	static By dismissBtn =  By.xpath("//button//span[text()='Dismiss']");
	static By dissmissBtn1 = By.xpath("//*[@aria-label='cookieconsent']//div/a");
	static By regEmailID = By.id("emailControl");
	static By regPassword = By.id("passwordControl");
	static By repeatPassword = By.id("repeatPasswordControl");
	static By selectQnBx = By.xpath("//div[@id='mat-select-value-1']/span");
	static By selectQn = By.xpath("//span[text()=' Name of your favorite pet? ']");
	static By securityQnAns = By.id("securityAnswerControl");	
	static By registerBtn = By.id("registerButton");
	static By loginBtn = By.id("loginButton");
	static By emailId = By.id("email");
	static By password = By.id("password");
	static By alreadyCustomer = By.xpath("//*[@class='primary-link']"); 
	static By yourBasket = By.xpath("//*[@aria-label='Show the shopping cart']//span[contains(text(),' Your Basket')]");
	static By IncreseQnty1 =By.xpath("//*[@class='mat-table cdk-table']//mat-cell[contains(text(),'Apple Pomace')]//..//button[2]/span[1]");
	static By IncreseQnty2 =By.xpath("//*[@class='mat-table cdk-table']//mat-cell[contains(text(),' OWASP Juice Shop Mug ')]//..//button[2]/span[1]");
	static By  IncreseQnty3 =By.xpath("//*[@class='mat-table cdk-table']//mat-cell[contains(text(),' Quince Juice (1000ml) ')]//..//button[2]/span[1]");
	static By checkoutBtn = By.id("checkoutButton");
	static By addAddress = By.xpath("//*[@aria-label='Add a new address']//span");
	static By countryTxt = By.xpath("//*[@placeholder='Please provide a country.']");
	static By nameTxt = By.xpath("//*[@placeholder='Please provide a name.']");
	static By mobileNo = By.xpath("//*[@placeholder='Please provide a mobile number.']");
	static By zipCode = By.xpath("//*[@placeholder='Please provide a ZIP code.']"); 
	static By Address = By.xpath("//*[@placeholder='Please provide an address.']");
	static By cityTxt = By.xpath("//*[@placeholder='Please provide a city.']");
	static By submitBtn = By.id("submitButton");
	static By radioBtn = By.xpath("id('mat-radio-40')//span");
	static By continueBtn = By.xpath("//*[@aria-label='Proceed to payment selection']");
	static By selectDelivery =By.xpath("id('mat-radio-42')//span[@class='mat-radio-container']");
	static By continueBtn1 = By.xpath("//*[@aria-label='Proceed to delivery method selection']");
	static By addCardSelect = By.id("mat-expansion-panel-header-0");
	static By cardNameTxt = By.id("mat-input-14");
	static By cardNum = By.id("mat-input-15");
	static By cuponSelect =By.id("mat-expansion-panel-header-1");
	static By cuponTxt = By.id("coupon");
	static By redeemBtn = By.id("applyCouponButton");
	static By errorMsg = By.xpath("//*[@class='error ng-star-inserted']");
	static By cardRadioBtn = By.xpath("id('mat-radio-44')//span[@class='mat-radio-container']");
	static By contReview = By.xpath("//*[@aria-label='Proceed to review']");
	static By plcOrder = By.xpath("//*[@aria-label='Complete your purchase']");
	static By accountBtn = By.id("navbarAccount");
	static By logOutBtn = By.id("navbarLogoutButton");
	
	
	
	public static void ActionItems() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/joshi/eclipse-workspace-vaish/Selenium-HelloWorld/src/test/resources/Driver/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		d.get("https://juice-shop.herokuapp.com/#/register");
		Actions action =new Actions(d);
		
		//User Register
		
		d.findElement(dismissBtn).click();
		d.findElement(dissmissBtn1).click();
		d.findElement(regEmailID).sendKeys("d57@1416.com");
		d.findElement(regPassword).sendKeys("1234asdf");
		d.findElement(repeatPassword).sendKeys("1234asdf");
		d.findElement(selectQnBx).click();
		d.findElement(selectQn).click();
		d.findElement(securityQnAns).sendKeys("Tommy");
		Thread.sleep(5000);
		d.findElement(registerBtn).click();
		
		//Login And Add to Cart Items
//		d.findElement(dismissBtn).click();	
//		d.findElement(dissmissBtn1).click();
//		Thread.sleep(5000);
//		d.findElement(alreadyCustomer).click();
		Thread.sleep(5000);
		d.findElement(emailId).sendKeys("d57@1416.com");
		d.findElement(password).sendKeys("1234asdf");
		d.findElement(loginBtn).click();
		WebElement item1AddtoCart =d.findElement(By.xpath("//*[@class='item-name'][contains(text(),'Apple Pomace')]//..//..//..//..//..//div[@style='display: flex; justify-content: center;']/button"));
		action.moveToElement(item1AddtoCart).perform();
		item1AddtoCart.click();
		WebElement NextPage =d.findElement(By.xpath("//*[@aria-label='Next page']//*[@class='mat-paginator-icon']"));
		action.scrollToElement(NextPage).perform();
		NextPage.click();
		WebElement item2AddtoCart = d.findElement(By.xpath("//*[@class='item-name'][contains(text(),' OWASP Juice Shop Mug ')]//..//..//..//..//..//div[@style='display: flex; justify-content: center;']/button"));
		action.moveToElement(item2AddtoCart).perform();
		item2AddtoCart.click();
		NextPage.click();
		WebElement item3AddtoCart = d.findElement(By.xpath("//*[@class='item-name'][contains(text(),' Quince Juice (1000ml) ')]//..//..//..//..//..//div[@style='display: flex; justify-content: center;']/button"));
		action.moveToElement(item3AddtoCart).perform();
		item3AddtoCart.click();
		
		
		//increase the quantity of all items by 2
		d.findElement(yourBasket).click();
		d.findElement(IncreseQnty1).click();
		Thread.sleep(3000);
		d.findElement(IncreseQnty2).click();
		Thread.sleep(3000);
		d.findElement(IncreseQnty3).click();
		Thread.sleep(3000);
		
		//Checkout and add Address
		d.findElement(checkoutBtn).click();
		d.findElement(addAddress).click();
	
		//Random Alp Values
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    StringBuilder sb = new StringBuilder();
		Random random  = new Random();
		  int length = 10;
		  
		  for(int i = 0; i < length; i++) {
			  int index = random.nextInt(alphabet.length());
			  char randomChar = alphabet.charAt(index);
			  sb.append(randomChar);
		  }
		  String randomString = sb.toString();
		  
		  
		  //Random Number Value
		  String numbers = "0123456789";
		    StringBuilder num = new StringBuilder();
			Random randomN  = new Random();
			  int Length = 10;
			  
			  for(int i = 0; i < Length; i++) {
				  int index = randomN.nextInt(numbers.length());
				  num.append(index);
			  }
			  String randomInt = num.toString(); 
			  
			  
			  
			  //Random Number 
			  String numbers1 = "0123456789";
			    StringBuilder num1 = new StringBuilder();
				Random randomN1  = new Random();
				  int Length1 = 7;
				  
				  for(int i = 0; i < Length1; i++) {
					  int index = randomN1.nextInt(numbers1.length());
					  num1.append(index);
				  }
				  String randomNum1 = num1.toString(); 
		  
		d.findElement(countryTxt).sendKeys(randomString);	
		d.findElement(nameTxt).sendKeys(randomString);
		d.findElement(mobileNo).sendKeys(randomInt);
		d.findElement(zipCode).sendKeys(randomNum1);
		d.findElement(Address).sendKeys(randomString);
		d.findElement(cityTxt).sendKeys(randomString);
		d.findElement(submitBtn).click();
		Thread.sleep(1000);
		
		
		//Select Address and delivery
		d.findElement(radioBtn).click();
		Thread.sleep(1000);
		d.findElement(continueBtn).click();
		d.findElement(selectDelivery).click();
		d.findElement(continueBtn1).click();
		Thread.sleep(2000);
		
		
		//Add a new card, try to add a fake coupon (10 digits) and verify error
		d.findElement(addCardSelect).click();
		d.findElement(cardNameTxt).sendKeys("Jaya");
		d.findElement(cardNum).sendKeys("2345678923456789");
		Select 	expMnth = new Select (d.findElement(By.id("mat-input-16")));
		expMnth.selectByValue("11");
		Select 	expYr = new Select (d.findElement(By.id("mat-input-17")));
		expYr.selectByValue("2080");
		Thread.sleep(2000);
		d.findElement(submitBtn).click();
		d.findElement(addCardSelect).click();
		Thread.sleep(5000);
		d.findElement(cuponSelect).click();
		d.findElement(cuponTxt).sendKeys("1234567890");
		d.findElement(redeemBtn).click();
		System.out.println("Erroe Message :- " +(d.findElement(errorMsg).getText()));
		d.findElement(cuponSelect).click();
		Thread.sleep(2000);
		d.findElement(cardRadioBtn).click();
		d.findElement(contReview).click();
		d.findElement(plcOrder).click();
		Thread.sleep(1000);
		
		//Verify in Account, order history -> print order, track orde
		
		d.findElement(accountBtn).click();
		WebElement ordPayBtn = d.findElement(By.xpath("//button[@aria-label='Show Orders and Payment Menu']"));
		action.moveToElement(ordPayBtn).click().perform();
		WebElement ordHistory =d.findElement(By.xpath("//*[@aria-label='Go to order history page']"));
		action.moveToElement(ordHistory).click().perform();
		WebElement trackOrd =d.findElement(By.xpath("//*[@aria-label='Track Your Order']//span"));
		action.moveToElement(trackOrd).click().perform();
		d.findElement(accountBtn).click();
		ordPayBtn.click();
		ordHistory.click();
		String currentWIndowID = d.getWindowHandle();
		WebElement printOrd =d.findElement(By.xpath("//*[@aria-label='Print order confirmation']//span"));
		action.moveToElement(printOrd).click().perform();
        d.switchTo().window(currentWIndowID);
        
        //logout from the application
        d.findElement(accountBtn).click();
        d.findElement(logOutBtn).click();
         
		
		System.out.println("Test done");
		
	}
		
	
	

	public static void main(String[] args) throws InterruptedException {
		
		ActionItems();
		
	}
}
