package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 10);
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//a[text() = 'Войти']")
    private  WebElement linkLogin;

    @FindBy(xpath = "//div/form/div[@id='login-content']/dl/dd/div/input[@name = 'loginId']")
    private WebElement inputEmail;

    @FindBy(id = "fm-login-password")
    private WebElement inputPassword;

    @FindBy(id = "fm-login-submit")
    private WebElement buttonSubmit;

    private WebElement linkLoggedInUser;

    @FindBy(xpath = "//a[text()='Выйти']")
    private WebElement linkLogOutInUser;

    @FindBy(xpath = ".//*[@id='nav-user-account']/div[1]")
    private WebElement buttonMove;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
        logger.info("Login page opened");
    }

    public void logIn(String email, String password) {
        linkLogin.click();
        waitForPageLoaded(driver);
        inputEmail.click();
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
    }

    public String isLogIn(String username){
        linkLoggedInUser = driver.findElement(By.xpath("//b[text()='"+username+"']"));
        return  linkLoggedInUser.getText();
    }

    public void logOut(){
        buttonMove.click();
        logger.debug("Enter button logout");
        wait.until(ExpectedConditions.elementToBeClickable(linkLogOutInUser));
        linkLogOutInUser.click();
        logger.info("Logout performed");
    }

    public boolean isLogOut(){
        return linkLogin.isDisplayed();
    }

}
