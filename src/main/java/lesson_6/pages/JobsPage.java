package lesson_6.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 *  Класс ContactsPage представляет собой страницу "Вакансии" сайта SimbirSoft
 *
 *  <p>
 *  Сделан с паттерном Page Object и предоставляет метод для проверки, открыта ли страница
 *  </p>
 *
 *
 *  <h4>Методы:</h4>
 *  <ul>
 *   <li>{@link #jobsPageIsOpen()} - выполнение проверки открыта ли страница.</li>
 *  </ul>
 *
 *  <h4>Используемые модули:</h4>
 *  <ul>
 *   <li>Selenide используется в качестве веб-драйвера</li>
 *   <li>Allure формирует отчеты</li>
 *  </ul>
 */
public class JobsPage {

    @Description("Проверить, что страница \"Вакансии\" открылась")
    @Step("Проверка вакансии")
    public JobsPage jobsPageIsOpen(){
        $(By.xpath("//h1"))
                .shouldHave(text("Вакансии"))
                .shouldBe(visible);
        return this;
    }
}
