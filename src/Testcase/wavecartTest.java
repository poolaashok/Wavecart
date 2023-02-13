package Testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaveCartTest {
    WebDriver driver;

    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("Webdriver.chrome.driver", "G:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        implicitlyWait();
        driver.get("https://www.wavemakeronline.com/run-0dnqs4vt0q/WaveKart_master/#/Main");
    }

    //@dropdown
    public void dropDown1(String value) {
        Select dropdown1 = new Select(driver.findElement(By.xpath(String.format("//select[@aria-expanded='false']"))));
        dropdown1.selectByVisibleText(value);
    }


    @Test
    public void product() {
        verify("https://www.wavemakeronline.com/run-0dnqs4vt0q/WaveKart_master/#/Main");
        waveClick(By.xpath("(//label[text()='Moto G (Black, with 8 GB)'])"));
        waveClick(By.xpath("//button[@class='btn app-button btn-warning']"));
        waveMethodSendKeys(By.xpath("//input[@name='j_username']"), "user");
        waveMethodSendKeys(By.xpath("//input[@name='j_password']"), "user");
        waveClick(By.xpath("//button[@caption='Sign in']"));
        dropDown1("3");
        waveClick(By.xpath("//button[@caption='Place Order']"));
        waveClick(By.xpath("//button[@class='btn app-button btn-primary']"));
        waveClick(By.xpath("//button[@name='nextBtn_wizard_payment']"));
        cashOnDelivery(By.xpath("//label[@title='Cash On Delivery(COD)']"));
        waveClick(By.xpath("//button[@class='btn app-button btn-primary']"));
        waveClick(By.xpath("//button[@class='btn app-button btn-success']"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void waveClick(By locator) {
        driver.findElement(locator).click();
    }

    public void waveMethodSendKeys(By Expression, String user) {
        driver.findElement(Expression).sendKeys(user);
    }

    public WebElement cashOnDelivery(By Expression) {

        return driver.findElement(Expression);
    }

    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void verify(String Url) {
        String actualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.wavemakeronline.com/run-0dnqs4vt0q/WaveKart_master/#/Main";
        Assert.assertEquals(actualUrl, ExpectedUrl);
        System.out.println(ExpectedUrl);
    }
}


