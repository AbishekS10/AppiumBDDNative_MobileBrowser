package PageObjects;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    private AppiumDriver driver;

    private By loginNamefield = By.id("com.androidsample.generalstore:id/nameField");

    private By loginGenderButtonFemale = By.id("com.androidsample.generalstore:id/radioFemale");

    private By loginCountryclick = By.id("android:id/text1");
    private By loginCountrySelect = By.xpath("//android.widget.TextView[@text='India']");

    private By loginLetShopButton= By.id("com.androidsample.generalstore:id/btnLetsShop");

    private By homeCheck = By.id("com.androidsample.generalstore:id/toolbar_title");


    public LoginPage(AppiumDriver driver)
    {

        this.driver=getDriver();
    }


    public void verifyUserin_LoginPage()
    {
        if(driver!=null)
        {
            System.out.println("Successfully app launched user in login page");
        }
    }

    public void enterNameLogin(){
        driver.findElement(loginNamefield).sendKeys("Ben10");

    }

    public void checkGenderbox(){
        driver.executeScript("mobile: hideKeyboard");
        driver.findElement(loginGenderButtonFemale).click();
    }

    public void selectCountry(){
        driver.findElement(loginCountryclick).click();
        driver.findElement (AppiumBy.androidUIAutomator ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        driver.findElement(loginCountrySelect).click();
    }

    public void checkloginButton(){
        driver.findElement(loginLetShopButton).click();
    }

    public void HomepageCheck(){

        Boolean element = driver.findElement(homeCheck).isDisplayed();
        if(element)
            System.out.println("Successfully logged in");

    }

    public void checkLoginwithoutnameerror(){
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast) [1]")).getAttribute("name");
        System.out.println(toastMessage);
        Assert.assertEquals(toastMessage, "Please enter your name");
    }


}
