package org.ssu.edu.teachua.ui.advanced_search;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.entities.Center;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.CenterService;
import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.service.ClubService;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchClubComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerUI;
import org.ssu.edu.teachua.utils.providers.DataProviderAdvancedSearch;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedSearchPageTest extends BaseTestRunnerUI {

    @BeforeMethod
    public void goHome() {
        driver.get(valueProvider.getBaseUiUrl());
    }

    @Issue("TUA-210")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that input field 'Вік дитини' accepts only positive integers from 2 to 18")
    @Test(dataProvider = "dpAgeFieldTest", dataProviderClass = DataProviderAdvancedSearch.class)
    public void testAgeField(List<String> age, List<String> expectedAge) {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchClubComponent advancedSearchClubComponent = new HomePage(driver)
                .clickAdvancedSearchIcon();

        String actualAgeFirst = advancedSearchClubComponent
                .clearAge()
                .setAge(age.get(0))
                .getAge();
        softAssert.assertEquals(actualAgeFirst, expectedAge.get(0), "Age has not been set correctly");

        String actualAgeSecond = advancedSearchClubComponent
                .clearAge()
                .setAge(age.get(1))
                .getAge();
        softAssert.assertEquals(actualAgeSecond, expectedAge.get(0), "Age has not been set correctly");

        String actualAgeThird = advancedSearchClubComponent
                .clearAge()
                .setAge(age.get(2))
                .getAge();
        softAssert.assertEquals(actualAgeThird, expectedAge.get(1), "Age has not been set correctly");

        String actualAgeFourth = advancedSearchClubComponent
                .clearAge()
                .setAge(age.get(3))
                .getAge();
        softAssert.assertEquals(actualAgeFourth, expectedAge.get(1), "Age has not been set correctly");

        softAssert.assertAll();
    }

    @Issue("TUA-224")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify “Advanced search” button opens “Розширений пошук” section")
    @Test
    public void testAdvancedSearchComponentIsDisplayedAndHidden() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage.clickAdvancedSearchIcon();

        AdvancedSearchCenterComponent advancedSearchCenterComponent = new AdvancedSearchCenterComponent(driver);
        boolean isAdvancedSearchModalDisplayed = advancedSearchCenterComponent.isAdvancedSearchModalDisplayed();
        softAssert.assertTrue(isAdvancedSearchModalDisplayed, "Advanced search modal should be displayed");

        homePage.clickAdvancedSearchIcon();

        isAdvancedSearchModalDisplayed = advancedSearchCenterComponent.isAdvancedSearchModalDisplayed();
        softAssert.assertFalse(isAdvancedSearchModalDisplayed, "Advanced search modal should not be displayed");
        softAssert.assertAll();
    }

    @Issue("TUA-509")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that all parameters are activated with the selected 'Гурток' radio button")
    @Test
    public void testAllParametersActivated() {
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

    @Test
    public void testSortingClubByName() throws Exception {
        Comparator<String> ascSortNameClub = (c1, c2) -> c1.compareToIgnoreCase(c2);
        Comparator<String> descSortNameClub = (c1, c2) -> c2.compareToIgnoreCase(c1);

        SoftAssert softAssert = new SoftAssert();

        AdvancedSearchClubComponent adsc = new HomePage(driver).clickAdvancedSearchIcon();

        adsc.chooseSortByName();
        adsc.chooseSortTypeAsc();
        List<String> listNameClubByNameAscSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getClubTitle).collect(Collectors.toList());

        adsc.chooseSortTypeDesc();
        List<String> listNameClubByNameDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getClubTitle).collect(Collectors.toList());

        List<String> expectListNameClubByNameAscSorting = expectListNameClubOrCenterCard(listNameClubByNameAscSorting, ascSortNameClub);
        List<String> expectListNameClubByNameDescSorting = expectListNameClubOrCenterCard(listNameClubByNameDescSorting, descSortNameClub);

        softAssert.assertEquals(listNameClubByNameAscSorting, expectListNameClubByNameAscSorting);
        softAssert.assertEquals(listNameClubByNameDescSorting, expectListNameClubByNameDescSorting);

        softAssert.assertAll();
    }

    @Test
    public void testSortingClubByRating() throws Exception {
        Comparator<Integer> ascSortRatinClub = (c1, c2) -> c1.compareTo(c2);
        Comparator<Integer> descSortRatinClub = (c1, c2) -> c2.compareTo(c1);

        SoftAssert softAssert = new SoftAssert();

        AdvancedSearchClubComponent adsc = new HomePage(driver).clickAdvancedSearchIcon();

        adsc.chooseSortByRating();
        adsc.chooseSortTypeAsc();
        List<Integer> listRatingClubByRatingAscSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getRating).collect(Collectors.toList());

        adsc.chooseSortTypeDesc();
        List<Integer> listRatingClubByRatingDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getRating).collect(Collectors.toList());

        List<Integer> expectListRatingClubByRatingAscSorting = expectListRatingClubOrCenterCard(listRatingClubByRatingAscSorting, ascSortRatinClub);
        List<Integer> expectListRatingByRatingDescSorting = expectListRatingClubOrCenterCard(listRatingClubByRatingDescSorting, descSortRatinClub);

        softAssert.assertEquals(listRatingClubByRatingAscSorting, expectListRatingClubByRatingAscSorting);
        softAssert.assertEquals(listRatingClubByRatingDescSorting, expectListRatingByRatingDescSorting);

        softAssert.assertAll();
    }

    @Test
    public void testSortingCenterByName() throws Exception {
        Comparator<String> ascSortNameCenter = (c1, c2) -> c1.compareToIgnoreCase(c2);
        Comparator<String> descSortNameCenter = (c1, c2) -> c2.compareToIgnoreCase(c1);

        SoftAssert softAssert = new SoftAssert();

        AdvancedSearchCenterComponent adsc = new HomePage(driver).clickAdvancedSearchIcon().chooseCenter();

        adsc.chooseSortByName();
        adsc.chooseSortTypeAsc();
        List<String> listNameCenterByNameAscSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getCenterTitle).collect(Collectors.toList());

        adsc.chooseSortTypeDesc();
        List<String> listNameCenterByNameDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getCenterTitle).collect(Collectors.toList());

        List<String> expectListNameCenterByNameAscSorting = expectListNameClubOrCenterCard(listNameCenterByNameAscSorting, ascSortNameCenter);
        List<String> expectListNameCenterByNameDescSorting = expectListNameClubOrCenterCard(listNameCenterByNameDescSorting, descSortNameCenter);

        softAssert.assertEquals(listNameCenterByNameAscSorting, expectListNameCenterByNameAscSorting);
        softAssert.assertEquals(listNameCenterByNameDescSorting, expectListNameCenterByNameDescSorting);

        softAssert.assertAll();
    }

    private List<String> expectListNameClubOrCenterCard(List<String> listClubCard, Comparator<String> comparatorSort) {
        List<String> copyListClubCard = new ArrayList<String>(listClubCard);
        copyListClubCard.sort(comparatorSort);
        return copyListClubCard;
    }

    private List<Integer> expectListRatingClubOrCenterCard(List<Integer> listClubCard, Comparator<Integer> comparatorSort) {
        List<Integer> copyListClubCard = new ArrayList<Integer>(listClubCard);
        copyListClubCard.sort(comparatorSort);
        return copyListClubCard;
    }

    @Issue("TUA-449")
    @Description("Verify that the user can sort the search results by rating " +
            "after clicking on the 'Центр' radio button")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testSortingCenterByRating() throws DBException, EntityException {

        CenterService centerService = new CenterService(valueProvider.getDbUrl(), valueProvider.getDbUserName(), valueProvider.getUDbUserPassword());
        AdvancedSearchCenterComponent adsc = new HomePage(driver).clickAdvancedSearchIcon().chooseCenter();

        adsc.chooseSortByRating()
                .chooseSortTypeAsc()
                .clearCity();

        List<String> sortCenterByRatingAscUi = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getCenterTitle).collect(Collectors.toList());

        adsc.chooseSortTypeDesc();

        List<String> sortCenterByRatingDescUi = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getCenterTitle).collect(Collectors.toList());

        List<String> sortCenterByRatingAscDB = centerService.getCentersByRatingAsc().stream()
                .map(Center::getName).collect(Collectors.toList());
        List<String> sortCenterByRatingDescDB = centerService.getCentersByRatingDesc().stream()
                .map(Center::getName).collect(Collectors.toList());

        softAssert.assertEquals(sortCenterByRatingAscUi, sortCenterByRatingAscDB);
        softAssert.assertEquals(sortCenterByRatingDescUi, sortCenterByRatingDescDB);

        softAssert.assertAll();
    }

    @Issue("TUA-516")
    @Severity(SeverityLevel.NORMAL)
    @Description("[Розширений пошук] Verify that the clubs can be sorted by rating")
    @Test
    public void testIfClubsSortedByRating() throws DBException, EntityException {

        ClubService clubService = entityService.getClubService();
        AdvancedSearchCenterComponent advancedSearchClub = new HomePage(driver)
                .clickAdvancedSearchIcon()
                .chooseSortByRating()
                .chooseSortTypeAsc()
                .clearCity();
        String[][] actualClubsSortedAsc = advancedSearchClub.getNamesAndRatingsOfCards();

        List<Club> clubsAscDb = clubService.getClubsSortedByRatingASC();
        String[][] expectedClubsSortedAsc = new String[clubsAscDb.size()][2];
        for (Club club : clubsAscDb) {
            expectedClubsSortedAsc[clubsAscDb.indexOf(club)][0] = club.getName();
            expectedClubsSortedAsc[clubsAscDb.indexOf(club)][1] = String.valueOf(club.getRating());
        }

        String[][] actualClubsSortedDesc = advancedSearchClub.chooseSortTypeDesc().getNamesAndRatingsOfCards();

        List<Club> clubsDescDb = clubService.getClubsSortedByRatingDESC();
        String[][] expectedClubsSortedDesc = new String[clubsDescDb.size()][2];
        for (Club club : clubsDescDb) {
            expectedClubsSortedDesc[clubsDescDb.indexOf(club)][0] = club.getName();
            expectedClubsSortedDesc[clubsDescDb.indexOf(club)][1] = String.valueOf(club.getRating());
        }

        softAssert.assertEquals(Arrays.deepToString(actualClubsSortedAsc), Arrays.deepToString(expectedClubsSortedAsc));
        softAssert.assertEquals(Arrays.deepToString(actualClubsSortedDesc), Arrays.deepToString(expectedClubsSortedDesc));
        softAssert.assertAll();
    }

    @Description("Verify that the user can sort the search results alphabetically after clicking on the 'Центр' radio button")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TUA-440")
    @Test
    public void testCentersSortAlphabetically() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        Comparator<String> sortAsc = (c1, c2) -> c1.compareToIgnoreCase(c2);
        Comparator<String> sortDesc = (c1, c2) -> c2.compareToIgnoreCase(c1);

        AdvancedSearchCenterComponent AdvancedSearchComponent = new HomePage(driver).clickAdvancedSearchIcon();
        softAssert.assertTrue(AdvancedSearchComponent.isAdvancedSearchModalDisplayed(),
                "Advanced search modal should be displayed");

        AdvancedSearchComponent.chooseCenter();
        List<String> uiCenterNames = AdvancedSearchComponent.getListCardsOnPage().stream()
                .map(ClubCardComponent::getCenterTitle)
                .collect(Collectors.toList());

        List<String> expectedNamesAsc = expectListNameClubOrCenterCard(uiCenterNames, sortAsc);
        softAssert.assertEquals(uiCenterNames, expectedNamesAsc,
                "Center names should be displayed alphabetically on UI");

        List<String> dbCenterNamesAsc = entityService.getCenterService()
                .getCentresSortedByNameAsc(true).stream()
                .map(Center::getName)
                .collect(Collectors.toList());
        softAssert.assertEquals(uiCenterNames, dbCenterNamesAsc,
                "Center names on UI should be matched with DB (ASC)");

        AdvancedSearchComponent.chooseSortTypeDesc();
        uiCenterNames = AdvancedSearchComponent.getListCardsOnPage().stream()
                .map(ClubCardComponent::getCenterTitle)
                .collect(Collectors.toList());

        List<String> expectedNamesDesc = expectListNameClubOrCenterCard(uiCenterNames, sortDesc);
        softAssert.assertEquals(uiCenterNames, expectedNamesDesc,
                "Center names should be sorted by descending on UI");

        List<String> dbCenterNamesDesc = entityService.getCenterService()
                .getCentresSortedByNameDesc(true).stream()
                .map(Center::getName)
                .collect(Collectors.toList());
        softAssert.assertEquals(uiCenterNames, dbCenterNamesDesc,
                "Center names on UI should be matched with DB (DESC)");

        softAssert.assertAll();
    }

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
