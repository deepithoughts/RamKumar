Feature: To get List of all Objects

  @getAllObjects
  Scenario: To receive all restfull objects from the API
    Given Hit the base URL "https://api.restful-api.dev/"
    When the user hits the "objects" with payload GET HTTP request
    Then status code is verified as 200

    @PostObject
    Scenario: To add an Object in RestAPI
      Given User is on the website landing page "https://api.restful-api.dev/"
      When the user hits the "objects" with payload using http post request
      """
    {
    "name": "Apple MacBook Pro 16",
    "data": {
    "year": 2019,
    "price": 1849.99,
    "CPU model": "Intel Core i9",
    "Hard disk size": "1 TB"
    }
    }
    """
      Then capture the "id" from the resposne body
    Then the response body is verified where name is "Apple MacBook Pro 16"
      And status code is 200
