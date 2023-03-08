package org.ssu.edu.teachua.ui.profile;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeTest;

public class ProfilePageTest extends LoginWithAdminRunner {

    @BeforeTest(description = "Precondition method : open Profile Page")
    public void openProfilePagePrecondition() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage();
    }
}
