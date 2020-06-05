package methods;

import jdk.jfr.Description;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
    public static WebDriver driver;

    public BaseMethods() {
        setBrowser("chrome");
    }
    public void driverQuit() {
        if(driver!=null){
            driver.quit();
        }
    }
    public void geturl(String url)
    {
        driver.navigate().to(url);
    }

    @Description("İlgili element tıklanabilir olana kadar bekler.")
    protected void waitElementToClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            logMessage(e.getMessage());
        }
    }

    @Description("Console'a mesaj yazdırılmasını sağlar.")
    protected void logMessage(String text) {
        System.out.println(text);
    }

    @Description("İlgili elemente tıklanmasını,eğer tıklanamazsa uyarı çıkması sağlanır.")
    protected void clickElement(WebElement element) {
        try {
            waitSeconds(1);
            element.click();
            logMessage(element.getText() + " elementine tıklandı.");
        } catch (Exception e) {
            logMessage("Elemente tıklanamadı. Element: " + element + " Hata: " + e.getMessage());
        }

    }

    @Description("İlgili elemente string ifade girilmesini sağlar.")
    protected void writeText(WebElement element, String text) {
        try {
            if (element.getText().equals("")) {
                element.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            }
            element.sendKeys(text);

        } catch (Exception e) {
            logMessage("İlgili elemente yazı yazılırken hata oluştu. Element:"+ element +"Hata: " + e.getMessage());
        }
    }

    @Description("Sayfada belirtilen saniye kadar beklmesini sağlar.")
    protected void waitSeconds(int seconds) {
        try {
            logMessage(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logMessage(e.getMessage());
        }
    }

    @Description("Sayfayı belirli bir element yüklenene kadar beklemesini sağlar.")
    protected void waitForPageLoad(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            logMessage(e.getMessage());
        }
    }

    public  void setBrowser(String browser) {
        if(browser.equals("chrome")){
            //chrome driver dizinini belirttik.
            System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
            //Browser ayarları
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //Chrome ayarlarını yapmak için yeni bir obje nesnesi oluşturulur.
            ChromeOptions chromeOptions = new ChromeOptions();
            //Browser'ı test modunda çalıştırma.
            chromeOptions.addArguments("test-type");
            //Dil çevirme penceresini kapattırma.
            chromeOptions.addArguments("disable-translate");
            //Browser tam ekranda gösterilir.
            chromeOptions.addArguments("start-maximized");
            //Pop-uplar bloklanır.
            chromeOptions.addArguments("disable-popup-blocking");
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            //Driver'ımızı setliyoruz.
            driver=(new ChromeDriver(chromeOptions));
        }
        else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
            //Browser ayarları
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //Chrome ayarlarını yapmak için yeni bir obje nesnesi oluşturulur.
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            //Browser'ı test modunda çalıştırma.
            firefoxOptions.addArguments("test-type");
//        //Dil çevirme penceresini kapattırma.
            firefoxOptions.addArguments("disable-translate");
            //Browser tam ekranda gösterilir.
            firefoxOptions.addArguments("start-maximized");
            //Pop-uplar bloklanır.
            firefoxOptions.addArguments("disable-popup-blocking");
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
            //Driver'ımızı setliyoruz.
            driver=(new FirefoxDriver(firefoxOptions));
        }
        else{
            Assert.fail("Driver bulunamadı.Ayarları kontrol ediniz.");
        }
    }
}
