package qaproject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class webtest {
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public void initWebDriver(String URL) throws InterruptedException {

		// Setting up Edge driver path.
		System.setProperty("webdriver.edge.driver", 
				"/home/goosa/edgedriver_linux64/msedgedriver");
		// Launching Edge browser.
		driver = new EdgeDriver();
		driver.get(URL);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	 
//	WebDriver driver = new EdgeDriver();
	
//public WebElement find(String id) {
//	
//	WebElement element;
//	element = driver.findElement(By.id(id));
//	return element;
//	
//}
	
	
  

  
  
//  public void prop() {
//		System.setProperty("webdriver.edge.driver", 
//				"/home/goosa/edgedriver_linux64/msedgedriver");
//		WebDriver driver = new EdgeDriver();
//		
//		driver.get("http://automationpractice.com/index.php");
//
//		//driver.quit();
//	}
  
  
  
//  	@SuppressWarnings("deprecation")
//  @Test
//  public void register() {
//  		System.setProperty("webdriver.edge.driver", 
//				"/home/goosa/edgedriver_linux64/msedgedriver");
//  		WebDriver driver = new EdgeDriver();
//  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("http://automationpractice.com/index.php?controller=my-account");
//		
//		WebElement submitBtn, accountCheck;
//		
//		//Find& write email to register with
//		find("email_create").sendKeys("emailtotest@gmail.com");
//		
//		//submit Button
//		find("SubmitCreate").click();
//		
//		//find and write on first name, last name. each by it's id
//		find("customer_firstname").sendKeys("NameFirst");
//		find("customer_lastname").sendKeys("NameLast");
//		
//		//Find& write password
//		find("passwd").sendKeys("123456789");
//		
//		//Find& write address
//		find("address1").sendKeys("Giza,Cairo");
//		
//		
//		//Find& write address
//		find("city").sendKeys("October");
//		
//		
//		// Drop down elements test
//		
//		Select states = new Select(find("id_state"));
//		assertFalse(states.isMultiple());
//		states.selectByValue("1");
//		assertEquals("Alabama", states.getFirstSelectedOption().getText());
//		
//		//Find and write post code
//		find("postcode").sendKeys("12345");
//		
//		//Find and write Phone number
//		find("phone_mobile").sendKeys("0123456789");
//
//		//Find and write alias
//		find("alias").sendKeys("october2145");
//		
//		
//		
//		submitBtn = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span/i"));
//		submitBtn.click();
//		
//		accountCheck = driver.findElement(By.className("info-account"));
//		assert(accountCheck.getText().contains("Welcome to your account."));
//  		
//  		
//  	}

  
  
  
  
  
  
  
  
  
  
  
  
  
  
@SuppressWarnings("deprecation")
//@Test
  public void Reg() {
	  
		System.setProperty("webdriver.edge.driver", 
				"/home/goosa/edgedriver_linux64/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=my-account");
		
		WebElement email_create, create_button, firstName, lastName,
		password, address, city, postalcode, phoneNumber, alias, submitBtn, accountCheck;
		email_create = driver.findElement(By.id("email_create"));
		email_create.sendKeys("Gx002507@gmail.com");
		
		create_button = driver.findElement(By.id("SubmitCreate"));
		create_button.click();
		
		firstName = driver.findElement(By.id("customer_firstname"));
		firstName.sendKeys("Gergesk");
		lastName = driver.findElement(By.id("customer_lastname"));
		lastName.sendKeys("Tharwatk");
		
		
    	password = driver.findElement(By.id("passwd"));
		password.sendKeys("123456");
		
		address = driver.findElement(By.id("address1"));
		address.sendKeys("Giza/Cairo");
		
		city = driver.findElement(By.id("city"));
		city.sendKeys("October");
		
		// Drop down elements test
		
		Select states = new Select(driver.findElement(By.id("id_state")));
		assertFalse(states.isMultiple());
		states.selectByValue("1");
		assertEquals("Alabama", states.getFirstSelectedOption().getText());
		
		postalcode = driver.findElement(By.id("postcode"));
		postalcode.sendKeys("56465");
		

		phoneNumber = driver.findElement(By.id("phone_mobile"));
		phoneNumber.sendKeys("0123456782");
		
		alias = driver.findElement(By.id("alias"));
		alias.sendKeys("october2145");
		
		submitBtn = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span/i"));
		submitBtn.click();
		
		accountCheck = driver.findElement(By.className("info-account"));
		assert(accountCheck.getText().contains("Welcome to your account."));
		//driver.quit();
	}


@SuppressWarnings("deprecation")
//@Test

public void searchProduct() {
	System.setProperty("webdriver.edge.driver", 
			"/home/goosa/edgedriver_linux64/msedgedriver");
	WebDriver driver = new EdgeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement searchBar, headResults;
	searchBar= driver.findElement(By.id("search_query_top"));
	searchBar.sendKeys("printed");
	searchBar.submit();
	
	headResults = driver.findElement(By.cssSelector(".page-heading.product-listing"));
	assert(headResults.getText().contains("PRINTED"));
	
}



@SuppressWarnings("deprecation")
//@Test
public void addToCart() throws InterruptedException {
	
//	System.setProperty("webdriver.edge.driver", 
//			"/home/goosa/edgedriver_linux64/msedgedriver");
//	WebDriver driver = new EdgeDriver();
//	driver.get("http://automationpractice.com/index.php");
	initWebDriver("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement addToCartBtn, cartLayer;
	addToCartBtn = driver.findElement(By.linkText("Add to cart"));
	addToCartBtn.click();
	
	
}


@SuppressWarnings("deprecation")
//@Test
public void verifyAddingWish_WO_Login() {
	System.setProperty("webdriver.edge.driver", 
			"/home/goosa/edgedriver_linux64/msedgedriver");
	WebDriver driver = new EdgeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	WebElement category, addToWhishList, errMsg;
	
	category = driver.findElement(By.linkText("Women"));
	category.click();
	
	addToWhishList = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[3]/div[1]/a"));
	addToWhishList.click();
	
	errMsg = driver.findElement(By.className("fancybox-error"));
	assert(errMsg.getText().contains("You must be logged in"));
	
	
}

@SuppressWarnings("deprecation")
@Test
public void verifyQuantityReflection() throws InterruptedException {
	addToCart();
	//WebDriver driver = new EdgeDriver();
	//initWebDriver("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	//############################################################
	WebElement cartBtn, closeBtn, plusBtn, price;
	closeBtn = driver.findElement(By.className("cross"));
	closeBtn.click();
	cartBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
	cartBtn.click();
	
	plusBtn = driver.findElement(By.className("icon-plus"));
	plusBtn.click();
	Thread.sleep(6000);
	price = driver.findElement(By.id("total_price"));
	assertEquals(price.getText(),"$35.02");
	
	
}
}
