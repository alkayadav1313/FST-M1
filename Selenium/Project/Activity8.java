package SeleniumLMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

    WebDriver driver;

    @BeforeClass

    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms");

        System.out.println("URL launch successfully");
    }


    @Test
    public void saveContact() throws InterruptedException {
        driver.findElement(By.xpath("//li[@id='menu-item-1506']")).click();

        driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("Alka Sinha");

        driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']")).sendKeys("alkatest123@gmail.com");

        driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']")).sendKeys("Learning Selenium");

        WebElement submit = driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']"));

        submit.sendKeys("Contact information filled");

        String val = submit.getAttribute("value");

        System.out.println(val);

        driver.findElement(By.xpath("//button[@id='wpforms-submit-8']")).click();

        String confirmMessage = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']")).getText();

        System.out.println(confirmMessage);

    }



    @AfterClass
    public void closeBrowser()
    {
        driver.close();
        System.out.println("Browser closed successfully!");
    }

}
