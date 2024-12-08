package utils.driver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeleniumConfig {
    private String browser;
    private String browserVersion;
    private String platform;
    private boolean headless;
    private SeleniumGridDTO seleniumGrid;
    private CapabilitiesDTO capabilities;
    private ScreenshotsDTO screenshots;
    private LogsDTO logs;

    @JsonProperty("browser")
    public String getBrowser() { return browser; }
    @JsonProperty("browser")
    public void setBrowser(String value) { this.browser = value; }

    @JsonProperty("browser_version")
    public String getBrowserVersion() { return browserVersion; }
    @JsonProperty("browser_version")
    public void setBrowserVersion(String value) { this.browserVersion = value; }

    @JsonProperty("platform")
    public String getPlatform() { return platform; }
    @JsonProperty("platform")
    public void setPlatform(String value) { this.platform = value; }

    @JsonProperty("headless")
    public boolean getHeadless() { return headless; }
    @JsonProperty("headless")
    public void setHeadless(boolean value) { this.headless = value; }

    @JsonProperty("selenium_grid")
    public SeleniumGridDTO getSeleniumGrid() { return seleniumGrid; }
    @JsonProperty("selenium_grid")
    public void setSeleniumGrid(SeleniumGridDTO value) { this.seleniumGrid = value; }

    @JsonProperty("capabilities")
    public CapabilitiesDTO getCapabilities() { return capabilities; }
    @JsonProperty("capabilities")
    public void setCapabilities(CapabilitiesDTO value) { this.capabilities = value; }

    @JsonProperty("screenshots")
    public ScreenshotsDTO getScreenshots() { return screenshots; }
    @JsonProperty("screenshots")
    public void setScreenshots(ScreenshotsDTO value) { this.screenshots = value; }

    @JsonProperty("logs")
    public LogsDTO getLogs() { return logs; }
    @JsonProperty("logs")
    public void setLogs(LogsDTO value) { this.logs = value; }
}