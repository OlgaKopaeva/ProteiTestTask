package webui.protei.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseView {
    WebDriver driver;
    protected WebDriverWait wait7seconds;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.wait7seconds = new WebDriverWait(driver, Duration.ofSeconds(7));
        PageFactory.initElements(driver, this);
    }
}
