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
        features = {"C:/Users/cguevara6/OneDrive - DXC Production/Documents/GitHub/FR-Test-Automation/src/test/resources/features/Phase1/Sprint3/AISM138.feature"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:C:/Users/cguevara6/OneDrive - DXC Production/Documents/GitHub/FR-Test-Automation/target/cucumber-parallel/1.html", "json:C:/Users/cguevara6/OneDrive - DXC Production/Documents/GitHub/FR-Test-Automation/target/cucumber-parallel/1.json", "html:C:/Users/cguevara6/OneDrive - DXC Production/Documents/GitHub/FR-Test-Automation/target/cucumber-parallel/1"},
        monochrome = false,
        
        tags = {"@EventsBrowser,@AccessManagement"},
        glue = {"com.stepdefs"})
public class Parallel01IT {
	
	@AfterClass
	public static void tearDown() throws IOException {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        //Reporter.setSystemInfo("user", System.getProperty("user.name"));
        //Reporter.setSystemInfo("os", "Windows");
	}
}