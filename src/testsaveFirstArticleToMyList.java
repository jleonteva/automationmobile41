import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.URL;
import java.util.List;

public class testsaveFirstArticleToMyList {
    private AppiumDriver driver;
    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTest");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/user/Desktop/JavaAppiumAuto/apks/Wikipedia_v2.7.50362-r-2021-06-04_apkpure.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }
    @After
    public void tearDown()
    {
        driver.quit();

    }


@Test
public void testsaveFirstArticleToMyList ()
{
    WebElement skipButton = driver.findElementByXPath("//*[contains(@text, 'SKIP')]");
        skipButton.click();

    waitForElementAndClick(
            By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search Wikipedia",
                        5
                        );

    waitForElementAndSendKeys(
            By.id("org.wikipedia:id/search_src_text"),
                "Java",
                        "Cannot find search text input",
                        25
                        );


    waitForElementPresent(
            By.id("org.wikipedia:id/page_list_item_description"),
                "Cannot find 'item_description'",
                        25
                        );

    waitForElementAndClick(
            By.xpath("//*[contains(@text, 'Object-oriented programming language')]"),
                "Cannot find 'Search Wikipedia' input",
                        15
                        );

    waitForElementPresent(
            By.id("org.wikipedia:id/page_contents_container"),
                "Cannot find article title",
                        15
                        );

    waitForElementAndClick(
            By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find 'article_menu_bookmark'",
                        10
                        );

    waitForElementAndClick(
            By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find 'ADD TO LIST'",
                        10
                        );

    waitForElementPresent(
            By.id("org.wikipedia:id/parentPanel"),
                "Cannot find 'parentPanel'",
                        10
                        );

    waitForElementAndSendKeys(
            By.id("org.wikipedia:id/text_input"),
                "TestListArt",
                        "Cannot find search text input",
                        25
                        );

    waitForElementAndClick(
            By.xpath("//*[@text = 'OK']"),
                "Cannot find press button 'OK'",
                        10
                        );

    waitForElementAndClick(
            By.xpath("//*[@text = 'VIEW LIST']"),
                "Cannot find press button 'VIEW LIST'",
                        10
                        );

    waitForElementPresent(
            By.id("org.wikipedia:id/reading_list_recycler_view"),
                "Cannot find reading_list",
                        30
                        );

    swipeElementToLeft(
            By.xpath("//*[@text = 'Java (programming language)']"),
                "Cannot find saved article"
                        );

    waitForElementNotPresent(
            By.xpath("//*[@text = 'Java (programming language)']"),
                "Cannot delete saved article",
                        5
                        );
}
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );

    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.click();
        return element;

    }
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.sendKeys(value);
        return element;

    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();

    }

    protected  void swipeUpQuick()
    {
        swipeUp(200);
    }



    protected  void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                35);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x,middle_y)
                .waitAction(300)
                .moveTo(left_x,middle_y)
                .release()
                .perform();


    }




}
