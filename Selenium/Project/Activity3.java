package SeleniumLMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity3 {

    public static void main(String[]args)
    {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms");

        String firstIfoBox = driver.findElement(By.xpath("//*[contains(text(),' Actionable Training ')]")).getText();

        System.out.println(firstIfoBox);

        Assert.assertEquals("Actionable Training",firstIfoBox);

        if(firstIfoBox.contains("Actionable Training"))
        {
            driver.close();
        }
        else
        {
            System.out.println("Landed of wrong page");

        }

    }
}
