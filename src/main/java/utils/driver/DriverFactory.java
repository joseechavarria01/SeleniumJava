package utils.driver;

import utils.Result;
import utils.ResultBind;
import utils.driver.type.AndroidAppiumDriver;
import utils.driver.type.Chrome;
import utils.driver.type.Firefox;
import utils.logger.LogController;

public class DriverFactory {
    private Result<DriverWrapper> driverWrapper;
    private LogController LOGGER = new LogController(DriverFactory.class);
    private static DriverFactory instance = null;

    private DriverFactory() {}

    public static DriverFactory getInstance() {
        synchronized (DriverFactory.class) {
            if (instance == null) {
                instance = new DriverFactory();
            }
        }
        return instance;
    }

    private Result<String> validateDriver(String typeDriver) {
        if (typeDriver == null || typeDriver.isEmpty()) {
            return Result.failureWithError("El driver proporcionado no existe.");
        }
        return Result.success(typeDriver);
    }

    private Result<DriverWrapper> createDriver(String typeDriver) {

        switch (typeDriver.toUpperCase()) {
            case "CHROME":
                driverWrapper = Chrome.getInstanceChrome();
                break;
            case "FIREFOX":
                driverWrapper = Firefox.getInstanceFirefox();
                break;
            case "ANDROID":
                driverWrapper = AndroidAppiumDriver.getInstance();
                break;
            default:
                return Result.failureWithError("No se encontró el proveedor de WebDriver.");
        }

        if (driverWrapper.isSuccess()) {
            return Result.success(driverWrapper.getValue());
        } else {
            return Result.failureWithError("Error al inicializar el WebDriver: " + driverWrapper.getErrors());
        }
    }

    public Result<DriverWrapper> registerDriver(String typeDriver) {
        return ResultBind.bind(validateDriver(typeDriver), validDriver ->
                createDriver(validDriver)
        );
    }

    public Object getDriver() {
        if (driverWrapper != null && driverWrapper.isSuccess()) {
            return driverWrapper.getValue().getDriver();
        } else {
            throw new IllegalStateException("No se pudo recuperar el driver. Registre primero el driver.");
        }
    }

    public void quitDriver() {
        if (driverWrapper != null && driverWrapper.isSuccess()) {
            driverWrapper.getValue().quitDriver();
        } else {
            LOGGER.error("No hay un driver activo para cerrar.");
        }
    }
}

