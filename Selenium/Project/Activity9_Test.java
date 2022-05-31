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

public class Activity9_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(5000);
    }

    @Test
    public void activityNineTestCase() throws InterruptedException {

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]")).click();

        WebElement table = driver.findElement(By.xpath("//table[@id='emgcontact_list']"));
        List< WebElement > rows_table = table.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        for (int row = 0; row < rows_count; row++) {
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            int columns_count = Columns_row.size();
            for (int column = 0; column < columns_count; column++) {
                String celtext = Columns_row.get(column).getText();
                System.out.print(celtext+"  ");
            }
            System.out.println();
        }
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

