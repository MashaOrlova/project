package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertFalse;

public abstract class AbstractPage {
    protected WebDriver driver;
    public abstract void openPage(String URL);
    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitForPageLoaded(WebDriver driver)
    {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver driver)
                    {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new WebDriverWait(driver,30);
        try
        {
            wait.until(expectation);
            Thread.sleep(4000);
        }
        catch(Throwable error)
        {
            assertFalse("Timeout waiting for Page Load Request to complete.",true);
        }
    }

    public void waitForElementLoaded(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void scrollToPage(WebElement webElement){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
