package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.sql.Timestamp;

public class AddCenterTest extends BaseTestRunnerUI {
    @Test
    public void addCenterTest() {
        HomePage homePage = new HomePage(driver);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<String> actualProfileContent = homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openAddCentreForm()
                .enterCenterName("First language center" + timestamp.getTime())
                .pressAddLocationButton()
                .enterLocationName("Лівий берег")
                .selectLocationCity("Одеса")
                .selectLocationSubway("Фонтан")
                .selectLocationDistrict("Приморський")
                .enterLocationAddress("проспект Бажана, 3А")
                .enterLocationGC("50.406108, 30.668492")
                .enterLocationPhone("0679002233")
                .pressAddLocationToListButton()
                .checkLocation(1)
                .pressNextButton()
                .enterCenterFacebook("https://www.facebook.com/1lngcenter/")
                .enterCenterSite("https://1lngcenter/")
                .enterCenterMail("center@gmail.com")
                .enterCenterSkype("1lngcenter")
                .enterCenterWhatsAppNumber("+380630336789")
                .enterPhone("0503334455")
                .pressNextButton()
                .addCenterLogo(valueProvider.getFilePath("photos/centerLogo.jpg"))
                .addCenterPhoto(valueProvider.getFilePath("photos/centerPhoto.jpg"))
                .addCenterDescription("Кількість курсів, призначених для окремих вікових груп, залежить від суми використовуваних на сьогоднішній день грантів")
                .pressNextButton()
                .checkClub(100)
                .pressFinishButton()
                .getProfilePageContent();

        Assert.assertEquals(actualProfileContent, Arrays.asList("Особистий кабінет", "Admin Admin", "АДМІНІСТРАТОР", "0689543242", "admin@gmail.com"));
    }

}