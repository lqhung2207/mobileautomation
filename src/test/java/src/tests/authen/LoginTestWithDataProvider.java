package src.tests.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.test_data.models.LoginCred;
import src.test_data.utils.DataObjectBuilder;
import src.test_flows.authentication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTestWithDataProvider {

    @Test(dataProvider = "loginCredDataSet")
    public void testLogin(LoginCred loginCred) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
                String username = loginCred.getUsername();
                String password = loginCred.getPassword();
                LoginFlow loginFlow = new LoginFlow(appiumDriver, username, password);
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }

    @DataProvider
    private LoginCred[] loginCredDataSet(){
        String fileLocation = "/src/test/java/src/tests/gson/login.json";
        return DataObjectBuilder.buildDataObject(fileLocation, LoginCred[].class);
//        LoginCred[] loginCredList = new LoginCred[]{
//                new LoginCred("", ""),
//                new LoginCred("teo@sth.com", "1234567"),
//                new LoginCred("teo@", "123    45678"),
//                new LoginCred("teo@sth.com", "12345678")
//        };
//        return loginCredList;
    }
}
