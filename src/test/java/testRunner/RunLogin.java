package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
/*import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; */




/*@RunWith(Cucumber.class)
@CucumberOptions(
	      // features = ".\\Features/AddTablets.feature" ,
	features = ".\\Features/",
	//	features = {".\\Features/LoginFeature.feature",".\\Features/AddTablets.feature"},
	       glue = "stepDefination" ,
	       dryRun = false, 
	       monochrome = true ,
	       tags = "@Smoke"  , 
	        plugin = {"pretty", "junit:target/cucumber-reports/reports_xml.xml", "json:target/cucumber-reports/reports_json.json","html:target/cucumber-reports/reports.html"}
	       //plugin = {"pretty", "json:target/cucumber-reports/reports_json.json"}
	      //plugin = {"pretty", "html:target/cucumber-reports/reports.html"}
		)                               */


@CucumberOptions( 
		    // features = ".\\Features/AddTablets.feature" ,
	        features = ".\\Features/",
	        //	features = {".\\Features/LoginFeature.feature",".\\Features/AddTablets.feature"},
	       glue = "stepDefination" ,
	       dryRun = false, 
	       monochrome = true ,
	       tags = "@smoke"  , 
	     //   plugin = {"pretty", "junit:target/cucumber-reports/reports_xml.xml", "json:target/cucumber-reports/reports_json.json","html:target/cucumber-reports/reports.html"}
	         //plugin = {"pretty", "json:target/cucumber-reports/reports_json.json"}
	       //plugin = {"pretty", "html:target/cucumber-reports/reports.html"}
	       plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		) 
public class RunLogin extends AbstractTestNGCucumberTests{
	{
		
		
		
		
	}
}
