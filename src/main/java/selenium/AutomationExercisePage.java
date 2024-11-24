package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationExercisePage {

private WebDriver driver;

    public AutomationExercisePage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver, this);
    }


    public boolean verifyPage() {
        return sliderCarousel.isDisplayed();
    }

    public void goToLogin() {
        signUp.click();
    }

    //Localizadores

    @FindBy(how = How.CSS, using = "[href='/login']" )
    WebElement signUp;

    @FindBy(how = How.CSS, using = "[id='slider-carousel'] [class='carousel-inner']" )
    WebElement sliderCarousel;
}
