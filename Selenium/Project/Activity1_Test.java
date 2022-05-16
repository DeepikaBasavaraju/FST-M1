package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(5000);
    }
    @Test
    public void activityOneTestCase() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("OrangeHRM", title);
        Thread.sleep(5000);
    }
    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

