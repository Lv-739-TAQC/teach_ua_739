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

public class Tua356 extends TestRunnerUI {

	@DataProvider(name = "dpTestVerifieDataLastName")
	private Object[][] dpTestVerifieDataLastName() {
		return new Object[][] { 
				{ "+3806895", "Телефон не відповідає формату +38(___) ___ __ __" },
				{ "+38065987458", "Телефон не відповідає формату +38(___) ___ __ __" },
				{ "+3806593859632586", "Телефон не відповідає формату +38(___) ___ __ __" },
				{ "+3806598521475", "Телефон не відповідає формату +38(___) ___ __ __" },
				{ "jngeoлщшогнеп", "Телефон не відповідає формату +38(___) ___ __ __" },
				{ "!@#$%^&*(_+.:", "Телефон не відповідає формату +38(___) ___ __ __" },
				{ "", "Телефон не відповідає формату +38(___) ___ __ __" } };
	}
	
	@Test(dataProvider = "dpTestVerifieDataLastName")
	public void run(String enteringData, String expectedMessages) {

		HomePage homePage = new HomePage(driver);

		EditProfileComponent editProfileComponent = homePage.getHeader().openGuestProfileMenu().openLogInForm()
				.enterEmail(valueProvider.getAdminEmail()).enterPassword(valueProvider.getAdminPassword())
				.clickLoginButton().getHeader().openAdminProfileMenu().openProfilePage().clickEditProfileButton();

		String actionMessages = editProfileComponent.enterNewPhone(enteringData).getAlertMessagePhone();
		
		softAssert.assertEquals(actionMessages, expectedMessages);
		softAssert.assertTrue(editProfileComponent.getSaveChangesButton().isDisplayed());
		softAssert.assertAll();

	}
}