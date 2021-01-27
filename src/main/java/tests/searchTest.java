package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class searchTest extends  baseTest{

    @Test(description = "Search for an Item, Successful Test Case")
    @Parameters({"searchValue"})
    public void searchForItemTest( String searchValue){
        homePage.GetAndTypeInSearchBox(searchValue);
        homePage.ClickOnSearchButton();
        Assert.assertTrue(homePage.GetProductCount());
    }

    @Test(description = "Search for an Item, Unsuccessful Test Case, Not Result were found")
    @Parameters({"wrongSearchValue"})
    public void unsuccessfulSearchForItemTest( String searchValue){
        homePage.GetAndTypeInSearchBox(searchValue);
        homePage.ClickOnSearchButton();
        Assert.assertTrue(homePage.CheckIfNotResultsWereFound());
    }
}
