package org.ssu.edu.teachua.ui.location;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderLocation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LocationComponentTest extends LoginWithAdminRunner {

    private AddLocationComponent addLocationComponent;

    @BeforeMethod
    void openAddLocationForm() {
        driver.navigate().refresh();
        addLocationComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openAddCentreForm()
                .pressAddLocationButton();
    }

    @Test(dataProvider = "dpTestAddLocationAllFields", dataProviderClass = DataProviderLocation.class)
    public void testAddLocationAllFieldsValid(String locationName, String city, String subway, String district,
                                              String address, String locationGC, String locationPhone, String expectedName) {
        String actualName = addLocationComponent
                .enterLocationName(locationName)
                .selectLocationCity(city)
                .selectLocationSubway(subway)
                .selectLocationDistrict(district)
                .enterLocationAddress(address)
                .enterLocationGC(locationGC)
                .enterLocationPhone(locationPhone)
                .pressAddLocationToListButton()
                .getNameNewLocation();

        Assert.assertEquals(actualName, expectedName);
    }

    @Issue("TUA-159")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies if a 'Керівник' can add a location to the " +
                 "\nlist of locations after filling in all mandatory fields with valid data.")
    @Test(dataProvider = "dpTestAddLocationMandatoryFields", dataProviderClass = DataProviderLocation.class)
    public void testAddLocationMandatoryFieldsValid(String locationName, String city, String address,
                                                    String locationGC, String locationPhone, String expectedName) {
        String actualName = addLocationComponent
                .enterLocationName(locationName)
                .selectLocationCity(city)
                .enterLocationAddress(address)
                .enterLocationGC(locationGC)
                .enterLocationPhone(locationPhone)
                .pressAddLocationToListButton()
                .getNameNewLocation();

        Assert.assertEquals(actualName, expectedName);
    }

    @Issue("TUA-160")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test case verifies that a 'Керівник' cannot add a location to the" +
                 "\nlist of locations after leaving all mandatory and optional fields empty.")
    @Test
    public void testAddLocationInvalid() {
        List<String> actualWarnings = addLocationComponent
                .pressAddLocationInvalidInput()
                .getWarningConditionAllFields();

        Assert.assertEquals(actualWarnings, Arrays.asList(
                "Некоректна назва локації", "Це поле є обов'язковим",
                "Це поле є обов'язковим", "Некоректна адреса",
                "Некоректні координати", "Це поле є обов'язковим"));
    }
}
