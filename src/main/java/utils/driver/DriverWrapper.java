package utils.driver;

public class DriverWrapper {
    private final IDriverWrapper driverManager;

    public DriverWrapper(IDriverWrapper driverManager) {
        this.driverManager = driverManager;
    }

    public void createDriver() {
        driverManager.driverCreate();
    }

    public Object getDriver() {
        return driverManager.getDriver();
    }

    public void quitDriver() {
        driverManager.quitDriver();
    }
}

