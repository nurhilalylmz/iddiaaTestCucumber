package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import methods.LoginMethods;

public class LoginSteps{
    LoginMethods loginPage=new LoginMethods();

    @When("close pop-up")
    public void closePopUp() {
        loginPage.closePopup();
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Given("^a web browser is at the iddiaa login page \"([^\"]*)\"$")
    public void aWebBrowserIsAtTheIddiaaLoginPage(String url) {
        loginPage.geturl(url);
        loginPage.waitForPageLoadMethod();
    }

    @And("^driver close$")
    public void driverClose() {
        loginPage.driverQuit();
    }

    @And("^user enters phone number \"([^\"]*)\"$")
    public void userEntersPhoneNumber(String phoneNumber) {
        loginPage.writePhoneNumber(phoneNumber);
    }

    @And("^user enters password \"([^\"]*)\"$")
    public void userEntersPassword(String password) {
        loginPage.writePassword(password);
    }

    @Then("^user go to Homepage \"([^\"]*)\"$")
    public void userGoToHomepage(String expectedURL) {
       loginPage.checkUserMainPage(expectedURL);
    }
}

