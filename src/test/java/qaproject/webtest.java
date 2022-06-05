package qaproject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class webtest {
	public WebDriver driver;
	
	public void initWebDriver(String URL) throws InterruptedException {

		// Setting up Edge driver path.
		System.setProperty("webdriver.edge.driver", 
				"/home/goosa/edgedriver_linux64/msedgedriver");
		// Launching Edge browser.
		driver = new EdgeDriver();
		driver.get(URL);
	
		//driver.manage().window().maximize();
	
	}
	 
/*
 *  1* Driver
 *  2* inspect
 *  3* get element
 *  4* sendkey
 *  5*sumbit
 */
	
public WebElement find(String id) {
	
	WebElement element;
	element = driver.findElement(By.id(id));
	return element;
	
}
	



  	
  @Test
  public void register() throws InterruptedException, IOException {
  		initWebDriver("http://automationpractice.com/index.php?controller=my-account");
  		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
		
		
		WebElement submitBtn, accountCheck;
		
		//Find& write email to register with
		find("email_create").sendKeys("emailtotest251@gmail.com");
		
		//submit Button
		find("SubmitCreate").click();
		
		//find and write on first name, last name. each by it's id
		find("customer_firstname").sendKeys("NameFirst");
		find("customer_lastname").sendKeys("NameLast");
		
		//Find& write password
		find("passwd").sendKeys("123456789");
		
		//Find& write address
		find("address1").sendKeys("Giza,Cairo");
		
		
		//Find& write address
		find("city").sendKeys("October");
		
		
		// Drop down elements test
		
		Select states = new Select(find("id_state"));
		assertFalse(states.isMultiple());
		states.selectByValue("1");
		assertEquals("Alabama", states.getFirstSelectedOption().getText());
		
		//Find and write post code
		find("postcode").sendKeys("12345");
		
		//Find and write Phone number
		find("phone_mobile").sendKeys("0123456789");

		//Find and write alias
		find("alias").sendKeys("october2145");
		
		
		
		submitBtn = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span/i"));
		submitBtn.click();
		
		accountCheck = driver.findElement(By.className("info-account"));
		assert(accountCheck.getText().contains("Welcome to your account."));
		//Sleep for 2 sec to get page
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
		//Screenshot
		TakeScreenshot("RegSuccess");
		driver.close();
  		
  	}
@Test

public void searchProduct() throws InterruptedException, IOException {
	initWebDriver("http://automationpractice.com/index.php");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	WebElement headResults;
	find("search_query_top").sendKeys("printed");
	find("search_query_top").submit();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	headResults = driver.findElement(By.cssSelector(".page-heading.product-listing"));
	assert(headResults.getText().contains("PRINTED"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	TakeScreenshot("SearchedProduct");
	
	driver.close();
	
}




//@Test
//This Method will be used in another test (VerifyQuantityReflection)
public void addToCart() throws InterruptedException, IOException {
	
	initWebDriver("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	
	WebElement addToCartBtn, cartLayer;
	
	addToCartBtn = driver.findElement(By.linkText("Add to cart"));
	addToCartBtn.click();
	
	TakeScreenshot("AddItemToCart");
	//driver.close();
	
	
}

@Test
public void verifyAddingWish_LoggedIn() throws IOException {
	try {
		initWebDriver("http://automationpractice.com/index.php");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	WebElement signinBtn, accountCheck, category, addToWhishList,errMsg;
	
	//Sign in
	signinBtn= driver.findElement(By.linkText("Sign in"));
	signinBtn.click();
	find("email").sendKeys("pocat@gmail.com");
	find("passwd").sendKeys("123456789");
	find("SubmitLogin").click();
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	accountCheck = driver.findElement(By.className("info-account"));
	assert(accountCheck.getText().contains("Welcome to your account."));
	
	// Adding to wish list
	category = driver.findElement(By.linkText("Women"));
	category.click();
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	addToWhishList = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[3]/div[1]/a"));
	addToWhishList.click();
	
	//check if added
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	errMsg = driver.findElement(By.className("fancybox-error"));
	assert(errMsg.getText().contains("Added"));
	
	//Screenshot
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	TakeScreenshot("VerfiyLoginWishList");
	driver.close();
	
}
@Test
public void verifyAddingWish_WO_Login() throws InterruptedException, IOException {
	initWebDriver("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	
	WebElement category, addToWhishList, errMsg;
	
	category = driver.findElement(By.linkText("Women"));
	category.click();
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	addToWhishList = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[3]/div[1]/a"));
	addToWhishList.click();
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	errMsg = driver.findElement(By.className("fancybox-error"));
	assert(errMsg.getText().contains("You must be logged in"));
	
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	TakeScreenshot("VerfiyLoginWishListLoggedIn");
	driver.close();
}

@Test
public void verifyQuantityReflection() throws InterruptedException, IOException {
	addToCart();
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));

	//############################################################
	WebElement cartBtn, closeBtn, plusBtn, price;
	closeBtn = driver.findElement(By.className("cross"));
	closeBtn.click();
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	cartBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
	cartBtn.click();
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
	plusBtn = driver.findElement(By.className("icon-plus"));
	plusBtn.click();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//	FluentWait wait = new FluentWait(driver);
//	wait.withTimeout(Duration.ofSeconds(6));
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	Thread.sleep(6000); //Implicit, Excplict and Fluent wait methods NOT working in this scenario :)
	price = driver.findElement(By.id("total_price"));
	assertEquals(price.getText() ,"$35.02");
	
	TakeScreenshot("VerifyPriceReflection");
	
	driver.close();
	
}

public void TakeScreenshot(String FileName)
        throws IOException
    {
        // Creating instance of File
        File File = ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);
 
        FileUtils.copyFile(File,
                           new File(FileName + ".png"));
    }
}
