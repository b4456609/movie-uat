Feature: Ticket
    Background:
        Given the following user exist:
            | name  | phone       |
            | Ben   | 1234567890  |

    @order_endpoint_/book_POST
    Scenario: Book tickets
        Given the show exist:
                | startTimeHour  | startTimeMinute  |theater | emptySeat | movie       |
                | 10             | 30               | 2      | 21        | La La Land  |
        When The user book a La La Land ticket
        Then Successful book the ticket

    @order_endpoint_/tickets/{orderId}_POST
    Scenario: Pick up tickets
        Given Ben has a order which is not picked up
        When The Ben pick the ticket
        Then Successful pick up the ticket