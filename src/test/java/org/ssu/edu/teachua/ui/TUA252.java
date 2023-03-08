package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TUA252 extends BaseTestRunnerUI {

    @Test
    public void testTUA252() {

        TestValueProvider adminCredentials = new TestValueProvider();
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(adminCredentials.getAdminEmail())
                .enterPassword(adminCredentials.getAdminPassword())
                .clickLoginButton();

        homePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickAddButton()
                .clickAddCenterButton()
                .pressNextButton();

        String errorActual = new AddCenterMainInfoComponent(driver).getCenterNameError();

        Assert.assertEquals(errorActual, "Некоректна назва центру");
    }
}
