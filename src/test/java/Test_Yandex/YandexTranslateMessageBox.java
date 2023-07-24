package Test_Yandex;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexTranslateMessageBox extends MainPage{
    @FindBy(xpath =  "//button[@id='textSpeaker']")
    private WebElement textSpeakerButton;
    @FindBy(xpath = "//button[@id='microphone']")
    private WebElement microphoneButton;
    @FindBy(xpath = "//button[@id='copySrcButton']")
    private WebElement copySrcButton;
    @FindBy(xpath = "//button[@id='keyboardButton']")
    private WebElement keyBoardButton;
    @FindBy(xpath = "//button[@id='translatorSpeaker']")
    private WebElement translatorSpeakerButton;
    @FindBy(xpath = "//button[@id='favButton']")
    private WebElement favButton;
    @FindBy(xpath = "//button[@id='shareButton']")
    private WebElement shareButton;
    public YandexTranslateMessageBox(){
        PageFactory.initElements(driver, this);
    }
}
