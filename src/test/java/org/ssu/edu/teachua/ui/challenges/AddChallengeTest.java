package org.ssu.edu.teachua.ui.challenges;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AddChallengeTest extends LoginWithAdminRunner {

    @DataProvider(name = "dpTestAddChallengeValid")
    public Object[][] dpTestAddChallengeValid() {
        return new Object[][]{
                {"115", "name-1", "title-1", ("description-1").repeat(20), "photos/image.png",
                        "Челендж 'name-1' успішно доданий!", "title-1"}
        };
    }

    @Test(dataProvider = "dpTestAddChallengeValid")
    public void testAddChallengeValid(String number, String name, String title,
                                      String description, String photoName,
                                      String expectedSuccessMsg, String expectedTitle) {
        HomePage homePage = new HomePage(driver);

        String actualSuccessMsg = homePage.getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge()
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
}
