package definitions;

import Actions.*;
import Helpers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;

public class Steps {

    // Class BrowserSetupSteps injected to retrieve the driver instance and use it in all steps execution
    private final BrowserSetupSteps browserSetupSteps;
    public Steps(BrowserSetupSteps browserSetupSteps) { this.browserSetupSteps = browserSetupSteps; }
    private static final long SLEEP_TIME = 1000;

    public WebDriver getDriver () {
        return browserSetupSteps.getDriver();
    }

    // STEP to Open a URL in the browser (URL passed as parameter - Cucumber step)
    @Given("^Open \"(.*)\" in \"(.*)\"$")
    public void openURL(String URL, String browser) throws Exception {
        try {

            // Initialize and setup browser driver
            browserSetupSteps.setUp(browser);
            // Open given URL
            getDriver().get(URL);
            // Wait for cookie banner and click the "Agree to all" button
            PageActions.wait_clickOn_agree_all_cookie_banner(getDriver());

        }catch(Exception e){
            System.out.println("Open URL '" + URL + "' on browser" + browser + "' Failed");
            throw e;
        }
    }

    // STEP to click a menu button and select a model (Values passed as parameter - Cucumber step)
    @Given("^Open \"(.*)\" menu, select \"(.*)\" and click the model \"(.*)\"")
    public void openMenuAndSelectModel(String menu, String button, String model) throws Exception {

            // Assertion to verify that "Our models" section is displayed
            Assert.assertTrue(menu + " button is not displayed", PageActions.isDisplayed_ourModels_button(getDriver(), menu));
            // Click to open "Our models"
            PageActions.clickOn_ourModels_button(getDriver(), menu);
            // Assertion to verify that "Our models" title is as expected
            Assert.assertEquals(menu + " title is not correct", PageActions.getTitle_ourModels_section(getDriver()), menu);
            // Click to select model "Hatchbacks/Saloons"
            PageActions.clickOn_ourModels_model_version_button(getDriver(), button);
            // Wait for prevent exception
            Thread.sleep(SLEEP_TIME);
            // Assertion to verify that "Model Flyout" section is displayed
            Assert.assertEquals(PageActions.getTitle_ourModels_flyout_section(getDriver()), button);
            // Click to select "A-Class"
            PageActions.clickOn_ourModels_model_version_flyout_button(getDriver(), model);
    }

    // STEP to click on the button
    @Then("^Click on the 'Build your car' button")
    public void clickBuildYourCarButton() {

            // Click on the "Build your car" button
            PageActions.clickOn_carPage_Build_your_car_button(getDriver());
            // Assertion to verify that "Car config" page is correct
            Assert.assertEquals("Car config URL is not correct", getDriver().getCurrentUrl(), Definitions.carConfig_URL_A_Class);
    }

    // STEP to click the filter field and select option (Value passed as parameter - Cucumber step)
    @Given("^Filter by fuel type \"(.*)\"")
    public void filterFuelType(String fuel) throws Exception {

            // Wait for prevent exception
            Thread.sleep(SLEEP_TIME);
            // Assertion to verify that "Fuel type" field is displayed
            Assert.assertTrue("Fuel field is not displayed", PageActions.isDisplayed_carConfig_fuel_field(getDriver()));
            // Scroll "Fuel type" field into the view
            PageActions.scrollTo_top_carConfig_fuel_field(getDriver());
            // Wait for prevent execution before scroll is completed
            Thread.sleep(SLEEP_TIME);
            // Click the "Fuel type" field to open the dropdown
            PageActions.clickOn_carConfig_fuel_field(getDriver());
            // Assertion to verify that "Fuel type" dropdown is displayed
            Assert.assertTrue("Fuel dropdown is not displayed", PageActions.isDisplayed_carConfig_fuel_dropdown(getDriver()));
            // Scroll the complete "Fuel type" dropdown into the view
            PageActions.scrollTo_carConfig_fuel_dropdown(getDriver());
            // Wait for prevent execution before scroll is completed
            Thread.sleep(SLEEP_TIME);
            // Wait for "Diesel" checkbox to be displayed
            Assert.assertTrue(fuel + " fuel checkbox is not displayed", PageActions.isDisplayed_carConfig_fuel_diesel_dropdown(getDriver(), fuel));
            // Click on the "Diesel" checkbox (filters)
            PageActions.clickOn_carConfig_fuel_diesel_dropdown(getDriver(), fuel);
            // Click the "ESC" keyboard button to close the "Fuel type" dropdown
            PageActions.clickOn_keyboard_esc_carConfig_fuel_dropdown(getDriver());
            // Scroll "Results" cards into view
            PageActions.scrollTo_bottom_carConfig_fuel_field(getDriver());
            // Wait for prevent execution before scroll is completed
            Thread.sleep(SLEEP_TIME);
    }

    // STEP to take and save screenshot of the results
    @Then("^Take and save a results screenshot")
    public void takeAndSaveScreenshot() throws Exception {
        try {

            // Take and save screenshot of the results (filtered variants)
            Files.takeAndSaveScreenshot(getDriver());
            System.out.println("Screenshot taken and saved successfully!");

        }catch(Exception e){
            System.out.println("Take and save screenshot Failed");
            throw e;
        }
    }

    // STEP to save the highest and lowest price of results in a text file
    @Then("^Save the highest and lowest price results in a text file")
    public void saveHighLowFile() throws Exception {
        try {

            // Save highest and lowest prices to a TXT File (filtered variants)
            Files.prepareAndSaveHighestAndLowestValuesToFile(getDriver());

        }catch(Exception e){
            System.out.println("Save highest and lowest price results in a file Failed");
            throw e;
        }
    }
}
