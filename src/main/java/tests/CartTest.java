package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class CartTest extends baseTest{
    @Test(description = "Add to item to cart")
    public void addItemToCartTest(){
        homePage.GetToItemPageAndAddItToCart();
        Assert.assertTrue(homePage.GetItemSuccessfully());
    }

    @Test(description = "Delete item from cart")
    public void deleteItemFromCartTest(){
        homePage.GetToItemPageAndAddItToCart();
        homePage.CloseItemDialog();
        homePage.GetToCart();
        cartPage.DeleteItemFromCart();
        Assert.assertTrue(cartPage.GetEmptyCartDialog());
    }

    @Test(description = "Check Store Information")
    public void searchStoresInfo(){
        homePage.ScrollDownAndClickOnOurStores();
        Assert.assertTrue(homePage.CheckIfMapIsAvailable());
    }
}