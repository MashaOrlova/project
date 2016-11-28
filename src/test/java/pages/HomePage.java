package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pahan on 14.11.2016.
 */
public class HomePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 10);

    @FindBy (id = "search-key")
    private  WebElement inputSearch;

    @FindBy (xpath = "//input[@class='search-button']")
    private WebElement buttonSearch;

    private WebElement findProduct;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public  void searchProduct(String productName)
    {
        inputSearch.sendKeys(productName);
        buttonSearch.click();
    }

    public boolean findProduct(String productName)
    {
        findProduct = driver.findElement(By.partialLinkText(productName));
        return findProduct.isDisplayed();
    }

}
