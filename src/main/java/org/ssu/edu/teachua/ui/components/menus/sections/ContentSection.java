package org.ssu.edu.teachua.ui.components.menus.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;
import org.ssu.edu.teachua.ui.pages.tasks.TasksPage;

public class ContentSection extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//div[contains(@aria-controls, 'challenges-submenu-popup')]")
    private WebElement challengesMenu;

    @FindBy(how = How.XPATH, using =
            "//ul[contains(@id, 'challenges-submenu-popup')]//a[contains(@href, 'tasks')]"
    )
    private WebElement tasksSectionNode;

    @FindBy(how = How.XPATH, using =
            "//ul[contains(@id, 'challenges-submenu-popup')]//a[contains(@href, 'challenges')]"
    )
    private WebElement challengesSectionNode;

    public ContentSection(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public ContentSection openChallengesMenu() {
        waitForElementToBeClickable(challengesMenu).click();
        return this;
    }

    public TasksPage clickTasks() {
        waitForElementToBeClickable(tasksSectionNode).click();
        return new TasksPage(driver);
    }

    public ChallengesPage clickChallenges() {
        waitForElementToBeClickable(challengesSectionNode).click();
        return new ChallengesPage(driver);
    }
}
