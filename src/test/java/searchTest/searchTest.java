package searchTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class searchTest extends BaseTest {
    HomePage homeObject = new HomePage(driver);
    SearchPage searchObject;


    @Test(priority = 1)
    public void SearchForExistingItem() throws InterruptedException {
        homeObject = new HomePage(driver);
        searchObject= homeObject.searchForItem("iPhone");
        Assert.assertTrue(searchObject.isSuccessSearchResult("iPhone"));
    }

    @Test(priority = 2)
    public void SearchForNotExistingItem() throws InterruptedException {
        homeObject = new HomePage(driver);
        searchObject= homeObject.searchForItem("kjhgftdrsx");
        Assert.assertTrue(searchObject.isSearchResultNotFound("kjhgftdrsx"));
    }

}
