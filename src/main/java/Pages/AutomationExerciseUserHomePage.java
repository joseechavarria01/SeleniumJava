package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.TestConstant;
import utils.logger.LogController;

public class AutomationExerciseUserHomePage {
    protected LogController LOGGER = new LogController(AutomationExerciseUserHomePage.class);
    private WebDriver driver;

    public AutomationExerciseUserHomePage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestConstant.TIMEOUT_IN_SECOND), this);
    }

    /**
     * @return true if username is displayed
     */
    public boolean verifyUsername() {
        LOGGER.info("Check if the username is visible.");
        return usernameLabel.isDisplayed();
    }

    /**
     *
     * Logout User
     */
    public void logout() {
        LOGGER.info("Click on logout user");
        logout.click();
    }

    //Localizadores
    @FindBy(how = How.CSS, using = "[class='fa fa-user'] + b" )
    WebElement usernameLabel;

    @FindBy(how = How.CSS, using = "[href='/logout']" )
    WebElement logout;
}
