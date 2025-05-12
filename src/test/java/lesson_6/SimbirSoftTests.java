package lesson_6;

import lesson_6.dao.Person;
import lesson_6.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class SimbirSoftTests extends BaseTest implements IJobsTestable {

    @BeforeMethod
    void initBeforeMethod() {
        open("/");
    }

    @Test(description = "show feedback modal window test")
    public void feedbackModalOpenTest() {
         page(MainPage.class)
                 .showFeedbackModal()
                .checkModalWindowVisible()
                 .checkTextInput();
        sleep(5000);
    }

    @Test(description = "Open contacts page test")
    public void openContactsPage() {
        page(MainPage.class)
                .goToContacts()
                .contactsPageIsOpen();
        sleep(5000);
    }

    @Test(description = "Create Person test")
    public void createPersonTest() {
        Person person = new Person.Builder()
                .withName("Testoviy Test Testovich")
                .withAge(45)
                .withWeight(80)
                .build();
    }

    @Override
    @Test(description = "Is jobs page opened (by nav menu) test")
    public void jobsTest(){
        page(MainPage.class)
                .goToJobs()
                .jobsPageIsOpen();
        sleep(5000);
    }

    @Override
    @Test(description = "Are 4 work shown test")
    public void jobsBellowTest(){
        page(MainPage.class)
                .checkJobs();
    }

    @Override
    @Test(description = "Open jobs page by textButton bellow")
    public void JobsOnPageTest() {
        page(MainPage.class)
                .goToJobsByTextButton()
                .jobsPageIsOpen();
        sleep(5_000);
    }
}
