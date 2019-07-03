package goodreads;

import static org.junit.Assert.*;
import org.openqa.selenium.*;



public class LandingPage {
    private StringBuffer verificationErrors = new StringBuffer();


    public void testGoodreads() {
        Util.driver.get("https://www.goodreads.com/");
        try {
            assertEquals("Goodreads | Meet your next favorite book", Util.driver.getTitle());
        } catch (Exception e) {
            verificationErrors.append(e.toString());
        }
    }


    public boolean login(String user, String password) {
        try {
            Util.driver.findElement(By.id("userSignInFormEmail")).click();
            Util.driver.findElement(By.id("userSignInFormEmail")).clear();
            Util.driver.findElement(By.id("userSignInFormEmail")).sendKeys(user);
            Util.driver.findElement(By.id("user_password")).click();
            Util.driver.findElement(By.id("user_password")).sendKeys(password);
            Util.driver.findElement(By.id("sign_in")).submit();
            Util.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/preceding::a[1]")).click();
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public void search(String what) {
        try {
            Util.driver.findElement(By.name("q")).click();
            Util.driver.findElement(By.name("q")).clear();
            Util.driver.findElement(By.name("q")).sendKeys("Patrick Modiano");
            try {
                assertEquals("Rue des boutiques obscures", Util.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Page 1 of about 117 results (0.40 seconds)'])[1]/following::span[1]")).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        } catch (Exception e) {

        }

    }

    public void comment(String mycomment) {
        try {
            Util.driver.findElement(By.name("comment[body_usertext]")).click();
            Util.driver.findElement(By.name("comment[body_usertext]")).clear();
            Util.driver.findElement(By.name("comment[body_usertext]")).sendKeys("Read the book");
            try {
                assertEquals("Read the book", Util.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='R D'])[4]/following::div[2]")).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

        } catch (Exception e) {
        }
    }
}




