package Actions;

import Objects.PageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

// CLASS WITH THE DEFINITION OF ALL ELEMENTS ACTIONS
public class PageActions {

    public static void wait_clickOn_agree_all_cookie_banner(WebDriver driver){
        // Wait for cookie policy popup to be visible
        PageObjects.component_cookie_byClassName_wait_visibility(driver);
        // Click the "Agree to all" button
        PageObjects.component_cookie_byCssSelector_agree_button_selector(driver).click();
    }

    public static boolean isDisplayed_ourModels_button(WebDriver driver, String button){

        return PageObjects.component_ourModels_byClassName_button_selector(driver, button).isDisplayed();
    }

    public static void clickOn_ourModels_button(WebDriver driver, String button){

        PageObjects.component_ourModels_byClassName_button_selector(driver, button).click();
    }

    public static String getTitle_ourModels_section(WebDriver driver){

        return PageObjects.component_ourModels_byClassName_Title_selector(driver).getText();
    }

    public static String getTitle_ourModels_flyout_section(WebDriver driver){

        return PageObjects.component_ourModels_byClassName_flyout_title_selector(driver).getText();
    }

    public static void clickOn_ourModels_model_version_button(WebDriver driver, String button){

        PageObjects.component_ourModels_byClassName_menu_text_selector(driver, button).click();
    }

    public static void clickOn_ourModels_model_version_flyout_button(WebDriver driver, String button){

        PageObjects.component_ourModels_byClassName_menu_text_flyout_selector(driver, button).click();
    }

    public static void clickOn_carPage_Build_your_car_button(WebDriver driver){

        PageObjects.component_carPage_byCssSel_build_button_selector(driver).click();
    }

    public static boolean isDisplayed_carConfig_fuel_field(WebDriver driver){

        return PageObjects.component_carConf_byClassName_fuel_selector(driver).isDisplayed();
    }

    public static void scrollTo_top_carConfig_fuel_field(WebDriver driver){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", PageObjects.component_carConf_byClassName_fuel_selector(driver));
    }

    public static void scrollTo_bottom_carConfig_fuel_field(WebDriver driver){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PageObjects.component_carConf_byClassName_fuel_selector(driver));
    }

    public static void clickOn_carConfig_fuel_field (WebDriver driver){

        PageObjects.component_carConf_byClassName_fuel_selector(driver).click();
    }

    public static boolean isDisplayed_carConfig_fuel_dropdown (WebDriver driver){

        return PageObjects.component_carConf_byClassName_filter_overlay_selector(driver).isDisplayed();
    }

    public static void scrollTo_carConfig_fuel_dropdown (WebDriver driver){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", PageObjects.component_carConf_byClassName_filter_overlay_selector(driver));
    }

    public static boolean isDisplayed_carConfig_fuel_diesel_dropdown (WebDriver driver, String fuel){

        return PageObjects.carConfig_byClassName_filter_checkboxes_selector(driver, fuel).isDisplayed();
    }

    public static void clickOn_carConfig_fuel_diesel_dropdown (WebDriver driver, String fuel){

        PageObjects.carConfig_byClassName_filter_checkboxes_selector(driver, fuel).click();
    }

    public static void clickOn_keyboard_esc_carConfig_fuel_dropdown (WebDriver driver){

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }
}