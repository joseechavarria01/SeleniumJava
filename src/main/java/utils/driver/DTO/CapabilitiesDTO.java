package utils.driver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CapabilitiesDTO {

    private boolean acceptSSLCerts;
    private String pageLoadStrategy;
    private SauceOptionsDTO sauceOptions;
    private Map<String, String> caps;
    private Map<String, Object> mobileEmulation;
    private String [] arguments;

    @JsonProperty("acceptSslCerts")
    public boolean getAcceptSSLCerts() { return acceptSSLCerts; }
    @JsonProperty("acceptSslCerts")
    public void setAcceptSSLCerts(boolean value) { this.acceptSSLCerts = value; }

    @JsonProperty("pageLoadStrategy")
    public String getPageLoadStrategy() { return pageLoadStrategy; }
    @JsonProperty("pageLoadStrategy")
    public void setPageLoadStrategy(String value) { this.pageLoadStrategy = value; }

    @JsonProperty("sauceOptions")
    public SauceOptionsDTO getSauceOptions() { return sauceOptions; }
    @JsonProperty("sauceOptions")
    public void setSauceOptions(SauceOptionsDTO value) { this.sauceOptions = value; }

    @JsonProperty("caps")
    public Map<String, String> getCaps() {
        return caps;
    }
    @JsonProperty("caps")
    public void setCaps(Map<String, String> value) {
        this.caps = value;
    }

    @JsonProperty("mobileEmulation")
    public Map<String, Object> getMobileEmulation() {
        return mobileEmulation;
    }
    @JsonProperty("mobileEmulation")
    public void setMobileEmulation(Map<String, Object> value) {
        this.mobileEmulation = value;
    }

    @JsonProperty("arguments")
    public void setArguments(String[] value) {
        this.arguments = value;
    }
    @JsonProperty("arguments")
    public String[] getArguments() {
        return arguments;
    }
}
