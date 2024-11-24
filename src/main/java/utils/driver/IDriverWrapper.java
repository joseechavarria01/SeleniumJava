/**
 * @author Jose Francisco Echavarria
 */
package utils.driver;

import java.net.MalformedURLException;

public interface IDriverWrapper {

    public void driverCreate();

    public Object setCapabilities();

    public Object getDriver();

    public void quitDriver();
}