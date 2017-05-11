Feature: Movie Detail
    Background:
        Given the following movies exist:
            | La La Land  |
            | Moonlight   |
            # | Zootopia    |

  @movie_endpoint_/find_GET
    Scenario: View All Movie Detail
        Given I am a guest
        When I view all movies detail
        Then I get 3 movies detail

    @movie_endpoint_/find_GET
    Scenario Outline: View a Specific Movie Detail
        Given I am a guest
            And I provide a <movieName>
        When I view <movieName> detail
        Then The <movieName> should be exist

        Examples:
            | movieName   |
            | La La Land  |
            | Moonlight   |
            | Zootopia    |