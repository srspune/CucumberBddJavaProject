package stepDefination;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObject.AddTablet;
import pageObject.LoginPage;
import pageObject.SearchCamera;


public class StepDefLogin extends BaseClass
{
	@Before         // ("@Sanity")
	public void Setup() throws IOException
	{
		
		// loading config.properties file
		
				FileReader file = new FileReader ("C:\\Users\\LENOVO\\eclipse-workspace\\BddCucumber\\src\\main\\resource\\config.properties");
				p = new Properties();
				p.load(file);
				
				String brow = p.getProperty("browser");
				
				switch (brow.toLowerCase())                                                             // parallel-cross browser testing
				{
				case "chrome" : driver = new ChromeDriver();  break;
				case "edge"      :  driver = new EdgeDriver();  break;
				case "firefox"      :  driver = new FirefoxDriver();  break;
				default : System.out.println(" Invalid Browser -   ");      return;
				}
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				
			// initialization of logger
	// 	log = LogManager.getLogger("StepDefLogin");
		 log = LogManager.getLogger(StepDefLogin.class);
		 
		 System.out.println("Setup Method Executed");
		  driver = new ChromeDriver();
		 log.info("Setup Logger Execiuted");
	}
	
	/*@Before(order = 2)
	public void Setup2()
	{
		  driver = new ChromeDriver();
		  System.out.println("Setup2 Method Executed");
	}
	@Before(order = 3)
	public void Setup3()
	{
		  driver = new ChromeDriver();
		  System.out.println("Setup3 Method Executed");
	}  
	 */
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser()
	{
        
          loginPg = new LoginPage(driver);
          tab = new AddTablet(driver); 
          Cam = new SearchCamera(driver);
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(2000);
		log.fatal("User Lounched Chrome Browser Log");

	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String PassWrd) throws InterruptedException
	{
            loginPg.enterEmail(emailAdd);
            Thread.sleep(2000);
            loginPg.enterPassword(PassWrd);
            log.info("UseeName and Password entered and Log");
	}
	
	@When ("Click on Login")
	public void click_on_login() throws InterruptedException
	{
		loginPg.clickOnLogin();
		log.info("login clicked Log");
	}



    @When("user click on MyAccount link")
	public void user_click_on_MyAccount_link() throws InterruptedException
	{
              loginPg.clickOnMyAcc();
              Thread.sleep(2000);
	}
	
	@And("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException
	{
              loginPg.clickOnLogout();
            
	} 

 
	
	
	

	
	// ADDTABLET
	
	@When("user click on Tablet link")
	public void user_click_on_tablet_link()
	{
              tab.clickOnTablets();
	}

	

	@Then("click on add to cart")
	public void click_on_add_to_cart() 
	{
         tab.clickOnAddToCart();
	}


	
	// 3 Search Camera
	
	@When("user search for {string}")
	public void user_search_for(String string) 
	{
		Cam.SearchOfCamera(string);
	    
	}

	@When("click on search button")
	public void click_on_search_button()
	{
	 Cam.clickOnBox();
	}

	@Then("verify title")
	public void verify_title()
	{
	    String title = "Search - Software" ; 
	    String Actual = driver.getTitle();
	    if(Actual.contains("Search"))
	    {
	    	System.out.println("Test Case Pass");
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }
	}

//	@After 
	public void tearDown(Scenario sc) throws IOException                        // Failed Test Case Scrrenshot cpstures
	{
		System.out.println("TearDownMehod Executed");
		if(sc.isFailed()==true)
		{
			// Convert webDriver object to TakesSreeenshot
			String fileWithPath = "C:\\Users\\LENOVO\\eclipse-workspace\\BddCucumber\\screenshot\\failedScrrenShot.png" ; 
			TakesScreenshot srcShot = ((TakesScreenshot)driver);
			
			// Call getScreenshot method to create image file
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			
			// move image file to new destination
			
			File DestFile = new File(fileWithPath);
			
			// Copy File at Destination
			
			FileUtils.copyFile(srcFile, DestFile);
			
			
		}
		driver.quit();
	}
	
	public void addScreenshot(Scenario scenario)
	{
		// if we want to capture only failed test case screenshot
	/*	if(scenario.isFailed())
		{
			final byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			// attach image file report(data , media, type , name of attachement)
			scenario.attach(screenshot,"image/png", scenario.getName());
		}  */
		
		final byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		// attach image file report(data , media, type , name of attachement)
		scenario.attach(screenshot,"image/png", scenario.getName());
		
		
	} 
	
		
	
	@AfterStep
	public void afterStepDemo()
	{
		System.out.println("These is after step");
	}
	@BeforeStep
	public void beforeStepDemo()
	{
		System.out.println("These is before step");
	}


}
