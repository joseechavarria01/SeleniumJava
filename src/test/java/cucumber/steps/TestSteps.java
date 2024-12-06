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

public class TestSteps {

    private final TestContext testContext;
    AutomationExerciseHomePage indexPage;
    AutomationExerciseLoginPage loginPage;
    AutomationExerciseUserHomePage homePage;
    private WebDriver driver;

    public TestSteps() {
        this.testContext = TestContextSingleton.getInstance();
    }

    @Given("el sitio web está accesible en la URL {string}")
    public void goToUrl(String url) {

        driver = testContext.getDriver();
        indexPage = new AutomationExerciseHomePage(driver);
        loginPage = new AutomationExerciseLoginPage(driver);
        homePage = new AutomationExerciseUserHomePage(driver);

        driver.navigate().to(url);
    }

    @Then("verificar que la página de inicio \\(home) se visualice correctamente con los elementos esperados")
    public void verifySignupLogin() {
      //  this.writeLogs("3. Verify that home page is visible successfully.");
        Assert.assertTrue(indexPage.verifyPage(),"Page is not available.");
    }

    @When("hacer clic en el botón 'Signup Login'")
    public void goToLoginForm() {
       // this.writeLogs("4. Click on 'Signup / Login' button.");
        indexPage.goToLogin();
    }

    @Then("verificar que el texto 'Login to your account' sea visible")
    public void validatesLoginAccountIsDisplayed() {
   //     this.writeLogs("5. Verify 'Login to your account' is visible.");
        Assert.assertTrue(loginPage.verifyLoginForm(), "Login page is not displayed.");
    }

    @When("ingresar el correo electrónico {string} y la contraseña {string}")
    public void setUserAndPassword(String email, String password) {
   //     this.writeLogs("6. Enter correct email address and password.");
        loginPage.setSignUsername(email);
        loginPage.setSignPassword(password);
    }

    @And("hacer clic en el botón 'login'")
    public void clickLoginButton() {
   //     this.writeLogs("7. Click 'login' button.");
        loginPage.signlogin();
    }

    @Then("verificar que el nombre de usuario se muestre correctamente en la página principal")
    public void validatesUserIsLoggedIn() {
 //       this.writeLogs("8. Verify that 'Logged in as username' is visible");
        Assert.assertTrue(homePage.verifyUsername(), "Home page is not displayed.");
        driver.quit();
 //       extent.flush();
    }
}


