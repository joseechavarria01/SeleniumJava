/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.type;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.driver.DTO.SeleniumConfig;
import utils.driver.IDriverFactory;
import utils.logger.LogController;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FirefoxDriverFactory implements IDriverFactory {

    private static FirefoxDriverFactory instance;
    private SeleniumConfig settings;
    protected WebDriver driver = null;

    private FirefoxDriverFactory(SeleniumConfig settings) {
        this.settings = settings;
    }

    public static FirefoxDriverFactory getInstanceFirefox(SeleniumConfig settings) {
        if (instance == null) {
            synchronized (FirefoxDriverFactory.class) {
                if (instance == null) {
                    instance = new FirefoxDriverFactory(settings);
                }
            }
        }
        return instance;
    }

    @Override
    public WebDriver driverCreate() {
        if (settings.getSeleniumGrid().getEnabled()) {
            try {
                return  driver = new RemoteWebDriver(new URL(settings.getSeleniumGrid().getURL()), this.setCapabilities());
            } catch (MalformedURLException urlException) {
                throw new NoSuchDriverException("Unable to obtain: geckodriver for Firefox Browser");
            }
        } else {
            return driver = new FirefoxDriver(this.setCapabilities());
        }
    }


    public FirefoxOptions setCapabilities() {
        FirefoxOptions options = new FirefoxOptions();

        if(settings.getCapabilities() != null) {

            for (Map.Entry<String, String> entry : settings.getCapabilities().getCaps().entrySet()) {
                options.setCapability(entry.getKey(), entry.getValue());
            }

            if(settings.getCapabilities().getArguments()  != null) {
                options.addArguments(settings.getCapabilities().getArguments() );
            }

            Map<String, Object> mobileEmulation = settings.getCapabilities().getMobileEmulation();
            if(!mobileEmulation.isEmpty() && (boolean) mobileEmulation.get("enable")) {
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("device.metrics", mobileEmulation.get("deviceMetrics"));
                options.setProfile(profile);
            }
        }
        return options;
    }

}