package steps;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import driver.WDriver;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SettingPage;

public class Steps {
    public static final String URL = "https://ru.aliexpress.com/";
    private WebDriver driver;

    public void initBrowser() {
        driver = WDriver.getDriver();
    }

    public void closeDriver() {
       WDriver.closeDriver();
    }

    public void logInLinkedin(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(URL);
        loginPage.logIn(email, password);
    }

    public void logOutLinkedin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOut();
    }

    public boolean isLoggedIn(String name) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.isLogIn(name).equals(name);
    }

    public boolean isLoggedOut(){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.isLogOut();
    }

    public void searchProduct(String productName) {
        HomePage homePage = new HomePage(driver);
        homePage.openPage(URL);
        homePage.searchProduct(productName);
    }

    public boolean findProduct(String productName) {
        HomePage homePage = new HomePage(driver);
        return homePage.findProduct(productName);
    }
}
