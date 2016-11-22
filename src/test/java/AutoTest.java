
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
    public static final String NAMEFOLLOWING = "Bill Gates";
    private Steps steps;
    private final Logger logger = LogManager.getRootLogger();
    public static final String USERNAME = "Pavel Zhavoronok";
    private static final String EMAIL = "pahazavoronok@gmail.com";
    private static final String PASSWORD = "2015320Paha";

    public enum Proficiency{ELEMENTARY(1), LIMITED_WORKING(2), PROFESSIONAL_WORCING(3), FULL_PROFESSIONAL(4), NATIVE_OR_BILINGUAL(5);
        private int indexProficiency;
        Proficiency(int indexProficiency) {
            this.indexProficiency = indexProficiency;
        }
        public int getIndex() {
            return this.indexProficiency;
        }
    }
    public enum Language{ENGLISH(5), RUSSIAN(18);
        private int indexLanguage;
        Language(int indexLanguage) {
            this.indexLanguage = indexLanguage;
        }
        public int getIndex() {
            return this.indexLanguage;
        }
    }
    public enum Image {IMG12("\\img\\12.jpg"),IMG123("\\img\\123.jpg"), IMG1234("\\img\\1234.jpg"), IMG12345("\\img\\12345.jpg");
        private String imagePath;
        Image(String imagePath) {
            this.imagePath = imagePath;
        }
        public String getImagePath() {
            return this.imagePath;
        }
    }

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
        steps.loadingImage(Image.IMG123.getImagePath());
        steps.deleteImage();
        Assert.assertFalse(steps.visibleUploadFile());
    }

    @Test
    public void loadingImageToProfie(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.loadingImage(Image.IMG12345.getImagePath());
        Assert.assertTrue(steps.isAddedImage());
        steps.deleteImage();
    }

    @Test
    public void addLanguageLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addLanguage(LANGUAGE, Proficiency.PROFESSIONAL_WORCING.getIndex());
        Assert.assertTrue(steps.isAddedLanguage());
        steps.removeLanguage();
    }

    @Test
    public void removeLanguageLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addLanguage(LANGUAGE,Proficiency.PROFESSIONAL_WORCING.getIndex());
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
        steps.setLanguageRussian(Language.RUSSIAN.getIndex());
        Assert.assertTrue(steps.languageChange(RUSSIAN_LANGUAGE));
        steps.setLanguageEnglish(Language.ENGLISH.getIndex());
    }

    @Test
    public void searchForPeople(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.searchForPeople(NAME);
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
    public void unfollowingLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addNewFollowing(NAMEFOLLOWING);
        steps.unfollowing();
        Assert.assertTrue(steps.removeFollowing(NAMEFOLLOWING));
    }

    @Test
    public void addNewFollowingLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.addNewFollowing(NAMEFOLLOWING);
        Assert.assertTrue(steps.isAddedFollowing(NAMEFOLLOWING));
        steps.unfollowing();
    }


    @After
    public void stopBrowser() {
        steps.closeDriver();
        logger.info("Stop browser");
    }
}
