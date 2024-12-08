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
import utils.config.Config;
import utils.driver.DTO.SeleniumConfig;
import utils.driver.IDriverFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class FirefoxDriverFactory implements IDriverFactory {

    private static FirefoxDriverFactory instance;
    private SeleniumConfig settings = Config.getInstance().getConfig();
    protected WebDriver driver = null;

    private FirefoxDriverFactory() {

    }

    public static FirefoxDriverFactory getInstanceFirefox() {
        if (instance == null) {
            synchronized (FirefoxDriverFactory.class) {
                if (instance == null) {
                    instance = new FirefoxDriverFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public WebDriver createDriver() {
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