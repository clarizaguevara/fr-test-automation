package cucumber.jvm.parallel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;

public class ReportBuilderJava {
    
    public static void main(String ... args) throws Exception{
        // Create ReportBuilder Object
        ReportBuilder reportBuilder = new ReportBuilder();
        
        // Set output Report Dir 
        reportBuilder.setReportDirectory("target/ReportBuilder/");
        
        // Set output report file name
        reportBuilder.setReportFileName("test_results");
        
        // Set Report Title
        reportBuilder.setReportTitle("Fast Retailing Event Automation Test Report");
        
        // Set Report Color for more visit http://materializecss.com/color.html
        reportBuilder.setReportColor(Color.CYAN);
        
        // Enable voice control for report
        //reportBuilder.enableVoiceControl();
        
        // Add additional info for Report
        reportBuilder.setAdditionalInfo("Environment", "http://206.164.57.173:6080/");

        // Create list or report Files or Directories or URLs or JSONObject or JSONString
        List<Object> cucumberJsonReports = new ArrayList<>();
        //cucumberJsonReports.add(new File("my/report/path/report.json"));
        cucumberJsonReports.add(new File("target/cucumber-parallel"));
        //cucumberJsonReports.add(new URL("http://myReportUrl/report.json"));
        //cucumberJsonReports.add(new JSONObject("report Json String"));
        
        // Build your report
        reportBuilder.build(cucumberJsonReports);
    }
}
