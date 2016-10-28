package Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alin on 10/28/2016.
 */
public class Driver {

    protected static WebDriver browser;
    private static WebDriverWait delay;
    public enum elementType{
        css,xpath
    }

    public void launchBrowser() {
        browser  = new FirefoxDriver();
    }

    public void goToURL(String url){
        browser.navigate().to(url);
    }

    public void closeBrowser(){
        browser.quit();
    }

    public void waitForElementToBeVisible(elementType type, String element) {
        delay  = new WebDriverWait(browser,10);
        switch (type) {

            case css:
                delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
                break;
            case xpath:
                delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
                break;
        }
    }

    public void waitForElementToBeClickable(elementType type, String element) {
        delay  = new WebDriverWait(browser,10);
        switch (type) {

            case css:
                delay.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
                break;
            case xpath:
                delay.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
                break;
        }
    }
}
