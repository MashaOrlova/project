package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 10);
    @FindBy(id = "login-email")
    private WebElement inputEmail;

    @FindBy(id = "login-password")
    private WebElement inputPassword;

    @FindBy(id = "login-submit")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//a[text()='Pavel Zhavoronok']")
    private WebElement linkLoggedInUser;

    @FindBy(xpath = "id('account-sub-nav')//span/a[@class = 'account-submenu-split-link']")
    private WebElement linkLogOutInUser;

    @FindBy(xpath = ".//*[@id='account-nav']/ul/li[4]/a")
    private WebElement buttonMove;

    @FindBy(xpath = "id('page-title')/h1")
    private WebElement signOutTitle;

    @FindBy(xpath = "//div/form/input[@name = 'first']")
    private WebElement inputFirstname;

    @FindBy(xpath = "//div/form/input[@name = 'last']")
    private WebElement inputLastname;

    @FindBy(xpath = "//div/form/input[@name = 'search']")
    private WebElement search;

    @FindBy (id = "name")
    private WebElement getName;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public void logIn(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        waitForPageLoaded(driver);
    }

    public String isLogIn(){
        return  linkLoggedInUser.getText();
    }

    public void logOut(){
        buttonMove.click();
        wait.until(ExpectedConditions.elementToBeClickable(linkLogOutInUser));
        linkLogOutInUser.click();
    }

    public String isLogOut(){
        return signOutTitle.getText();
    }

    public void searchName(String firstname, String lastname){
        inputFirstname.sendKeys(firstname);
        inputLastname.sendKeys(lastname);
        search.click();
        waitForPageLoaded(driver);
    }

    public String foundTheName(){
        wait.until(ExpectedConditions.elementToBeClickable(getName));
        return getName.getText();
    }
}
