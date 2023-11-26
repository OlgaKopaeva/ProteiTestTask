package webui.protei.base;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import webui.protei.common.Configuration;
import webui.protei.pages.MainPage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static webui.protei.common.Configuration.BASE_URL;

public abstract class BaseUITest {

    protected WebDriver driver;

    @BeforeEach
    public void beforeTest() throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        Thread.sleep(500);
        driver.manage().window().maximize();
    }




   /* @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
