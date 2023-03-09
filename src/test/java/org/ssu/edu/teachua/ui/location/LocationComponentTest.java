package org.ssu.edu.teachua.ui.location;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocationComponentTest extends LoginWithAdminRunner {
    @Test
    public void testAddLocation() {
        HomePage homePage = new HomePage(driver);
        String actualName = homePage.getHeader()
                .openAdminProfileMenu()
                .openAddCentreForm()
                .pressAddLocationButton()
                .enterLocationName("Лівий берег")
                .selectLocationCity("Одеса")
                .selectLocationSubway("Фонтан")
                .selectLocationDistrict("Приморський")
                .enterLocationAddress("проспект Бажана, 3А")
                .enterLocationGC("50.406108, 30.668492")
                .enterLocationPhone("0679002233")
                .pressAddLocationToListButton()
                .getNameNewLocation();
        Assert.assertEquals(actualName, "Лівий берег");
    }
}
