package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(7000);
    }

    @Test
    public void activitySevenTestCase() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
        driver.findElement(By.xpath("//ul[@id='sidenav']/li[9]/a[1]")).click();
        driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
        driver.findElement(By.xpath("//input[@id='experience_employer']")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@id='experience_jobtitle']")).sendKeys("Test Specialist");
        driver.findElement(By.xpath("//input[@id='btnWorkExpSave']")).click();
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

