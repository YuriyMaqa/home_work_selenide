package home_work;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SoftAssertionsTests {

    @BeforeAll
    static void setUp() {

        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void junit5SoftAssertionTest() {
        Selenide.open("https://github.com");

        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();

        //зайти в проект selenide
        $$("ul.repo-list").first().$("a").click();
        //перейти в wiki
        $("#wiki-tab").click();

        //Проверить, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAsse");
        $$("#wiki-pages-box li").shouldHave(itemWithText("SoftAssertions"));

        //Открыть страницу SoftAssertions
        $$("#wiki-pages-box li").find(text("SoftAssertions")).click();

        //Проверить что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}


// 1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
// $("h1 div");  - будет искать первый элемент в доме, в котором есть h1 и d1v)
// $("h1").$("div"); - будет искать первый элемент "h1" в доме, затем в нём уже будет искать элемент "d1v".
// в случае если в первом элементе "h1" не будет "d1v", вариант $("h1").$("div"); не найдет элемент.
