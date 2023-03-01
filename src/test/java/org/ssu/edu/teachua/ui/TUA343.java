package org.ssu.edu.teachua.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TUA343 extends TestRunnerUI{
	
	@DataProvider(name = "dpTestVerifieDataLastName")
    private Object[][] dpTestVerifieDataLastName() {
        return new Object[][]{
                {"AfBbCcDdEeFfGgHhIiJjKkLlMm", "Прізвище не може містити більше, ніж 25 символів"},
                {"!@#$%^&,", "Прізвище не може містити спеціальні символи"},
                {"1234", "Прізвище не може містити цифри"},
                {"-Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {" Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {"'Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname-", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname ", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname'", "Прізвище повинно починатися та закінчуватися літерою"},
                {" ", "Введіть прізвище"}
        };
    }
	
	@Test(dataProvider = "dpTestVerifieDataLastName")
	public void run(String enteringData, String expectedMessages ) {
	
		HomePage homePage = new HomePage(driver);
		
		EditProfileComponent editProfileComponent = homePage.getHeader()
				.openGuestProfileMenu()
				.openLogInForm()
				.enterEmail(valueProvider.getAdminEmail())
				.enterPassword(valueProvider.getAdminPassword())
				.clickLoginButton()
				.getHeader()
				.openAdminProfileMenu()
				.openProfilePage()
				.clickEditProfileButton();
		
		String actionMessages =  editProfileComponent.enterNewLastName(enteringData).getAlertMessageLastName();
								
		softAssert.assertEquals(actionMessages,expectedMessages);
		softAssert.assertTrue(editProfileComponent.getSaveChangesButton().isDisplayed());
		softAssert.assertAll();
	
	}
}
