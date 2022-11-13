package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.models.components.login.LoginFormComponent;
import src.models.components.login.LoginFormComponentMod02;
import src.models.pages.LoginScreenMod01;
import src.models.pages.LoginScreenMod02;

public class LoginTestMod02 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginScreenMod02 loginScreen = new LoginScreenMod02(appiumDriver);
            loginScreen.bottomNavComponent().loginIconElem().click();
            LoginFormComponentMod02 loginFormComponent = loginScreen.loginFormComponent();
            loginFormComponent.inputUsername("teo@sth.com");
            loginFormComponent.inputPassword("12345678");
            loginFormComponent.clickOnLoginBtn();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
