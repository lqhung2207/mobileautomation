package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.models.components.login.LoginFormComponent;
import src.models.pages.LoginScreenMod01;

public class LoginTestMod01 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginScreenMod01 loginScreen = new LoginScreenMod01(appiumDriver);
            loginScreen.bottomNavComponent().clickOnLoginIcon();
            LoginFormComponent loginFormComponent = loginScreen.loginFormComponent();
            loginFormComponent.usernameElem().sendKeys("teo@sth.com");
            loginFormComponent.passwordElem().sendKeys("12345678");
            loginFormComponent.loginBtnElem().click();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
