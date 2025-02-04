package stepDefination;

import io.cucumber.java.en.And;

public class CloseStep extends BaseClass
{
	
	
	@And("close browser")
	public void close_browser() 
	{
		driver.close();
		log.info("close the browser");
	 //  driver.quit();
	}

}
