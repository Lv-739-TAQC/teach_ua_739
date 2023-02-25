package org.ssu.edu.teachua.ui.add_club_component;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.providers.AddClubComponentProvider;
import org.ssu.edu.teachua.ui.runners.LoginRunner;
import org.testng.annotations.Test;

public class AddClubTest extends LoginRunner {

    @Test(dataProvider = "dpTestDescriptionFieldFirstValid", dataProviderClass = AddClubComponentProvider.class)
    public void testDescriptionFieldFirstValid(String nameField, int categoriesNumber, String childAgeFrom,
                                               String childAgeTo, String contactPhone, String description) {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickAddButton()
                .clickAddClubButton()
                .enterClubName(nameField)
                .getCategoriesCheckBoxes(categoriesNumber)
                .enterChildAgeFrom(childAgeFrom)
                .enterChildAgeFor(childAgeTo)
                .clickNextStepButton()
                .enterContactPhone(contactPhone)
                .clickNextStepButton()
                .enterDescription(description);
    }
}
