import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClickConstructorFromPersonalAccountTest extends BrowserSettings{
    @Before //регистрация пользователя
    public void registrationUser() {
        user = user.getRandomUser();                                        //создать пользователя
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                        //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                            //регистрация пользователя
    }

    @Test
    @DisplayName("Успешный переход в Конструктов из Личного кабинета для авторизованного пользователя")
    public void successfulGoConstructorOnPersonalAccountAuthorizedUserTest() {
        mainPage.openPage();                                                //открыть главную страницу
        mainPage.clickLogInAccountButton();                                 //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                         //вход в аккаунт пользователя
        mainPage.clickPersonalAccountButton();                              //вход в "Личный кабинет"
        personalAccountPage.clickDesignerButton();                          //переход в Конструктор
        assertTrue("Соберите бургер", mainPage.waitAssembleBurgerField());
    }

}
