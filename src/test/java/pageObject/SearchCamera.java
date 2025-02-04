package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCamera 
{
WebDriver driver;
	
	public SearchCamera(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@placeholder=\"Search\"]") WebElement SearchBox ; 
	@FindBy (xpath = "//button[@class=\"btn btn-default btn-lg\"]") WebElement ClickOnBox ;
	
	public void SearchOfCamera(String Cameras)
	{
		SearchBox.sendKeys(Cameras);
	}
	
	public void clickOnBox()
	{
		ClickOnBox.click();
	}
	

}
