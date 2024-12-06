package cucumber.hooks;

import cucumber.common.TestContext;
import cucumber.config.TestContextSingleton;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    private final TestContext testContext;

    public Hooks() {
        this.testContext = TestContextSingleton.getInstance();
    }

    @Before
    public void setUp() {
        System.out.println("Setting up before the test...");
        testContext.initializeDriver();
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down after the test...");
        testContext.quitDriver();
    }
}
