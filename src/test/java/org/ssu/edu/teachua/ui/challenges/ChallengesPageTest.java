package org.ssu.edu.teachua.ui.challenges;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengesPageTest extends LoginWithAdminRunner {

    private AddChallengePage addChallengePage;

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

    @Test(dataProvider = "dpTestCompressAndUploadPhoto", dataProviderClass = DataProviderChallenge.class)
    public void testIfPhotoCompressedAndUploaded(String photoPath) {
        addChallengePage.addPhoto(valueProvider.getFilePath(photoPath));
        Assert.assertTrue(addChallengePage.getPhotoAppeared().isDisplayed());
    }

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
}
