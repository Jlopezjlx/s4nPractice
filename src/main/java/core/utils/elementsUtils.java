package core.utils;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class elementsUtils {
    private Logger log = LogManager.getLogger(elementsUtils.class.getName());
    private static elementsUtils instance = null;

    private elementsUtils() {

    }

    public static elementsUtils getInstance() {
        if (instance == null) {
            return new elementsUtils();
        }
        return instance;
    }

    public WebElement findElement(String findBy, By locator, WebDriver driver) {

        WebElement element = null;
        try {
            log.info("Finding element by " + findBy + "...");
            element = driver.findElement(locator);
            log.info("Element " + locator + " found!");

        } catch (Exception e) {
            log.error("***Element " + locator + " Not Found!!!*** " + "by: " + findBy+"\n");
            log.error(e);
        }
        return element;
    }

    public WebElement findElement(String findBy, By locator, WebElement container) {

        WebElement element = null;
        try {
            log.info("Finding element by " + findBy + "...");
            element = container.findElement(locator);
            log.info("Element " + locator + " found!");

        } catch (Exception e) {
            log.error("***Element " + locator + " Not Found!!!*** " + "by: " + findBy+"\n");
            log.error(e);
        }
        return element;
    }

    public List<WebElement> findElements(String findBy, By locator, WebDriver driver){
        List<WebElement> elements = null;
        try {
            log.info("Finding elements by " + findBy + "...");
            elements = driver.findElements(locator);
            log.info("Element " + locator + " found!");
        } catch (Exception e) {
            log.error("***Elements " + locator + " Not Found!!!*** " + "by: " + findBy);
            log.error(e);
        }

        return elements;
    }

    public List<WebElement> findElements(String findBy, By locator, WebElement container){
        List<WebElement> elements = null;
        try {
            log.info("Finding elements by " + findBy + "...");
            elements = container.findElements(locator);
            log.info("Element " + locator + " found!");
        } catch (Exception e) {
            log.error("***Elements " + locator + " Not Found!!!*** " + "by: " + findBy);
            log.error(e);
        }

        return elements;
    }


    public void clickElement(WebElement element) throws Exception {
        try {
            log.info("Clicking on element: " + element);
            element.click();
        } catch (Exception e) {
            log.error("Element was not clicked because it doesn't exist. Exception message: "+e);
            throw new Exception("Element was not clicked because it doesn't exist", e);
        }
    }


    public void sendKeys(WebElement element, String keysToSend) throws Exception {

        try {
            log.info("Sending String: " + keysToSend + " on WebElement: " + element);
            element.sendKeys(keysToSend);

        } catch (Exception e) {
            log.error(e);
            log.error("No value was typed because element was not found. Exception message: "+e);
            throw new Exception("No value was typed because element was not found",e);
        }

    }

    public void selectOption(WebElement element, String keys, WebDriver driver) {

        try {
            log.info("Sending String: " + keys + " on WebElement: " + element);
            element.click();
            WebElement input = driver.switchTo().activeElement();
            input.sendKeys(keys.replace("_", " "));
            Thread.sleep(500);
            input.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            log.error(e);
            log.error("No value was typed since option doesn't exist on dropdown. Exception message: "+e);

        }
    }
    public void autocompleteOption(WebElement element, String keys, WebDriver driver) {

        try {
            log.info("Sending String: " + keys + " on WebElement: " + element);
            element.click();
            WebElement input = driver.switchTo().activeElement();
            input.sendKeys(keys);
            input.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            log.error(e);
            log.error("No value was typed since option doesn't exist on dropdown. Exception message: "+e);

        }

    }


    public boolean isDisplayed(WebElement element) {
        log.info("Verifying if the element " + element + " is displayed!");
        return element.isDisplayed();
    }

    public boolean isEnable(WebElement element) {
        log.info("Verifying if the element " + element + " is enabled!");
        return element.isEnabled();
    }

    public boolean isEmpty(WebElement element) {
        log.info("Verifying if the element " + element + " is empty!");
        return element.getAttribute("value").isEmpty();
    }

    public boolean isSelected(WebElement element) {
        log.info("Verifying if the element " + element + " is selected!");
        return element.isSelected();
    }


}
