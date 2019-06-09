package steps;

import base.BaseMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.net.MalformedURLException;

public class MainSteps extends BaseMethods {

    @Given("^Launch the app$")
    public void launchTheApp() throws MalformedURLException {
        setUp();
    }

    @And("^Quit the app$")
    public void quitTheApp() {
        tearDown();
    }
}
