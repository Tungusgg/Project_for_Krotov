package Test_Yandex;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(@title, 'Переводчик')]")
    private WebElement headerLogo;
    @FindBy(xpath = "//nav[@class='header-nav']//a[contains(text(), 'Текст')]")
    private WebElement textButton;
    @FindBy(xpath = "//nav[@class='header-nav']//a[contains(text(), 'Сайты')]")
    private WebElement sitesButton;
    @FindBy(xpath = "//nav[@class='header-nav']//a[contains(text(), 'Документы')]")
    private WebElement documentButton;
    @FindBy(xpath = "//nav[@class='header-nav']//a[contains(text(), 'Картинки')]")
    private WebElement imagesButton;
    @FindBy(xpath = "//nav[@class='header-nav']//a[contains(text(), 'Для бизнеса')]")
    private WebElement busyButton;
    @FindBy(xpath = "//button[@id='userButton']")
    private WebElement userButton;
    @FindBy(xpath = "//div[@id='fakeArea']")
    private WebElement inputField;
    @FindBy(xpath = "//ul[@id='miniNav-items']//li[contains(., 'Словарь')]")
    private WebElement dictionary;
    @FindBy(xpath = "//ul[@id='miniNav-items']//li[contains(., 'Связанные слова')]")
    private WebElement relateWords;
    @FindBy(xpath = "//ul[@id='miniNav-items']//li[contains(., 'Склонения и спряжения')]")
    private WebElement declensions;
    @FindBy(xpath = "//button[@id='keyboardButton']")
    private WebElement keyBoardButton;

    public MainPage(){
        driver.get("https://translate.yandex.ru/");
        PageFactory.initElements(driver, this);
    }

    /**
     *  Метод проверяет наличие наличие основных виджетов
     */
    public MainPage checkMainWidget(){
        headerLogo.isDisplayed();
        textButton.isDisplayed();
        sitesButton.isDisplayed();
        documentButton.isDisplayed();
        imagesButton.isDisplayed();
        busyButton.isDisplayed();
        userButton.isDisplayed();
        return this;
    }

    /**
     * Метод проверяет, что в поле справа отображается перевод
     */
    public YandexTranslateMessageBox yandexTranslateMessageBox(String translate_1, String translate_2){
        String translates = "//pre[@id='translation']//span[contains(text(), '" + translate_2 + "')]";
        inputField.click();
        inputField.sendKeys(translate_1);
        driver.findElement(By.xpath(translates)).isDisplayed();
       return new YandexTranslateMessageBox();
    }
    /**
     * Метод проверяет наличие элементов всплывающего мини навбара
     */
    public YandexTranslateMessageBox miniNavBarBox(){
        dictionary.isDisplayed();
        declensions.isDisplayed();
        relateWords.isDisplayed();
        return new YandexTranslateMessageBox();
    }

    /**
     * Клик по элементу из хедера
     */
    public void clickHeaderElement(String nameElement){
        String element = "//nav[@class='header-nav']//a[contains(text(), '"+ nameElement +"')]";
        driver.findElement(By.xpath(element)).click();
    }

    /**
     * Метод кликает, проверяет переход и возвращает нас назад
     * @param click - куда кликаем
     * @param check - что проверяем
     */
    public void clickAndCheck(String click, String check){
        clickHeaderElement(click);
        driver.findElement(By.xpath(check)).isDisplayed();
        driver.navigate().back();
    }

    /**
     * Метод делает клик по иконке кейборда
     */
    public void clickKeyBoardButton(){
        keyBoardButton.click();
    }
    /**
     * Метод делает клик по нужному нам символу
     * @param symbol
     */
    public void clickSymbol(String symbol){
        String keyWord = "//div[contains(@role, 'button') and contains(., '"+ symbol +"')]";
        driver.findElement(By.xpath(keyWord)).click();
    }
    /**
     * Метод проверяет введённое нами слово для перевода
     */
    public void checkWord(String word){
        String words = "//div[contains(@id, 'fakeArea') and contains(., '"+ word +"')]";
        driver.findElement(By.xpath(words)).isDisplayed();
    }
}
