package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.config.Config;
import utils.driver.DTO.SeleniumConfig;
import utils.driver.DriverFactory;
import utils.driver.DriverWrapper;
import utils.logger.LogController;

import java.lang.reflect.Method;

public class baseTest {

    protected LogController LOGGER = new LogController(baseTest.class);
    protected String baseUrl = "https://automationexercise.com/";
    protected DriverWrapper driverWrapper;
    protected SeleniumConfig seleniumConfig;
    WebDriver driver;
    
    @BeforeMethod
    public void setUp(Method method) {
        // Código para inicializar recursos necesarios para los logs
        String runId = String.format("%s:%s", method.getName(), System.currentTimeMillis());
        LOGGER.info(String.format("Setting runId to %s", runId));
        System.setProperty("runId", runId);

        LOGGER.info("Se carga la configuracion del driver");
        seleniumConfig = Config.getInstance().getConfig("config.json");

        LOGGER.info("Se registra y obtine el driverWrapper desde DriverFactory");
        driverWrapper = DriverFactory.getInstance()
                .registerDriver(seleniumConfig.getBrowser())
                .getValue(); // Obtiene el wrapper del drive

        LOGGER.info("Se Inicializa el driver");
        driverWrapper.createDriver();
        driver = (WebDriver) driverWrapper.getDriver();
        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

}
