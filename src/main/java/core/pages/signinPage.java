package core.pages;


import org.openqa.selenium.*;
import core.utils.elementsUtils;
import core.utils.waits;

public class signinPage extends page{
    private WebDriver driver;
    private String searchValue;
    private waits waits;
    private elementsUtils elements_utils;
    private final By name = By.name("firstname");
    private final By lastName = By.name("lastname");
    private final By email = By.name("email");
    private final By password = By.name("password");
    private final By birthday = By.name("birthdate");
    private final By createButton = By.cssSelector("button.btn.btn-default");


    public signinPage(WebDriver driver) {
        this.driver = driver;
        waits = new waits(driver);
        elements_utils = elementsUtils.getInstance();

    }

    public void TypeFirstName( String first_name) throws Exception {
        waits.ForElement(driver.findElement(name));
        WebElement firstName = elements_utils.findElement("name", name, driver);
        elements_utils.sendKeys(firstName, first_name);
        firstName.sendKeys(Keys.RETURN);
    }

    public void TypeLastname( String last_name) throws Exception {
        waits.ForElement(driver.findElement(lastName));
        WebElement LastName = elements_utils.findElement("name", lastName, driver);
        elements_utils.sendKeys(LastName, last_name);
    }

    public void TypeEmail( String email_) throws Exception {
        waits.ForElement(driver.findElement(email));
        WebElement LastName = elements_utils.findElement("name", email, driver);
        elements_utils.sendKeys(LastName, email_);
    }

    public void TypePassword( String pass) throws Exception {
        waits.ForElement(driver.findElement(password));
        WebElement LastName = elements_utils.findElement("name", password, driver);
        elements_utils.sendKeys(LastName, pass);
    }

    public void TypeBirthday( String birthday_) throws Exception {
        waits.ForElement(driver.findElement(birthday));
        WebElement LastName = elements_utils.findElement("name", birthday, driver);
        elements_utils.sendKeys(LastName, birthday_);
    }

    public void SelectGender( String gender) throws Exception {
        switch(gender) {
            case "man":
            case "woman":
                elements_utils.findElement("name", By.name(gender), driver).click();
                break;
        }
    }

    public void ClickOnCreate() throws  Exception{
        WebElement button = elements_utils.findElement("xpath", By.xpath("//button[text()='Crear cuenta']"), driver);
        elements_utils.clickElement(button);
    }


    public String validateAlertOnCreation(){

        Alert alert = driver.switchTo().alert();
        String alert_message = alert.getText();
        alert.accept();
        return alert_message;
    }

}
