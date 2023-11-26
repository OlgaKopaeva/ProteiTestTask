package webui.protei.interfaces;

//import webui.protei.pages.FormPage;
import webui.protei.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public interface InputsPage {
    public MainPage enterDataEmail(String email);

    public MainPage enterDataName(String name);

    public MainPage selectDataGender(String value);

    public MainPage clickDataCheck11() ;

    public MainPage clickDataCheck12();

    public MainPage clickDataSelect21();

    public MainPage clickDataSelect22() ;

    public MainPage clickDataSelect23();

    public MainPage clickDataSend() ;

    public MainPage checkLoginSuccess();




}
