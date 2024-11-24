package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.AutomationExerciseHomePage;
import selenium.AutomationExerciseLoginPage;

public class LoginTest extends baseTest {
    private String user = "xavomawusse-1109@yopmail.com";
    private String password = "AJghEJY2g3S5Ay";
    @Test
    public void login() {
        LOGGER.info(String.format("Se navega a la url %s", baseUrl));
        navigateTo(baseUrl);

        LOGGER.info("Se crean las paginas del sitio Automation Exercise");
        AutomationExerciseHomePage automationExercisePage = new AutomationExerciseHomePage(driver);
        AutomationExerciseLoginPage automationExerciseLoginPage = new AutomationExerciseLoginPage(driver);

        LOGGER.info("Se verifica la pagina no sea null");
        Assert.assertTrue(automationExercisePage.verifyPage(),"Page is not available");
        automationExercisePage.goToLogin();

        LOGGER.info("Se ingresa el usuario");
        automationExerciseLoginPage.setSignUsername(user);
        LOGGER.info("Se ingresa el password.");
        automationExerciseLoginPage.setSignUsername(password);
        LOGGER.info("Se loguea el usuario.");
        automationExerciseLoginPage.signlogin();
    }
}
