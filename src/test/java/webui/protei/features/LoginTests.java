package webui.protei.features;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webui.protei.base.BaseUITest;
import webui.protei.common.Configuration;
import webui.protei.pages.FormPage;
import webui.protei.pages.LoginPage;

public class LoginTests extends BaseUITest {
    @Test
    @DisplayName("Login with correct parameters")
    public void loginPositiveTest() {
        FormPage loginScreen = new LoginPage(driver)
                .enterEmail(Configuration.EMAIL_EXIST)
                .enterPassword((Configuration.PASSWORD_EXIST))
                .clickLoginButton(driver);
        loginScreen.checkLoginSuccess();

    }

    @Test
    @DisplayName("Login when user doesn't exist")
    public void loginUserNotExistTest() {
        FormPage loginScreen = new LoginPage(driver)
                .enterEmail(Configuration.EMAIL_NOT_EXIST)
                .enterPassword((Configuration.PASSWORD_NOT_EXIST))
                .clickLoginButton(driver);
        loginScreen.checkLoginNotSuccess();

    }

    @Test
    @DisplayName("Login email without at")
    public void loginEmailWithoutAtTest() {
        FormPage loginScreen = new LoginPage(driver)
                .enterEmail(Configuration.EMAIL_WITHOUT_AT)
                .enterPassword((Configuration.PASSWORD_EXIST))
                .clickLoginButton(driver);
        loginScreen.checkLoginEmailIncorrectFormat();
    }

    @Test
    @DisplayName("Login email too long")
    public void loginEmailTooLongTest() {
        FormPage loginScreen = new LoginPage(driver)
                .enterEmail(Configuration.EMAIL_TOO_LONG)
                .enterPassword((Configuration.PASSWORD_EXIST))
                .clickLoginButton(driver);
        loginScreen.checkLoginEmailIncorrectFormat();
    }

}
