package webui.protei.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webui.protei.base.BaseUITest;
import webui.protei.common.Configuration;
import webui.protei.pages.MainPage;

public class FormTests extends BaseUITest {

    @Test
    @DisplayName("Fill in the form with correct parameters")
    public void FormPositiveTest() throws InterruptedException {

        MainPage formScreen = new MainPage(driver)
                .authScenario(driver, Configuration.EMAIL_EXIST, Configuration.PASSWORD_EXIST)
                .enterDataEmail(Configuration.EMAIL_EXAMPLE)
                .enterDataName(Configuration.NAME_EXAMPLE)
                .selectDataGender(Configuration.GENDER_MALE)
                .clickDataCheck11()
                .clickDataCheck12()
                .clickDataSelect22()
                .clickDataSend();
        Assertions.assertTrue(formScreen.checkDataAdded());

        Assertions.assertEquals(formScreen.getEmailInTable(), Configuration.EMAIL_EXAMPLE);
        Assertions.assertEquals(formScreen.getNameInTable(), Configuration.NAME_EXAMPLE);
        Assertions.assertEquals(formScreen.getGenderInTable(), Configuration.GENDER_MALE);
        Assertions.assertEquals(formScreen.getCheckboxInTable(), "1.1, 1.2");
        Assertions.assertEquals(formScreen.getSelectInTable(), "2.2");
    }

    @Test
    @DisplayName("Form email doesn't contain domain name")
    public void formEmailWithoutDomainNameTest() {
        MainPage formScreen = new MainPage(driver)
                .authScenario(driver, Configuration.EMAIL_EXIST, Configuration.PASSWORD_EXIST)
                .enterDataEmail(Configuration.EMAIL_WITHOUT_DOMAIN)
                .enterDataName(Configuration.NAME_EXAMPLE)
                .selectDataGender(Configuration.GENDER_MALE)
                .clickDataCheck11()
                .clickDataCheck12()
                .clickDataSelect22()
                .clickDataSend();

        Assertions.assertFalse(formScreen.checkDataAdded());
        formScreen.checkEmailIncorrectFormat();
    }
}
