package org.ssu.edu.teachua.ui.location;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderCentre;
import org.ssu.edu.teachua.utils.providers.DataProviderLocation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class LocationComponentTest extends LoginWithAdminRunner {
    @Test(dataProvider = "dpTestAddLocation", dataProviderClass = DataProviderLocation.class)
    public void testAddLocation(String locationName, String city, String subway, String district,
                                String address, String locationGC, String locationPhone, String expectedName) {
        HomePage homePage = new HomePage(driver);
        String actualName = homePage.getHeader()
                .openAdminProfileMenu()
                .openAddCentreForm()
                .pressAddLocationButton()
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
}
