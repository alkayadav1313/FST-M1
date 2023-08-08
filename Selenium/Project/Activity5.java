package SeleniumLMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity5 {

    public static void main(String[]args)
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();

        String title=driver.getTitle();

        System.out.println(title);

        Assert.assertEquals("My Account – Alchemy LMS",title);

        driver.close();


    }
}
