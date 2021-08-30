package ru.tadree;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository){
        $(".header-search-input").setValue(repository).submit();
    }
    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository){
        $(By.linkText(repository)).click();
    }
    @Step("Переходим в раздел Issues")
    public void openIssueTab(){
        $(By.partialLinkText("Issues")).click();
    }
    @Step("Проверяем, что отображается Issue с названием {issue_name}")
    public void shouldSeeIssueWithName(String issue_name){
        $(byText(issue_name)).shouldBe(Condition.visible);
    }
}
