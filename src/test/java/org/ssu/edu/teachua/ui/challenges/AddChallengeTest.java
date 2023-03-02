package org.ssu.edu.teachua.ui.challenges;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddChallengeTest extends LoginRunner {

    @DataProvider(name = "dpTestAddChallengeValid")
    public Object[][] dpTestAddChallengeValid() {
        return new Object[][]{
                {"115", "name-1", "title-1", ("description-1").repeat(20), "image.png",
                        "Челендж 'name-1' успішно доданий!", "title-1"}
        };
    }

    @Test(dataProvider = "dpTestAddChallengeValid")
    public void testAddChallengeValid(String number, String name, String title,
                                      String description, String photoName,
                                      String expectedSuccessMsg, String expectedTitle) {
        HomePage homePage = new HomePage(driver);
        AddChallengePage addChallengePage = new AddChallengePage(driver);

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

        String actualTitle = addChallengePage
                .clickViewChallenge()
                .getChallengeTitle();

        softAssert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
        softAssert.assertEquals(actualTitle, expectedTitle);

        softAssert.assertAll();
    }
}
