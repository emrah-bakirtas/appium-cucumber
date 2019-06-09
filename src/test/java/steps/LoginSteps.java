package steps;

import base.BaseMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginSteps extends BaseMethods {

    private static final By LOG_IN_BUTTON_ID = By.id("com.atsocio.socio:id/button_sign_in");
    private static final By LOGIN_TEXT_ID = By.id("com.atsocio.socio:id/text_input_edit_text");
    private static final By NEXT_BUTTON_ID = By.id("com.atsocio.socio:id/button_next");
    private static final By SEARCH_BUTTON_ID = By.id("com.atsocio.socio:id/button_search_event");
    private static final By PASSWORD_TOGGLE_ID = By.id("com.atsocio.socio:id/text_input_password_toggle");

    @When("^Click on Log-in button$")
    public void clickOnLogInButton() {
        clickElement(LOG_IN_BUTTON_ID);
    }

    @Then("^Type email")
    public void typeEmailAs() {
        fillInputField(LOGIN_TEXT_ID, config.getUserEmail(), false);
    }

    @Then("^Click Next button$")
    public void clickNextButton() {
        clickElement(NEXT_BUTTON_ID);
    }

    @Then("^Type password$")
    public void typePasswordAs() {
        untilElementAppear(PASSWORD_TOGGLE_ID);
        findElements(LOGIN_TEXT_ID).get(1).sendKeys(config.getUserPassword());
    }

    @And("^See Search button$")
    public void seeSearchButton() {
        Assert.assertTrue(isElementExist(SEARCH_BUTTON_ID));
    }
}
