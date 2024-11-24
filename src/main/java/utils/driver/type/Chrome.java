/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.type;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Result;
import utils.config.Config;
import utils.driver.DTO.SeleniumConfig;
import utils.driver.DriverWrapper;
import utils.driver.IDriverWrapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Chrome implements IDriverWrapper {

    private WebDriver driver = null;
    private static volatile Chrome instance = null;
    SeleniumConfig config = Config.getInstance().getConfig();

    private Chrome() {

    }

    public static Result<DriverWrapper> getInstanceChrome() {
        if (instance == null) {
            synchronized (Chrome.class) {
                if (instance == null) {
                    instance = new Chrome();
                }
            }
        }
        DriverWrapper driverWrapper = new DriverWrapper(instance);
        return Result.success(driverWrapper);
    }

    @Override
    public void driverCreate() {
        if (config.getSeleniumGrid().getEnabled()) {
            try {
                driver = new RemoteWebDriver(new URL(config.getSeleniumGrid().getURL()), this.setCapabilities());
            } catch (MalformedURLException urlException) {

            }
        } else {
            driver = new ChromeDriver(this.setCapabilities());
        }
    }

    public ChromeOptions setCapabilities() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> mobileEmulation = config.getCapabilities().getMobileEmulation();

        for (Map.Entry<String, String> entry : config.getCapabilities().getCaps().entrySet()) {
            options.setCapability(entry.getKey(), entry.getValue());
        }

        if(config.getCapabilities().getArguments() != null) {
            options.addArguments(config.getCapabilities().getArguments());
        }

        if(!mobileEmulation.isEmpty() && (boolean)mobileEmulation.get("enable")) {
            Map<String, String> mobileConfig = new HashMap<>();
            String deviceName = config.getCapabilities().getMobileEmulation().get("deviceName").toString();

            if(deviceName.isEmpty() || deviceName == null) {
                for (Map.Entry<String, Object> entry : mobileEmulation.entrySet()) {

                    if(!entry.getKey().equalsIgnoreCase("deviceName")) {
                      //  mobileConfig.put(entry.getKey(), entry.getValue());
                    }
                }
            } else {
                mobileConfig.put("deviceName", deviceName);
            }

            options.setExperimentalOption("mobileEmulation", mobileConfig);
        }

        return options;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

    @Override
	public WebDriver getDriver() {
		return driver;
	}
}