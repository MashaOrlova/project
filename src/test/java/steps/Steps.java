package steps;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import driver.WDriver;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SettingPage;

public class Steps {
    public static final String URL = "https://www.linkedin.com";
    private String PAGE_URL = "https://www.linkedin.com/profile/edit";
    public static final String PAGE_NEW_POST = "https://www.linkedin.com/post/new/en";
    private static final String LANGUAGE_URL = "https://www.linkedin.com/psettings/select-language";
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
        return loginPage.isLogIn().equals(name);
    }

    public boolean isLoggedOut(String string){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.isLogOut().equals(string);
    }

    public void searchName(String firstname, String lastname){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(URL);
        loginPage.searchName(firstname, lastname);
    }

    public boolean nameSearch(String firstname, String lastname){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.foundTheName().equals(firstname + " " + lastname);
    }

    public void loadingImage(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(PAGE_URL);
        homePage.clickToButtonChooseImmage();
        homePage.clickChooseImage();
    }

    public boolean isAddedImage(){
        HomePage homePage = new HomePage(driver);
        return homePage.isAddedImage();
    }

    public void deleteImage(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(PAGE_URL);
        homePage.deleteImage();
    }

    public boolean visibleUploadFile(){
        HomePage homePage = new HomePage(driver);
        return homePage.isVisibleUploadFile();
    }

    public void addLanguage(String language, int indexProficiency){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        profilePage.addNewLanguage(language, indexProficiency);
    }

    public boolean isAddedLanguage(){
        ProfilePage profilePage = new ProfilePage(driver);
        return profilePage.isAddedLanguage();
    }

    public void removeLanguage(){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        profilePage.removeLanguage();
    }

    public boolean isRemovedLanguage(){
        ProfilePage profilePage = new ProfilePage(driver);
        return profilePage.isRemoverLanguage();
    }

    public void addPublication(String title){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        profilePage.addNewPublication(title);
    }

    public boolean isAddedPublication(){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        return profilePage.isAddedNewPublication();
    }

    public void removePublication(){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        profilePage.removeAddedNewPublication();
    }

    public boolean isRemovedPublication(){
        ProfilePage profilePage = new ProfilePage(driver);
        return profilePage.isRemoveNewPublication();
    }

    public void setLanguageRussian(int indexLanguageRussian){
        SettingPage settingPage = new SettingPage(driver);
        settingPage.openPage(LANGUAGE_URL);
        settingPage.setLanguageRussain(indexLanguageRussian);
    }

    public boolean languageChange(String language){
        SettingPage settingPage = new SettingPage(driver);
        return  settingPage.languageInChanged().equals(language);
    }

    public void setLanguageEnglish(int indexLanguageEnglish){
        SettingPage settingPage = new SettingPage(driver);
        settingPage.openPage(LANGUAGE_URL);
        settingPage.setLanguageEnglish(indexLanguageEnglish);
    }

    public void searchForPeaple(String name){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(PAGE_URL);
        homePage.searchForPeople(name);
    }

    public boolean foundPeople(String name){
        HomePage homePage = new HomePage(driver);
        return homePage.foundPeople().equals(name);
    }

    public void addNewPost(String message, String headline){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(PAGE_URL);
        homePage.openPage(PAGE_NEW_POST);
        homePage.writeAnArticle(message, headline);
    }

    public boolean isAddedNewPost(String postName){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(PAGE_URL);
        return homePage.addedNewPost().equals(postName);
    }

    public void removeNewPost(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(PAGE_URL);
        homePage.removeNewPost();
    }

    public boolean isRemovedNewPost(){
        HomePage homePage = new HomePage(driver);
        return homePage.deletedNewPost();
    }

    public void addNewFollower(){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        profilePage.addFollower();
    }

    public boolean isAddedFollower(){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        return profilePage.isAddedFollower();
    }

    public void unfollowing(){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        profilePage.unfollowing();
    }

    public boolean removeFollower(){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage(PAGE_URL);
        return profilePage.removeFollower();
    }
}
