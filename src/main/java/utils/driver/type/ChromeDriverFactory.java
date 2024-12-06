/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.type;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.driver.DTO.SeleniumConfig;
import utils.driver.IDriverFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class ChromeDriverFactory implements IDriverFactory {

    private WebDriver driver = null;
    private static volatile ChromeDriverFactory instance = null;
    private SeleniumConfig settings;

    private ChromeDriverFactory(SeleniumConfig settings) {
        this.settings = settings;
    }

    public static ChromeDriverFactory getInstanceChrome(SeleniumConfig settings) {
        if (instance == null) {
            synchronized (ChromeDriverFactory.class) {
                if (instance == null) {
                    instance = new ChromeDriverFactory(settings);
                }
            }
        }
        return instance;
    }

    public ChromeOptions setCapabilities() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> mobileEmulation = settings.getCapabilities().getMobileEmulation();

        for (Map.Entry<String, String> entry : settings.getCapabilities().getCaps().entrySet()) {
            options.setCapability(entry.getKey(), entry.getValue());
        }

        if(settings.getCapabilities().getArguments() != null) {
            options.addArguments(settings.getCapabilities().getArguments());
        }

        if(!mobileEmulation.isEmpty() && (boolean) mobileEmulation.get("enable")) {
            Map<String, String> mobileConfig = new HashMap<>();
            String deviceName = settings.getCapabilities().getMobileEmulation().get("deviceName").toString();

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

    @Override
    public WebDriver driverCreate() {

        if (settings.getSeleniumGrid().getEnabled()) {
            try {
               return  driver = new RemoteWebDriver(new URL(settings.getSeleniumGrid().getURL()), this.setCapabilities());
            } catch (MalformedURLException urlException) {
                throw new NoSuchDriverException("Unable to obtain: chromedriver");
            }
        } else {
           return driver = new org.openqa.selenium.chrome.ChromeDriver(this.setCapabilities());
        }
    }
}