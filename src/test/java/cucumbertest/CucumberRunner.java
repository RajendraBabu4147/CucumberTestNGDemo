package cucumbertest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

features = "Features",
glue = {"stepDefinition"},

//this plugin "usage" generates the time taken by each step or method
//plugin = {"usage"},
//this will generate an html report in target folder using pretty plugin

//plugin = {"pretty", "json:target/cucumber-reports/cucmber.json",
		//"html:target/cucmber-reports.html",
		//"junit:target/cucmber-reports/cucmber.xml"},

plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
// monochrome = true

//tags = "@ToBeRun"

)

 public class CucumberRunner extends AbstractTestNGCucumberTests{

}
