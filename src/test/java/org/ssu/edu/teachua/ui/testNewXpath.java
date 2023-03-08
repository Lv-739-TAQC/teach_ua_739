package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.components.modal.edit_center_component.EditCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNewXpath extends LoginWithAdminRunner {

    private ProfilePage editCenterMainInfoComponent;

    @Test
    void testTestTest () {
        driver.navigate().refresh();
        editCenterMainInfoComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .openDropdownClubCenter()
                .chooseCenters();
    }
}
