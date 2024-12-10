package cucumber.steps;

import Pages.AutomationExerciseHomePage;
import Pages.AutomationExerciseLoginPage;
import Pages.AutomationExerciseUserHomePage;
import cucumber.common.TestContext;
import cucumber.config.TestContextSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ExerciseLoginSteps {

    private final TestContext testContext;
    AutomationExerciseHomePage indexPage;
    AutomationExerciseLoginPage loginPage;
    AutomationExerciseUserHomePage homePage;
    private WebDriver driver;

    public ExerciseLoginSteps() {
        this.testContext = TestContextSingleton.getInstance();
        driver = testContext.getDriver();
        indexPage = new AutomationExerciseHomePage(driver);
        loginPage = new AutomationExerciseLoginPage(driver);
        homePage = new AutomationExerciseUserHomePage(driver);
    }

    @Given("el sitio web está accesible en la URL {string}")
    public void goToUrl(String url) {
        driver.navigate().to(url);
        testContext.report().infoStep(String.format("2. Navigate to %s", url));
    }

    @Then("verificar que la página de inicio \\(home) se visualice correctamente con los elementos esperados")
    public void verifySignupLogin() {
        testContext.report().infoStep("3. Verify that home page is visible successfully.");
        Assert.assertTrue(indexPage.verifyPage(),"Page is not available.");
    }

    @When("hacer clic en el botón 'Signup Login'")
    public void goToLoginForm() {
        testContext.report().infoStep("4. Click on 'Signup / Login' button.");
        indexPage.goToLogin();
    }

    @Then("verificar que el texto 'Login to your account' sea visible")
    public void validatesLoginAccountIsDisplayed() {
        testContext.report().infoStep("5. Verify 'Login to your account' is visible.");
        Assert.assertTrue(loginPage.verifyLoginForm(), "Login page is not displayed.");
    }

    @When("ingresar el correo electrónico {string} y la contraseña {string}")
    public void setUserAndPassword(String email, String password) {
        testContext.report().infoStep("6. Enter correct email address and password.");
        loginPage.setSignUsername(email);
        loginPage.setSignPassword(password);
    }

    @And("hacer clic en el botón 'login'")
    public void clickLoginButton() {
        testContext.report().infoStep("7. Click 'login' button.");
        loginPage.signlogin();
    }

    @Then("verificar que el nombre de usuario se muestre correctamente en la página principal")
    public void validatesUserIsLoggedIn() {
        testContext.report().infoStep("8. Verify that 'Logged in as username' is visible");
        Assert.assertTrue(homePage.verifyUsername(), "Home page is not displayed.");
    }
}


