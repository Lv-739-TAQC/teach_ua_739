Feature: News Article File Compression

  Background: Login as admin
    Given User log in as an admin
    And User is on the add news article page

  Scenario: Verify that image of a news article is compressed to 300KB
    When User fills in the news article title "Example23_Приклад"
    And User fills in the news article content "ExamplePOIUQ*$%9328r2390idkdslxmsn1!;?*(0_,/ЇЄПриклад~+=-"
    And User fills in the news article image "photos/heart.png" greater than 300KB
    And User submits the news article
    Then The system should compress the image "heart.png" to 300000 or less