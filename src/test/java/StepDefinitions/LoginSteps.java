package StepDefinitions;

import Base.BaseTest;
import PageObjects.BrowserPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

    private AppiumDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private BrowserPage browserPage;

    public LoginSteps() {
         System.out.println("Initializing LoginSteps..");
         setup();
         homePage = new HomePage(driver);
         browserPage = new BrowserPage(driver);
         loginPage = new LoginPage(driver);

    }

    @Given("user to launch calculator app")
    public void user_to_launch_calculator_app() {


         homePage.verifyUserin_HomePage();



    }



    @When("user perform addition with value {string} and {string}")
    public void user_perform_addition(String a, String b){
       homePage.clickvalue_sum(a,b);

    }

    @And("user to check equals")
    public void user_check_equalsbutton()
    {
       homePage.clickequals();
    }

    @Then("user should get Addition output as {string}")
    public void user_additionOutput_Check(String c){
      homePage.Checkoutput(c);
       tearDown();
    }

    @When("user to launch store app")
    public void launchstoreapp(){
        loginPage.verifyUserin_LoginPage();
    }

    @When("User to enter login details name")
    public void enterNameinLoginPage(){
        loginPage.enterNameLogin();


    }

    @And("User to select genderbox")
    public void selectGenderBox(){

        loginPage.checkGenderbox();
    }


    @When("User to select country dropdown")
    public void user_to_select_country_dropdown() {
        loginPage.selectCountry();

    }
    @When("User to check save button")
    public void user_to_check_save_button() {
        loginPage.checkloginButton();
    }
    @Then("User successfully into store App.")
    public void user_successfully_into_store_app() {
        loginPage.HomepageCheck();


    }

    @Then("User to check vaidate unsuccess login error")
    public void validatenameloginerror(){
        loginPage.checkLoginwithoutnameerror();

    }


}
