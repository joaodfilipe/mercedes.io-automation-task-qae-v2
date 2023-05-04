package Objects;

import Locators.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

// CLASS WITH THE DEFINITION OF ALL PAGES ELEMENTS
public class PageObjects {

    private static WebElement element = null;
    private static final long WAIT_TIMEOUT = 10;

    // ELEMENT - Shadow container (Cookie popup)
    public static WebElement cookie_popup_container_shadow_dom (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SHADOW_COOKIE_BANNER_SEL));
        return element;
    }

    // ELEMENT - Shadow container (Our models section - Header)
    public static WebElement ourModels_container_shadow_dom_header(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SHADOW_HEADER_SEL));
        return element;
    }

    // ELEMENT - Shadow container (Our models section - Flyout)
    public static WebElement ourModels_container_shadow_dom_flyout(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SHADOW_FLYOUT_SEL));
        return element;
    }

    // ELEMENT - Shadow container (Car page)
    public static WebElement carPage_build_shadow_dom(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SHADOW_BUILD_CAR_SEL));
        return element;
    }

    // ELEMENT - Shadow container (Car configurator)
    public static WebElement carConfig_container_shadow_dom (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SHADOW_CAR_CONFIG_SEL));
        return element;
    }

    // ELEMENT - Shadow container (Our models section - Flyout - Title)
    public static WebElement component_ourModels_byClassName_flyout_title_selector(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        // GET first Shadow
        SearchContext shadowRoot = ourModels_container_shadow_dom_flyout(driver).getShadowRoot();
        // GET second Shadow
        WebElement shadowContent = wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(Locators.SHADOW_FLYOUT_HEADER_SEL)));
        SearchContext shadowRootTwo = shadowContent.getShadowRoot();
        element = wait.until(ExpectedConditions.visibilityOf(shadowRootTwo.findElement(Locators.OUR_MODELS_FLYOUT_TITLE_CLASS)));
        return element;
    }

    // ELEMENT - Shadow container (Car configurator - Fuel Filter)
    public static WebElement component_carConf_byClassName_filter_overlay_selector(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        // GET first Shadow
        SearchContext shadowRoot = carConfig_container_shadow_dom(driver).getShadowRoot();
        // GET second Shadow
        WebElement shadowContent = wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(Locators.SHADOW_CAR_CONFIG_FILTER_SEL)));
        SearchContext shadowRootTwo = shadowContent.getShadowRoot();
        element = wait.until(ExpectedConditions.elementToBeClickable(shadowRootTwo.findElement(Locators.CAR_CONFIG_FILTER_OVERLAY_SHADOW_SEL)));
        return element;
    }

    // _____________________

    // ELEMENT - Return selector (by className) for the cookie banner popup (Wait for visibility of banner)
    public static WebElement component_cookie_byClassName_wait_visibility(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = cookie_popup_container_shadow_dom(driver).getShadowRoot();
        boolean success = false;

        while (!success) {
            try {
                element = wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(Locators.COOKIE_BANNER_CLASS)));
                success = true;
            } catch(Exception e){
                // Wait until element is visible
            }
        }
        return element;
    }

    // ELEMENT - Return selector (by cssSelector) for the "Agree to all" button
    public static WebElement component_cookie_byCssSelector_agree_button_selector(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = cookie_popup_container_shadow_dom(driver).getShadowRoot();
        element = wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(Locators.COOKIE_AGREE_BUTTON_SELECTOR)));
        return element;
    }

    // ELEMENT - Return selector (by className) for the menu buttons ("Our models" - Search and return the element)
    public static WebElement component_ourModels_byClassName_button_selector(WebDriver driver, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = ourModels_container_shadow_dom_header(driver).getShadowRoot();
        List<WebElement> shadowElement = shadowRoot.findElements(Locators.OUR_MODELS_BUTTON_CLASS);

        for (WebElement webElement : shadowElement) {
            if (webElement.getText().equals(text)) element = wait.until(ExpectedConditions.visibilityOf(webElement));
        }
        return element;
    }

    // ELEMENT - Return selector (by className) for the "Our models" title
    public static WebElement component_ourModels_byClassName_Title_selector(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = ourModels_container_shadow_dom_header(driver).getShadowRoot();
        element = wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(Locators.OUR_MODELS_TITLE_CLASS)));
        return element;
    }
    // ELEMENT - Return selector (by cssSelector) for a model on "Our models" (Saloons/Hatchbacks - Search and return the element)
    public static WebElement component_ourModels_byClassName_menu_text_selector(WebDriver driver, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = ourModels_container_shadow_dom_flyout(driver).getShadowRoot();
        List<WebElement> shadowElement = shadowRoot.findElements(Locators.MODELS_BUTTONS_CLASS);

        for (WebElement webElement : shadowElement) {
            if (webElement.getText().equals(text)) element = wait.until(ExpectedConditions.visibilityOf(webElement));
        }
        return element;
    }

    // ELEMENT - Return selector (by cssSelector) for a model on "Our models" ("A Class" - Search and return the element)
    public static WebElement component_ourModels_byClassName_menu_text_flyout_selector(WebDriver driver, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = ourModels_container_shadow_dom_flyout(driver).getShadowRoot();
        List<WebElement> shadowElement = shadowRoot.findElements(Locators.MODELS_BUTTONS_FLYOUT_CLASS);

        for (WebElement webElement : shadowElement) {
            if (webElement.getText().equals(text)) element = wait.until(ExpectedConditions.visibilityOf(webElement));
        }
        return element;
    }

    // ELEMENT - Return selector (by cssSelector) for the "Build your car" button
    public static WebElement component_carPage_byCssSel_build_button_selector(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = carPage_build_shadow_dom(driver).getShadowRoot();
        element = wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(Locators.BUILD_CAR_BUTTON_SELECTOR)));
        return element;
    }

    // ELEMENT - Return selector (by className) for a "Fuel type" on the dropdown ("Diesel" - Search and return the element)
    public static WebElement carConfig_byClassName_filter_checkboxes_selector(WebDriver driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        // GET first Shadow
        SearchContext shadowRoot = carConfig_container_shadow_dom(driver).getShadowRoot();
        // GET second Shadow
        List<WebElement> shadowContent = shadowRoot.findElements(Locators.FUEL_CHECKBOXES_SHADOW_SELECTOR);

        for (WebElement webElement : shadowContent) {
            if (webElement.getText().equals(text)) element = wait.until(ExpectedConditions.visibilityOf(webElement));
        }
        SearchContext shadowRootThree = element.getShadowRoot();
        element = wait.until(ExpectedConditions.elementToBeClickable(shadowRootThree.findElement(Locators.FUEL_CHECKBOXES_SELECTOR)));
        return element;
    }

    // ELEMENT - Return selector (by className) for "Fuel type" field (Wait until visible)
    public static WebElement component_carConf_byClassName_fuel_selector(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        SearchContext shadowRoot = carConfig_container_shadow_dom(driver).getShadowRoot();
        boolean success = false;

        while (!success) {
            try {
                element = wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(Locators.FUEL_DROPDOWN_CLASS)));
                success = true;
            } catch(Exception e){
                // Wait until element is visible
            }
        }
        return element;
    }

    // ELEMENT - Return list of selectors (by className) for all model result cards (Filtered)
    public static List<WebElement> component_carConf_byClassName_All_result_cards_selector(WebDriver driver){
        SearchContext shadowRoot = carConfig_container_shadow_dom(driver).getShadowRoot();
        return shadowRoot.findElements(Locators.CARDS_HEADER_CLASS);
    }
}