# mercedes.io-automation-tech-challenge

## Getting Started

### Languages and frameworks
```
Core Language: Java
Frameworks:
    - Selenium
    - Cucumber
```

### Project Structure 

```
-- 1. "DemoTest.feature" : 
    Cucumber feature file with the definition of the Gherkin challenge steps;

-- 2. "Steps" : 
    Java file with all the step definitions that are linked to a Gherkin step in the cucumber scenario;

-- 3. "BrowserSetupSteps" : 
    Java file with the definition of methods for the initialization/management of the driver instance;

-- 4. "PageObjects" : 
    Java file with the definition of methods that are responsible for returning all necessary WebElements;

-- 5. "Locators" : 
    Java file with the definition of all static locators necessary to find the WebElements of the test;

-- 6. "Files" : 
    Java file with the definition of all methods responsible for the files management (Screenshot and txt file);

-- 7. "Definitions" : 
    Java file with the definition of all static constants;

-- 8. "PageActions" : 
    Java file that gathers the calls for all element methods and runs the necessary actions;
    
NOTE --> ALL project dependencies added to the "pom" XML file :
            - commons-io
            - junit
            - cucumber-java
            - ...
```

## Objectives

### Challenge task list

#### | Validate A Class models price are between £15,000 and £60,000 |

- [x] Open Mercedes-benz United Kingdom market
- [x] Under “Our Models” - Select “Model: Hatchbacks”
- [x] Mouse over the “A Class” model available and proceed to “Build your car”
- [x] Filter by Fuel type “Diesel”
- [x] Take and save a screenshot of the results
- [x] Save the value “£” of the highest and lowest price results in a text file

### Cucumber Gherkin steps (Challenge task list)

```
@MercedesIODemo
Feature: Automation Technical Task - MercedesIO

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
```

## Instructions

* On the feature file ("DemoTest"), change "browser" to the desired driver (Chrome or Edge)

```
Browsers supported:
    - Chrome
    - Edge
```

* Run the previous feature file to start the automation scenario: "**Validate A-Class models prices are between £15,000 and £60,000**"
