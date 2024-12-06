package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AutomationExerciseUserHomePage;
import Pages.AutomationExerciseHomePage;
import Pages.AutomationExerciseLoginPage;

public class LoginTest extends baseTest {

    @Test
    public void  loginUser() {
        AutomationExerciseHomePage indexPage = new AutomationExerciseHomePage(driver);
        AutomationExerciseLoginPage loginPage = new AutomationExerciseLoginPage(driver);
        AutomationExerciseUserHomePage homePage = new AutomationExerciseUserHomePage(driver);
        String email = "xavomawusse-1109@yopmail.com";
        String password = "AJghEJY2g3S5Ay";


        LOGGER.info(String.format("2. Navigate to url %s", baseUrl));
        navigateTo(baseUrl);

        this.writeLogs("3. Verify that home page is visible successfully");
        Assert.assertTrue(indexPage.verifyPage(),"Page is not available");

        this.writeLogs("4. Click on 'Signup / Login' button");
        indexPage.goToLogin();

        this.writeLogs("5. Verify 'Login to your account' is visible");
        loginPage.verifyLoginForm();

        this.writeLogs("6. Enter correct email address and password");
        loginPage.setSignUsername(email);
        loginPage.setSignPassword(password);

        this.writeLogs("7. Click 'login' button");
        loginPage.signlogin();

        this.writeLogs("8. Verify that 'Logged in as username' is visible");
        Assert.assertTrue(homePage.verifyUsername(), "Home page is not displayed.");
    }

    @Test
    public void logoutUser() {
        AutomationExerciseHomePage indexPage = new AutomationExerciseHomePage(driver);
        AutomationExerciseLoginPage loginPage = new AutomationExerciseLoginPage(driver);
        AutomationExerciseUserHomePage homePage = new AutomationExerciseUserHomePage(driver);
        String email = "xavomawusse-1109@yopmail.com";
        String password = "AJghEJY2g3S5Ay";


        LOGGER.info(String.format("2. Navigate to url %s.", baseUrl));
        navigateTo(baseUrl);

        this.writeLogs("3. Verify that home page is visible successfully.");
        Assert.assertTrue(indexPage.verifyPage(),"Page is not available.");

        this.writeLogs("4. Click on 'Signup / Login' button.");
        indexPage.goToLogin();

        this.writeLogs("5. Verify 'Login to your account' is visible.");
        Assert.assertTrue(loginPage.verifyLoginForm(), "Login page is not displayed.");

        this.writeLogs("6. Enter correct email address and password.");
        loginPage.setSignUsername(email);
        loginPage.setSignPassword(password);

        this.writeLogs("7. Click 'login' button.");
        loginPage.signlogin();

        this.writeLogs("8. Verify that 'Logged in as username' is visible");
        Assert.assertTrue(homePage.verifyUsername(), "Home page is not displayed.");

        this.writeLogs("9. Click 'Logout' button.");
        homePage.logout();

        this.writeLogs("10. Verify that user is navigated to login page.");
        Assert.assertTrue(loginPage.verifyLoginForm(), "Login page is not displayed.");
    }

    @Test
    public void incorrectLogin() {
        AutomationExerciseHomePage indexPage = new AutomationExerciseHomePage(driver);
        AutomationExerciseLoginPage loginPage = new AutomationExerciseLoginPage(driver);
        String email = "xavomawusse-1109@yopmail.org";
        String password = "AJghEJY2g3S5Ay";
        String errorMessage = "Your email or password is incorrect!";

        this.writeLogs(String.format("2. Navigate to url %s", baseUrl));
        navigateTo(baseUrl);

        this.writeLogs("3. Verify that home page is visible successfully");
        Assert.assertTrue(indexPage.verifyPage(),"Page is not available");

        this.writeLogs("4. Click on 'Signup / Login' button");
        indexPage.goToLogin();

        this.writeLogs("5. Verify 'Login to your account' is visible");
        loginPage.verifyLoginForm();

       this.writeLogs("6. Enter incorrect email address and password");
        loginPage.setSignUsername(email);
        loginPage.setSignPassword(password);

       this.writeLogs("7. Click 'login' button");
        loginPage.signlogin();

       this.writeLogs(" 8. Verify error 'Your email or password is incorrect!' is visible");
       Assert.assertTrue(errorMessage.equalsIgnoreCase(loginPage.getErrorMessage()));
    }
}
