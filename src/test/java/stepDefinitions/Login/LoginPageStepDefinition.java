package stepDefinitions.Login;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.Login.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class LoginPageStepDefinition {
    TestContextSetup testContextSetup;
    LoginPage loginPage;

    public LoginPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.loginPage = testContextSetup.pageObjectManager.logIn();
    }

    @Given("user visits login page")
    public void user_visits_login_page() {
        loginPage.login().click();
    }

    @Given("user Enter username {string}")
    public void user_enter_username(String email) {
        loginPage.setUserName(email);
    }

    @Given("user Enter password {string}")
    public void user_enter_password(String password) {
        loginPage.setPassword(password);
    }

    @Then("click on login button")
    public void click_on_login_button() throws InterruptedException {
        loginPage.setLogin().click();
        Thread.sleep(5000);
    }

    @When("user Enter {string} and {string}")
    public void user_enter_and(String email, String password) throws InterruptedException {
        loginPage.setUserName(email);
        Thread.sleep(5000);
        loginPage.setPassword(password);
    }

    @When("click on Facebook icon")
    public void click_on_facebook_icon() throws InterruptedException {
        loginPage.signInByFacebook().click();
        Thread.sleep(5000);
        loginPage.switchWindow();
    }

    @When("user Enter Facebook credentials {string} and {string}")
    public void user_enter_facebook_credentials_and(String Phone, String FbPassword) {
        loginPage.setUserId(Phone);
        loginPage.setFBPassword(FbPassword);
    }

    @And("click on Facebook login button")
    public void clickOnFacebookLoginButton() throws InterruptedException {
        loginPage.setFbLogin().click();
        loginPage.switchTab();
        Thread.sleep(5000);
    }

    @Then("login successfully and validation of page title")
    public void login_successfully_and_validation_of_page_title() {
        Assert.assertEquals("Flipboard: Your Social Magazine", LoginPage.getPageTitle());
    }

    @When("login successfully and redirect to home page")
    public void login_successfully_and_redirect_to_home_page(){
        Assert.assertEquals("Flipboard: Your Social Magazine", LoginPage.getPageTitle());
    }
}
