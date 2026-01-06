package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = {"Stepdefinitons", "webTest.LoyalFriendCare.beginnerMethods", "webTest.LoyalFriendCare.lylTest", "webTest.LoyalFriendCare.Pages", "webTest.utilities"},
        dryRun = false,
        tags = "@formDoldurma",
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
