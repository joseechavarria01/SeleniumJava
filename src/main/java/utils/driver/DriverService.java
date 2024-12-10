/**
 * @author Jose Francisco Echavarria
 */
package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.NoSuchDriverException;

public class DriverService {

    private  IDriverFactory _driverFactory = DriverFactory.getInstance();
    private static DriverService instance = null;
    private WebDriver _driver;

    private DriverService()
    {
    }

    public static DriverService getInstance() {
        synchronized (DriverService.class) {
            if (instance == null) {
                instance = new DriverService();
            }
        }
        return instance;
    }

    public void createDriver() {
        _driver = _driverFactory.createDriver();
    }

    public WebDriver getDriver()
    {
        if (_driver == null)
        {
            throw new NoSuchDriverException(String.format("El driver '%s' no se ha iniciado.",_driver));
        }
        return _driver;
    }

    public void quit()
    {
        if (_driver == null)
        {
            throw new NoSuchDriverException(String.format("El driver '%s' no se ha iniciado.",_driver));
        }
        _driver.quit();
    }
}
