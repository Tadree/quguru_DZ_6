package ru.tadree;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private WebSteps steps = new WebSteps();
    private static final String REPOSITORY ="Tadree/quguru_DZ_6";
    private static final String ISSUE_NAME ="TestIssue";

    @Test
    public void shouldSeeIssueInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }
}
