package org.ssu.edu.teachua.utils.providers;

import org.ssu.edu.teachua.api.models.location.Location;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProviderCentre {

    @DataProvider(name = "dpTestAddCenterUI")
    public static Object[][] dpTestAddCenterUI() {
        return new Object[][]{
                {"First language center", "Лівий берег", "Одеса", "Фонтан", "Приморський", "проспект Бажана, 3А",
                        "50.406108, 30.668492", "0679002233", 1, "https://www.facebook.com/1lngcenter/",
                        "https://1lngcenter/", "center@gmail.com", "1lngcenter", "+380630336789", "0503334455",
                        "photos/centerLogo.jpg", "photos/centerPhoto.jpg", "Кількість курсів, призначених для окремих вікових" +
                        "груп, залежить від суми використовуваних на сьогоднішній день грантів", 100,
                        Arrays.asList("Особистий кабінет", "Admin Admin", "АДМІНІСТРАТОР", "0689543242", "admin@gmail.com")}
        };
    }

    @DataProvider(name = "dpTestAddCenterDB")
    public static Object[][] dpTestAddCenterDB() {
        return new Object[][]{
                {"test-name-1", "test-location-1", "Дніпро", "Заводська", "Соборний", "Шевченка, 10А",
                        "45.406508, 34.668592", "0679002233", 1, "0503334455", ("test-description-1").repeat(5), 1},
        };
    }

    @DataProvider(name = "pdTestCreateCenterDescriptionInvalid")
    public static Object[][] pdTestCreateCenterDescriptionInvalid() {
        Location location = new Location(0, "location23", "test321", "Київ", "Дарницький", "Вирлиця", "49.829104498711104, 24.005058710351314", "0563339988");
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(location);
        ArrayList<Integer> clubsId = new ArrayList<>();
        clubsId.add(37);
        return new Object[][]{
                {
                        "API testing center edition",
                        locations,
                        "Testing description field of the center",
                        "0563339988",
                        clubsId,
                        "description Length should be between 40 and 1500 chars"

                },
                {
                        "API testing center edition",
                        locations,
                        "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat. At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere p..",
                        "0563339988",
                        clubsId,
                        "description Length should be between 40 and 1500 chars"

                },
                {
                        "API testing center edition",
                        locations,
                        "TestЫng description fiЁld of the center",
                        "0563339988",
                        clubsId,
                        "description Length should be between 40 and 1500 chars and description Помилка. Присутні недопустимі символи"

                }
        };
    }
}