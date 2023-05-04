@MercedesIODemo
Feature: Automation Testing Task - MercedesIO

  @Test-MercedesIODemo
  Scenario Outline: Validate A-Class models prices are between £15,000 and £60,000
    Given Open "<URL>" in "<browser>"
    Given Open "<menu>" menu, select "<button>" and click the model "<model>"
    Then Click on the 'Build your car' button
    Given Filter by fuel type "<fuel>"
    Then Take and save a results screenshot
    Then Save the highest and lowest price results in a text file

    # Browsers supported: Chrome and Edge
    Examples:
      | URL                             | browser   | menu        | button    | model            | fuel    |
      | https://www.mercedes-benz.co.uk | Chrome    | Our models  | Saloons   | A-Class Saloon   | Diesel  |