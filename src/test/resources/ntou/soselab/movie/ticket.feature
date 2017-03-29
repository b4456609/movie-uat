Feature: Ticket
    Background:
        Given the following user exist:
            | name  | phone       |
            | Ben   | 1234567890  |

    @order_endpoint_/book_POST
    @theater_endpoint_/show_POST
    @movie_endpoint_/_POST
    @theater_endpoint_/_POST
    Scenario: Book tickets
        Given the show exist:
                | startTimeHour  | startTimeMinute  |theater | emptySeat | movie       |
                | 10             | 30               | 2      | 21        | La La Land  |
        When The user book a La La Land ticket
        Then Successful book the ticket

    @order_endpoint_/tickets/{orderId}_POST
    @order_endpoint_/book_POST
    @theater_endpoint_/show_POST
    @movie_endpoint_/_POST
    @theater_endpoint_/_POST
    Scenario: Pick up tickets
        Given the show exist:
            | startTimeHour  | startTimeMinute  |theater | emptySeat | movie       |
            | 10             | 30               | 2      | 21        | La La Land  |
        And Ben has a order which is not picked up
        When The Ben pick the ticket
        Then Successful pick up the ticket