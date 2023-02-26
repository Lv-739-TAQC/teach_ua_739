package org.ssu.edu.teachua.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.ssu.edu.teachua.ui.pages.clubs.AdvancedSearchClubsPage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tua103 extends TestRunnerUI{
	HomePage homePage;
	AdvancedSearchClubsPage  ascp;
	
	@BeforeMethod
	public void openAdvancedSearchClubsPage() {
		homePage = new HomePage(driver);
		ascp = homePage.openAdvancedSearchPage();
	}
	
	@Test
	public void testSortingByNameClubByAlphabeticaltSort() throws Exception {
		Comparator<String> ascSortTextClubCardSort = (c1, c2) -> c2.compareTo(c1);
		Comparator<String> descSortTextClubCardSort = (c1, c2) -> c1.compareTo(c2);
		List<String> listNameClubCardAlphabeticalSortingAscSorting = 
					ascp.clickRadioButtonCenter()
					.clickAlphabeticalSorting()
					.clickAscSorting().listClubCard()
					.stream().map(card -> card.getClubTitle().getText()).toList();
		
		List<String> listNameClubCardAlphabeticalSortingDescSorting = 
				ascp.clickRadioButtonCenter()
				.clickAlphabeticalSorting()
				.clickDescSorting().listClubCard()
				.stream().map(card -> card.getClubTitle().getText()).toList();
		
		List<String> expectListNameClubCardAlphabeticalSortingAscSorting = expectListNameClubOrCenterCard(listNameClubCardAlphabeticalSortingAscSorting,ascSortTextClubCardSort);
		List<String> expectListNameClubCardAlphabeticalSortingDescSorting = expectListNameClubOrCenterCard(listNameClubCardAlphabeticalSortingDescSorting,descSortTextClubCardSort);
		
		Assert.assertEquals(listNameClubCardAlphabeticalSortingAscSorting, expectListNameClubCardAlphabeticalSortingAscSorting);
		Assert.assertEquals(listNameClubCardAlphabeticalSortingDescSorting, expectListNameClubCardAlphabeticalSortingDescSorting);
	}
	
	@Test
	public void testSortingByNameClubByRatingSort() throws Exception {
		Comparator<Integer> ascSortRatinClubCardSort = (c1, c2) -> c2.compareTo(c1);
		Comparator<Integer> descSortRatinClubCardSort = (c1, c2) -> c1.compareTo(c2);
		
		List<Integer> listRatingClubCardRatingSortingAscSorting = 
				ascp.clickRadioButtonCenter().clickRatingSorting().clickAscSorting().listClubCard()
				.stream().map(card -> card.ratingClub()).toList();
		List<Integer> listRatingClubCardRatingSortingDescSorting = 
				ascp.clickRadioButtonCenter().clickRatingSorting().clickDescSorting().listClubCard()
				.stream().map(card -> card.ratingClub()).toList();
		
		List<Integer> expectListRatingClubCardRatingSortingAscSorting = expectListRatingClubOrCenterCard(listRatingClubCardRatingSortingAscSorting,ascSortRatinClubCardSort);
		List<Integer> expectListRatingClubCardRatingSortingDescSorting = expectListRatingClubOrCenterCard(listRatingClubCardRatingSortingDescSorting,descSortRatinClubCardSort);
		
		Assert.assertEquals(listRatingClubCardRatingSortingAscSorting, expectListRatingClubCardRatingSortingAscSorting);
		Assert.assertEquals(listRatingClubCardRatingSortingDescSorting, expectListRatingClubCardRatingSortingDescSorting);
	}
	@Test
	public void testSortingByNameCenterByAlphabeticaltSort() throws Exception {
		Comparator<String> ascSortTextCenterCardSort = (c1, c2) -> c2.compareTo(c1);
		Comparator<String> descSortTextCenterCardSort = (c1, c2) -> c1.compareTo(c2);
		List<String> listNameCenterCardAlphabeticalSortingAscSorting = 
					ascp.clickRadioButtonCenter()
					.clickAlphabeticalSorting()
					.clickAscSorting().listClubCard()
					.stream().map(card -> card.getClubTitle().getText()).toList();
		
		List<String> listNameCenterCardAlphabeticalSortingDescSorting = 
				ascp.clickRadioButtonCenter()
				.clickAlphabeticalSorting()
				.clickDescSorting().listClubCard()
				.stream().map(card -> card.getClubTitle().getText()).toList();
		
		List<String> expectListNameCenterCardAlphabeticalSortingAscSorting = expectListNameClubOrCenterCard(listNameCenterCardAlphabeticalSortingAscSorting,ascSortTextCenterCardSort);
		List<String> expectListNameCenterCardAlphabeticalSortingDescSorting = expectListNameClubOrCenterCard(listNameCenterCardAlphabeticalSortingDescSorting,descSortTextCenterCardSort);
		
		Assert.assertEquals(listNameCenterCardAlphabeticalSortingAscSorting, expectListNameCenterCardAlphabeticalSortingAscSorting);
		Assert.assertEquals(listNameCenterCardAlphabeticalSortingDescSorting, expectListNameCenterCardAlphabeticalSortingDescSorting);
	}
	
	private List<String> expectListNameClubOrCenterCard(List<String> listClubCard, Comparator<String> comparatorSort){
		 List<String> copyListClubCard =  new ArrayList<String>(listClubCard);
		 copyListClubCard.sort(comparatorSort);
		 return copyListClubCard;
	}
	private List<Integer> expectListRatingClubOrCenterCard(List<Integer> listClubCard, Comparator<Integer> comparatorSort){
		 List<Integer> copyListClubCard =  new ArrayList<Integer>(listClubCard);
		 copyListClubCard.sort(comparatorSort);
		 return copyListClubCard;
	}

}
