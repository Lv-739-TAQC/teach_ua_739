package org.ssu.edu.teachua.ui.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClubComponentTest extends LoginWithAdminRunner {

    private AddClubMainInfoComponent mainInfoComponent;

    @BeforeMethod
    void openAddClubForm() {
        driver.navigate().refresh();
        mainInfoComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openAddClubForm();
    }

    @Issue("TUA-172")
    @Issue("TUA-173")
    @Issue("TUA-177")
    @Description("All these test-cases cover positive scenario when introducing changes" +
                "\n to the 'Опис' field results in no error message shown")
    @Test(dataProvider = "dpTestDescriptionFieldValid", dataProviderClass = DataProviderClub.class)
    public void testDescriptionFieldValid(String nameField, int categoriesNumber, String childAgeFrom,
                                          String childAgeFor, String contactPhone, String description) {
        boolean isInputSuccess = mainInfoComponent
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

    @Issue("TUA-176")
    @Issue("TUA-177")
    @Issue("TUA-178")
    @Severity(SeverityLevel.NORMAL)
    @Description("All of these test cases verify if specific error message is" +
                 "\ndisplayed after entering invalid data in the 'Опис' field.")
    @Test(dataProvider = "dpTestDescriptionFieldInvalid", dataProviderClass = DataProviderClub.class)
    public void testDescriptionFieldInvalid(String nameField, int categoriesNumber, String childAgeFrom,
                                            String childAgeFor, String contactPhone, String description,
                                            String expectedErrorMessage) {
        String actualErrorMessage = mainInfoComponent
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
