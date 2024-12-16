package StepDefinitions;

import Base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

public class HomePage extends BaseTest {


    private AppiumDriver driver;
    private PageObjects.HomePage homePage;
    public HomePage() {
        System.out.println("Initializing LoginSteps..");
        setup();
        homePage = new PageObjects.HomePage(driver);

    }

    @Then("user able to select products in Homepage")
    public void selectProducts(){
        homePage.selectProducts();

    }

}
