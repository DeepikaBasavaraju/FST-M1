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

public class Activity5_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(5000);
    }

    @Test
    public void activityFiveTestCase() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys("Dipika");
        driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).sendKeys("Basavaraju");
        driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();

        WebElement dropdownPath= driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        Select dropdown= new Select(dropdownPath);
        dropdown.selectByVisibleText("Indian");

        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

