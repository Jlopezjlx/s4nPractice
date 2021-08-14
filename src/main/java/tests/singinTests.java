package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class singinTests extends  baseTest{

    @Test(description = "Create an account successfully")
    @Parameters({"firstName", "LastName", "email", "birthday"})
    public void createAccount( String firstName, String LastName, String email, String birthday) throws Exception {
        signinPage.TypeFirstName(firstName);
        signinPage.TypeLastname(LastName);
        signinPage.TypeEmail(email);
        signinPage.TypePassword("ddddddddd343");
        signinPage.TypeBirthday("1997-05-10");
        signinPage.SelectGender("man");
        signinPage.ClickOnCreate();
        Assert.assertTrue(signinPage.validateAlertOnCreation().contains("Bienvenido"));
    }

    @Test(description = "Create an account successfully using woman as gender")
    @Parameters({"firstName", "LastName", "email", "birthday"})
    public void createAccountwithWoman( String firstName, String LastName, String email, String birthday) throws Exception {
        signinPage.TypeFirstName(firstName);
        signinPage.TypeLastname(LastName);
        signinPage.TypeEmail(email);
        signinPage.TypePassword("ddddddddd343");
        signinPage.TypeBirthday("1997-05-10");
        signinPage.SelectGender("woman");
        signinPage.ClickOnCreate();
        Assert.assertTrue(signinPage.validateAlertOnCreation().contains("Bienvenido"));
    }
}
