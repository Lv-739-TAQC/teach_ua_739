package org.ssu.edu.teachua.ui.add_club_component;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.providers.AddClubComponentProvider;
import org.ssu.edu.teachua.ui.runners.LoginRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddClubTest extends LoginRunner {

    @Test(dataProvider = "dpTestDescriptionFieldValid", dataProviderClass = AddClubComponentProvider.class)
    public void testDescriptionFieldValid(String nameField, int categoriesNumber, String childAgeFrom,
                                          String childAgeFor, String contactPhone, String description) {
        HomePage homePage = new HomePage(driver);

        boolean isInputSuccess = homePage.getHeader()
                .openAdminProfileMenu()
                .openAddClubForm()
                .enterClubName(nameField)
                .getCategoriesCheckBoxes(categoriesNumber)
                .enterChildAgeFrom(childAgeFrom)
                .enterChildAgeFor(childAgeFor)
                .clickNextStepButton()
                .enterContactPhone(contactPhone)
                .clickNextStepButton()
                .enterDescription(description)
                .getDescriptionSuccess();

        Assert.assertTrue(isInputSuccess);
    }

    @Test(dataProvider = "dpTestDescriptionFieldInvalid", dataProviderClass = AddClubComponentProvider.class)
    public void testDescriptionFieldInvalid(String nameField, int categoriesNumber, String childAgeFrom,
                                            String childAgeFor, String contactPhone, String description,
                                            String expectedErrorMessage) {
        HomePage homePage = new HomePage(driver);

        String actualErrorMessage = homePage.getHeader()
                .openAdminProfileMenu()
                .openAddClubForm()
                .enterClubName(nameField)
                .getCategoriesCheckBoxes(categoriesNumber)
                .enterChildAgeFrom(childAgeFrom)
                .enterChildAgeFor(childAgeFor)
                .clickNextStepButton()
                .enterContactPhone(contactPhone)
                .clickNextStepButton()
                .enterDescription(description)
                .getDescriptionErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}
