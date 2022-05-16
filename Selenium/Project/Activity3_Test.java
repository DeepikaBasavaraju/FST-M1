package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class Activity3_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(7000);
    }

    @Test
    public void activityThreeTestCase() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(7000);
        String title = driver.getTitle();
        System.out.println("Verify homepage opened or not by fetching title is: " + title);
        Assert.assertEquals("OrangeHRM", title);

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

