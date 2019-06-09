package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        format = {"json:target/site/cucumber.json", "html:target/site/cucumber-report"},
        glue = "steps")
public class TestRunner {
}