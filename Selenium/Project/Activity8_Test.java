package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Activity8_Test {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new FirefoxDriver();
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(5000);
    }

    @Test
    public void activityEightTestCase() throws InterruptedException {

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(10000);
        driver.findElement(By.linkText("Apply Leave")).click();
        Select dropdownLeave = new Select(driver.findElement(By.cssSelector("#applyleave_txtLeaveType")));
        dropdownLeave.selectByVisibleText("DayOff");
        driver.findElement(By.xpath("//form[@id=\"frmLeaveApply\"]//li[3]/img")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui-datepicker-calendar']")));
        driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//tr[4]/td[1]")).click();
        driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
        driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();
        driver.findElement(By.cssSelector("input[id *= '_allcheck']")).click();
        driver.findElement(By.cssSelector("input[id *= 'chkSearchFilter_1']")).click();
        driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(6) > a")));
        WebElement approvalStatus = driver.findElement(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(6) > a"));
        System.out.println(approvalStatus.getText());
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

