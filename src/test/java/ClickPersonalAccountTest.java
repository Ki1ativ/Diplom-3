import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClickPersonalAccountTest extends BrowserSettings{

    @Test
    @DisplayName("Успешный переход в Личный кабинет с Главной страницы для авторизованного пользователя")
    public void successfulGoPersonalAccountOnMainPageAuthorizedUserTest() {
        user = User.getRandomUser();                                    //создать пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                    //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                        //регистрация пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                     //вход в аккаунт пользователя
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInformation());
    }

    @Test
    @DisplayName("Успешный переход в Личный кабинет со страницы Лента Заказов для авторизованного пользователя")
    public void successfulGoPersonalAccountOnFeedOrderPageAuthorizedUserTest() {
        user = User.getRandomUser();                                    //создать пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        authorizationPage.clickRegistrationButton();                    //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                        //регистрация пользователя
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.loginToUserAccount(user);                     //вход в аккаунт пользователя
        mainPage.clickOrderFeedButton();                                //переход на страницу "Лента заказов"
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInformation());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет с Главной страницы для неавторизованного пользователя")
    public void notSuccessfulGoPersonalAccountOnMainPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Лента Заказов для авторизованного пользователя")
    public void notSuccessfulGoPersonalAccountOnFeedOrderPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickOrderFeedButton();                                //переход на страницу "Лента заказов"
        mainPage.clickPersonalAccountButton();                          //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Авторизации для неавторизованного пользователя")
    public void notSuccessfulGoPersonalAccountOnAuthorizationPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.clickPersonalAccountButton();                 //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Регистрации для неавторизованного пользователя")
    public void notSuccessfulGoPersonalAccountOnRegistrationPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.clickRegistrationButton();                    //переход на страницу регистрации
        registrationPage.clickPersonalAccountButton();                  //вход в "Личный кабинет"
        assertNotEquals( personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Не успешный переход в Личный кабинет со страницы Возобновления пароля для неавторизованного пользователя")
    public void notSuccessfulGoPersonalAccountOnRecoverPasswordPageNoAuthorizedUserTest() {
        mainPage.openPage();                                            //открыть главную страницу
        mainPage.clickLogInAccountButton();                             //переход на страницу входа в аккаунт
        authorizationPage.clickRecoverPasswordButton();                 //переход на страницу восстановления пароля
        recoverPasswordPage.clickPersonalAccountButton();               //вход в "Личный кабинет"
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

}
