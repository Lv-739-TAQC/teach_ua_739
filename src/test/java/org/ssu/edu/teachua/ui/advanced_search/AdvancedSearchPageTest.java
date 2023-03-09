package org.ssu.edu.teachua.ui.advanced_search;

import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchClubComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.ssu.edu.teachua.utils.providers.DataProviderAdvancedSearch;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdvancedSearchPageTest extends BaseTestRunnerUI {

    @Test (dataProvider = "dpAgeFieldTest", dataProviderClass = DataProviderAdvancedSearch.class)
    public void AgeFieldTest(List<String> age, List<String> expectedAge) {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchClubComponent advancedSearchClubComponent = new HomePage(driver)
                .clickAdvancedSearchIcon();

        String actualAgeFirst = advancedSearchClubComponent
                .setAge(age.get(0))
                .getAge();
        softAssert.assertEquals(actualAgeFirst, expectedAge.get(0), "Age has not been set correctly");

        String actualAgeSecond = advancedSearchClubComponent
                .setAge(age.get(1))
                .getAge();
        softAssert.assertEquals(actualAgeSecond, expectedAge.get(0), "Age has not been set correctly");

        String actualAgeThird = advancedSearchClubComponent
                .setAge(age.get(2))
                .getAge();
        softAssert.assertEquals(actualAgeThird, expectedAge.get(1), "Age has not been set correctly");

        String actualAgeFourth = advancedSearchClubComponent
                .setAge(age.get(3))
                .getAge();
        softAssert.assertEquals(actualAgeFourth,  expectedAge.get(1), "Age has not been set correctly");

        softAssert.assertAll();
    }

    @Test
    public void advancedSearchComponentIsDisplayedAndHiddenTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage
                .clickAdvancedSearchIcon();

        AdvancedSearchCenterComponent advancedSearchCenterComponent = new AdvancedSearchCenterComponent(driver);
        boolean isAdvancedSearchModalDisplayed = advancedSearchCenterComponent.isAdvancedSearchModalDisplayed();
        softAssert.assertTrue(isAdvancedSearchModalDisplayed, "Advanced search modal should be displayed");

        homePage
                .clickAdvancedSearchIcon();

        isAdvancedSearchModalDisplayed = advancedSearchCenterComponent.isAdvancedSearchModalDisplayed();
        softAssert.assertFalse(isAdvancedSearchModalDisplayed,"Advanced search modal should not be displayed");
        softAssert.assertAll();
    }

    @Test
    public void allParametersActivatedTest() {
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
