package Base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static AppiumDriver driver;




    // INITIALINING THE APPIUMDRIVER
    public void setup(){

        if(driver == null){
            try {
               if(ConfigManager.getProperty("platform").equals("Android") && ConfigManager.getProperty("browser").isEmpty())
                {
                    System.out.println("Setting up Appium driver for APP");
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("platformName", ConfigManager.getProperty("platform"));
                    caps.setCapability("deviceName", ConfigManager.getProperty("devicename"));
                    caps.setCapability("app", ConfigManager.getProperty("appPath"));
                    caps.setCapability("automationName", "UIAutomator2");
                   caps.setCapability("noReset", "true");
                    driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    System.out.println("Appium driver initialized successfullly");
                } else if (ConfigManager.getProperty("browser").equals("chorme")) {

                   System.out.println("Setting up Appium driver for Mobile Browser");
                   DesiredCapabilities caps = new DesiredCapabilities();
                   caps.setCapability("platformName", ConfigManager.getProperty("platform"));
                   caps.setCapability("deviceName", ConfigManager.getProperty("devicename"));
                   caps.setCapability("automationName", "UIAutomator2");
                   caps.setCapability("browserName",ConfigManager.getProperty("browser"));
                   caps.setCapability("chromedriverExecutable",ConfigManager.getProperty("WebDriverLocalPath"));
                   

                   driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);
                   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                   System.out.println("Appium driver initialized successfullly");
                   
               }
            }
            catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize appium driver");
            }
        }
    }



    //CLOSING THE APPIUMDRIVER
    public void tearDown()
    {
        System.out.println("Qutting Appium driver..");
        if(driver != null);
        driver.quit();
        System.out.println("Appium driver quit successfully");
    }

    public static AppiumDriver getDriver()
    {
        System.out.println("returning appium driver instance");

        return driver;
    }
}
