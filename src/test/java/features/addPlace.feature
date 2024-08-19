Feature: Functionality to add a new place
  @Run @Walk
  Scenario: Add a new place
    Given Create the add place payload
      | Element      | Value                     |
      | ACCURACY     | 50                        |
      | NAME         | Frontline house           |
      | ADDRESS      | 29, side layout, cohen 09 |
      | PHONE NUMBER | (+91) 983 893 3937        |
      | LANGUAGE     | French-IN                 |
      | WEBSITE      | http://google.com         |
      | LATITUDE     | -38.383494                |
      | LONGITUDE    | 33.427362                 |
      | FIRST TYPE   | shoe park                 |
      | SECOND TYPE  | shop                      |
    When Trigger the "AddPlaceApi" request
    Then Validate the status code for the response is 200
    And Validate "scope" in response is "APP"
    And Validate "status" in response is "OK"