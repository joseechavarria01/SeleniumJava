/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class LogsDTO {
    private String path;
    private boolean enabled;

    @JsonProperty("path")
    public void setPath(String value) {
        this.path = value;
    }
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("enabled")
    public boolean getEnabled() {
        return enabled;
    }
    @JsonProperty("enabled")
    public void setEnabled(boolean width) {
        this.enabled = width;
    }
}
