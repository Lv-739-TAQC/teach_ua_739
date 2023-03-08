package org.ssu.edu.teachua.ui;


import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;
import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.news.NewsPage;
import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.ssu.edu.teachua.utils.JanetTafiyDataProvider;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JanetTafiyTests extends BaseTestRunnerUI {
    private static final int NEWS_INDEX = 1;

    @Test(dataProvider = "registrationData", dataProviderClass = JanetTafiyDataProvider.class)
    public void testRegistrationForm(String lastName, String firstName, String phone, String email, String password, String confirmPassword) {
        HomePage homePage = new HomePage(driver);
        SignUpComponent signUp = homePage.getHeader()
                .openGuestProfileMenu()
                .openRegistrationForm();
        signUp.enterLastName(lastName)
                .enterFirstName(firstName)
                .enterPhone(phone)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickCloseButton();

        homePage.getHeader()
                .openGuestProfileMenu();

        Assert.assertEquals(signUp.getLastNameFieldValue(), lastName);
        Assert.assertEquals(signUp.getFirstNameFieldValue(), firstName);
        Assert.assertEquals(signUp.getEmailFieldValue(), email);
        Assert.assertEquals(signUp.getPasswordFieldValue(), password);
        Assert.assertEquals(signUp.getConfirmPasswordFieldValue(), confirmPassword);
    }

    @Test(dataProvider = "challengeData", dataProviderClass = JanetTafiyDataProvider.class)
    public void successfulChallengeCreation(String sortNumber, String photoPath, String name, String title, String description) {
        TestValueProvider valueProvider = new TestValueProvider();
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge();

        AddChallengePage addChallenge = new AddChallengePage(driver);

        Assert.assertTrue(addChallenge.getSortNumber().getText().isEmpty());
        Assert.assertTrue(addChallenge.getName().getText().isEmpty());
        Assert.assertTrue(addChallenge.getTitle().getText().isEmpty());
        Assert.assertTrue(addChallenge.getDescription().getText().isEmpty());

        addChallenge.fillSortNumber(sortNumber)
                .addPhoto(valueProvider.getFilePath(photoPath))
                .fillName(name)
                .fillTitle(title)
                .fillDescription(description)
                .clickSave()
                .clickViewChallenge();
        ViewChallengePage viewChallenge = new ViewChallengePage(driver);
        Assert.assertEquals(viewChallenge.getChallengeDescription(), description);
    }

    @Test
    public void testNews() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().clickNewsButton();

        NewsPage news = new NewsPage(driver);

        String expectedNewsTitle = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle = news.chooseCertainNews(NEWS_INDEX)
                .clickDate()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle, expectedNewsTitle);

        homePage.getHeader().clickNewsButton();
        String expectedNewsTitle1 = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle1 = news.chooseCertainNews(NEWS_INDEX)
                .clickImage()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle1, expectedNewsTitle1);

        homePage.getHeader().clickNewsButton();
        String expectedNewsTitle2 = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle2 = news.chooseCertainNews(NEWS_INDEX)
                .clickTitle()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle2, expectedNewsTitle2);

        homePage.getHeader().clickNewsButton();
        String expectedNewsTitle3 = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle3 = news.chooseCertainNews(NEWS_INDEX)
                .clickDetailsButton()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle3, expectedNewsTitle3);


    }


}
