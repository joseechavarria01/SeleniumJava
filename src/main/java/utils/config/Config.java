/**
 * @author Jose Francisco Echavarria
 */
package utils.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.TestConstant;
import utils.driver.DTO.SeleniumConfig;
import utils.logger.LogController;

import java.io.IOException;
import java.io.InputStream;

public class Config {
    private SeleniumConfig driverDTO;
    private static volatile Config instance = null;
    protected LogController LOGGER = new LogController(Config.class);

    public static Config getInstance() {
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                }
            }
        }
        return instance;
    }

    public SeleniumConfig getConfig() {
        // Cargar el archivo JSON desde resources
        ClassLoader classLoader = Config.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(TestConstant.SELENIUM_CONFIG)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Archivo JSON no encontrado en resources");
            }

            ObjectMapper mapper = new ObjectMapper();
            driverDTO = mapper.readValue(inputStream, SeleniumConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return driverDTO;
    }

    public void sepRunId(String methodName) {
        String runId = String.format("%s:%s", methodName, System.currentTimeMillis());
        LOGGER.info(String.format("Setting runId to %s", runId));
        System.setProperty("runId", runId);
    }
}