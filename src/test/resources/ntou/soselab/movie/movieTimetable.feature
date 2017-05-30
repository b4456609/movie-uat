Feature: Movie Timetable

    Background:
        Given the following show exist:
            | startTimeHour  | startTimeMinute  | theater | emptySeat | movie       |
            | 10             |           0      | 2       | 21        | La La Land  |
            | 10             |          10      | 3       | 12        | La La Land  |
            | 10             |          20      | 1       | 2         | Moonlight   |
            | 13             |           0      | 4       | 0         | Zootopia    |

    Scenario: View Movie Timetable
        Given I am a guest
        When I view timetable
        Then I get 4 show information

    Scenario Outline: View Show Detail
        Given I am a guest
        When I view show, <movie>, detail
        Then The number of result should be <resultNumber>
            And <emptySeat> empty seat should be exist in one item

        Examples:
            | movie      | resultNumber | emptySeat   |
            | La La Land | 2            | 21          |
            | La La Land | 2            | 12          |
            | Moonlight  | 1            | 2           |
            | Zootopia   | 1            | 0           |