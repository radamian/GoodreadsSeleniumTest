package goodreads;

import com.gargoylesoftware.htmlunit.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import goodreads.Util;

import static org.junit.Assert.fail;

public class UnitTest {
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        baseUrl = "https://www.goodreads.com/";
        Util.driver.manage().window().maximize();
        Util.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Setup");
    }

    @After
    public void tearDown() throws Exception {
        Util.driver.quit();
        System.out.println("End");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void Test() {
        System.out.println("Start test");
        Pages.landingpage().testGoodreads();

        Pages.landingpage().login("raluca.damian@endava.com", "Fast1234");
        Pages.landingpage().search("Patrick Modiano");
        Pages.landingpage().comment("Nice one!");


    }


}
