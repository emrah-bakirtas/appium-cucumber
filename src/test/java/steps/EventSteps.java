package steps;

import base.BaseMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EventSteps extends BaseMethods {

    private static final By SEARCH_BUTTON = By.id("com.atsocio.socio:id/button_search_event");
    private static final By SEARCH_TEXT = By.id("com.atsocio.socio:id/search_src_text");
    private static final By JOIN_TEXT = By.id("com.atsocio.socio:id/text_join");
    private static final By WELCOME_MESSAGE_HEADER = By.id("com.atsocio.socio:id/text_header");
    private static final By EXIT_EVENT_BUTTON = By.className("android.widget.ImageButton");
    private static final By ALERT_TITLE = By.id("com.atsocio.socio:id/alertTitle");
    private static final By POP_UP_YES_BUTTON = By.id("android:id/button1");

    @Given("^Click on Search button$")
    public void clickOnSearchButton() {
        clickElement(SEARCH_BUTTON);
    }

    @When("^Type event name as \"([^\"]*)\" and press enter$")
    public void typeEventNameAsAndPressEnter(String eventName) {
        fillInputField(SEARCH_TEXT, eventName, true);
    }

    @Then("^Click on the event Home text$")
    public void clickOnTheEventHomeText() {
        clickElement(JOIN_TEXT);
    }

    @And("^See welcome message as \"([^\"]*)\"$")
    public void seeWelcomeMessageAs(String message) {
        Assert.assertEquals(message, getTextOfElement(WELCOME_MESSAGE_HEADER));
    }

    @Given("^Click on Exit Event button$")
    public void clickOnExitEventButton() {
        clickElement(EXIT_EVENT_BUTTON);
    }

    @When("^See Switch Event pop-up as \"([^\"]*)\"$")
    public void seeSwitchEventPopUpAs(String title) {
        Assert.assertEquals(title, getTextOfElement(ALERT_TITLE));
    }

    @Then("^Click on Yes button$")
    public void clickOnYesButton() {
        clickElement(POP_UP_YES_BUTTON);
    }
}
