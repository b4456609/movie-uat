Feature: User Registraion

    @user_endpoint_/registration_POST
    Scenario Outline: User Registraion
        Given I am a unregister user
            And I provide a <name>
            And I provide a <phone>
        When I register the account
        Then I got my user id
            And I can check my name is <name>
            And I can check my phone number is <phone>

        Examples:
            | name  | phone       |
            | Ben   | 1234567890  |
            | Marry | 1234523590  |