package com.yandex.praktikum.tests;

import com.yandex.praktikum.page.DriverRule;
import com.yandex.praktikum.page.MainFoodElementPage;
import com.yandex.praktikum.page.MainPage;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ExaminFooterText {
    private final String questionsImportant;
    private final String answersImportant;
    private final String numberImportant;

    public ExaminFooterText(String questionsImportant, String answersImportant, String numberImportant) {
        this.questionsImportant = questionsImportant;
        this.answersImportant = answersImportant;
        this.numberImportant = numberImportant;
    }

    @Parameterized.Parameters
    public static Object[][] compareText() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "0"},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "1"},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "2"},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "3"},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "4"},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "5"},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "6"},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", "7"},
        };
    }


    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void openMainPage() throws Exception {

        WebDriver driver = factory.getDriver();
        MainFoodElementPage objQuestionFood = new MainFoodElementPage(driver);
        MainPage objMainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        objMainPage.getWebOpen();

        objMainPage.clickButterCookie();

        objQuestionFood.scrollToQuestion(numberImportant);

        objQuestionFood.clickQuestionFood(numberImportant);


        assertEquals("Вопрос под номером " + numberImportant + " не тот", objQuestionFood.getTextQuestion(numberImportant), questionsImportant);
        assertEquals("Ответ под номером " + numberImportant + " не тот", objQuestionFood.getTextAnswer(numberImportant), answersImportant);


    }

    @After
    public void tearDown() {
        factory.getDriver().quit();
    }
}

