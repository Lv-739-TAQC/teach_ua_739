package org.ssu.edu.teachua.ui.challenges;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class AddChallengePageTest extends LoginWithAdminRunner {
    private AddChallengePage addChallengePage;

    @DataProvider(name = "dpTestAddChallengeValid")
    public Object[][] dpTestAddChallengeValid() {
        return new Object[][]{
                {"115", "name-1", "title-1", ("description-1").repeat(20), "photos/image.png",
                        "Челендж 'name-1' успішно доданий!", "title-1"}
        };
    }

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

    @Test(dataProvider = "dpTestAddChallengeValid")
    public void testAddChallengeValid(String number, String name, String title,
                                      String description, String photoName,
                                      String expectedSuccessMsg, String expectedTitle) {

        String actualSuccessMsg = addChallengePage
                .fillSortNumber(number)
                .fillName(name)
                .fillTitle(title)
                .fillDescription(description)
                .addPhoto(valueProvider.getFilePath(photoName))
                .clickSave()
                .checkSuccessMessage();

        AddChallengePage addChallengePage = new AddChallengePage(driver);
        String actualTitle = addChallengePage
                .clickViewChallenge()
                .getChallengeTitle();

        softAssert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
        softAssert.assertEquals(actualTitle, expectedTitle);

        softAssert.assertAll();
    }

    @Test(dataProvider = "dpTestCompressAndUploadPhoto", dataProviderClass = DataProviderChallenge.class)
    public void verifyIfPhotoCompressedAndUploadedTest(String photoPath) {

        addChallengePage.addPhoto(valueProvider.getFilePath(photoPath));

        Assert.assertTrue(addChallengePage.getPhotoAppeared().isDisplayed());
    }

    @Test(dataProvider = "dpTestErrorMessageChallengeNameField", dataProviderClass = DataProviderChallenge.class)
    public void verifyErrorMessagesForChallengeNameFieldTest(String sortNumber, String title, String description, String photoPath, List<String> invalidNames, String redBorderColor, List<String> expectedErrorMsg) {

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

    @Test (dataProvider = "dpTestInvalidValueNameField", dataProviderClass = DataProviderChallenge.class)
    public void testErrorMessagesForChallengeNameField(String title, String description,
                                                       String photoPath,List<String> invalidNames,
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
        softAssert.assertEquals(actualValueFirst,expectedSuccessMsg.get(0));

        String actualValueSecond = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(validName.get(1))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueSecond,expectedSuccessMsg.get(1));

        String actualValueThird = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(validName.get(2))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueThird,expectedSuccessMsg.get(2));

        String actualValueFourth = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(validName.get(3))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueFourth,expectedSuccessMsg.get(3));
        softAssert.assertAll();
    }

}
