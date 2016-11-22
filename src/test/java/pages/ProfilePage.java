package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPage {

    private final Wait<WebDriver> wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "id('background-languages')/button")
    private WebElement btnAddNewLanguage;

    @FindBy(id = "language-languages_3_-languages-editLanguages")
    private WebElement inputLanguages;

    @FindBy(id = "proficiency-languages_3_-languages-editLanguages")
    private WebElement selectlanguage;

    @FindBy(xpath = "//input[@name = 'submit']")
    private WebElement btnSaveLanguage;

    @FindBy(xpath = "//div/h4/span[text() = 'Ukrainian']")
    private WebElement addedLanguage;

    @FindBy(xpath = "id('control_gen_26')/li[3]/button")
    private WebElement btnRemoveLanguage;

    @FindBy(xpath = "id('background-publications')/button[text() = 'Add publication']")
    private WebElement btnAddNewPublication;

    @FindBy(id = "pubTitle-editPublicationForm")
    private WebElement inputTitlePublication;

    @FindBy(id = "pubSummary-editPublicationForm")
    private WebElement textareaDecription;

    @FindBy(xpath = "//p/input[@name = 'submit']")
    private WebElement btnSavePublication;

    @FindBy(xpath = "//span[text()= 'New Publication']")
    private WebElement spanAddedPublication;

    @FindBy(xpath = "//header/h4/div/span[text() = 'New Publication']")
    private WebElement editAddedNewPublication;

    @FindBy(xpath = "//a[text() = 'Remove this publication']")
    private WebElement removePublication;

    @FindBy(xpath = "//button[text() = 'Yes, remove']")
    private WebElement confirmationRemove;

    @FindBy(id = "background-languages")
    private WebElement scrollLanguage;

    @FindBy(xpath = "//a[@title = 'Discover more']")
    private WebElement buttonDiscoverMore;

    //@FindBy(xpath = "//span[text() = 'Bill Gates']")
    private WebElement buttonFollow;

    @FindBy(id = "following-container")
    private WebElement scrollFollowingContainer;

    @FindBy(id = "follow-btn")
    private WebElement buttonFollowInPage;

    @FindBy(id = "catalog-section-discover")
    private WebElement scrollDiscoverMore;

  //  @FindBy(xpath = "//strong[text() = 'Bill Gates']")
    private WebElement strongName;

    @FindBy(xpath = "//div[1]/ul/li/div/a[1]/span[text() = 'Following']")
    private WebElement buttonUnfollowing;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public void addNewLanguage(String language, int indexProficiency){
        scrollToPage(scrollLanguage);
        btnAddNewLanguage.click();
        inputLanguages.sendKeys(language);
        selectlanguage.click();
        Select select = new Select(selectlanguage);
        select.selectByIndex(indexProficiency);
        selectlanguage.sendKeys(Keys.ENTER);
        btnSaveLanguage.click();
        waitForElementLoaded(addedLanguage);
    }

    public boolean isAddedLanguage(){
        waitForElementLoaded(addedLanguage);
        return addedLanguage.isDisplayed();
    }

    public void removeLanguage(){
        scrollToPage(scrollLanguage);
        btnAddNewLanguage.click();
        btnRemoveLanguage.click();
        btnSaveLanguage.click();
    }
    public boolean isRemoverLanguage(){
        return addedLanguage.isDisplayed();
    }

    public void addNewPublication(String title){
        btnAddNewPublication.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputTitlePublication));
        inputTitlePublication.sendKeys(title);
        textareaDecription.sendKeys(title + 1);
        btnSavePublication.click();
        wait.until(ExpectedConditions.elementToBeClickable(editAddedNewPublication));
    }

    public boolean isAddedNewPublication(){
        wait.until(ExpectedConditions.elementToBeClickable(editAddedNewPublication));
        editAddedNewPublication.click();
        return removePublication.isDisplayed();
    }

    public void removeAddedNewPublication(){
        wait.until(ExpectedConditions.elementToBeClickable(editAddedNewPublication));
        editAddedNewPublication.click();
        textareaDecription.click();
        removePublication.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmationRemove));
        confirmationRemove.click();
    }

    public boolean isRemoveNewPublication(){
        return editAddedNewPublication.isDisplayed();
    }

    public void addFollowing(String name){
        scrollToPage(scrollFollowingContainer);
        buttonDiscoverMore.click();
        scrollToPage(scrollDiscoverMore);
        buttonFollow = driver.findElement(By.xpath("//span[text() = '"+ name +"']"));
        buttonFollow.click();
        waitForPageLoaded(driver);
        buttonFollow.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonFollowInPage));
        buttonFollowInPage.click();
    }

    public boolean isAddedFollowing(String name){
        scrollToPage(scrollFollowingContainer);
        strongName = driver.findElement(By.xpath("//strong[text() = '"+ name +"']"));
        return strongName.isDisplayed();
    }

    public void unfollowing(){
        scrollToPage(scrollFollowingContainer);
        wait.until(ExpectedConditions.elementToBeClickable(buttonUnfollowing));
        buttonUnfollowing.click();
    }
    public boolean removeFollowing(String name){
        scrollToPage(scrollFollowingContainer);
        buttonDiscoverMore.click();
        scrollToPage(scrollDiscoverMore);
        buttonFollow = driver.findElement(By.xpath("//span[text() = '"+ name +"']"));
        buttonFollow.click();
        waitForPageLoaded(driver);
        buttonFollow.click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonFollowInPage));
        return buttonFollowInPage.isEnabled();
    }
}

