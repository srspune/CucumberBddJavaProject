package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@name=\"email\"]") WebElement UserName ; 
	@FindBy (xpath = "//input[@name=\"password\"]" ) WebElement Password;
	@FindBy (xpath = "//input[@value=\"Login\"]")    WebElement click ;
	@FindBy (xpath = "//a[@class=\"dropdown-toggle\"]") WebElement MyAccClick ;
	@FindBy (xpath = "(//a[text()='Logout'])[1]")   WebElement logout;
	
	public void enterEmail(String mail) throws InterruptedException
	{
	
		UserName.sendKeys(mail);
	}

	public void enterPassword (String pass) throws InterruptedException
	{
		
		Password.sendKeys(pass);
		
	}
	
	public void clickOnLogin() throws InterruptedException
	{
		Thread.sleep(2000);
		click.click();
	}
	
	public void clickOnMyAcc() throws InterruptedException
	{
		MyAccClick.click();
		Thread.sleep(2000);
	}
	
	public void clickOnLogout() throws InterruptedException
	{
		Thread.sleep(2000);
		logout.click();
	}
}
