package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.TestConstant;

public class AutomationExerciseProductPage {
    private WebDriver driver;

    public AutomationExerciseProductPage(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestConstant.TIMEOUT_IN_SECOND), this);
    }

    /**
     *
     * Search a product.
     */
    public void searchProduct(String product) {
        searchProductsText.sendKeys(product);
        submitSearch.click();
    }

    /**
     *
     * Verify 'SEARCHED PRODUCTS' is visible
     */
    public boolean verifySearchedProduct(String product) {
        return singleProductsDiv.isDisplayed() && productNamelabel.isDisplayed();
    }

    /**
     *
     * @return true if search products is displayed.
     */
    public boolean searchProductIsDisplayed() {
        return searchProductsText.isDisplayed();
    }

    //Localizadores
    @FindBy(how = How.ID, using = "search_product" )
    WebElement searchProductsText;

    @FindBy(how = How.ID, using = "submit_search" )
    WebElement submitSearch;

    @FindBy(how = How.CSS, using = "[class='single-products']" )
    WebElement singleProductsDiv;

    @FindBy(how = How.CSS, using = "[class='productinfo text-center']" )
    WebElement productNamelabel;
}
