package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class AddTablet 
{
     WebDriver driver;
	
	public AddTablet(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//a[text()='Tablets']")   WebElement Tablets;
	@FindBy (xpath = "(//i[@class=\"fa fa-heart\"])[2]")   WebElement AddToCart;
	
	
	public void clickOnTablets()
	{
		Tablets.click();
	}
	
	
	
	public void clickOnAddToCart()
	{
		AddToCart.click();
	}
	
}
