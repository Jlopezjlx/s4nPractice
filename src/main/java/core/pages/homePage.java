package core.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import core.utils.waits;

public class homePage extends core.pages.page{
    private WebDriver driver;
    private String searchValue;
    private waits waits;
    private final String itemToAdd = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line";
    private final String cartButton ="#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a";
    private final String AddToCart = "add_to_cart";
    private final String ItemSuccessfullyAdded = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2";
    private final String CloseItemDialog = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span";
    private final String SearchInput = "search_query_top";
    private final String SearchButtonName = "submit_search";
    private final String ProductCount = "div.product-count";
    private final String OurStoresButton = "#block_various_links_footer > ul > li:nth-child(4) > a";
    private final String Map = "map";
    private final String NotResultAlert = "#center_column > p";


    public homePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waits = new waits(driver);

    }

    public void GetToCart(){
        waits.ForElement(driver.findElement(By.cssSelector(cartButton)));
        driver.findElement(By.cssSelector(cartButton)).click();

    }

    public void CloseItemDialog(){
        waits.ForElement(driver.findElement(By.cssSelector(CloseItemDialog)));
        driver.findElement(By.cssSelector(CloseItemDialog)).click();

    }

    public boolean GetItemSuccessfully(){
        waits.ForElement(driver.findElement(By.cssSelector(ItemSuccessfullyAdded)));
        if (driver.findElement(By.cssSelector(ItemSuccessfullyAdded)).getText().contains("Product successfully")){
            return true;
        }else {
            return false;
        }
    }

    public boolean GetProductCount(){
        waits.ForElement(driver.findElement(By.cssSelector(ProductCount)));
        if (driver.findElement(By.cssSelector(ProductCount)).getText().contains("Showing")){
            return true;
        }else {
            return false;
        }
    }

    public boolean CheckIfNotResultsWereFound(){
        waits.ForElement(driver.findElement(By.cssSelector(NotResultAlert)));
        if (driver.findElement(By.cssSelector(NotResultAlert)).getText().contains("No results were")){
            return true;
        }else {
            return false;
        }
    }

    public void GetAndTypeInSearchBox(String searchValue){
        waits.ForElement(driver.findElement(By.id(SearchInput)));
        driver.findElement(By.id(SearchInput)).sendKeys(searchValue);
    }

    public void ClickOnSearchButton(){
        waits.ForElement(driver.findElement(By.name(SearchButtonName)));
        driver.findElement(By.name(SearchButtonName)).click();
    }

    public void GetToItemPageAndAddItToCart(){
        waits = new waits(driver);
        driver.findElement(By.cssSelector(itemToAdd)).click();
        driver.findElement(By.id(AddToCart)).click();
    }

    public void ScrollDownAndClickOnOurStores(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.cssSelector(OurStoresButton));
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
    }

    public boolean CheckIfMapIsAvailable(){
        waits.ForElement(driver.findElement(By.id(Map)));
        return driver.findElement(By.id(Map)).isDisplayed();
    }

}
