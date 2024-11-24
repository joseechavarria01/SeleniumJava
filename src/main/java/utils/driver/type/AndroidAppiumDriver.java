/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.type;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.Appium.AppiumServer;
import utils.Result;
import utils.driver.DriverWrapper;
import utils.driver.IDriverWrapper;
import utils.logger.LogController;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


public class AndroidAppiumDriver implements IDriverWrapper {
	protected static final LogController LOGGER =  new LogController(MethodHandles.lookup().lookupClass());
	private AppiumDriver driver = null;
	private static AndroidAppiumDriver instance;
	private final AppiumServer appiumServer = new AppiumServer();

	private AndroidAppiumDriver() {

	}

	public static Result<DriverWrapper> getInstance() {
		if (instance == null) {
			synchronized (Chrome.class) {
				if (instance == null) {
					instance = new AndroidAppiumDriver();
				}
			}
		}
		DriverWrapper driverWrapper = new DriverWrapper(instance);
		return Result.success(driverWrapper);
	}

	@Override
	public void driverCreate() {
		appiumServer.serverStart();
		try {
             driver = new AndroidDriver(new URL(appiumServer.appiumUrl()), this.setCapabilities());
			LOGGER.info("Se inicia el android driver correctamente :)");
        } catch(MalformedURLException exception) {
			LOGGER.info(exception.getMessage());
        }
	}

	@Override
	public UiAutomator2Options setCapabilities() {
		UiAutomator2Options options = new UiAutomator2Options();
/*
		for (Map.Entry<String, String> entry : env.getCaps().entrySet()) {
			options.setCapability(entry.getKey(), entry.getValue());
		}*/
		return options;
	}

	@Override
	public AppiumDriver getDriver() {
		return driver;
	}

	@Override
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
			LOGGER.info("Se el driver se ha cerrado correctamente.");
			try {
				Runtime.getRuntime().exec(String.format("adb shell am force-stop "));
				LOGGER.info("La aplicación ha sido cerrada forzosamente.");
			} catch (IOException e) {
				LOGGER.info(e.getMessage());
			}
        }
    }

}
