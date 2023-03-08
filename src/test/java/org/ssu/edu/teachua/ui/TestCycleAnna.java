package org.ssu.edu.teachua.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubDescriptionComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.annotations.Test;

import java.util.List;


public class TestCycleAnna extends BaseTestRunnerUI {

    @Test
    public void addClubDescriptionFieldPositiveTestTUA172() {
        HomePage homePage = new HomePage(driver);
        List<WebElement> descriptionHelp;
        AddClubDescriptionComponent descriptionStepAddClub = homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openAddClubForm()
                .enterClubName("Speaking club")
                .getCategoriesCheckBoxes(2)
                .enterChildAgeFrom("6")
                .enterChildAgeFor("16")
                .clickNextStepButton()
                .enterContactPhone("0674443322")
                .clickNextStepButton();

        descriptionStepAddClub.enterDescription(valueProvider.getStringFromFile(valueProvider.getFilePath("text/1000symbols.txt")));
        descriptionHelp = driver.findElements(By.xpath(".//div[@id='basic_description_help']"));
        softAssert.assertEquals(descriptionHelp.size(), 0);

        descriptionStepAddClub.enterDescription("Lorem ipsum dolor sit amet, consectetur adipis");
        descriptionHelp = driver.findElements(By.xpath(".//div[@id='basic_description_help']"));
        softAssert.assertEquals(descriptionHelp.size(), 0);

        descriptionStepAddClub.enterDescription(valueProvider.getStringFromFile(valueProvider.getFilePath("text/1500symbols.txt")));
        descriptionHelp = driver.findElements(By.xpath(".//div[@id='basic_description_help']"));
        softAssert.assertEquals(descriptionHelp.size(), 0);

        softAssert.assertAll();

    }


    @Test
    public void addClubDescriptionFieldPositiveTestTUA173() {
        HomePage homePage = new HomePage(driver);
        List<WebElement> descriptionHelp;
        AddClubDescriptionComponent descriptionStepAddClub = homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openAddClubForm()
                .enterClubName("Speaking club")
                .getCategoriesCheckBoxes(2)
                .enterChildAgeFrom("6")
                .enterChildAgeFor("16")
                .clickNextStepButton()
                .enterContactPhone("0674443322")
                .clickNextStepButton();

        descriptionStepAddClub.enterDescription("Гурток Speaking club спрямований на розвиток мовленнєвих навичок для дітей віком від 6 і до 16 років");
        descriptionHelp = driver.findElements(By.xpath(".//div[@id='basic_description_help']"));
        softAssert.assertEquals(descriptionHelp.size(), 0);

        descriptionStepAddClub.enterDescription("1234567890123456789012345678901234567890");
        descriptionHelp = driver.findElements(By.xpath(".//div[@id='basic_description_help']"));
        softAssert.assertEquals(descriptionHelp.size(), 0);

        descriptionStepAddClub.enterDescription("!#$%&'()*+,-./:;<=>?@[]^_`{}~!#$%&'()*+,-./:;<=>?@[]^_`{}~");
        descriptionHelp = driver.findElements(By.xpath(".//div[@id='basic_description_help']"));
        softAssert.assertEquals(descriptionHelp.size(), 0);

        softAssert.assertAll();

    }


    @Test
    public void addClubDescriptionFieldNegativeTestTUA176() {
        HomePage homePage = new HomePage(driver);
        WebElement descriptionHelp;
        AddClubDescriptionComponent descriptionStepAddClub = homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openAddClubForm()
                .enterClubName("Speaking club")
                .getCategoriesCheckBoxes(2)
                .enterChildAgeFrom("6")
                .enterChildAgeFor("16")
                .clickNextStepButton()
                .enterContactPhone("0674443322")
                .clickNextStepButton();

        descriptionStepAddClub.enterDescription("Lorem ipsum dolor si");
        descriptionHelp = driver.findElement(By.xpath(".//div[@id='basic_description_help']//div[2]"));
        softAssert.assertEquals(descriptionHelp.getText(), "Опис гуртка може містити від 40 до 1500 символів.");

        descriptionStepAddClub.enterDescription("1");
        descriptionHelp = driver.findElement(By.xpath(".//div[@id='basic_description_help']//div[2]"));
        softAssert.assertEquals(descriptionHelp.getText(), "Опис гуртка може містити від 40 до 1500 символів.");

        descriptionStepAddClub.enterDescription("Lorem ipsum dolor sit amet, consectetur");
        descriptionHelp = driver.findElement(By.xpath(".//div[@id='basic_description_help']//div[2]"));
        softAssert.assertEquals(descriptionHelp.getText(), "Опис гуртка може містити від 40 до 1500 символів.");

        softAssert.assertAll();

    }

}
