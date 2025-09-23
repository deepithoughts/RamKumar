package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",glue="stepDefinitions",
        monochrome=true,tags="@PostObject")

public class TestRunner extends AbstractTestNGCucumberTests {

}
