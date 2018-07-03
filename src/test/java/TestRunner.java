import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(format = {"pretty","html:target/html"},features = "src/main/resources",
        plugin = "html:target/reports", tags = {"@smoke"})

public class TestRunner {


}
