package ru.tadree;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    private static final String REPOSITORY ="Tadree/quguru_DZ_6";
    private static final String ISSUE_NAME ="TestIssue";

    @Test
    public void repositoryIssueTest(){
        open("https://github.com/");
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(By.linkText(REPOSITORY)).click();
        $(By.partialLinkText("Issues")).click();
        $(byText(ISSUE_NAME)).shouldBe(Condition.visible);
    }

}
