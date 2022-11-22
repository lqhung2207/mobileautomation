package src.tests.authen;

import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import src.test_data.models.LoginCred;
import src.test_data.utils.DataObjectBuilder;
import src.test_flows.authentication.LoginFlow;
import src.tests.BaseTest;

public class LoginTestWithBaseTest extends BaseTest {

    @Test(dataProvider = "loginCredDataSet")
    public void testLogin(LoginCred loginCred) {
        String username = loginCred.getUsername();
        String password = loginCred.getPassword();
        LoginFlow loginFlow = new LoginFlow(getDriver(), username, password);
        loginFlow.gotoLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
//        Assert.fail("[err]...");
    }

    @DataProvider
    private LoginCred[] loginCredDataSet() {
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
