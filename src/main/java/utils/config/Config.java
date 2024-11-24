package utils.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.driver.DTO.SeleniumConfig;

import java.io.IOException;
import java.io.InputStream;

public class Config {
    private SeleniumConfig driverDTO;
    private static volatile Config instance = null;

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

    public SeleniumConfig getConfig(String configFile) {
        // Cargar el archivo JSON desde resources
        ClassLoader classLoader = Config.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(configFile)) {
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

    public SeleniumConfig getConfig() {
        if(driverDTO == null) {
            throw new IllegalArgumentException("No se Iniciado la configuracion del driver");
        }
        return driverDTO;
    }
}