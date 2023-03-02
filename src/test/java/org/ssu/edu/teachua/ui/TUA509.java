package org.ssu.edu.teachua.ui;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TUA509 extends TestRunnerUI {

    @Test
    public void testTUA509() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchCenterComponent advancedSearchCenterComponent = new HomePage(driver)
                .clickAdvancedSearchIcon();

        boolean isClubRadioButtonEnabled = advancedSearchCenterComponent.isClubRadioButtonSelected();
        softAssert.assertTrue(isClubRadioButtonEnabled, "Club radio button should be selected");

        boolean isCityDropdownEnabled = advancedSearchCenterComponent.isCityParameterActivated();
        softAssert.assertTrue(isCityDropdownEnabled, "City dropdown should be activated");

        boolean isDistrictDropdownEnabled = advancedSearchCenterComponent.isDistrictParameterActivated();
        softAssert.assertTrue(isDistrictDropdownEnabled, "District dropdown should be activated");

        boolean isSubwayStationDropdownEnabled = advancedSearchCenterComponent.isStationParameterActivated();
        softAssert.assertTrue(isSubwayStationDropdownEnabled, "Subway station dropdown should be activated");

        boolean isAvailableOnlineCheckboxEnabled = advancedSearchCenterComponent.isOnlineParameterActivated();
        softAssert.assertTrue(isAvailableOnlineCheckboxEnabled, "Available online checkbox should be activated");

        boolean isCategoriesCheckboxesEnabled = advancedSearchCenterComponent.isCategoriesCheckboxesActivated();
        softAssert.assertTrue(isCategoriesCheckboxesEnabled, "Categories checkboxes should be activated");

        boolean isAgeFieldEnabled = advancedSearchCenterComponent.isAgeFieldActivated();
        softAssert.assertTrue(isAgeFieldEnabled, "Age field should be activated");

        softAssert.assertAll();
    }

}






