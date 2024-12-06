package utils.driver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeleniumGridDTO {
    private boolean enabled;
    private String url;

    @JsonProperty("enabled")
    public boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    @JsonProperty("url")
    public String getURL() {
        return url;
    }

    @JsonProperty("url")
    public void setURL(String value) {
        this.url = value;
    }
}

