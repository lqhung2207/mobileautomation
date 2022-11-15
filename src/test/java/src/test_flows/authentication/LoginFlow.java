package src.test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.validator.routines.EmailValidator;
import src.models.components.login.LoginFormComponentMod03;
import src.models.pages.LoginScreenMod03;
import src.test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private String username;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.username = username;
        this.password = password;
    }

    public void login(){
        LoginScreenMod03 loginScreen = new LoginScreenMod03(appiumDriver);
        LoginFormComponentMod03 loginFormComponent = loginScreen.loginFormComponent();

        if(!username.isEmpty()) loginFormComponent.inputUsername(username);
        if(!password.isEmpty()) loginFormComponent.inputPassword(password);
        loginFormComponent.clickOnLoginBtn();

    }

    public void verifyLogin(){
        boolean isEmailValid = isEmailValid();
        boolean isPasswordValid = isPasswordValid();

        LoginFormComponentMod03 loginFormComponent = new LoginScreenMod03(appiumDriver).loginFormComponent();

        if(isEmailValid && isPasswordValid){
            verifyCorrectLoginCreds(loginFormComponent);
        }

        if(!isEmailValid){
            verifyIncorrectEmailLogin(loginFormComponent);
        }

        if(!isPasswordValid){
            verifyIncorrectPasswordLogin(loginFormComponent);
        }


    }

    private boolean isEmailValid() {
        return EmailValidator.getInstance().isValid(username);
    }
    private boolean isPasswordValid() {
        return password.length() >= 8;
    }

    private void verifyCorrectLoginCreds(LoginFormComponentMod03 loginFormComponent) {
        System.out.println("Title login success pop-up: " + loginFormComponent.loginSuccessPopup());
    }

    private void verifyIncorrectEmailLogin(LoginFormComponentMod03 loginFormComponent) {
        String actualInvalidEmailTxt = loginFormComponent.inValidEmailTxt();
        String expectedInvalidEmailTxt = "Please enter a valid email address";

        System.out.println("actualInvalidEmailTxt: " + actualInvalidEmailTxt);
        System.out.println("expectedInvalidEmailTxt: " + expectedInvalidEmailTxt);
    }

    private void verifyIncorrectPasswordLogin(LoginFormComponentMod03 loginFormComponent) {
        String actualInvalidPasswordTxt = loginFormComponent.inValidPasswordTxt();
        String expectedInvalidPasswordTxt = "Please enter a valid email address";

        System.out.println("actualInvalidPasswordTxt: " + actualInvalidPasswordTxt);
        System.out.println("expectedInvalidPasswordTxt: " + expectedInvalidPasswordTxt);
    }

}
