package webui.protei.interfaces;

import org.openqa.selenium.WebDriver;
import webui.protei.pages.MainPage;

public interface AuthPage {
    public MainPage enterEmail(String email);

    public MainPage enterPassword(String password);

    public MainPage clickLoginButton(WebDriver driver);

    public MainPage checkLoginNotSuccess();
    public MainPage checkEmailIncorrectFormat();

}
