package org.ssu.edu.teachua.ui.club;

import org.ssu.edu.teachua.ui.components.modal.edit_club_component.EditClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;

public class EditClubComponentTest extends LoginWithAdminRunner {

    private EditClubMainInfoComponent editClubComponent;

    @BeforeMethod
    void openEditClubForm() {
        driver.navigate().refresh();
        editClubComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickClubDots(1)
                .clickEditClubButton();
    }
}
