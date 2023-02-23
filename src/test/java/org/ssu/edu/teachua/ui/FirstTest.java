package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;

public class FirstTest extends TestRunnerUI {

    @Test
    public void firstTest() {
        new HomePage(driver)
                .getHeader()
                .clickAboutButton()
                .getHeader()
                .clickLogo()
                .getHeader()
                .openGuestProfileMenu();
    }
}
