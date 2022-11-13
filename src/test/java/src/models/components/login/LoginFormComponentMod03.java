package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponentMod03 {

    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By usernameSelect = MobileBy.AccessibilityId("input-email");
    private static final By passwordSelect = MobileBy.AccessibilityId("input-password");
    private static final By loginBtnSelect = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponentMod03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponentMod03 inputUsername(String username){
        appiumDriver.findElement(usernameSelect).sendKeys(username);
        return this;
    }

    public LoginFormComponentMod03 inputPassword(String password){
        appiumDriver.findElement(passwordSelect).sendKeys(password);
        return this;
    }

    public LoginFormComponentMod03 clickOnLoginBtn(){
        appiumDriver.findElement(loginBtnSelect).click();
        return this;
    }
}
