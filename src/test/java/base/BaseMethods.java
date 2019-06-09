package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseMethods {

    private static AndroidDriver<MobileElement> driver;
    private static WebDriverWait wait;
    private static final int DEFAULT_WAIT = 10;
    private static final String accessKey = System.getenv("BROWSERSTACK_ACCESSKEY");
    private static final String userName = System.getenv("BROWSERSTACK_USERNAME");
    protected Configuration config;

    public BaseMethods() {
        this.config = Configuration.getInstance();
    }

    private static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    private static void setDriver(AndroidDriver<MobileElement> driver) {
        BaseMethods.driver = driver;
    }

    /**
     * Use this method to set up android driver
     *
     * Note: Get capability values from config.properties
     */
    protected void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", config.getDevice());
        caps.setCapability("app", config.getApp());
        caps.setCapability("browserstack.debug", config.getBrowserstackDebug());

        setDriver(new AndroidDriver<MobileElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps));
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        wait = new WebDriverWait(getDriver(), DEFAULT_WAIT);
    }

    /**
     * Use this method to quit android driver
     */
    protected void tearDown() {
        driver.quit();
    }


    /**
     * Use this method to find element by By
     *
     * @return A MobileElement, or an empty if nothing matches
     */
    protected MobileElement findElement(By by, int... index) {
        return index.length == 0
                ? driver.findElement(by)
                : driver.findElements(by).get(index[0]);
    }


    /**
     * Use this method to find elements by By
     *
     * @return A list of MobileElements, or an empty if nothing matches
     */
    protected List<MobileElement> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * Use this method click to element
     */
    protected void clickElement(By by, int... index) {
        untilElementAppear(by);

        MobileElement element = index.length == 0
                ? findElement(by)
                : findElement(by, index[0]);

        element.click();
    }

    /**
     * Use this method to simulate typing into an element if it is enable.
     * Send enter if pressEnter is true, do nothing otherwise.
     * Note : Before sending operation, element is cleared.
     */
    protected void fillInputField(By by, String text, boolean pressEnter) {
        untilElementAppear(by);

        MobileElement element = findElement(by);

        if (element.isEnabled()) {
            element.clear();
            element.sendKeys(text);

            if (pressEnter) driver.pressKeyCode(AndroidKeyCode.ENTER);
        }
    }

    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element.
     *
     * @return The innerText of this element.
     */
    protected String getTextOfElement(By by, int... index) {
        untilElementAppear(by);

        return index.length == 0
                ? findElement(by).getText()
                : findElement(by, index[0]).getText();
    }

    /**
     * Wait until element appears
     */
    protected void untilElementAppear(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Wait until element disappears
     */
    protected void untilElementDisappear(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * Return true if element exist, false otherwise.
     *
     * @return True if element exists, false otherwise.
     */
    protected boolean isElementExist(By by) {
        return findElements(by).size() > 0;
    }
}
