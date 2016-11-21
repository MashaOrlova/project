package pages;

import org.openqa.selenium.Beta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SettingPage extends AbstractPage {

    @FindBy(xpath = ".//*[@id='account-nav']/ul/li[4]/a")
    private WebElement buttonMove;

    @FindBy(xpath = "id('account-sub-nav')//span/a[@class = 'account-submenu-split-link']")
    private WebElement linkChangeLanguage;

    @FindBy(xpath = "//select[@name = 'selectLanguage']")
    private WebElement selectLanguage;

    @FindBy(xpath = "id('setting-select-language')/a/h3")
    private WebElement russianLanguage;



    public SettingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public void setLanguageRussain(int languageRussain){
        selectLanguage.click();
        Select select = new Select(selectLanguage);
        select.selectByIndex(languageRussain);
    }

    public String languageInChanged(){
        return russianLanguage.getText();
    }

    public void setLanguageEnglish(int languageEnglish){
        selectLanguage.click();
        Select select = new Select(selectLanguage);
        select.selectByIndex(languageEnglish);
    }

}
