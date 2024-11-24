package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.logger.LogController;

public class AutomationExerciseLoginPage {

    protected LogController LOGGER = new LogController(AutomationExerciseLoginPage.class);
    private WebDriver driver;

    public AutomationExerciseLoginPage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver, this);
    }

    public void setSignUsername(String username) {
        LOGGER.info("Set user name");
        userText.sendKeys(username);
    }

    public void setSignPassword(String password) {
        LOGGER.info("Set password");
        passwordText.sendKeys(password);
    }

    public void signlogin() {
        LOGGER.info("Click to login Button");
        loginButton.submit();
    }

    //Localizadores
    @FindBy(how = How.CSS, using = "[action='/login'] [name='email']")
    WebElement userText;

    @FindBy(how = How.CSS, using = "[action='/login'] [name='password']")
    WebElement passwordText;

    @FindBy(how = How.CSS, using = "[data-qa='login-button']" )
    WebElement loginButton;
}
