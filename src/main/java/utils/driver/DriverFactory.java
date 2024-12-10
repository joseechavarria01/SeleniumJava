/**
 * @author Jose Francisco Echavarria
 */
package utils.driver;

import org.openqa.selenium.WebDriver;
import utils.config.Config;
import utils.driver.DTO.SeleniumConfig;
import utils.driver.type.ChromeDriverFactory;
import utils.driver.type.FirefoxDriverFactory;
import utils.logger.LogController;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory implements IDriverFactory {
    private LogController LOGGER = new LogController(DriverFactory.class);
    private static DriverFactory instance = null;
    private Map<String, IDriverFactory> driverFactories;
    private SeleniumConfig settings = Config.getInstance().getConfig();

    private DriverFactory() {
        driverFactories = new HashMap<>();
        driverFactories.put("CHROME", ChromeDriverFactory.getInstanceChrome());
        driverFactories.put("FIREFOX", FirefoxDriverFactory.getInstanceFirefox());
    }

    public static DriverFactory getInstance() {
        synchronized (DriverFactory.class) {
            if (instance == null) {
                instance = new DriverFactory();
            }
        }
        return instance;
    }

    @Override
    public WebDriver createDriver()
    {
        String driverType = settings.getBrowser().toUpperCase();
        if (!driverFactories.containsKey(driverType))
        {
            throw new UnsupportedOperationException(String.format("El navegador '%s' no está soportado.",settings.getBrowser()));
        }
        LOGGER.info(String.format("Create driver '%s' ",driverFactories.get(driverType).getClass().getName()));
        return driverFactories.get(driverType).createDriver();
    }
}
