package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvancedSearchTest extends TestRunnerUI {

    @Test
    public void verifyThatAvailableOnlineCategoriesChildAgeParametersAreDeactivatedAfterSelectingCenterRadioButton() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchCenterComponent advancedSearchCenterComponent =new HomePage(driver)
                .clickAdvancedSearchIcon()
                .chooseCenter();

        softAssert.assertTrue(advancedSearchCenterComponent.isOnlineParameterDeactivated(), "Online parameter is activated");
        softAssert.assertTrue(advancedSearchCenterComponent.isCategoriesParameterDeactivated(), "Categories parameter is activated");
        softAssert.assertTrue(advancedSearchCenterComponent.isChildAgeParameterDeactivated(), "Child age parameter is activated");
        softAssert.assertAll();
    }
}
