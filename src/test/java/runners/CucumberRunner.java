package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.xe.framework.stepdifinitions",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}


