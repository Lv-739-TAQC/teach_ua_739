package org.ssu.edu.teachua.ui.components.menus.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;
import org.ssu.edu.teachua.ui.pages.tasks.TasksPage;

import io.qameta.allure.Step;

/**
 * This class contains methods and elements that describe the menu components for 'Content' section
 */
public class ContentSection extends BaseComponent {

    /**
     * This element finds by xPath the 'Challenges' element in the menu components for 'Content' section
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@aria-controls, 'challenges-submenu-popup')]")
    private WebElement challengesMenu;

    /**
     * This element finds by xPath the 'Tasks' element in the menu components for 'Challenges' section
     */
    @FindBy(how = How.XPATH, using =
            "//ul[contains(@id, 'challenges-submenu-popup')]//a[contains(@href, 'tasks')]"
    )
    private WebElement tasksSectionNode;

    /**
     * This element finds by xPath the 'Challenges' element in the menu components for 'Challenges' section
     */
    @FindBy(how = How.XPATH, using =
            "//ul[contains(@id, 'challenges-submenu-popup')]//a[contains(@href, 'challenges')]"
    )
    private WebElement challengesSectionNode;

    public ContentSection(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * This method is clicking on 'Challenges' element in the 'Content' section
     * which open menus challenges section
     * @return new instance of {@link ContentSection}
     */
    @Step("Click challenge button. Open menu`s challenge section.")	
    public ContentSection openChallengesMenu() {
        waitForElementToBeClickable(challengesMenu).click();
        return this;
    }

    /**
     * This method is clicking on 'Tasks' element in the 'Challenges' section
     * which open the main task page
     * @return new instance of {@link TasksPage}
     */
    @Step("Click task button. Open the main task page.")	
    public TasksPage clickTasks() {
        waitForElementToBeClickable(tasksSectionNode).click();
        return new TasksPage(driver);
    }

    /**
     * This method is clicking on 'Challenges' element in the 'Challenges' section
     * which open the main challenges page
     * @return new instance of {@link ChallengesPage}
     */
    @Step("Click challenge button. Open the main challenge page.")	
    public ChallengesPage clickChallenges() {
        waitForElementToBeClickable(challengesSectionNode).click();
        return new ChallengesPage(driver);
    }
}
