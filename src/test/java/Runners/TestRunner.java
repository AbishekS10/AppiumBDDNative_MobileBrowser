package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "@test1",
        glue = {"StepDefinitions"},
//       plugin = {"pretty", "html:target/cucumber-reports"},
        //io.gameta.allure.cucumber7jvm.Allure Cucumber7Jvm
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)
public class TestRunner {
}
