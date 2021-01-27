package core.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class waits {

    private WebDriver driver;

    public waits(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void ForElement(WebElement element) {
        int waitTime = 15;
        final WebDriverWait wait = new WebDriverWait(driver, waitTime);
        try {
            wait.until(visibilityOf(element));
        } catch (Exception e){
            System.out.println("Wait time was superior of " + waitTime);
        }
    }
    }