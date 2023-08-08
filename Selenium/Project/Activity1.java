package SeleniumLMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Activity1 {

    public static void main(String[]args){
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms");



        String Title = driver.getTitle();
        System.out.println(Title);



        if(Title.contains("Alchemy LMS – An LMS Application"))
        {
            Assert.assertEquals("Alchemy LMS – An LMS Application",Title);
            driver.close();
        }
        else
        {
            System.out.println("Landed on wrong page");

        }


    }

}
