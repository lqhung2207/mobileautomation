package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.io.File;

public class TakingScreenShot {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            // Navigate to login form
            MobileElement navloginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navloginBtnElem.click();

            // Whole screen
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots").concat("LoginScreen.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

            // An area
            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64SLoginFormData = loginFormElem.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots").concat("LoginFormScreen.png");
            FileUtils.copyFile(base64SLoginFormData, new File(loginFormFileLocation));

            // An element
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64SLoginBtnData = loginBtnElem.getScreenshotAs(OutputType.FILE);
            String loginFormBtnLocation = System.getProperty("user.dir").concat("/screenshots").concat("LoginBtnScreen.png");
            FileUtils.copyFile(base64SLoginBtnData, new File(loginFormBtnLocation));


        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
