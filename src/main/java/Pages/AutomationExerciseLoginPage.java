package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.TestConstant;
import utils.logger.LogController;

public class AutomationExerciseLoginPage {

    protected LogController LOGGER = new LogController(AutomationExerciseLoginPage.class);
    private WebDriver driver;

    public AutomationExerciseLoginPage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestConstant.TIMEOUT_IN_SECOND), this);
    }

    /**
     *
     * @return true if login form is displayed.
     */
    public boolean verifyLoginForm() {
        LOGGER.info("Form is displayed.");
        return formTitleLabel.isDisplayed();
    }

    /**
     * Set username
     * @param emailAddress
     */
    public void setSignUsername(String emailAddress) {
        LOGGER.info("Set username");
        userText.sendKeys(emailAddress);
    }

    /**
     * Set user password
     * @param password
     */
    public void setSignPassword(String password) {
        LOGGER.info("Set password");
        passwordText.sendKeys(password);
    }

    /**
     * Click on login button
     */
    public void signlogin() {
        LOGGER.info("Click to login Button");
        loginButton.submit();
    }

    /**
     * Gets the error message from an incorrect login attempt.
     * @return
     */
    public String getErrorMessage() {
        LOGGER.info("Get message error.");
        return loginErrorLabel.getText();
    }

    //Localizadores
    @FindBy(how = How.CSS, using = "[action='/login'] [name='email']")
    WebElement formTitleLabel;

    @FindBy(how = How.CSS, using = "[action='/login'] [name='email']")
    WebElement userText;

    @FindBy(how = How.CSS, using = "[action='/login'] [name='password']")
    WebElement passwordText;

    @FindBy(how = How.CSS, using = "[data-qa='login-button']" )
    WebElement loginButton;

    @FindBy(how = How.CSS, using = "[name='password'] + p" )
    WebElement loginErrorLabel;
}
