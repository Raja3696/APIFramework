package cucumber.Options;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features"
		,glue= {"stepDefinitions"}
//		,tags = {"@Deleteplace"}
		,monochrome = true
//		,plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		,plugin= "json:target/jsonReports/cucumber-report.json"
//		,plugin={"html:target/NewReport","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunner {


}


