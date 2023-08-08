package SeleniumLMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms");

        System.out.println("launched browser and opened the URL successfully");

    }
    @Test(priority = 2)
    public void loginWithCredentials1()
    {
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");

        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");

        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

        System.out.println("Entered Credentials successfully ");
    }

    @Test(priority = 0)
    public void myAccountVerify1()
    {
        driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();

        String title=driver.getTitle();

        System.out.println(title);

        Assert.assertEquals("My Account – Alchemy LMS",title);

        System.out.println("My account title is verified successfully ");

    }
    @Test(priority = 3)
    public void verifyLoginMessage1()
    {
        String loginMessage=driver.findElement(By.xpath("//*[@class='uagb-ifb-title']")).getText();

        System.out.println(loginMessage);

        if(loginMessage.contains("My Account"))
        {
            Assert.assertEquals("My Account",loginMessage);
            System.out.println("Logged in successfully");
        }

        else{
            System.out.println("Incorrect username or password. Please try again");
        }

    }

    @Test(priority=4)
    public void verifyTitleAfterClickingCourse() {
        driver.findElement(By.xpath("//span[contains(text(),'Social Media Marketing')]")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Developing Strategy')]")).click();

        String title = driver.getTitle();
        System.out.println(title);


        Assert.assertEquals("Developing Strategy – Alchemy LMS", title);
    }


    @Test(priority = 5)
    public void completeCourse()
    {
        String completeMessage= driver.findElement(By.xpath("//span[contains(text(),'100% Complete')]")).getText();

        System.out.println(completeMessage);

        if(completeMessage.contains("100% COMPLETE"))
        {
            Assert.assertEquals("100% COMPLETE",completeMessage);

        }

        else {
            System.out.println("Course is InProgress");
        }
    }

    @Test(priority = 1)
    public void clickOnLogin()
    {
        WebElement loginButton = driver.findElement(By.xpath("//*[@class='ld-login ld-login ld-login-text ld-login-button ld-button']"));

        Assert.assertTrue(loginButton.isDisplayed());
        System.out.println("login button is displayed");
        loginButton.click();
        System.out.println("Clicked on login successfully");
    }

    @AfterClass
    public void closeBrowser1()
    {
        driver.close();

        System.out.println("Browser closed successfully");
    }


}
