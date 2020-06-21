Feature: Perform a free car check

  @vehicleTest
  Scenario Outline: Verify Vehicle details
    Given I parse list of Car Registration Numbers from the "<input_file>"
    And I parse expected car details from the "<output_file>"
    When I check car details in the car tax check website
    Then Actual vehicle details are verified with expected details
    Examples:
      | input_file                                | output_file                                |
      | src/test/resources/testdata/car_input.txt | src/test/resources/testdata/car_output.txt |
