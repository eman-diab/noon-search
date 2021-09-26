package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;

    private By searchResultHeader = By.cssSelector("div[data-qa='searchHeader']");
    private By searchResultTitle = By.cssSelector("div[data-qa='product-name']");
    private By searchResultEmpty = By.cssSelector("div>img[alt='We couldn’t find what you were looking for']");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessSearchResult(String Item){
        boolean success;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains("https://www.noon.com/egypt-en/search?q="+Item));

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultHeader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultTitle));
        wait.until(ExpectedConditions.attributeContains(searchResultTitle, "title",Item));

        if ( (driver.findElement(searchResultHeader).isDisplayed()) && (driver.findElement(searchResultHeader).isDisplayed())) {
           success=true;
        }
        else { success=false; }

        return success;
    }


    public boolean isSearchResultNotFound(String Item){
        boolean success;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains("https://www.noon.com/egypt-en/search?q="+Item));

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultEmpty));
        return driver.findElement(searchResultEmpty).isDisplayed();
    }



}
