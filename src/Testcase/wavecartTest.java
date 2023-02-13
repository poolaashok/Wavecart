package Testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class wavecartTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp()  {
        System.setProperty("Webdriver.chrome.driver", "G:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        implicitlyWait(20);
        driver.get("https://www.wavemakeronline.com/run-0dnqs4vt0q/WaveKart_master/#/Main");
    }

    //@dropdown
    public void dropdown1(String index, String value)  {
        Select dropdown1 = new Select(driver.findElement(By.xpath(String.format("//select[@aria-expanded='false']"))));
        dropdown1.selectByVisibleText(value);
    }


    @Test
    public void product() throws InterruptedException {
        verify("https://www.wavemakeronline.com/run-0dnqs4vt0q/WaveKart_master/#/Main");
       WaveClick("(//label[text()='Moto G (Black, with 8 GB)'])");
       //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[text()='Moto G (Black, with 8 GB)'])")));
        WaveClick("//button[@class='btn app-button btn-warning']");
        explicitlyWait("//button[@class='btn app-button btn-warning']");
        waveMethodSendKeys("//input[@name='j_username']", "user");
        waveMethodSendKeys2("//input[@name='j_password']", "user");
        WaveClick("//button[@caption='Sign in']");
        dropdown1("0", "3");
        WaveClick("//button[@caption='Place Order']");
        WaveClick("//button[@class='btn app-button btn-primary']");
        WaveClick("//button[@name='nextBtn_wizard_payment']");
        cashOnDelivery("//label[@title='Cash On Delivery(COD)']");
        WaveClick("//button[@class='btn app-button btn-primary']");
        WaveClick("//button[@class='btn app-button btn-success']");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void WaveClick(String Expression) {
        driver.findElement(By.xpath(Expression)).click();
    }

    public void waveMethodSendKeys(String Expression, String user) {
        driver.findElement(By.xpath(Expression)).sendKeys(user);
    }

    public void waveMethodSendKeys2(String Expression, String user) {
        driver.findElement(By.xpath(Expression)).sendKeys(user);
    }

    public WebElement cashOnDelivery(String Expression) {

        return driver.findElement(By.xpath(Expression));
    }

    public void implicitlyWait(int time) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void verify(String Url) {
        String actualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.wavemakeronline.com/run-0dnqs4vt0q/WaveKart_master/#/Main";
        Assert.assertEquals(actualUrl, ExpectedUrl);
        System.out.println(ExpectedUrl);
    }


    public void explicitlyWait(String Expression ) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Expression)));
    }
}


