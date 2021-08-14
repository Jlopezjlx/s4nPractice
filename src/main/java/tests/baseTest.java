package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import  org.testng.annotations.*;
import core.pages.signinPage;

public class baseTest {
    protected static String ChromeDriverPath;
    protected static String FirefoxDriverPath;
    protected static ChromeOptions chromeOptions;
    protected static WebDriver driver;
    signinPage signinPage;

    @BeforeMethod
    @Parameters({"Url", "browser"})
    public void SetUp( String Url, String browser) throws InterruptedException {
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
            Thread.sleep(500);
        }
        signinPage = new signinPage(driver);
    }

    @AfterMethod
    public void tearDownMain() {
        driver.close();
    }
}
