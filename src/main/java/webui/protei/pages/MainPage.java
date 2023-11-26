package webui.protei.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webui.protei.base.BaseView;
import webui.protei.interfaces.AuthPage;
import webui.protei.interfaces.InputsPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends BaseView implements AuthPage, InputsPage {

    Boolean loginSuccess = false;
    Boolean dataAddedToTable = false;

    @FindBy(css = "input[id='loginEmail']")
    private WebElement loginEmail;

    @FindBy(css = "input[id='loginPassword']")
    private WebElement loginPassword;

    @FindBy(css = "button[id='authButton']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='authPage']")
    private WebElement authPageBlock;

    @FindBy(xpath = "//*[@id='inputsPage']")
    private WebElement inputsPageBlock;

    @FindBy(xpath = "//*[@id=\"invalidEmailPassword\"]")
    private WebElement messageLoginNotSuccess;

    @FindBy(xpath = "//div[@class='uk-modal uk-open']")
    private WebElement messageDataAdded;

    @FindBy(xpath = "//*[@id=\"emailFormatError\"]")
    private WebElement messageEmailIncorrectFormat;

    @FindBy(css = "input[id='dataEmail']")
    private WebElement dataEmail;

    @FindBy(css = "input[id='dataName']")
    private WebElement dataName;

    @FindBy(css = "select[id='dataGender']")
    private WebElement dataGender;

    public Select getSelectGender() {
        return new Select(dataGender);
    }

    @FindBy(css = "input[id='dataCheck11']")
    private WebElement dataCheck11;
    @FindBy(css = "input[id='dataCheck12']")
    private WebElement dataCheck12;

    @FindBy(css = "input[id='dataSelect21']")
    private WebElement dataSelect21;
    @FindBy(css = "input[id='dataSelect22']")
    private WebElement dataSelect22;
    @FindBy(css = "input[id='dataSelect23']")
    private WebElement dataSelect23;

    @FindBy(css = "button[id='dataSend']")
    private WebElement dataSend;

    @FindBy(xpath = "//*[@id='dataTable']")
    private WebElement formTable;

    @FindBy(xpath = "//*[@id='dataTable']/tbody/tr/td[1]")
    private WebElement emailInTable;
    @FindBy(xpath = "//*[@id='dataTable']/tbody/tr/td[2]")
    private WebElement nameInTable;
    @FindBy(xpath = "//*[@id='dataTable']/tbody/tr/td[3]")
    private WebElement genderInTable;
    @FindBy(xpath = "//*[@id='dataTable']/tbody/tr/td[4]")
    private WebElement checkboxInTable;
    @FindBy(xpath = "//*[@id='dataTable']/tbody/tr/td[5]")
    private WebElement selectInTable;

    public String getEmailInTable() {
        return emailInTable.getText();
    }

    public String getNameInTable() {
        return nameInTable.getText();
    }

    public String getGenderInTable() {
        return genderInTable.getText();
    }

    public String getCheckboxInTable() {
        return checkboxInTable.getText();
    }

    public String getSelectInTable() {
        return selectInTable.getText();
    }

    public MainPage enterEmail(String email) {
        loginEmail.sendKeys(email);
        return this;
    }

    public MainPage enterPassword(String password) {
        loginPassword.sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton(WebDriver driver) {
        loginButton.click();
        loginSuccess = inputsPageBlock.isDisplayed();
        return this;
    }

    public MainPage enterDataEmail(String email) {
        dataEmail.sendKeys(email);
        return this;
    }

    public MainPage enterDataName(String name) {
        dataName.sendKeys(name);
        return this;
    }

    public MainPage selectDataGender(String value) {
        getSelectGender().selectByVisibleText(value);
        return this;
    }

    public MainPage clickDataCheck11() {
        dataCheck11.click();
        return this;
    }

    public MainPage clickDataCheck12() {
        dataCheck12.click();
        return this;
    }

    public MainPage clickDataSelect21() {
        dataSelect21.click();
        return this;
    }

    public MainPage clickDataSelect22() {
        dataSelect22.click();
        return this;
    }

    public MainPage clickDataSelect23() {
        dataSelect23.click();
        return this;
    }

    public MainPage clickDataSend() {
        dataSend.click();
        dataAddedToTable = messageDataAdded.isDisplayed();
        return this;
    }

    public MainPage checkLoginSuccess() {
        assertTrue(loginSuccess);
        return this;
    }

    public MainPage checkLoginNotSuccess() {
        assertFalse(loginSuccess);
        assertTrue(messageLoginNotSuccess.isDisplayed());
        return this;
    }

    public MainPage checkEmailIncorrectFormat() {
        assertFalse(loginSuccess);
        assertTrue(messageEmailIncorrectFormat.isDisplayed());
        return this;
    }

    public Boolean checkDataAdded() {
        return dataAddedToTable;
    }

    public MainPage authScenario(WebDriver driver, String email, String password) {
        MainPage loginScreen = new MainPage(driver)
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton(driver)
                .checkLoginSuccess();
        return this;
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
