package lesson_5;

import com.codeborne.selenide.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SimbirSoftTests {
    private static Logger _logger;

    @BeforeClass
    void init(){
        _logger = (Logger) LogManager.getLogger(SimbirSoftTests.class);
        Configuration.baseUrl = "https://www.simbirsoft.com/";
//        Configuration.headless = true;

        _logger.info("configuration intialized");
    }

    @Test
    void bankFeedbackTest(){
        _logger.debug("SimbirSoftTest.bankFeedbackTest");
        open(baseUrl);

        $(By.xpath("//*[contains(@class, 'gh-nav-item--solutions')]"))
                .shouldHave(text("Решения"))
                .hover();
        $(By.linkText("Для банков"))
                .shouldHave(text("Для банков"))
                .click();
        webdriver().driver().switchTo().window(1);
        Assert.assertEquals(webdriver().driver().getCurrentFrameUrl(), baseUrl + "finance/","opened" +
                " page doesn't equal banks");

        $(By.xpath("//a[@class='order-service' and contains(@data-name,'Оставить')]"))
                .shouldHave(text("Оставить заявку"))
                .click();
    }

    @Test
    void test(){
        _logger.debug("SimbirSoftTest.test");
        open(baseUrl);

        $(By.xpath("//div[@class=\"gh-nav-item \"]//a[contains(text(), \"Вакансии\")]"))
                .shouldHave(text("Вакансии"))
                .click();
        $(By.xpath("//div[contains(@class,\"list-layout-more--toggle\")]//div"))
                .shouldHave(text("Показать еще"))
                .click();
        $(By.xpath("//*[@class=\"is-header-layout-b\"]//a[@data-name=\"Искусственный интеллект\"]"))
                .shouldHave(text("Искусственный интеллект"))
                .click();
    }
}
