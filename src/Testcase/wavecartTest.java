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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.beans.Expression;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class WaveCartTest {
    WebDriver driver;

    WebDriverWait wait;
    String button1 = "(//label[text()='Moto G (Black, with 8 GB)'])";
    String button2 = "//button[@caption='ADD TO CART']";
    String userNameInput = "//input[@name='j_username']";
    String passwordInput = "//input[@name='j_password']";
    String signInput = "//button[@caption='Sign in']";
    String image = "//img[@name='picture_CartList']";
    String text = "//label[text()='Moto G (Black, with 8 GB)']";
    String button3 = "//button[@caption='Place Order']";
    String button4 = "//button[@name='nextBtn_wizard_payment']";
    String Address = "//span[text()='Mid Town 6-3-348, Road No. 1, Banjara Hills Icon']";
    String button5 = "//button[@name='nextBtn_wizard_payment']";
    String button6 = "//button[@name='nextBtn_wizard_payment']";
    String Address2 = "//label[text()='Mid Town 6-3-348, Road No. 1, Banjara Hills,Hyderabad,']";
    String button7 = "//button[@name='doneBtn_wizard_payment']";
    String Amount = "//label[@name='lbl_amt']";
    String button8 = "//button[@caption='cancel order']";
    String button9 = "//button[@aria-label='Submit button']";
    String shopping = "//button[@caption='continue shopping']";
    String product = "//label[text()='Nokia Asha 502 (Black)']";
    String product2 = "//label[text()='Samsung Galaxy Grand 2 (White)']";


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
    public void dropDown1(By expression, String value) {
        Select dropdown1;
        dropdown1 = new Select(Select(expression));
        dropdown1.selectByVisibleText(value);
    }

    @Test(dataProvider = "productData")
    public void product(String productData) {
        waveClick(By.xpath(button1));
        waveClick(By.xpath(button2));
        waveMethodSendKeys(By.xpath(userNameInput), "user");
        waveMethodSendKeys(By.xpath(passwordInput), "user");
        waveClick(By.xpath(signInput));
        verifyCartImage(By.xpath(image));
        verifyProDuct(By.xpath(text));
        dropDown1(By.xpath("//select[@aria-expanded='false']"), "2");
        waveClick(By.xpath(button3));
        waveClick(By.xpath(button4));
        verifyAddress(By.xpath(Address));
        waveClick(By.xpath(button5));
        waveClick(By.xpath(button6));
        verifyShippingAddress(By.xpath(Address2));
        waveClick(By.xpath(button7));
        verifyingAmount(By.xpath(Amount));
        waveClick(By.xpath(button8));
        canCleOrder(By.xpath(button9));
        click2(By.xpath(shopping));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void waveClick(By locator) {
        driver.findElement(locator).click();

    }

    public void click2(By Expression) {
        driver.findElement(Expression);
    }

    public void waveMethodSendKeys(By Expression, String user) {
        driver.findElement(Expression).sendKeys(user);
    }

    public WebElement Select(By Expression) {

        return driver.findElement(Expression);
    }

    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void verifyProDuct(By Expression) {
        String ExpectedText = "Moto G (Black, with 8 GB)";
        String actualText = driver.findElement(Expression).getText();
        Assert.assertEquals(actualText, ExpectedText);
        System.out.println(ExpectedText);
    }

    public void verifyAddress(By Expression) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        String actualAddressText = driver.findElement(Expression).getText();
        String ExpectedAddress = "Mid Town 6-3-348, Road No. 1, Banjara Hills Icon";
        Assert.assertEquals(actualAddressText, ExpectedAddress);


    }

    public void verifyShippingAddress(By Expression) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        String actualAddress = driver.findElement(Expression).getText();
        String ExpectedAddress = "Mid Town 6-3-348, Road No. 1, Banjara Hills,Hyderabad,";
        Assert.assertEquals(actualAddress, ExpectedAddress);
    }

    public void verifyingAmount(By Expression) {
        String ExpectedAmount = "195";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        String actualAmount = driver.findElement(Expression).getText();
        Assert.assertEquals(actualAmount, ExpectedAmount);
    }

    public void canCleOrder(By Expression) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        driver.findElement(Expression);
    }

    public void verifyCartImage(By Expression) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        boolean img = driver.findElement(Expression).isDisplayed();
        Assert.assertTrue(img);
    }

    @DataProvider(name = "productData")
    public Object[][] productData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "//label[text()='Nokia Asha 502 (Black)']";
        data[0][1] = "//label[text()='Samsung Galaxy Grand 2 (White)']";
        return data;

    }
}











