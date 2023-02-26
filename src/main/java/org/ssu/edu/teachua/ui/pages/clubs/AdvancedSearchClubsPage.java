package org.ssu.edu.teachua.ui.pages.clubs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;

public class AdvancedSearchClubsPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'за алфавітом')]")
	private WebElement alphabeticalSorting;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'за рейтингом')]")
	private WebElement ratingSorting;
	@FindBy(how = How.XPATH, using = "//span[contains(@aria-label, 'arrow-up')]")
	private WebElement ascSorting;
	@FindBy(how = How.XPATH, using = "//span[contains(@aria-label, 'arrow-down')]")
	private WebElement descSorting;
	@FindBy(how = How.XPATH, using = "//label[contains(@class, 'ant-radio-wrapper')]//span[contains(text(),'Гурток')]")
	private WebElement radioButtonClub;
	@FindBy(how = How.XPATH, using = "//label[contains(@class, 'ant-radio-wrapper')]//span[contains(text(),'Центр')]")
	private WebElement radiobuttonCenter;
	

	
	public AdvancedSearchClubsPage(WebDriver driver) {
		super(driver);
	}
	
	public AdvancedSearchClubsPage clickAlphabeticalSorting(){
		sleep(1);
		waitForElementToAppear(alphabeticalSorting).click();
		return this;
	}
	public AdvancedSearchClubsPage clickRatingSorting(){
		sleep(1);
		waitForElementToAppear(ratingSorting).click();
		return this;
	}
	
	public AdvancedSearchClubsPage clickAscSorting(){
		sleep(1);
		waitForElementToAppear(ascSorting).click();
		return this;
	}
	public AdvancedSearchClubsPage clickDescSorting(){
		sleep(1);
		waitForElementToAppear(descSorting).click();
		return this;
	}
	
	public AdvancedSearchClubsPage clickRadioButtonClub(){
		sleep(2);
		waitForElementToAppear(radioButtonClub).click();
		return this;
	}
	public AdvancedSearchClubsPage clickRadioButtonCenter(){
		sleep(2);
		waitForElementToAppear(radiobuttonCenter).click();
		return this;
	}
	
	public List<ClubCardComponent> listClubCard(){
		sleep(3);
		List<WebElement> listClubCard = waitForElementsToAppear(driver.findElements(By.className("ant-card-body")));
		return listClubCard.stream().map(wb -> new ClubCardComponent(driver, wb)).toList();
	}
}
