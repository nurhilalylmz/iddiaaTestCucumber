package methods;

import contants.ContantsLoginPage;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class LoginMethods extends BaseMethods {
    ContantsLoginPage loginPage = PageFactory.initElements(driver, ContantsLoginPage.class);

    public LoginMethods() {
    }


    public void waitForPageLoadMethod() {
        waitForPageLoad(loginPage.copyrightText);
    }
    @Description("Çıkan pop-up'ı kapatır.")
    public void closePopup() {
        waitElementToClickable(loginPage.buttonClosePopup);
        clickElement(loginPage.buttonClosePopup);
    }
    public void writePhoneNumber(String phoneNumber) {
        writeText(loginPage.phoneNumber, phoneNumber);
        waitSeconds(1);
    }
    public void writePassword(String password) {
        writeText(loginPage.password, password);
        waitSeconds(1);
    }
    public void clickLoginButton() {
        clickElement(loginPage.buttonLogin);
        waitSeconds(1);
    }
    @Description("Kullanıcının hangi sayfada olduğu kontrol edilir.")
    public void checkUserMainPage(String expectingUrl) {
        waitForPageLoad(loginPage.copyrightText);
        Assert.assertEquals("İstenen sayfada olunmadığı görüldü",expectingUrl, driver.getCurrentUrl());
    }
}
