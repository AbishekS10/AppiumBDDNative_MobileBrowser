package PageObjects;

import Base.BaseTest;
import Base.ConfigManager;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BrowserPage extends BaseTest {
    private AppiumDriver driver;

    static String name;


    private By usernameField = By.xpath("//input[@name='username']");

    private By passwordfield = By.xpath("//input[@name='password']");

    private By loginButton = By.xpath("//button[@type='submit']");

    private By Dashborad = By.xpath("//h6[text()='Dashboard']");

    private By loginerror =By.xpath("//p[text()='Invalid credentials']");

    private By adminMenu = By.xpath("//span[text()='Admin']");

    private By addMenu = By.xpath("//button[text()=' Add ']");

    private By addMenuUserRoleArrowbutton = By.xpath("(//div[text()='-- Select --']//following::div/i)[1]");

    private By addMenuUserRoleAdminButton = By.xpath("//div[text()='Admin']");

    private By addMenuStatusArrowbutton = By.xpath("(//div[text()='-- Select --']//following::div/i)[2]");

    private By addMenuStatusEnabledbutton = By.xpath("//div[text()='Enabled']");

    private By addmenuEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");

    private By addMenuUsername =By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

    private By AddMenuPassword = By.xpath("(//input[@type='password'])[1]");

    private By AddMenuPassword2 = By.xpath("(//input[@type='password'])[2]");

    private By AddMenuSaveButton = By.xpath("//button[text()=' Save ']");






    public BrowserPage(AppiumDriver driver)
    {

        this.driver=getDriver();
    }


    public void verifybrowser() {

        try {
            if (driver != null)
                System.out.println("Browser successfully launched");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void launchURL(String url){


        driver.get(url);

    }

    public void enterUsername_Password(String username, String password){

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordfield).sendKeys(password);

    }

    public  void checkLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public void succesloginCheck(){

        boolean element = driver.findElement(Dashborad).isDisplayed();

        if(element)
            System.out.println("Login successfully");
        else
            System.out.println("Unsuccessfully");

    }

    public void invalidLoginerror(){
        boolean element = driver.findElement(loginerror).isDisplayed();

        if (element)
            System.out.println("Unsuccessfully login and error message present");
    }

    public void checkAdminandaddmenu(){

        driver.findElement(adminMenu).click();
        driver.findElement(addMenu).click();
    }

    public void enterMandatoryField(){

        driver.findElement(addMenuUserRoleArrowbutton).click();
        driver.findElement(addMenuUserRoleAdminButton).click();
        driver.findElement(addMenuStatusArrowbutton).click();
        driver.findElement(addMenuStatusEnabledbutton).click();
        driver.findElement(addmenuEmployeeName).sendKeys("peter");
        name = "Ben10";
        driver.findElement(addMenuUsername).sendKeys(name);
        driver.findElement(AddMenuPassword).sendKeys("qwerty12345");
        driver.findElement(AddMenuPassword2).sendKeys("qwerty12345");
    }

    public void checkSaveButton(){

        driver.findElement(AddMenuSaveButton).click();

    }

    public void checkCreatedUserRecord()
    {
        String name1= String.format("//div[text()='%s']",name);
       boolean element = driver.findElement(By.xpath("name1")).isDisplayed();
        Assert.assertTrue(element);
    }


}
