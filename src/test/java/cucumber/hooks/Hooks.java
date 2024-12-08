package cucumber.hooks;

import cucumber.common.TestContext;
import cucumber.config.TestContextSingleton;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

    private static TestContext testContext;

    @BeforeAll
    public static void setupExtent() {
        testContext = TestContextSingleton.getInstance();
        testContext.configReport();
    }

    @Before
    public void setUp(Scenario scenario) {
        testContext.createTest(scenario.getName());
        testContext.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        testContext.report().infoStep("Tearing down after the test...");
        if (scenario.isFailed()) {
            testContext.report().failStepAddScreenCapture(scenario.getName(),scenario.getId());
        }
        testContext.report().flush();
        testContext.quitDriver();
    }
}
