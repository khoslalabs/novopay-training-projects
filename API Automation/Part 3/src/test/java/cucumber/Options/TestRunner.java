package cucumber.Options;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature/Login.feature",glue= "stepdefinition",tags= "@Regression")
public class TestRunner {
	

}
