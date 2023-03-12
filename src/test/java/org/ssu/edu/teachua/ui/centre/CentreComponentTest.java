package org.ssu.edu.teachua.ui.centre;

import io.qameta.allure.Issue;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.ssu.edu.teachua.utils.providers.DataProviderCentre;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.List;

public class CentreComponentTest extends LoginWithAdminRunner {

    @Test(dataProvider = "dpTestAddCenter", dataProviderClass = DataProviderCentre.class)
    public void testAddCenter(String centerName, String locationName, String city, String subway, String district,
                              String address, String locationGC, String locationPhone, int locationIdx, String facebookUrl,
                              String siteUrl, String emailUrl, String skypeName, String whatsAppNumber, String simplePhone,
                              String photoLogoPath, String centerPhotoPath, String description, int clubIdx,
                              List<String> expectedProfileContent) {
        HomePage homePage = new HomePage(driver);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<String> actualProfileContent = homePage
                .getHeader()
                .openAdminProfileMenu()
                .openAddCentreForm()
                .enterCenterName(centerName + timestamp.getTime())
                .pressAddLocationButton()
                .enterLocationName(locationName)
                .selectLocationCity(city)
                .selectLocationSubway(subway)
                .selectLocationDistrict(district)
                .enterLocationAddress(address)
                .enterLocationGC(locationGC)
                .enterLocationPhone(locationPhone)
                .pressAddLocationToListButton()
                .checkLocation(locationIdx)
                .pressNextButton()
                .enterCenterFacebook(facebookUrl)
                .enterCenterSite(siteUrl)
                .enterCenterMail(emailUrl)
                .enterCenterSkype(skypeName)
                .enterCenterWhatsAppNumber(whatsAppNumber)
                .enterPhone(simplePhone)
                .pressNextButton()
                .addCenterLogo(valueProvider.getFilePath(photoLogoPath))
                .addCenterPhoto(valueProvider.getFilePath(centerPhotoPath))
                .addCenterDescription(description)
                .pressNextButton()
                .checkClub(clubIdx)
                .pressFinishButton()
                .getProfilePageContent();

        Assert.assertEquals(actualProfileContent, expectedProfileContent);
    }

    @Issue("TUA-252") @Test
    public void testEmptyNameField() {

        HomePage homePage = new HomePage(driver);
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