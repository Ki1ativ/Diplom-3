import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSettings {

    WebDriver driver;
    MainPage mainPage;
    AuthorizationPage authorizationPage;
    RegistrationPage registrationPage;
    RecoverPasswordPage recoverPasswordPage;
    MainPage personalAccountButton;
    PersonalAccountPage personalAccountPage;
    User user;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver = new ChromeDriver(new ChromeOptions().setBinary("C:\\Users\\KiLaTiV\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"));
        //driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        registrationPage = new RegistrationPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        personalAccountButton = new MainPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
