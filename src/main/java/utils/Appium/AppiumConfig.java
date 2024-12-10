/**
 * @author Jose Francisco Echavarria
 */
package utils.Appium;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppiumConfig {
    private String hubURL;
    private int usingPort;
    private String appiumServer;
    private String logFileName;
    private String logLevel;
    private String executablePath;
    private String appiumJsPath;
    private boolean appiumLogs;
    private String androidHome;
    private String pathSeparator;

    @JsonProperty("hubUrl")
    public String getHubURL() {
        return hubURL;
    }

    @JsonProperty("hubUrl")
    public void setHubURL(String hubURL) {
        this.hubURL = hubURL;
    }

    @JsonProperty("appiumServer")
    public String getAppiumServer() {
        return appiumServer;
    }

    @JsonProperty("appiumServer")
    public void setAppiumServer(String appiumServer) {
        this.appiumServer = appiumServer;
    }

    @JsonProperty("usingPort")
    public int getUsingPort() {
        return usingPort;
    }

    @JsonProperty("usingPort")
    public void setUsingPort(int usingPort) {
        this.usingPort = usingPort;
    }

    @JsonProperty("logFileName")
    public String getLogFileName() {
        return logFileName;
    }

    @JsonProperty("logFileName")
    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("executablePath")
    public String getExecutablePath() {
        return executablePath;
    }

    @JsonProperty("executablePath")
    public void setExecutablePath(String executablePath) {
        this.executablePath = executablePath;
    }

    @JsonProperty("appiumJsPath")
    public String getAppiumJsPath() {
        return appiumJsPath;
    }

    @JsonProperty("appiumJsPath")
    public void setAppiumJsPath(String appiumJsPath) {
        this.appiumJsPath = appiumJsPath;
    }

    @JsonProperty("disableAppiumLogs")
    public boolean getAppiumLogs() {
        return appiumLogs;
    }

    @JsonProperty("disableAppiumLogs")
    public void setAppiumLogsString(boolean appiumLogs) {
        this.appiumLogs = appiumLogs;
    }

    @JsonProperty("android_home")
    public String getAndroidHome() {
        return androidHome;
    }

    @JsonProperty("android_home")
    public void setAndroidHome(String value) {
        this.androidHome = value;
    }

    @JsonProperty("pathSeparator")
    public String getPathSeparator() {
        return pathSeparator;
    }

    @JsonProperty("pathSeparator")
    public void setPathSeparator(String value) {
        this.pathSeparator = value;
    }
}
