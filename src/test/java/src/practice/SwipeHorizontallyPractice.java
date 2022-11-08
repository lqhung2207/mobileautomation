package src.practice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.time.Duration;

public class SwipeHorizontallyPractice {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            // Navigate to log in Screen
            MobileElement navSwipeBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navSwipeBtnElem.click();

            // Find active bth and click
//            appiumDriver.findElement(MobileBy.AccessibilityId("button-Active")).click();

            // Wait until we are on the new screen after navigating
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")")));

            // Get Mobile Screen
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate Touch points
            int xStartPoint = 90 * screenWidth / 100;
            int xEndPoint = 10 * screenWidth / 100;
            int yStartPoint = 70 * screenHeight / 100;
            int yEndPoint = 70 * screenHeight / 100;

            // Convert point to coordinate
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Swipe max 5 times and find text
            int i = 1;
            int countSwipe = 0;
            int page = 1;
            while (i > 0) {
                String titleCardElem = "(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[" + page + "]/android.widget.TextView[1]";
//              List<MobileElement> page = appiumDriver.findElements(MobileBy.xpath(("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[3]")));
                MobileElement findTitleElem = appiumDriver.findElement(MobileBy.xpath((titleCardElem)));
                System.out.println("Title of card is: " + findTitleElem.getText());
                page = 2;
                i++;
                if (findTitleElem.getText().equals("SUPPORT VIDEOS")) {
                    System.out.println("FOUND");
                    i = 0;
                } else {
                    TouchAction touchAction = new TouchAction(appiumDriver);
                    touchAction
                            .press(startPoint)
                            .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                            .moveTo(endPoint)
                            .release()
                            .perform();
                    countSwipe++;
                    System.out.println("Swiped " + countSwipe + " times!");
                }
                // End loop when swipe 5 times
                if (countSwipe > 5){
                    System.out.println("Can't find");
                    break;
                }
            }
            // Debug purpose ONLY
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
