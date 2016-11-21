package pages;

import org.junit.Test;
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

    private final Wait<WebDriver> wait = new WebDriverWait(driver, 10);
    @FindBy(xpath = "id('profile-sub-nav')/li[1]")
    private WebElement linkProfile;

    @FindBy(id = "control_gen_3")
    private WebElement buttonChooseImage;

    @FindBy(xpath = ".//*[@id='dialog-wrapper']//form/input[@name = 'file']")
    private WebElement uploadFileInput;

    @FindBy(xpath = ".//*[@id='dialog-wrapper']//div[2]/div[2]//div[2]/button[1]")
    private WebElement submitUploadFileInput;

    @FindBy(xpath = ".//*[@id='dialog-wrapper']//span/input[@name = 'file']")
    private WebElement reloadFileInput;

    @FindBy(xpath = "//button[@class = 'delete']")
    private WebElement deleteImageButton;

    @FindBy(id = "main-search-box")
    private WebElement inputSearchPeople;

    @FindBy(xpath = "//button[@name = 'search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "id('results')/li/a/img")
    private WebElement resultSearch;

    @FindBy(xpath = "id('name')/h1/span/span")
    private WebElement getPeopleName;

    @FindBy(xpath = "//span[text() = 'Create post']")
    private WebElement linkWriteANewPost;

    @FindBy(xpath = "//textarea")
    private WebElement inputHeadline;

    @FindBy(xpath = "//div[@class = 'ql-editor ql-blank']/p")
    private WebElement inputMessage;

    @FindBy(xpath = "//button[text() = 'Publish']")
    private WebElement buttonPublish;

    @FindBy(xpath = "//footer/button[text() = 'Publish']")
    private WebElement buttonConfirmationPublish;

    @FindBy(id = "post-container")
    private WebElement scrollPostContainer;

    @FindBy(xpath = "//div/ul/li[1]/h5/a")
    private WebElement linkAddedPost;

    @FindBy(xpath = "id('article-header')/a")
    private WebElement buttonEditArticle;

    @FindBy(xpath = "//span[text() = 'View More']")
    private WebElement viewMore;

    @FindBy(xpath = "//button[text() = 'More']")
    private WebElement buttonMore;

    @FindBy(xpath = "//ul/li[3]/a")
    private WebElement linkArticle;

    @FindBy(xpath = "//li[2]/button")
    private WebElement buttonDeletePost;

    @FindBy(xpath = "//li/button[2]")
    private WebElement buttonConfirmationDeletePost;

    @FindBy(xpath = "//span[text() = 'You do not have any articles.']")
    private WebElement spanArticlesNotFound;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public void clickToButtonChooseImmage() {
        buttonChooseImage.click();
    }

    public void clickChooseImage(){
        waitForPageLoaded(driver);
        uploadFileInput.sendKeys(System.getProperty("user.dir") + "\\img\\12345.jpg");
        wait.until(ExpectedConditions.elementToBeClickable(submitUploadFileInput));
        wait.until(ExpectedConditions.elementToBeClickable(submitUploadFileInput));
        submitUploadFileInput.click();
        waitForPageLoaded(driver);
    }

    public boolean isAddedImage(){
        buttonChooseImage.click();
        return deleteImageButton.isDisplayed();
    }

    public void deleteImage(){
        buttonChooseImage.click();
        waitForPageLoaded(driver);
        deleteImageButton.click();
    }

    public boolean isVisibleUploadFile(){
        return uploadFileInput.isDisplayed();
    }

    public void searchForPeople(String name){
        inputSearchPeople.sendKeys(name);
        buttonSearch.click();
        wait.until(ExpectedConditions.elementToBeClickable(resultSearch));
        resultSearch.click();
    }

    public String foundPeople(){
        return getPeopleName.getText();
    }

   public void writeAnArticle(String message, String headline){
       wait.until(ExpectedConditions.elementToBeClickable(inputHeadline));
       waitForPageLoaded(driver);
       inputHeadline.sendKeys(headline);
       inputMessage.click();
       inputMessage.sendKeys(message);
       waitForPageLoaded(driver);
       buttonPublish.click();
       wait.until(ExpectedConditions.elementToBeClickable(buttonConfirmationPublish));
       buttonConfirmationPublish.click();
   }


    public String addedNewPost(){
        return linkAddedPost.getText();
    }

    public void removeNewPost(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollPostContainer);
        linkAddedPost.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonEditArticle));
        buttonEditArticle.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonMore));
        buttonMore.click();
        wait.until(ExpectedConditions.elementToBeClickable(linkArticle));
        linkArticle.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonDeletePost));
        buttonDeletePost.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonConfirmationDeletePost));
        buttonConfirmationDeletePost.click();
        waitForPageLoaded(driver);
    }

    public boolean deletedNewPost(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonMore));
        buttonMore.click();
        wait.until(ExpectedConditions.elementToBeClickable(linkArticle));
        linkArticle.click();
        return spanArticlesNotFound.isDisplayed();
    }
}
