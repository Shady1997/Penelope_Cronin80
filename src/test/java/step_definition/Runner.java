package step_definition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "step_definition" }, monochrome = true, plugin = {
		"pretty", "html:target/HtmlReports/report.html", "json:target/JsonReport/report.json",
		"junit:target/JunitReport/report.xml" }, tags = "@SmokeTest"
//plugin = {"pretty", "json:target/JsonReport/report.json" }
//plugin = {"pretty", "junit:target/JunitReport/report.xml" }
)
public class Runner {

}
