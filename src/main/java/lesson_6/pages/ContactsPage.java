package lesson_6.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


/**
 *  Класс ContactsPage представляет собой страницу "Контакты" сайта SimbirSoft
 *
 *  <p>
 *  Сделан с паттерном Page Object и предоставляет метод для проверки, открыта ли страница
 *  </p>
 *
 *
 *  <h4>Методы:</h4>
 *  <ul>
 *   <li>{@link #contactsPageIsOpen()} - выполнение проверки открыта ли страница.</li>
 *  </ul>
 *
 *  <h4>Используемые модули:</h4>
 *  <ul>
 *   <li>Selenide используется в качестве веб-драйвера</li>
 *   <li>Allure формирует отчеты</li>
 *  </ul>
 */
public class ContactsPage {

    @Description("Проверить, что страница \"Контакты\" открылась")
    @Step("Проверка \"Контакты\"")
    public ContactsPage contactsPageIsOpen() {
        $(By.xpath("//h1"))
                .shouldHave(text("Контакты"))
                .shouldBe(visible);
        return this;
    }
}
