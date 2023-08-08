package SeleniumLMS;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @Test(dependsOnMethods = {"setUp"})
    public void openURL()
    {
        driver.get("https://alchemy.hguy.co/lms");
        System.out.println("opening the URL");
    }

    @Test
    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver= new FirefoxDriver();

        System.out.println("Launching the browser");
    }

    @Test(dependsOnMethods = {"openURL"})
    public void verifyHeading()
    {
        String heading =driver.findElement(By.xpath("//*[contains(text(),' Learn from Industry Experts ')]")).getText();
        System.out.println(heading);

        if(heading.contains("Learn from Industry Experts"))
        {
            Assert.assertEquals("Learn from Industry Experts",heading);

            System.out.println("Verify the title");
            driver.close();

            System.out.println("Closing the browser successfully");

        }
        else
        {
            System.out.println("Landed on wrong page");

        }
    }
}
