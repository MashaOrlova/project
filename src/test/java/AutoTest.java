
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;


public class AutoTest {
    public static final String STRING = "You have signed out";
    public static final String LANGUAGE = "Ukrainian";
    public static final String TITLE = "New Publication";
    public static final String FIRSTNAME = "Pavel";
    public static final String LASTNAME = "Zhavoronok";
    public static final String RUSSIAN_LANGUAGE = "Язык";
    public static final String NAME = "Иван Капелько";
    private Steps steps;
    private final Logger logger = LogManager.getRootLogger();
    public static final String USERNAME = "Pavel Zhavoronok";
    private static final String EMAIL = "pahazavoronok@gmail.com";
    private static final String PASSWORD = "2015320Paha";

    @Before
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
        logger.info("Browser init");
    }


    @Test
    public void oneCanLoginLinkedin() {
        steps.logInLinkedin(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test
    public void addPublicationLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addPublication(TITLE);
        Assert.assertTrue(steps.isAddedPublication());
        steps.removePublication();
    }

    @Test
    public void removePublicationLinkedin(){
        steps.logInLinkedin(EMAIL,PASSWORD);
        steps.addPublication(TITLE);
        steps.removePublication();
        Assert.assertFalse(steps.isRemovedPublication());
    }

    @Test
    public void searchNameLinkedin(){
        steps.searchName(FIRSTNAME, LASTNAME);
        Assert.assertTrue(steps.nameSearch(FIRSTNAME, LASTNAME));
    }


    @Test
    public void removeProfilePictures(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.loadingImage();
        steps.deleteImage();
        Assert.assertFalse(steps.visibleUploadFile());
    }

    @Test
    public void loadingImageToProfie(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.loadingImage();
        Assert.assertTrue(steps.isAddedImage());
        steps.deleteImage();
    }

    @Test
    public void addLanguageLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addLanguage(LANGUAGE,3);
        Assert.assertTrue(steps.isAddedLanguage());
        steps.removeLanguage();
    }

    @Test
    public void removeLanguageLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addLanguage(LANGUAGE,3);
        steps.removeLanguage();
        Assert.assertFalse(steps.isRemovedLanguage());
    }

    @Test
    public void oneCanLogOutLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.logOutLinkedin();
        Assert.assertTrue(steps.isLoggedOut(STRING));
    }

    @Test
    public void languageChangeInRussian(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.setLanguageRussian(18);
        Assert.assertTrue(steps.languageChange(RUSSIAN_LANGUAGE));
        steps.setLanguageEnglish(5);
    }

    @Test
    public void searchForPeople(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.searchForPeaple(NAME);
        Assert.assertTrue(steps.foundPeople(NAME));
    }

    @Test
    public void addNewPostLinkedIn(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addNewPost(TITLE + TITLE, TITLE);
        Assert.assertTrue(steps.isAddedNewPost(TITLE));
        steps.removeNewPost();
    }

   @Test
   public void removeNewPostLinkedin(){
       steps.logInLinkedin(EMAIL, PASSWORD);
       steps.addNewPost(TITLE + TITLE, TITLE);
       steps.removeNewPost();
       Assert.assertTrue(steps.isRemovedNewPost());
   }

    @Test
    public void addNewFollowerLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addNewFollower();
        Assert.assertTrue(steps.isAddedFollower());
        steps.unfollowing();
    }

    @Test
    public void unfollowingLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addNewFollower();
        steps.unfollowing();
        Assert.assertTrue(steps.removeFollower());
    }

    @After
    public void stopBrowser() {
        steps.closeDriver();
    }
}
