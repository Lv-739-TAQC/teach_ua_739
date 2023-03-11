package org.ssu.edu.teachua.ui;

import io.qameta.allure.Issue;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvancedSearchTest extends BaseTestRunnerUI {

    @Issue(value = "TUA-510")
    @Test(description = "[Розширений пошук] Verify that 'Доступний онлайн', 'Категорії', 'Вік дитини' parameters are deactivated after selecting 'Центр' radio button")
    public void verifyThatAvailableOnlineCategoriesChildAgeParametersAreDeactivated() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchCenterComponent advancedSearchCenterComponent = new HomePage(driver)
                .clickAdvancedSearchIcon()
                .chooseCenter();

        softAssert.assertTrue(advancedSearchCenterComponent.isOnlineParameterDeactivated(), "Online parameter is activated");
        softAssert.assertTrue(advancedSearchCenterComponent.isCategoriesParameterDeactivated(), "Categories parameter is activated");
        softAssert.assertTrue(advancedSearchCenterComponent.isChildAgeParameterDeactivated(), "Child age parameter is activated");
        softAssert.assertAll();
    }


}
