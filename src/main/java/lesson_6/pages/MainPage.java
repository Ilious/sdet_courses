package lesson_6.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс MainPage представляет собой основную страницу сайта SimbirSoft
 *
 * <p>
 * Сделан с паттерном Page Object и предоставляет методы для взаимодействия
 * с одними из ключевых элементов страницы такими кнопками, как "Написать нам" и "Контакты".
 * </p>
 *
 *
 * <h4>Методы:</h4>
 * <ul>
 *  <li>{@link #showFeedbackModal()} - открытие модального окна с формой для обратной связи.</li>
 *  <li>{@link #goToContacts()} - переход на страницу "Контакты".</li>
 *  <li>{@link #goToJobsByTextButton()} - переход на страницу "Вакансии" с помощью кнопки "Все вакансии".</li>
 *  <li>{@link #goToJobs()} - переход на страницу "Вакансии" с помощью навигационного меню.</li>
 *  <li>{@link #checkJobs()} - проверка отображения ровно 4х вакансий на основной странице.</li>
 * </ul>
 *
 * <h4>Используемые модули:</h4>
 * <ul>
 *  <li>Selenide используется в качестве веб-драйвера</li>
 *  <li>Allure формирует отчеты</li>
 * </ul>
 */
public class MainPage {

    /**
     * Кнопка для открытия модального окна обратной связи.
     */
    @FindBy(xpath = "//a[@data-gclick='showModalFeedback']")
    private SelenideElement feedbackButton;

    /**
     * Кнопка для открытия страницы "Вакансии".
     */
    @FindBy(xpath = "//*[contains(@class,\"gh-nav-item\")]//child::*[text()=\"Вакансии\"]")
    private SelenideElement jobsButton;

    /**
     * Элемент "О нас", который при наведении, показывает в меню кнопку "Контакты".
     */
    @FindBy(xpath = "//*[contains(@class, \"gh-nav-item--about\")]")
    private SelenideElement navItemAbout;

    /** Путь до элемента списка "Вакансии", который должен отображать 4 вакансии. */
    final String XP_LIST_JOBS = "//*[contains(@class, \"m-section\")]//child::*[@class=\"is-list-vacancy-a\"]";

    /** Список вакансий в низу страницы */
    @FindBy(xpath = XP_LIST_JOBS)
    private SelenideElement listJobs;

    @Description("Проверить, что кнопка 'Написать нам' присутствует и кликабельная")
    @Step("Открытие модального окна \"Написать нам\"")
    public FeedbackModal showFeedbackModal() {
        feedbackButton
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        return page(FeedbackModal.class);
    }

    @Description("Проверить, что при наведении на элемент меню 'О наc' появляется ссылка \"Контакты\"")
    @Step("Переход на \"Контакты\"")
    public ContactsPage goToContacts() {
        navItemAbout.shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .shouldHave(text("Контакты"))
                .click();
        return page(ContactsPage.class);
    }

    @Description("Проверить, что кнопка Вакансии в основном меню есть и идет переход на страницу \"Вакансии\"")
    @Step("Переход на \"Вакансии\"(меню)")
    public JobsPage goToJobs() {
        jobsButton
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Вакансии"))
                .click();
        return page(JobsPage.class);
    }

    @Description("Проверить отображается ли 4 вакансии на основной странице")
    @Step("Проверить вакансии")
    public MainPage checkJobs() {
        int actualSize = listJobs.$$(By.xpath(".//*[@class='grid-item']"))
                .filter(exist)
                .filter(visible)
                .size();
        assert actualSize == 4 : "Expected size 4, but found " + actualSize;
        return this;
    }

    @Description("Проверить работает ли кнопка \"Все вакансии\" в низу страницы")
    @Step("Проверить кнопку \"Все вакансии\"")
    public JobsPage goToJobsByTextButton() {
        $(By.xpath("//..//*[contains(text(),'Все вакансии')]")).scrollIntoView("{block: 'center'}")
                .should(exist)
                .shouldBe(visible)
                .click();


        $(By.xpath("//h1"))
                .shouldHave(text("Вакансии"));

        return page(JobsPage.class);
    }
}
