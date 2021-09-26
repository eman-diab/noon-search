package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By searchInput = By.cssSelector("input[id='searchBar']");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage searchForItem (String Item) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(searchInput).sendKeys(Item, Keys.ENTER);

        return new SearchPage(driver);
    }


}
