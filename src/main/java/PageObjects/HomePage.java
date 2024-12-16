package PageObjects;

import Base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import org.openqa.selenium.By;

import java.security.PublicKey;

public class HomePage extends BaseTest {

    private AppiumDriver driver;

    private By text2 = By.id("com.miui.calculator:id/digit_2");

    private By text9 = By.id("com.miui.calculator:id/digit_9");

    private By sumButton = By .id("com.miui.calculator:id/op_add");

    private By equalsButton = By.id("com.miui.calculator:id/btn_equal_s");

    private By outputvalue = By.id("com.miui.calculator:id/result");

    private By HomeProductsSelect =By.xpath("(//andriod.widget.TextView[text()='ADD TO CART'])[1]");

    private By HomeProductsSelect2 =By.xpath("(//andriod.widget.TextView[text()='ADD TO CART'])[2]");

    public HomePage(AppiumDriver driver)
    {

       this.driver=getDriver();
    }


    public void verifyUserin_HomePage()
    {
       if(driver!=null)
       {
           System.out.println("Successfully app launched");
       }
    }
    public void clickvalue_sum(String a, String b)
    {
        driver.findElement(text2).click();
        driver.findElement(sumButton).click();
        driver.findElement(text9).click();

    }

    public void clickequals()
    {
        driver.findElement(equalsButton).click();
    }

    public void Checkoutput(String c)
    {
        String output =driver.findElement(outputvalue).getText();

        String[] arr=  output.split(" ");
        System.out.println(arr[1]);
        Assert.assertArrayEquals(arr[1].getBytes(), c.getBytes());

    }

    public void selectProducts(){
        try {
            driver.findElement(HomeProductsSelect).click();
            driver.findElement(HomeProductsSelect2).click();
            System.out.println("Product successfully selected");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

}
