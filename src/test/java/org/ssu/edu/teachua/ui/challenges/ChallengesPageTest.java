package org.ssu.edu.teachua.ui.challenges;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.entities.Challenges;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.ChallengesService;
import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import io.qameta.allure.Issue;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminUIRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;

public class ChallengesPageTest extends LoginWithAdminUIRunner {

    private AddChallengePage addChallengePage;
    private ChallengesService challengesService;

    @BeforeMethod
    void openAddChallengePage() {
        driver.navigate().refresh();
        addChallengePage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge();
    }

    @Issue("TUA-151")
    @Severity(SeverityLevel.NORMAL)
    @Description("We need to check whether the challenge is created" +
            "\nif all parameters are filled with valid values.")
    @Test(dataProvider = "dpTestAddChallengeValid", dataProviderClass = DataProviderChallenge.class)
    public void testAddChallengeValid(String number, String name, String title, String description,
                                      String photoName, String expectedSuccessMsg) {
        AddChallengePage addChallengePage = new AddChallengePage(driver);

        String actualSuccessMsg = addChallengePage
                .fillSortNumber(number)
                .fillName(name)
                .fillTitle(title)
                .fillDescription(description)
                .addPhoto(valueProvider.getFilePath(photoName))
                .clickSave()
                .checkSuccessMessage();

        addChallengePage.goToChallenges()
                .fillSearchField(name)
                .clickSearchButton()
                .selectCertainChallenge(0)
                .clickDeleteButton()
                .clickConfirmDeletingButton();

        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
    }

    @Issue("TUA-229")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that a 'Керівник' can add a photo with invalid parameters\n into the ‘Баннер’ file picker")
    @Test(dataProvider = "dpTestCompressAndUploadPhoto", dataProviderClass = DataProviderChallenge.class)
    public void testIfPhotoCompressedAndUploaded(String photoPath) {
        addChallengePage.addPhoto(valueProvider.getFilePath(photoPath));
        Assert.assertTrue(addChallengePage.getPhotoAppeared().isDisplayed());
    }

    @Issue("TUA-231")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the error messages of ‘Назва Челенджу’ field\n on ‘Основна інформація’ tab of 'Додати челендж' pop-up")
    @Test(dataProvider = "dpTestErrorMessageChallengeNameField", dataProviderClass = DataProviderChallenge.class)
    public void testErrorMessagesForChallengeNameField(String sortNumber, String title, String description,
                                                       String photoPath, List<String> invalidNames,
                                                       String redBorderColor, List<String> expectedErrorMsg) {
        String actualErrorFirst = addChallengePage
                .fillSortNumber(sortNumber)
                .fillTitle(title)
                .fillDescription(description)
                .addPhoto(valueProvider.getFilePath(photoPath))
                .fillName(invalidNames.get(0))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorFirst, expectedErrorMsg.get(0));

        String actualErrorSecond = addChallengePage
                .waitForErrorMessageToDisappear()
                .clearName()
                .fillName(invalidNames.get(1))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorSecond, expectedErrorMsg.get(1));

        String actualErrorThird = addChallengePage
                .waitForErrorMessageToDisappear()
                .clearName()
                .fillName(invalidNames.get(2))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorThird, expectedErrorMsg.get(2));

        String actualErrorFourth = addChallengePage
                .waitForErrorMessageToDisappear()
                .clearName()
                .fillName(invalidNames.get(3))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorFourth, expectedErrorMsg.get(3));

        String actualBorderColor = addChallengePage
                .getBorderColorForNameField();
        softAssert.assertEquals(actualBorderColor, redBorderColor);

        softAssert.assertAll();
    }

    @Issue("TUA-71")
    @Description("Verify that user can open ”Челендж” page from any other pages of the site.")
    @Test
    public void challengeDropdownTest() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .clickChallengesButton()
                .clickChallengeButton(5);
        String expected = driver.getCurrentUrl();

        String testChallengePage = homePage.getHeader()
                .clickChallengesButton()
                .getChallengeUrl(5);

        Assert.assertEquals(testChallengePage, expected);
    }

    @Issue("TUA-157")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that a challenge can't be created if mandatory parameters are empty")
    @Test(dataProvider = "dpTestEmptySortNumber", dataProviderClass = DataProviderChallenge.class)
    public void testErrorMessagesForChallengeSortNumberField(String sortNumber, String name, String title,
                                                             String description, String photoPath,
                                                             String expectedErrorMsg) {

        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueSortNumber()));
        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueName()));
        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueTitle()));
        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueDescription()));

        String actualError = addChallengePage
                .waitForErrorMessageToDisappear()
                .fillSortNumber(sortNumber)
                .fillName(name)
                .fillTitle(title)
                .fillDescription(description)
                .addPhoto(valueProvider.getFilePath(photoPath))
                .clickSave()
                .checkErrorMessage();

        softAssert.assertEquals(actualError, expectedErrorMsg);

        softAssert.assertAll();
    }

    @Issue("TUA-336")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin cannot create challenge with invalid data in 'Назва' field")
    @Test(dataProvider = "dpTestInvalidValueNameField", dataProviderClass = DataProviderChallenge.class)
    public void testErrorMessagesForChallengeInvalidValueNameField(String title, String description,
                                                                   String photoPath, List<String> invalidNames,
                                                                   List<String> expectedErrorMsg) {

        addChallengePage
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillTitle(title)
                .fillDescription(description)
                .addPhoto(valueProvider.getFilePath(photoPath));

        String actualErrorMsgFirst = addChallengePage.fillName(invalidNames.get(0))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorMsgFirst, expectedErrorMsg.get(0));

        String actualErrorMsgSecond = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName(invalidNames.get(1))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorMsgSecond, expectedErrorMsg.get(1));

        String actualErrorMsgThird = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName(invalidNames.get(2))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorMsgThird, expectedErrorMsg.get(2));
        softAssert.assertAll();
    }

    @Issue("TUA-335")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that 'admin' is able to create a challenge with the valid data")
    @Test(dataProvider = "dpTestValidValueNameField", dataProviderClass = DataProviderChallenge.class)
    public void testCreatingChallengeWithValidNameField(String title, String description,
                                                        String photoPath, List<String> validName,
                                                        List<String> expectedSuccessMsg) {

        addChallengePage
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillTitle(title)
                .fillDescription(description)
                .addPhoto(valueProvider.getFilePath(photoPath));

        String actualValueFirst = addChallengePage.fillName(validName.get(0))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueFirst, expectedSuccessMsg.get(0));

        String actualValueSecond = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(validName.get(1))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueSecond, expectedSuccessMsg.get(1));

        String actualValueThird = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(validName.get(2))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueThird, expectedSuccessMsg.get(2));

        String actualValueFourth = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(validName.get(3))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueFourth, expectedSuccessMsg.get(3));
        softAssert.assertAll();
    }

    @Issue("TUA-527")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies that fields on a challenge page are empty and user can create a challenge with valid data")
    @Test(dataProvider = "challengeData", dataProviderClass = DataProviderChallenge.class)
    public void testChallengeCreation(String randomSortNumber, String photoPath, String name,
                                      String title, String description) throws DBException, EntityException {
        String sortNumberText = addChallengePage.getSortNumber().getText();
        String nameText = addChallengePage.getName().getText();
        String titleText = addChallengePage.getTitle().getText();
        String descriptionText = addChallengePage.getDescription().getText();

        Assert.assertTrue(sortNumberText.isEmpty(), "Sort number field is not empty.");
        Assert.assertTrue(nameText.isEmpty(), "Name field is not empty.");
        Assert.assertTrue(titleText.isEmpty(), "Title field is not empty.");
        Assert.assertTrue(descriptionText.isEmpty(), "Description field is not empty.");

        int sortNumber = Integer.parseInt(randomSortNumber);

        Challenges expectedChallenge = new Challenges();
        expectedChallenge.setName(name);
        expectedChallenge.setTitle(title);
        expectedChallenge.setDescription(description);
        expectedChallenge.setSortNumber(BigInteger.valueOf(sortNumber));

        addChallengePage.fillSortNumber(randomSortNumber)
                .addPhoto(valueProvider.getFilePath(photoPath))
                .fillName(name)
                .fillTitle(title)
                .fillDescription(description)
                .clickSave();

        challengesService = entityService.getChallengeService();
        Challenges actualChallenge = challengesService.getChallengeBySortNumber(sortNumber);
        String actualDescription = actualChallenge.getDescription();
        Assert.assertEquals(expectedChallenge.getName(), actualChallenge.getName(), "Challenge name doesn't match");
        Assert.assertEquals(expectedChallenge.getTitle(), actualChallenge.getTitle(), "Challenge title doesn't match");
        //regex is needed to remove html tags that are automatically added after insertion to database.
        Assert.assertEquals(expectedChallenge.getDescription(), actualDescription.replaceAll("<[^>]*>", ""), "Challenge description doesn't match");
        Assert.assertEquals(expectedChallenge.getSortNumber(), actualChallenge.getSortNumber(), "Challenge sort number doesn't match");
    }
}
