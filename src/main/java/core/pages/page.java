package core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class page {
    public page(final WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }
}