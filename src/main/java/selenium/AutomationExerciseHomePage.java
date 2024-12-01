package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationExerciseHomePage {

    private WebDriver driver;

    public AutomationExerciseHomePage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @return true if slider carousel is displayed
     */
    public boolean verifyPage() {
        return sliderCarousel.isDisplayed();
    }

    /**
     * Click on Signup / Login link navigate to login page
     */
    public void goToLogin() {
        signUp.click();
    }

    /**
     * Click on Products link navigate to Product Page
     */
    public void goToProducts() {
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
