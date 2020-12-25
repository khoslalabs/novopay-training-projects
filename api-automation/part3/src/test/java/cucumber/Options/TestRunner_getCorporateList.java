package cucumber.Options;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature/getCorporateList.feature",
					glue= {"in.novopay.platform.apis.test.getCorporateList"},
					tags= "@Regression",
					plugin={"html:target/site/cucumber-reports.html",
							"json:target/jsonReports/cucumber-reports.json",
							} )
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
						featureOverviewChart = true,
						toPDF = true,
						overviewReport = true,
						outputFolder = "target")


public class TestRunner_getCorporateList {

}
