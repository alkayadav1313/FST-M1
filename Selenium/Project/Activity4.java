package SeleniumLMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity4 {
    public static void main(String[]args)
    {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms");

        String secondCourse = driver.findElement(By.xpath("//*[contains(text(),'Email Marketing Strategies')]")).getText();

        System.out.println(secondCourse);

        Assert.assertEquals("Email Marketing Strategies",secondCourse);

        if(secondCourse.contains("Email Marketing Strategies"))
        {
            driver.close();
        }

        else
        {
            System.out.println("Landed of wrong course");

        }
    }
}
