package cucumberoptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepdefinations",monochrome=true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
