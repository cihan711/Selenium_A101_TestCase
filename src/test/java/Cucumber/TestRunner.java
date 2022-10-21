package Cucumber;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	//@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/java/Cucumber",
			glue =  "stepDefinations",
			plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"html:target/cucumber-reports/report.html'"},
			monochrome = true)


	public class TestRunner  extends AbstractTestNGCucumberTests{

	}

