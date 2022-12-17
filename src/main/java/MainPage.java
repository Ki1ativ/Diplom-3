import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";

    private final By designerButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo') and (@href='/')]"); //кнопка "Конструктор"
    private final By orderFeedButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/feed')]"); //кнопка "Лента заказов"
    private final By personalAccountButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/account')]"); //кнопка "Личный Кабинет"
    private final By assembleBurgerField = By.xpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']"); //поле "Соберите бургер"
    private final By logInAccountButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']"); //кнопка "Войти в аккаунт"
    private final By bunsButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Булки']/parent::div"); //кнопка "Булки"
    private final By saucesButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Соусы']/parent::div"); //кнопка ""Соусы"
    private final By ingredientsButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Начинки']/parent::div"); //кнопка "Начинки"
    private final By bunsTitle  = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][1]"); //заголовок "Булки"
    private final By saucesTitle  = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][2]"); //заголовок "Соусы"
    private final By ingredientsTitle  = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][3]"); //заголовок "Начинки"
    private final By orderButton = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button");//кнопка "Оформить заказ"


    //открытие страницы тестирования
    public void openPage() {
        driver.get(mainPageUrl);
    }

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //нажать кнопку "Конструктор"
    public void clickDesignerButton(){
        driver.findElement(designerButton).click();
    }

    //нажать кнопку "Лента заказов"
    public void clickOrderFeedButton(){
        driver.findElement(orderFeedButton).click();
    }

    //нажать кнопку "Личный Кабинет"
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    //ожидание загрузки поля "Соберите бургер"
    public boolean waitAssembleBurgerField() {
        String text = driver.findElement(assembleBurgerField).getText();
        return (text.equals("Соберите бургер"));
    }

    //нажать кнопку  "Войти в аккаунт"
    public void clickLogInAccountButton(){
        driver.findElement(logInAccountButton).click();
    }

        //выбрать раздел "Булки"
    public void clickBunsButton(){
        driver.findElement(bunsButton).click();
    }

    //выбрать раздел "Соусы"
    public void clickSaucesButton(){
        driver.findElement(saucesButton).click();
    }

    //выбрать раздел "Начинки"
    public void clickIngredientsButton(){
        driver.findElement(ingredientsButton).click();
    }

    //получение значения заголовка "Булки"
    public String getBunsTitle() {
        String text = driver.findElement(bunsTitle).getText();
        return text;
    }

    //получение значения заголовка "Соусы"
    public String getSaucesTitle() {
        String text = driver.findElement(saucesTitle).getText();
        return text;
    }

    //получение значения заголовка "Начинки"
    public String getIngredientsTitle() {
        String text = driver.findElement(ingredientsTitle).getText();
        return text;
    }

    //ожидание появления кнопки "Оформить заказ"
    public boolean waitOrderButton() {
        wait(orderButton);
        String text = driver.findElement(orderButton).getText();
        return (text.equals("Оформить заказ"));
    }

}
