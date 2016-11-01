package Tests;
import TestFramework.Constants;
import TestFramework.FirefoxBrowser;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import org.testng.ITestNGMethod;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Alin on 10/19/2016.
 */

public class TestConfig extends FirefoxBrowser{

    public FirefoxBrowser driver = new FirefoxBrowser();

    @BeforeSuite
    public void setup() throws Exception {
        driver.launchBrowser();
        driver.goToURL(Constants.url);
        driver.waitForElementToBeClickable(FirefoxBrowser.elementType.css,"input[id=\"username\"]");
        driver.verifyTitle("Archive2Azure - Login");
        driver.enterUsername(Constants.username);
        driver.enterPassword(Constants.password);
        driver.clickLogin();
        driver.waitForElementToBeVisible(FirefoxBrowser.elementType.xpath,"/html/body/div/div[2]/div[1]/div/div/div[3]/ul/li[1]/a");
        driver.verifyTitle("Archive2Azure");

    }


    @AfterMethod(alwaysRun = true)
    public void onTestFailure(ITestResult result) throws Exception {
        if (!result.isSuccess())
            Reporter.setCurrentTestResult(result);
            Reporter.log(takeScreenShoot(browser, result.getMethod()));
            Reporter.setCurrentTestResult(null);
    }
    public String takeScreenShoot(WebDriver driver, ITestNGMethod testMethod) throws Exception {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameScreenshot = testMethod.getXmlTest().getName().toUpperCase() + "_" + testMethod.getTestClass().getRealClass().getSimpleName() + "_" + testMethod.getMethodName();
        String path = getPath(nameScreenshot);
        FileUtils.copyFile(screenshot, new File(path));
        String screenShot = "<a href=" + path + " target='_blank' >" + this.getFileName(nameScreenshot) + "</a>";
        return screenShot;
    }

    private String getFileName(String nameTest) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
        Date date = new Date();
        return dateFormat.format(date) + "_" + nameTest + ".png";
    }

    private String getPath(String nameTest) throws IOException {
        File directory = new File(".");
        String newFileNamePath = directory.getCanonicalPath() + "\\target\\surefire-reports\\screenShots\\" + getFileName(nameTest);
        return newFileNamePath;
    }


    @AfterSuite
    public void tearDown() throws Exception {
        driver.closeBrowser();
    }
}
