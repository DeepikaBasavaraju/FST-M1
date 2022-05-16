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

import java.util.List;

public class Activity6_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(7000);
    }

    @Test
    public void activitySixTestCase() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(10000);
        boolean eleDisplayed= driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']")).isDisplayed();
        System.out.println("Element displayed is " + eleDisplayed);
        driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']")).click();

        String bodyText = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
        System.out.println(bodyText);
        if (bodyText.contains("Search Directory")){
            System.out.println("Heading matches with the test Search Directory");
        }
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

