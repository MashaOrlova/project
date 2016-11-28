
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;


public class AutoTest {
    public static final String PRODUCT_NAME = "iphone";
    private Steps steps;
    private final Logger logger = LogManager.getRootLogger();
    private static final String USERNAME = "Maria";
    private static final String EMAIL = "maria-orlova95@mail.ru";
    private static final String PASSWORD = "BOB123456";

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
    public void oneCanLogOutLinkedin(){
        steps.logInLinkedin(EMAIL, PASSWORD);
        steps.logOutLinkedin();
        Assert.assertTrue(steps.isLoggedOut());
    }

    @Test
    public void searchProduct(){
        steps.searchProduct (PRODUCT_NAME);
        Assert.assertTrue(steps.findProduct(PRODUCT_NAME));
    }


    @After
    public void stopBrowser() {
        steps.closeDriver();
        logger.info("Stop browser");
    }
}
