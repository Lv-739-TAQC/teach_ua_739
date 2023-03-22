package org.ssu.edu.teachua.ui.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.entities.Location;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubContactsComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class ClubModalAsAdminTest extends LoginWithAdminRunner {

    private AddClubMainInfoComponent mainInfoComponent;
    private AddClubContactsComponent contactsComponent;

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
            "\n displayed after entering invalid data in the 'Опис' field.")
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

    @Issue("TUA-237")
    @Description("This test case verifies that a 'Керівник'" +
            " can add a location of a club that doesn't refer " +
            "to any center after filling in mandatory fields with valid data.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "dpTestAddLocationForClub", dataProviderClass = DataProviderClub.class)
    public void testAddLocationForClub(String nameField, int categoryNum, String childAgeFrom, String childAgeFor,
                                       String locationNameField, String cityField, String districtField, String subwayField,
                                       String addressField, String coordinatesField, String phoneField, String contactPhone,
                                       String description) {

        mainInfoComponent.enterClubName(nameField)
                .getCategoriesCheckBoxes(categoryNum)
                .enterChildAgeFrom(childAgeFrom)
                .enterChildAgeFor(childAgeFor)
                .clickNextStepButton()
                .clickAddLocationButton()
                .enterLocationName(locationNameField)
                .selectLocationCity(cityField)
                .selectLocationDistrict(districtField)
                .selectLocationSubway(subwayField)
                .enterLocationAddress(addressField)
                .enterLocationGC(coordinatesField)
                .enterLocationPhone(phoneField)
                .pressAddLocationToListButton();

        contactsComponent = new AddClubContactsComponent(driver);

        contactsComponent.enterContactPhone(contactPhone)
                .clickNextStepButton()
                .enterDescription(description)
                .clickEndButton();

        Location location = entityService.getLocationService().getLocationByName(locationNameField).get(0);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(
                Arrays.asList(location.getName(), location.getCity(), location.getDistrict(),
                        location.getStation(), location.getAddress(), location.getPhone()),
                Arrays.asList(locationNameField, cityField, districtField,
                        subwayField, addressField, phoneField)
        );

        softAssert.assertAll();
    }
}
