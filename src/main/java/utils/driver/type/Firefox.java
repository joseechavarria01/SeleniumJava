/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.type;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.Result;
import utils.driver.DriverWrapper;
import utils.driver.IDriverWrapper;
import utils.logger.LogController;

import java.lang.invoke.MethodHandles;


public class Firefox implements IDriverWrapper {

    public static Firefox instance;
    protected static final LogController LOGGER =  new LogController(MethodHandles.lookup().lookupClass());
    protected WebDriver driver = null;

    private Firefox() {

    }

    public static Result<DriverWrapper>  getInstanceFirefox() {
        if (instance == null) {
            synchronized (Chrome.class) {
                if (instance == null) {
                    instance = new Firefox();
                }
            }
        }
        DriverWrapper driverWrapper = new DriverWrapper(instance);
        return Result.success(driverWrapper);
    }

    @Override
    public void driverCreate() {
        driver = new FirefoxDriver(this.setCapabilities());
    }

    public FirefoxOptions setCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
/*
        if(env.getDriverConfig() != null) {
            DriverConfig driverConfig = env.getDriverConfig() ;

            for (Map.Entry<String, String> entry : driverConfig.getCaps().entrySet()) {
                LOGGER.info(entry.getKey() + ":" + entry.getValue());
                options.setCapability(entry.getKey(), entry.getValue());
            }

            MobileEmulation mobileEmulation = driverConfig.getMobileEmulation();
            if(driverConfig.getDriverType() != null && driverConfig.getDriverType().equals("WEB_PHONE")) {
                if(mobileEmulation != null && mobileEmulation.getWidth() > 0 && mobileEmulation.getHeight() > 0) {
                    driver.manage().window().setSize( new Dimension(mobileEmulation.getWidth(), mobileEmulation.getHeight()));
                }
                LOGGER.info("No se encontro una configuracion mobile valida.");
            }

            if(driverConfig.getArguments() != null) {
                options.addArguments(driverConfig.getArguments());
            }
        } */

        return options;
    }
    
    @Override
    public void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

    @Override
	public Object getDriver() {
		return driver;
	}
}