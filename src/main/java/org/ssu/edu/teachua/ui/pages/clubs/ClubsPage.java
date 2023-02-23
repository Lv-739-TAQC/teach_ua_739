package org.ssu.edu.teachua.ui.pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;

import java.util.ArrayList;
import java.util.List;

public class ClubsPage extends BasePage {


    private final List<ClubCardComponent> clubs;

    public ClubsPage(WebDriver driver) {
        super(driver);
        clubs = initClubsCard();

    }

    private List<ClubCardComponent> initClubsCard() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ant-card ant-card-bordered card']"));
        List<ClubCardComponent> cards = new ArrayList<>();
        for (WebElement element : elements) {
            cards.add(new ClubCardComponent(driver, element));
        }
        return cards;
    }
}
