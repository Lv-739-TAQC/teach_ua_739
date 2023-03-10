package org.ssu.edu.teachua.ui.challenges;

import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengesPageTest extends LoginWithAdminRunner {
    @Test(dataProvider = "challengeData", dataProviderClass = DataProviderChallenge.class)
    public void testChallengeCreation(String sortNumber, String photoPath, String name, String title, String description) {
        Assert.assertTrue(addChallengePage.getSortNumber().getText().isEmpty());
        Assert.assertTrue(addChallengePage.getName().getText().isEmpty());
        Assert.assertTrue(addChallengePage.getTitle().getText().isEmpty());
        Assert.assertTrue(addChallengePage.getDescription().getText().isEmpty());

        addChallengePage.fillSortNumber(sortNumber)
                .addPhoto(valueProvider.getFilePath(photoPath))
                .fillName(name)
                .fillTitle(title)
                .fillDescription(description)
                .clickSave()
                .clickViewChallenge();

        ViewChallengePage viewChallenge = new ViewChallengePage(driver);
        Assert.assertEquals(viewChallenge.getChallengeDescription(), description);
    }

}
