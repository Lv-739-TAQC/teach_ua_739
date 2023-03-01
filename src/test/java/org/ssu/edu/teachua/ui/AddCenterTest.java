package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;

public class AddCenterTest extends TestRunnerUI {
    @Test
    public void addCenterTest() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openAddCentreForm()
                .enterCenterName("First language center")
                .pressAddLocationButton()
                .pressCloseAddLocationWindow()
                .checkLocation(3)
                .pressNextButton()
                .enterCenterFacebook("https://www.facebook.com/1lngcenter/")
                .enterCenterSite("https://1lngcenter/")
                .enterCenterMail("center@gmail.com")
                .enterCenterSkype("1lngcenter")
                .enterCenterWhatsAppNumber("+380630336789")
                .enterPhone("0503334455")
                .pressNextButton()
                .addCenterLogo(valueProvider.getFilePath("centerLogo.jpg"))
                .addCenterPhoto(valueProvider.getFilePath("centerPhoto.jpg"))
                .addCenterDescription("Кількість курсів, призначених для окремих вікових груп, залежить від суми використовуваних на сьогоднішній день грантів")
                .pressNextButton()
                .checkClub(100)
                .pressFinishButton();
    }

}