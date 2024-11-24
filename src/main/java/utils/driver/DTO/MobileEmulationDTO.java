/**
 * @author Jose Francisco Echavarria
 */
package utils.driver.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MobileEmulationDTO {

	private String deviceName;
	private int width;
	private int height;

	@JsonProperty("deviceName")
	public void setDeviceName(String value) {
		this.deviceName = value;
	}

	@JsonProperty("deviceName")
	public String getDeviceName() {
		return deviceName;
	}
	@JsonProperty("width")
	public int getWidth() {
		return width;
	}
	@JsonProperty("width")
	public void setWidth(int width) {
		this.width = width;
	}
	@JsonProperty("height")
	public int getHeight() {
		return height;
	}
	@JsonProperty("height")
	public void setHeight(int height) {
		this.height = height;
	}
}

