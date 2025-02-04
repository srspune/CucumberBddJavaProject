package stepDefination;

import java.util.Properties;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import pageObject.AddTablet;
import pageObject.LoginPage;
import pageObject.SearchCamera;

public class BaseClass 
{
	public WebDriver driver ; 
	public LoginPage loginPg ; 
	public AddTablet tab ; 
	public SearchCamera Cam ; 
	
	public static Logger log ; 
	
	public Properties p;

}
