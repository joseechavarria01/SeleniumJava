package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.TestConstant;
import utils.logger.LogController;

public class AutomationExerciseHomePage {
    protected LogController LOGGER = new LogController(AutomationExerciseHomePage.class);
    private WebDriver driver;

    public AutomationExerciseHomePage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestConstant.TIMEOUT_IN_SECOND), this);
    }

    /**
     *
     * @return true if slider carousel is displayed
     */
    public boolean verifyPage() {
        LOGGER.info("Home page is displayed.");
        return sliderCarousel.isDisplayed();
    }

    /**
     * Click on Signup / Login link navigate to login page
     */
    public void goToLogin() {
        LOGGER.info("Click on login menu.");
        signUp.click();
    }

    /**
     * Click on Products link navigate to Product Page
     */
    public void goToProducts() {
        LOGGER.info("Click on product's menu.");
        products.click();
    }

    //Localizadores
    @FindBy(how = How.CSS, using = "[href='/login']" )
    WebElement signUp;

    @FindBy(how = How.CSS, using = "[id='slider-carousel'] [class='carousel-inner']" )
    WebElement sliderCarousel;

    @FindBy(how = How.CSS, using = "[href='/products']" )
    WebElement products;
}
