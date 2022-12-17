import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConstructorPageTest extends BrowserSettings{

    @Test
    @DisplayName("Успешный переход к разделу Булки блока Конструктор")
    public void successfulTransitionToTheBunsSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        mainPage.clickIngredientsButton();                  //переход к разделу "Начинки"
        mainPage.clickBunsButton();                         //переход к разделу "Булки"
        assertEquals("Булки", mainPage.getBunsTitle());
    }

    @Test
    @DisplayName("Успешный переход к разделу Начинки блока Конструктор")
    public void successfulTransitionToTheIngredientsSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        mainPage.clickIngredientsButton();                  //переход к разделу "Начинки"
        assertEquals("Начинки", mainPage.getIngredientsTitle());
    }

    @Test
    @DisplayName("Успешный переход к разделу Соусы блока Конструктор")
    public void successfulTransitionToTheSaucesSectionConstructorTestOK() {
        mainPage.openPage();                                //открыть главную страницу
        mainPage.clickSaucesButton();                       //переход к разделу "Соусы"
        assertEquals("Соусы", mainPage.getSaucesTitle());
    }
}
