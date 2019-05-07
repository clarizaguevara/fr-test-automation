import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.stepdefs.ScenarioHooks;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/sclavio/Documents/Git/FR-Test-Automation/src/test/resources/features/AISM62.feature"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:C:/Users/sclavio/Documents/Git/FR-Test-Automation/target/cucumber-parallel/1.html", "json:C:/Users/sclavio/Documents/Git/FR-Test-Automation/target/cucumber-parallel/1.json", "html:C:/Users/sclavio/Documents/Git/FR-Test-Automation/target/cucumber-parallel/1"},
        monochrome = false,
        
        tags = {"@onescenario"},
        glue = {"com.stepdefs"})
public class Parallel01IT {
	
	@AfterClass
	public static void tearDown() throws IOException {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        //Reporter.setSystemInfo("user", System.getProperty("user.name"));
        //Reporter.setSystemInfo("os", "Windows");
	}
}