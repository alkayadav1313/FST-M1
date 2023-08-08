package SeleniumLMS;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
    public void setUp1()
    {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver= new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms");

        System.out.println("launched browser and opened the URL successfully");

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


    @Test(priority = 3)
    public void verifyLoginMessage()
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


    @Test(priority = 0)
    public void myAccountVerify()
    {
        driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();

        String title=driver.getTitle();

        System.out.println(title);

        Assert.assertEquals("My Account – Alchemy LMS",title);

        System.out.println("My account title is verified successfully ");

    }

    @Test(priority = 2)
    public void loginWithCredentials()
    {
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");

        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");

        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

        System.out.println("Entered Credentials successfully ");
    }


    @AfterClass
    public void closeBrowser1()
    {
        driver.close();

        System.out.println("Browser closed successfully");
    }



}
