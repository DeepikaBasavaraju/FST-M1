package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(7000);
    }

    @Test
    public void activityFourTestCase() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
        driver.findElement(By.xpath("//input[@name='btnAdd']")).click();

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("deepika");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("b");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).sendKeys("deepika b");
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        Thread.sleep(7000);

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

