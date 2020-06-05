package contants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsLoginPage
{
    @FindBy(how = How.ID,using = "10000")
    public WebElement phoneNumber;
    @FindBy(how = How.ID,using = "20000")
    public WebElement password;
    @FindBy(how = How.CSS,using = "button")
    public WebElement buttonLogin;
    @FindBy(how = How.CLASS_NAME,using = "policy-popup__close")
    public WebElement buttonClosePopup;
    @FindBy(how = How.CSS,using = ".col-copy")
    public WebElement copyrightText;
}
