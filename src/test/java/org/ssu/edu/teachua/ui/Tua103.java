package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchClubComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tua103 extends BaseTestRunnerUI {

    @Test
    public void testSortingClubByName() throws Exception {
        Comparator<String> ascSortNameClub = (c1, c2) -> c2.compareTo(c1);
        Comparator<String> descSortNameClub = (c1, c2) -> c1.compareTo(c2);

        HomePage homePage = new HomePage(driver);
        AdvancedSearchClubComponent adsc = homePage.clickAdvancedSearchIcon();
        adsc.chooseSortByName();

        adsc.chooseSortTypeAsc();
        List<String> listNameClubByNameAscSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getClubTitle).collect(Collectors.toList());

        adsc.chooseSortTypeDesc();
        List<String> listNameClubByNameDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getClubTitle).collect(Collectors.toList());

        List<String> expectListNameClubByNameAscSorting = expectListNameClubOrCenterCard(listNameClubByNameAscSorting, ascSortNameClub);
        List<String> expectListNameClubByNameDescSorting = expectListNameClubOrCenterCard(listNameClubByNameDescSorting, descSortNameClub);

        Assert.assertEquals(listNameClubByNameAscSorting, expectListNameClubByNameAscSorting);
        Assert.assertEquals(listNameClubByNameDescSorting, expectListNameClubByNameDescSorting);
    }

    @Test
    public void testSortingClubByRating() throws Exception {
        Comparator<Integer> ascSortRatinClub = (c1, c2) -> c2.compareTo(c1);
        Comparator<Integer> descSortRatinClub = (c1, c2) -> c1.compareTo(c2);

        HomePage homePage = new HomePage(driver);
        AdvancedSearchClubComponent adsc = homePage.clickAdvancedSearchIcon();
        adsc.chooseSortByRating();

        adsc.chooseSortTypeAsc();
        List<Integer> listRatingClubByRatingAscSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getRating).collect(Collectors.toList());

        adsc.chooseSortTypeDesc();
        List<Integer> listRatingClubByRatingDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getRating).collect(Collectors.toList());

        List<Integer> expectListRatingClubByRatingAscSorting = expectListRatingClubOrCenterCard(listRatingClubByRatingAscSorting, ascSortRatinClub);
        List<Integer> expectListRatingByRatingDescSorting = expectListRatingClubOrCenterCard(listRatingClubByRatingDescSorting, descSortRatinClub);

        Assert.assertEquals(listRatingClubByRatingAscSorting, expectListRatingClubByRatingAscSorting);
        Assert.assertEquals(listRatingClubByRatingDescSorting, expectListRatingByRatingDescSorting);
    }

    @Test
    public void testSortingCenterByName() throws Exception {
        Comparator<String> ascSortNameCenter = (c1, c2) -> c2.compareTo(c1);
        Comparator<String> descSortNameCenter = (c1, c2) -> c1.compareTo(c2);

        HomePage homePage = new HomePage(driver);
        AdvancedSearchCenterComponent adsc = homePage.clickAdvancedSearchIcon().chooseCenter();
        adsc.chooseSortByName();

        adsc.chooseSortTypeAsc();
        List<String> listNameCenterByNameAscSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getClubTitle).collect(Collectors.toList());

		adsc.chooseSortTypeDesc();
        List<String> listNameCenterByNameDescSorting = adsc.getListCardsOnPage().stream()
                .map(ClubCardComponent::getClubTitle).collect(Collectors.toList());

        List<String> expectListNameCenterByNameAscSorting = expectListNameClubOrCenterCard(listNameCenterByNameAscSorting, ascSortNameCenter);
        List<String> expectListNameCenterByNameDescSorting = expectListNameClubOrCenterCard(listNameCenterByNameDescSorting, descSortNameCenter);

        Assert.assertEquals(listNameCenterByNameAscSorting, expectListNameCenterByNameAscSorting);
        Assert.assertEquals(listNameCenterByNameDescSorting, expectListNameCenterByNameDescSorting);
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

}
