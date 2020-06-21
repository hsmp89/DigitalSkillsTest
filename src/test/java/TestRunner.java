import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(tags = {"@vehicleTest"},
        plugin = {"pretty", "html:target/features/cucumber-pretty",
                "json:target/cucumber/cucumber.json",
                "junit:target/junit/cucumber.xml"},
        features = "classpath:features",
        glue = "stepdefinitions")

public class TestRunner {
}
