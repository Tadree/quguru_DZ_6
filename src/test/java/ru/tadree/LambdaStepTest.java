package ru.tadree;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private static final String REPOSITORY ="Tadree/quguru_DZ_6";
    private static final String ISSUE_NAME ="TestIssue";

    @Test
    public void repositoryIssueTest(){
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий", () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем, что отображается Issue с названием" + ISSUE_NAME, () -> {
            $(byText(ISSUE_NAME)).shouldBe(Condition.visible);
        });
    }

}
