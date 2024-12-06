package cucumber.config;

import cucumber.common.TestContext;

public class TestContextSingleton {

    private static final TestContext instance = new TestContext();

    public static TestContext getInstance() {
        return instance;
    }
}

