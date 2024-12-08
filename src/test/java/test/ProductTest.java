package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AutomationExerciseHomePage;
import Pages.AutomationExerciseProductPage;

public class ProductTest extends baseTest {

    @Test
    public void logoutUser() {
        AutomationExerciseHomePage homePage = new AutomationExerciseHomePage(driver);
        AutomationExerciseProductPage productPage = new AutomationExerciseProductPage(driver);
        String product = "Summer White Top";

        LOGGER.info(String.format("2. Navigate to url %s.", baseUrl));
        navigateTo(baseUrl);

        this.reports.infoStep("3. Verify that home page is visible successfully.");
        Assert.assertTrue(homePage.verifyPage(),"Page is not available.");

        this.reports.infoStep("4. Click on 'Products' button");
        homePage.goToProducts();

        this.reports.infoStep("5. Verify user is navigated to ALL PRODUCTS page successfully.");
        Assert.assertTrue(productPage.searchProductIsDisplayed(), "Search products is not displayed.");

        this.reports.infoStep("6. Enter product name in search input and click search button.");
        productPage.searchProduct(product);

        this.reports.infoStep("7. Verify 'SEARCHED PRODUCTS' is visible.");
        Assert.assertTrue(productPage.verifySearchedProduct(product));
    }
}
