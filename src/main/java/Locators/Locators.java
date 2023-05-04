package Locators;

import org.openqa.selenium.By;

// CLASS WITH THE DEFINITION OF ALL LOCATORS
public class Locators {

    public static final By SHADOW_COOKIE_BANNER_SEL = By.cssSelector("cmm-cookie-banner");
    public static final By SHADOW_HEADER_SEL = By.cssSelector("owc-header");
    public static final By SHADOW_FLYOUT_SEL = By.cssSelector("vmos-flyout");
    public static final By SHADOW_FLYOUT_HEADER_SEL = By.cssSelector("owc-header-flyout");
    public static final By SHADOW_BUILD_CAR_SEL = By.cssSelector("owc-stage");
    public static final By SHADOW_CAR_CONFIG_SEL = By.cssSelector("owcc-car-configurator");
    public static final By SHADOW_CAR_CONFIG_FILTER_SEL = By.cssSelector("ccwb-multi-select");

    public static final By COOKIE_BANNER_CLASS = By.className("cmm-cookie-banner__content");
    public static final By COOKIE_AGREE_BUTTON_SELECTOR = By.cssSelector("div > div > div.cmm-cookie-banner__content > cmm-buttons-wrapper > div > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all");
    public static final By OUR_MODELS_BUTTON_CLASS = By.className("owc-header-navigation-topic__label");
    public static final By OUR_MODELS_TITLE_CLASS = By.className("owc-header-flyout__inner-content-title");
    public static final By OUR_MODELS_FLYOUT_TITLE_CLASS = By.className("owc-header-flyout__topbar-content");
    public static final By MODELS_BUTTONS_CLASS = By.cssSelector("#app-vue > div > ul > li:nth-child(3) > ul > li");
    public static final By MODELS_BUTTONS_FLYOUT_CLASS = By.cssSelector("#app-vue > div > owc-header-flyout > ul > li > ul > li");
    public static final By BUILD_CAR_BUTTON_SELECTOR = By.cssSelector("div > div.owc-stage__content-wrapper > div > div.owc-stage__cta-wrapper.wb-grid-row > div > div > a.owc-stage-cta-buttons__button.wb-button.wb-button--medium.wb-button--theme-dark.wb-button--large.wb-button--secondary.owc-stage-cta-buttons__button--secondary");
    public static final By CAR_CONFIG_FILTER_OVERLAY_SHADOW_SEL = By.className("overlay");
    public static final By FUEL_CHECKBOXES_SHADOW_SELECTOR = By.cssSelector("ccwb-checkbox");
    public static final By FUEL_DROPDOWN_CLASS = By.className("cc-motorization-filters-primary-filters");
    public static final By FUEL_CHECKBOXES_SELECTOR = By.className("indicator");
    public static final By CARDS_HEADER_CLASS = By.className("cc-motorization-header__price");
}