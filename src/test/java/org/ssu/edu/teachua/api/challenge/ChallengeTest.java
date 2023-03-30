package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengeTest extends LoginWithAdminAPIRunner {

    @Issue("TUA-751")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user can not create Challenge after entering invalid data into \"Name\" field")
    @Test(dataProvider = "dpTestIfChallengeIsNotCreated", dataProviderClass = DataProviderChallenge.class)
    public void testIfChallengeIsNotCreated(List<String> validValues, List<String> invalidNames, List<String> expectedMsg, int expectedStatusCode) {
//API - challenge client is not created yet :(

        softAssert.assertEquals(1, expectedMsg.get(0));
        softAssert.assertEquals(1, expectedMsg.get(1));
        softAssert.assertEquals(1, expectedMsg.get(2));
        softAssert.assertEquals(1, expectedMsg.get(3));
        softAssert.assertEquals(1, expectedStatusCode);
        softAssert.assertAll();
    }
}
