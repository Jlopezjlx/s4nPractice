package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import core.pages.homePage;
import core.pages.cartPage;

public class baseTest {
    protected static String ChromeDriverPath;
    protected static String FirefoxDriverPath;
    protected static ChromeOptions chromeOptions;
    protected static WebDriver driver;
    homePage homePage;
    cartPage cartPage;

    @BeforeMethod
    @Parameters({"Url", "browser"})
    public void SetUp( String Url, String browser){
        if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxDriverPath = "";
        }
        else if (browser.equalsIgnoreCase("Chrome")) {
            ChromeDriverPath = "src/resources/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            driver.get(Url);
        }
        homePage = new homePage(driver);
        cartPage = new cartPage(driver);
    }

    @AfterMethod
    public void tearDownMain() {
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
        driver.close();
    }
}
