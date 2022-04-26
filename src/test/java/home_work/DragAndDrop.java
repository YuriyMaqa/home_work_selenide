package home_work;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DragAndDrop {

    SelenideElement
            a = $("#column-a"),
            b = $("#column-b");



    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dragAndDropTest() {
        a.dragAndDropTo(b);
        a.shouldHave(text("B"));
    }

    @Test
    void ActionTest() {
//         Selenide.actions().moveToElement(a).clickAndHold().moveToElement(b).release().build().perform();
//         Selenide.actions().moveToElement(a).clickAndHold().moveByOffset(250, 0).release().perform();
//        Selenide.actions().clickAndHold(a).moveToElement(b).release().perform();

        // все три способа не сработали, пока не нашёл рабочий способ через actions ))
    }
}
