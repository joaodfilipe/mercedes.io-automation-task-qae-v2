package definitions;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// CLASS WITH THE DEFINITION OF ALL BROWSER METHODS
public class BrowserSetupSteps {

    private static WebDriver driver;

    // STEP called initially to initialize the driver instance (according to parameter)
    public void setUp(String browser) {
        try {

            // Set driver according to parameter
            switch (browser.toLowerCase()) {

                // CHROME DRIVER
                case ("chrome"):
                    // Chrome Driver capabilities
                    ChromeOptions optionsChr = new ChromeOptions();
                    optionsChr.addArguments("--incognito"); // Always run in incognito mode (clear session)
                    optionsChr.addArguments("--remote-allow-origins=*");

                    // Initialize chrome driver
                    driver = WebDriverManager.chromedriver().capabilities(optionsChr).create();
                    driver.manage().window().maximize(); // Maximize current window
                    break;

                    // MS EDGE DRIVER
                case ("edge"):
                    // Edge Driver capabilities
                    EdgeOptions optionsEdg = new EdgeOptions();
                    optionsEdg.addArguments("InPrivate");
                    optionsEdg.addArguments("--remote-allow-origins=*");

                    // Initialize ms edge driver
                    driver = WebDriverManager.edgedriver().capabilities(optionsEdg).create();
                    driver.manage().window().maximize(); // Maximize current window
                    break;
                default:
                    throw new NotImplementedException();
            }

    }catch(Exception e){
        System.out.println("Browser setup Failed");
        throw e;
    }
    }

    // STEP called after the test steps to close the browser (If any of the steps fail)
    // Executed before each test (@AfterClass executed only once)
    @After
    public void closeWindowOnFailed(Scenario s) {
        if (s.isFailed()) try {
            driver.close();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    // STEP called after each test to close the browser
    @After
    public void closeBrowser() throws Exception{
        // Sleep function called to allow to check the actions done in the page (before the browser is closed)
        Thread.sleep(1000);
        quitWebDriver();
    }

    // Function to return the driver instance
    WebDriver getDriver() {
        return driver;
    }

    // Function to close the browser
    void quitWebDriver(){
        driver.quit();
    }
}