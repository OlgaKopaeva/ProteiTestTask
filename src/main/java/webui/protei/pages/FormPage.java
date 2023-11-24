package webui.protei.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webui.protei.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormPage extends BaseView {
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

    @FindBy(xpath = "//*[@id=\"invalidEmailPassword\"]")
    private WebElement messageLoginNotSuccess;

    @FindBy(xpath = "//*[@id=\"emailFormatError\"]")
    private WebElement messageLoginEmailIncorrectFormat;



    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage enterDataEmail(String email) {
        dataEmail.sendKeys(email);
        return this;
    }

    public FormPage enterDataName(String name) {
        dataName.sendKeys(name);
        return this;
    }

    public FormPage selectDataGender(String value) {
        getSelectGender().selectByValue(value);
        return this;
    }

    public FormPage clickDataCheck11() {
        dataCheck11.click();
        return this;
    }

    public FormPage clickDataCheck12() {
        dataCheck12.click();
        return this;
    }

    public FormPage clickDataSelect21() {
        dataSelect21.click();
        return this;
    }

    public FormPage clickDataSelect22() {
        dataSelect22.click();
        return this;
    }

    public FormPage clickDataSelect23() {
        dataSelect23.click();
        return this;
    }

    public FormPage clickDataSend() {
        dataSend.click();
        return this;
    }

    public FormPage checkLoginSuccess(){
        assertTrue(dataSend.isDisplayed());
        return this;
    }

    public FormPage checkLoginNotSuccess(){
        assertTrue(messageLoginNotSuccess.isDisplayed());
        return this;
    }
    public void checkLoginEmailIncorrectFormat(){
        assertTrue(messageLoginEmailIncorrectFormat.isDisplayed());
    }


}
