package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.AutomationExercisePage;

public class LoginTest extends baseTest {
    
    @Test
    public void login() {
        LOGGER.info(String.format("Se navega a la url %s", baseUrl));
        navigateTo(baseUrl);

        LOGGER.info("Se crea la pagina Automation Exercise");
        AutomationExercisePage automationExercisePage = new AutomationExercisePage(driver);

        LOGGER.info("Se verifica la pagina no sea null");
        Assert.assertTrue(automationExercisePage.verifyPage(),"Page is not available");

        LOGGER.info("Se loguea el usuario.");
        automationExercisePage.goToLogin();

    }
}
