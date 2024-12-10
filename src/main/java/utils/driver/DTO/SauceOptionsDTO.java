/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SauceOptionsDTO {
    private String username;
    private String accessKey;
    private String name;
    private String build;
    private List<String> tags;

    @JsonProperty("username")
    public String getUsername() { return username; }
    @JsonProperty("username")
    public void setUsername(String value) { this.username = value; }

    @JsonProperty("accessKey")
    public String getAccessKey() { return accessKey; }
    @JsonProperty("accessKey")
    public void setAccessKey(String value) { this.accessKey = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("build")
    public String getBuild() { return build; }
    @JsonProperty("build")
    public void setBuild(String value) { this.build = value; }

    @JsonProperty("tags")
    public List<String> getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(List<String> value) { this.tags = value; }
}