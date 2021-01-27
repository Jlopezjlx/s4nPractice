package core.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.utils.waits;

public class cartPage extends core.pages.page{
    private WebDriver driver;
    private waits waits;
    private final String DeleteItemFromCart = "#\\31 _1_0_0 > i";
    private final String EmptyCartDialog = "#center_column > p";


    public cartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public boolean GetEmptyCartDialog(){
        waits.ForElement(driver.findElement(By.cssSelector(EmptyCartDialog)));
        if (driver.findElement(By.cssSelector(EmptyCartDialog)).getText().contains("cart is empty")){
            return true;
        }else {
            return false;
        }
    }


    public void DeleteItemFromCart(){
        waits = new waits(driver);
        waits.ForElement(driver.findElement(By.cssSelector(DeleteItemFromCart)));
        driver.findElement(By.cssSelector(DeleteItemFromCart)).click();
    }
}
