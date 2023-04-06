package org.ssu.edu.teachua.ui.centre;

import org.ssu.edu.teachua.ui.components.modal.edit_center_component.EditCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminUIRunner;
import org.testng.annotations.BeforeMethod;

public class EditCenterComponentTest extends LoginWithAdminUIRunner {

    private EditCenterMainInfoComponent editCenterComponent;

    @BeforeMethod
    void openEditCenterForm() {
        driver.navigate().refresh();
        editCenterComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .openDropdownClubCenter()
                .chooseCenters()
                .clickCenterDots(1)
                .getEditCenterButton();
    }
}
