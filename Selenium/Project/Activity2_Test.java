package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(7000);
    }

    @Test
    public void activityTwoTestCase() throws InterruptedException {
        WebElement attribute=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        System.out.println("Img URL is: " + attribute.getAttribute("src"));
        Thread.sleep(5000);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

