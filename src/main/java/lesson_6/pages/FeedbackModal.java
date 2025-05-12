package lesson_6.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


/**
 *  Класс Feedback представляет собой модальное окно "Написать нам" сайта SimbirSoft
 *
 *  <p>
 *  Сделан с паттерном Page Object и предоставляет методы для взаимодействия с модальным окном и его элементом таким,
 *  как текстовое поле для ввода "Имя или организация"
 *  </p>
 *
 *
 *  <h4>Методы:</h4>
 *  <ul>
 *   <li>{@link #checkModalWindowVisible()} - выполнение проверки, видно ли модальное окно.</li>
 *   <li>{@link #checkTextInput()} - выполнение проверки, есть ли у модального окна текстовое поле для ввода "Имя или
 *   организация".</li>
 *  </ul>
 *
 *  <h4>Используемые модули:</h4>
 *  <ul>
 *   <li>Selenide используется в качестве веб-драйвера</li>
 *   <li>Allure формирует отчеты</li>
 *  </ul>
 */
public class FeedbackModal {

    /** Ссылка на модальное окно "Написать нам" в виде xpath. */
    final String FEEDBACK_MODAL = "//*[@class='fmo-parent']//*[@class='fb-modal-default']";

    /** Модальное окно. */
    @FindBy(xpath = FEEDBACK_MODAL)
    private SelenideElement feedbackModalWindow;

    /** Элементы модального окна для взаимодействия с ним такие, как "Имя или организация". */
    @FindBy(xpath = FEEDBACK_MODAL + "//input[@data-clear=\"text\"]/../..")
    private SelenideElement inputText;

    @Description("Проверяется, что модальное окно \"Обратная связь\" отобразилось на странице")
    @Step("Проверка модального окна")
    public FeedbackModal checkModalWindowVisible() {
        feedbackModalWindow.shouldBe(visible);
        return this;
    }

    @Description("Проверяется, что текстовое поле 'Имя или организация' присутствует")
    @Step("Проверка поля ввода")
    public FeedbackModal checkTextInput() {
        feedbackModalWindow
                .shouldBe(visible)
                .shouldHave(text("Имя или организация"));
        return this;
    }
}
