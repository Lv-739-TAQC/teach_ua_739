package org.ssu.edu.teachua.ui.add_club;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AddClubTest extends LoginRunner {

    public static final List<String> ERROR_MSG = Arrays.asList(
            "Опис гуртка задовгий",
            "Опис гуртка не може містити російські літери",
            "Некоректний опис гуртка\nОпис гуртка не може містити російські літери"
    );

    @DataProvider(name = "dpTestDescriptionFieldValid")
    public Object[][] dpTestDescriptionFieldValid() {
        return new Object[][]{
                {"club1.1", 0, "10", "15", "1212121212", ("some data;").repeat(150)},
                {"club1.2", 6, "9", "14", "1313131313", ("text;").repeat(300)},
                {"club1.3", 12, "15", "18", "2323232323", ("new test data ;").repeat(100)},
                {"club1.4", 3, "11", "18", "2525252525", ("some text;").repeat(5)},
                {"club1.5", 9, "8", "13", "1717171717", ("club description;").repeat(3)}
        };
    }

    @Test(dataProvider = "dpTestDescriptionFieldValid")
    public void testDescriptionFieldValid(String nameField, int categoriesNumber, String childAgeFrom,
                                          String childAgeFor, String contactPhone, String description) {
        HomePage homePage = new HomePage(driver);

        boolean isInputSuccess = homePage.getHeader()
                .openAdminProfileMenu()
                .openAddClubForm()
                .enterClubName(nameField)
                .getCategoriesCheckBoxes(categoriesNumber)
                .enterChildAgeFrom(childAgeFrom)
                .enterChildAgeFor(childAgeFor)
                .clickNextStepButton()
                .enterContactPhone(contactPhone)
                .clickNextStepButton()
                .enterDescription(description)
                .getDescriptionSuccess();

        Assert.assertTrue(isInputSuccess);
    }

    @DataProvider(name = "dpTestDescriptionFieldInvalid")
    public Object[][] dpTestDescriptionFieldInvalid() {
        return new Object[][]{
                {"club2.1", 1, "12", "16", "1212121212", (("text;").repeat(300) + "!"), ERROR_MSG.get(0)},
                {"club2.2", 7, "10", "16", "1313131313", ("new test data ;").repeat(120), ERROR_MSG.get(0)},
                {"club2.3", 9, "15", "18", "2323232323", ("запрещенные слова;").repeat(3), ERROR_MSG.get(1)},
                {"club2.4", 2, "11", "18", "2525252525", ("эъüöäЫэъüöä").repeat(5), ERROR_MSG.get(2)},
                {"club2.5", 10, "8", "15", "1717171717", ("Aussätzige|Прокаженные").repeat(2), ERROR_MSG.get(2)}
        };
    }

    @Test(dataProvider = "dpTestDescriptionFieldInvalid")
    public void testDescriptionFieldInvalid(String nameField, int categoriesNumber, String childAgeFrom,
                                            String childAgeFor, String contactPhone, String description,
                                            String expectedErrorMessage) {
        HomePage homePage = new HomePage(driver);

        String actualErrorMessage = homePage.getHeader()
                .openAdminProfileMenu()
                .openAddClubForm()
                .enterClubName(nameField)
                .getCategoriesCheckBoxes(categoriesNumber)
                .enterChildAgeFrom(childAgeFrom)
                .enterChildAgeFor(childAgeFor)
                .clickNextStepButton()
                .enterContactPhone(contactPhone)
                .clickNextStepButton()
                .enterDescription(description)
                .getDescriptionErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}
