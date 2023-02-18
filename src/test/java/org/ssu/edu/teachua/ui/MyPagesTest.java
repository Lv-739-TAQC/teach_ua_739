package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;

public class MyPagesTest extends TestRunnerUI {

    @Test
    public void testProfilePageMethods() {
        HomePage homePage = new HomePage(driver);
    }
}
