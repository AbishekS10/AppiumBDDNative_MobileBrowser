package StepDefinitions;

import Base.BaseTest;
import Base.ConfigManager;
import PageObjects.BrowserPage;
import PageObjects.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrowserPagestep extends BaseTest {

    private AppiumDriver driver;
    private PageObjects.BrowserPage browserPage;

    public BrowserPagestep() {
        System.out.println("Initializing LoginSteps..");
        setup();
        browserPage = new PageObjects.BrowserPage(driver);

    }

    @Given("user to launch egde browser")
    public void user_launch_edge_browser(){
        browserPage.verifybrowser();

    }

    @And("user to open OrangeHR web Application")
    public void launchURL(){
        String URL = ConfigManager.getProperty("URL");
        browserPage.launchURL(URL);

    }

    @When("^User login into application With (.+) and password (.+) and check login$")
    public void user_login_into_application_with_and_password(String string, String string2) {

         browserPage.enterUsername_Password(string,string2);
         browserPage.checkLoginButton();

    }

    @Then("user to validate successfully login")
    public void userSuccessLogin(){
        browserPage.succesloginCheck();

    }

    @Then("user to validate error")
    public void userValidateError()
    {
        browserPage.invalidLoginerror();

    }

    @And("User to check admin menu and add menu")
    public void checkAdminandAddMenu(){

        browserPage.checkAdminandaddmenu();


    }

    @And("user to enter mandatory fields")
    public void enterMandatoryField(){

        browserPage.enterMandatoryField();


    }

    @And("user to check save")
    public  void checkSaveButton(){
        browserPage.checkSaveButton();

    }

    @Then("user to able to see created username in the record")
    public void checkCreatedUsernameRecord(){


    }




}
