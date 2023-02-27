package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedSearchTest extends TestRunnerUI {

    @Test
    public void verifyThatAvailableOnlineCategoriesChildAgeParametersAreDeactivatedAfterSelectingCenterRadioButton() {
        AdvancedSearchCenterComponent advancedSearchCenterComponent =new HomePage(driver)
                .clickAdvancedSearchIcon()
                .chooseCenter();

        Assert.assertTrue(advancedSearchCenterComponent.isOnlineParameterDeactivated(), "Online parameter is activated");
        Assert.assertTrue(advancedSearchCenterComponent.isCategoriesParameterDeactivated(), "Categories parameter is activated");
        Assert.assertTrue(advancedSearchCenterComponent.isChildAgeParameterDeactivated(), "Child age parameter is activated");
    }
}
