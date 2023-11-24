package webui.protei.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.protei.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BaseView {

    @FindBy(css = "input[id='loginEmail']")
    private WebElement loginEmail;

    @FindBy(css = "input[id='loginPassword']")
    private WebElement loginPassword;

    @FindBy(css = "button[id='authButton']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email){
        loginEmail.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        loginPassword.sendKeys(password);
        return this;
    }

    public FormPage clickLoginButton(WebDriver driver){
        loginButton.click();
        return new FormPage(driver);
    }




}
