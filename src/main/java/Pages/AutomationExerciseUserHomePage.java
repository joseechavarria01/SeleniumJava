package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationExerciseUserHomePage {
    private WebDriver driver;

    public AutomationExerciseUserHomePage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * @return true if username is displayed
     */
    public boolean verifyUsername() {
        return usernameLabel.isDisplayed();
    }

    /**
     *
     * Logout User
     */
    public void logout() {
        logout.click();
    }

    //Localizadores
    @FindBy(how = How.CSS, using = "[class='fa fa-user'] + b" )
    WebElement usernameLabel;

    @FindBy(how = How.CSS, using = "[href='/logout']" )
    WebElement logout;
}
