package org.ssu.edu.teachua.ui.advanced_search;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.ssu.edu.teachua.db.entities.Center;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchClubComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerUI;
import org.ssu.edu.teachua.utils.providers.DataProviderAdvancedSearch;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AdvancedSearchPageTest extends BaseTestRunnerUI {

    @Issue("TUA-210")
    @Description ("Verify that input field 'Вік дитини' accepts only positive integers from 2 to 18")
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
    @Description ("Verify “Advanced search” button opens “Розширений пошук” section")
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
    @Description ("Verify that all parameters are activated with the selected 'Гурток' radio button")
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
                .map(ClubCardComponent::getClubTitle).collect(toList());
        
        adsc.chooseSortTypeDesc();
        List<String> listNameClubByNameDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getClubTitle).collect(toList());
        
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
                .map(ClubCardComponent::getRating).collect(toList());

        adsc.chooseSortTypeDesc();
        List<Integer> listRatingClubByRatingDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getRating).collect(toList());

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
                .map(ClubCardComponent::getCenterTitle).collect(toList());

		adsc.chooseSortTypeDesc();
        List<String> listNameCenterByNameDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getCenterTitle).collect(toList());

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

    @Description("Verify that the user can sort the search results alphabetically after clicking on the 'Центр' radio button")
    @Issue("TUA-440")
    @Test
    public void testCentersSortAlphabetically() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        Comparator<String> sortAsc = String::compareToIgnoreCase;
        Comparator<String> sortDesc = (s1, s2) -> s2.compareToIgnoreCase(s1);

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

}
