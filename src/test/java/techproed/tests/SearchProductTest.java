package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.SearchProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
public class SearchProductTest {
    SearchProductPage searchProductPage = new SearchProductPage();
    @Test
    public void searchProductsTest(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automation_exercise_url"));
//        3. Verify that home page is visible successfully
        Assert.assertEquals( Driver.getDriver().getCurrentUrl(), "https://www.automationexercise.com/");
//        4. Click on 'Products' button
        searchProductPage.product.click();
//        5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(searchProductPage.allProducts.isDisplayed());
//        6. Enter product name in search input and click search button
        searchProductPage.searchBox.sendKeys("Blue Top");
        searchProductPage.searchButton.click();
//        7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(searchProductPage.searchedProductsText.isDisplayed());
        searchProductPage.viewProduct.click();
//        8. Verify all the products related to search are visible
        Assert.assertTrue(searchProductPage.blueTopName.isDisplayed());
        Assert.assertTrue(searchProductPage.category.getText().contains("Women"));
        Assert.assertEquals(searchProductPage.brand_polo.getText(),"Brand: Polo");

    }
}