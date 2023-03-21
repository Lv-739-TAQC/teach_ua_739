//package org.ssu.edu.teachua.ui.centre;
//
//import io.qameta.allure.Issue;
//import io.qameta.allure.Severity;
//import io.qameta.allure.Description;
//import io.qameta.allure.SeverityLevel;
//import org.ssu.edu.teachua.db.entities.Center;
//import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;
//import org.ssu.edu.teachua.ui.pages.home.HomePage;
//import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
//import org.ssu.edu.teachua.utils.providers.DataProviderCentre;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.sql.Timestamp;
//import java.util.Arrays;
//import java.util.List;
//
//public class CentreComponentTest extends LoginWithAdminRunner {
//
//    private AddCenterMainInfoComponent mainInfoComponent;
//    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//
//    @BeforeMethod
//    void openAddCenterForm() {
//        driver.navigate().refresh();
//        mainInfoComponent = new HomePage(driver)
//                .getHeader()
//                .openAdminProfileMenu()
//                .openAddCentreForm();
//    }
//
//    @Description("This test verifies successful center creation with all fields filled in")
//    @Test(dataProvider = "dpTestAddCenterUI", dataProviderClass = DataProviderCentre.class)
//    public void testAddCenterUI(String centerName, String locationName, String city, String subway, String district,
//                                String address, String locationGC, String locationPhone, int locationIdx, String facebookUrl,
//                                String siteUrl, String emailUrl, String skypeName, String whatsAppNumber, String simplePhone,
//                                String photoLogoPath, String centerPhotoPath, String description, int clubIdx,
//                                List<String> expectedProfileContent) {
//        String generatedCenterName = centerName + timestamp.getTime();
//        List<String> actualProfileContent = mainInfoComponent
//                .enterCenterName(generatedCenterName)
//                .pressAddLocationButton()
//                .enterLocationName(locationName)
//                .selectLocationCity(city)
//                .selectLocationSubway(subway)
//                .selectLocationDistrict(district)
//                .enterLocationAddress(address)
//                .enterLocationGC(locationGC)
//                .enterLocationPhone(locationPhone)
//                .pressAddLocationToListButton()
//                .checkLocation(locationIdx)
//                .pressNextButton()
//                .enterCenterFacebook(facebookUrl)
//                .enterCenterSite(siteUrl)
//                .enterCenterMail(emailUrl)
//                .enterCenterSkype(skypeName)
//                .enterCenterWhatsAppNumber(whatsAppNumber)
//                .enterPhone(simplePhone)
//                .pressNextButton()
//                .addCenterLogo(valueProvider.getFilePath(photoLogoPath))
//                .addCenterPhoto(valueProvider.getFilePath(centerPhotoPath))
//                .addCenterDescription(description)
//                .pressNextButton()
//                .checkClub(clubIdx)
//                .pressFinishButton()
//                .getProfilePageContent();
//
//        Assert.assertEquals(actualProfileContent, expectedProfileContent);
//    }
//
//    @Issue("TUA-252")
//    @Test
//    public void testEmptyNameField() {
//        mainInfoComponent.pressNextButton();
//        String actualError = mainInfoComponent.getCenterNameError();
//        Assert.assertEquals(actualError, "Некоректна назва центру");
//    }
//
//    @Issue("TUA-214")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("This test case verifies that user 'Керівник' can create a center with" +
//            "\n all mandatory fields filled with valid data")
//    @Test(dataProvider = "dpTestAddCenterDB", dataProviderClass = DataProviderCentre.class)
//    public void testAddCenterDB(String centerName, String locationName, String city, String subway, String district,
//                                String address, String locationGC, String locationPhone, int locationIdx, String contactPhone,
//                                String description, int clubIdx) {
//        String generatedCenterName = centerName + timestamp.getTime();
//        mainInfoComponent.enterCenterName(generatedCenterName)
//                .pressAddLocationButton()
//                .enterLocationName(locationName)
//                .selectLocationCity(city)
//                .selectLocationSubway(subway)
//                .selectLocationDistrict(district)
//                .enterLocationAddress(address)
//                .enterLocationGC(locationGC)
//                .enterLocationPhone(locationPhone)
//                .pressAddLocationToListButton()
//                .checkLocation(locationIdx)
//                .pressNextButton()
//                .enterPhone(contactPhone)
//                .pressNextButton()
//                .addCenterDescription(description)
//                .pressNextButton()
//                .checkClub(clubIdx)
//                .pressFinishButton();
//
//        Center center = entityService.getCenterService().getCentersByName(generatedCenterName).get(0);
//
//        Assert.assertEquals(
//                Arrays.asList(center.getName(), center.getDescription()),
//                Arrays.asList(generatedCenterName, description)
//        );
//    }
//}