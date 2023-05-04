package Helpers;

import Objects.PageObjects;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// CLASS WITH THE DEFINITIONS OF ALL STATIC DEFINITIONS
public class Files {

    public static void takeAndSaveScreenshot(WebDriver driver) throws Exception {
        try {

            // Take screenshot
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Save the screenshot inside "results" folder
            String screenShotName = "results_" + java.time.LocalDateTime.now();
            FileUtils.copyFile(scrFile, new File("./results/screenshotsResults/" + screenShotName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Take screenshot Failed: " + e.getMessage());
            throw e;
        }
    }

    public static void prepareAndSaveHighestAndLowestValuesToFile(WebDriver driver) throws Exception {

        // Save all price elements in the results
        List<WebElement> shadowElements = PageObjects.component_carConf_byClassName_All_result_cards_selector(driver);
        List<Integer> list = new ArrayList<>();

        // Convert the values to integers, remove the characters and save them to another list (for comparison)
        for (WebElement webElement : shadowElements) {
            list.add(Integer.valueOf(webElement.getText().replace("£", "").replace(",", "")));
        }

        // Convert values to the original decimal format
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        // Get max and min values of the list and save them to the text file
        System.out.println("HIGHEST result value is: " + "£" + decimalFormat.format(Collections.max(list)));
        System.out.println("LOWEST result value is: " + "£" + decimalFormat.format(Collections.min(list)));
        writeHighAndLowValuesToFile("£" + decimalFormat.format(Collections.max(list)), "£" + decimalFormat.format(Collections.min(list)));
    }

    public static void writeHighAndLowValuesToFile(String highest, String lowest) throws Exception {
        try {

            // Set file name and file path
            String fileName = "HighestAndLowest_" + java.time.LocalDateTime.now() + ".txt";
            String filePath = System.getProperty("user.dir") + "/results/" + fileName;
            File file = new File(filePath);
            FileWriter write = new FileWriter(filePath);

            // Create text file
            if (file.createNewFile()) {
                System.out.println("File already exists: " + file.getName());
            }

            // Save highest and lowest results (passed by parameter) in the text file
            write.write("HIGHEST value in results: " + highest + System.getProperty( "line.separator"));
            write.write("LOWEST value in results: " + lowest );
            // Close file after saving the result values
            write.close();
        }
        catch (Exception e)
        {
            System.out.println("Save highest and lowest value to File Failed: " + e.getMessage());
            throw e;
        }
    }
}