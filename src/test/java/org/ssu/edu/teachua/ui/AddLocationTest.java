package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddLocationTest extends BaseTestRunnerUI {

    @Test
    public void addLocationTest() {
        HomePage homePage = new HomePage(driver);
        String actualName = homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
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