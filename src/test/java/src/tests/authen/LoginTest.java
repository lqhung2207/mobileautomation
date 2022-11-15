package src.tests.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.test_data.models.LoginCred;
import src.test_flows.authentication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {
    @Test
    public void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        List<LoginCred> loginCredList = new ArrayList<>();
        loginCredList.add(new LoginCred("", ""));
        loginCredList.add(new LoginCred("teo@sth.com", "1234567"));
        loginCredList.add(new LoginCred("teo@", "12345678"));
        loginCredList.add(new LoginCred("teo@sth.com", "12345678"));
        try {
            for (LoginCred loginCred : loginCredList) {
                String username = loginCred.getUsername();
                String password = loginCred.getPassword();
                LoginFlow loginFlow = new LoginFlow(appiumDriver, username, password);
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
