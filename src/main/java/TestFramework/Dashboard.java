package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Alin on 10/19/2016.
 */
public class Dashboard extends FirefoxBrowser{
    FirefoxBrowser please = new FirefoxBrowser();

    /**
     * Performs the click action on the "Transaction history" button in the left side menu
     */
    public void clickTransactionHistory(){
        browser.findElement(By.cssSelector("a[href=\"#/transactions\"]"));
    }

    /**
     * Performs the click action on the "Current hour transactions" button in the left side menu
     */
    public void clickCurrentHourTransaction(){
        browser.findElement(By.cssSelector("a[href=\"#/lasthourtransactions\"]"));    }

    /**
     * Performs the click action on the "Today transactions" button in the left side menu
     */
    public void clickTodayTransaction(){
        browser.findElement(By.cssSelector("a[href=\"#/todaytransactions\"]"));
    }
}
