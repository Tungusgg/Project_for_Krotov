package Test_Yandex;

import TestValues.TestVlues;
import core.BaseTest;
import org.junit.Test;

public class Tests extends BaseTest {
    /**
     * Тестовый метод выполняет проверку работоспособности переводчика
     */
    @Test
    public void checkMainFunction(){
        MainPage mainPage = new MainPage();
        mainPage.checkMainWidget()
                .yandexTranslateMessageBox(TestVlues.translate_1, TestVlues.translate_2);
    }

    /**
     * Тестовый метод проверяет наличи всплывающего после перевода мини нав бара
     */
    @Test
    public void checkMiniNavItems(){
        MainPage mainPage = new MainPage();
        mainPage.checkMainWidget()
                .yandexTranslateMessageBox(TestVlues.translate_1, TestVlues.translate_2)
                .miniNavBarBox();
    }
    /**
     * Тестовый метод проверяет кликабельность элементов хеддера
     */
    @Test
    public void checkHeaderIsClickable(){
        String suites = "Сайты";
        String documents = "Документы";
        String images = "Картинки";
        String business = "Для бизнеса";
        MainPage mainPage = new MainPage();

        mainPage.clickAndCheck(suites, TestVlues.birka_2);
        mainPage.clickAndCheck(documents, TestVlues.birka_3);
        mainPage.clickAndCheck(images, TestVlues.birka_4);
        mainPage.clickAndCheck(business, TestVlues.birka_5);
    }
    @Test
    public void checkKeyboardClickable(){
        MainPage mainPage = new MainPage();

        mainPage.clickKeyBoardButton();
        mainPage.clickSymbol("h");
        mainPage.clickSymbol("e");
        mainPage.clickSymbol("l");
        mainPage.clickSymbol("l");
        mainPage.clickSymbol("o");
        mainPage.checkWord(TestVlues.translate_1);
    }
}
