package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Alin on 10/20/2016.
 */
public class Index extends FirefoxBrowser{
    FirefoxBrowser please = new FirefoxBrowser();

//Index Policies
        /**
         * Performs the click action on the "Index Policies" button in the left side menu
         */
        public void clickIndexPolicies() {
            browser.findElement(By.cssSelector("a[href=\"#/manageIndexes\"]")).click();
        }

        /**
         * Performs the click action on the "Index Analytics" button in the left side menu
         */
        public void clickIndexAnalytics() {
            browser.findElement(By.cssSelector("a[href=\"#/indexAnalytics\"]")).click();
        }

        /**
         * Performs the click action on the "Refresh" button on Indexes page
         */
        public void refreshIndexGrid() {
            browser.findElement(By.cssSelector("div[title=\"Refresh the Index Grid\"]")).click();
        }

        /**
         * Performs the click action on the "Cancel" button in the "View Index" menu
         */
        public void viewIndexCancel() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel[1]/div/div/div/div[4]/div/div[1]/div/i")).click();
        }

        /**
         * Performs the click action on the "Cancel" button in the "Build Index" menu
         */
        public void buildIndexCancel() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel[1]/div/div/div/div[4]/div/div[1]/div/i")).click();
        }

        /**
         * Performs the click action on the "Discover" button in the "Build Index" menu
         */
        public void buildIndexDiscover() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel[3]/div/div/div/div[4]/div/div[2]/div/span")).click();
        }

        /**
         * Performs the click action on the "Discover and Build" button in the "Build Index" menu
         */
        public void buildIndexDiscoverAndBuild() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel[3]/div/div/div/div[4]/div/div[3]/div/span")).click();
        }

        /**
         * Performs the click actions on the "No" button in the "Delete confirmation" menu when trying to delete an index
         */
        public void deleteIndexNo(){
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[1]/div")).click();
        }

        /**
         * Performs the click actions on the "Yes" button in the "Delete confirmation" menu when trying to delete an index
         */
        public void deleteIndexYes(){
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[2]/div")).click();
        }

        /**
         * Performs the click action on the "Ok" button in the "Cabinets" menu
         */
        public void viewSchemaOkButton(){
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel[7]/div/div/div/div[4]/div/div/div")).click();
        }

        /**
         * Performs the click action on the "View Index Properties" button corresponding to the desired row
         * @param text String of the row we want actions performed on. (e.g. the name of the Row)
         */
        public void viewIndexProperties(String text){
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row index-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(text)){
                    row.findElement(By.cssSelector("i[class=\"fa fa-eye\"]")).click();
                    break;
                }
            }
        }

        /**
         * Performs the click action on the "Schema" link corresponding to the desired row
         * @param text String of the row we want actions performed on. (e.g. the name of the Row)
         */
        public void viewSchema(String text){
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row index-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(text)){
                    row.findElement(By.cssSelector("a[ng-click=\"vm.viewStreams(item)\"]")).click();
                    break;
                }
            }
        }

        /**
         * Performs the click action on the "Build Index" button corresponding to the desired row
         * @param text String of the row we want actions performed on. (e.g. the name of the Row)
         */
        public void buildIndex(String text){
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row index-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(text)){
                    row.findElement(By.cssSelector("div[title=\"Build Index\"]")).click();
                    break;
                }
            }
        }

        /**
         * Performs the click action on the "Delete Index" button corresponding to the desired row
         * @param text String of the row we want actions performed on. (e.g. the name of the Row)
         */
        public void deleteIndex(String text){
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row index-row ng-scope\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(text)){
                row.findElement(By.cssSelector("i[class=\"fa fa-times\"]")).click();
                break;
            }
        }
    }

        /**
         * Performs the click action on the "Create New" button in the Index Policies page
         */
        public void createNewIndex() {
        browser.findElement(By.cssSelector("div[title=\"Create new Index\"]")).click();
    }
//Index schemas

        /**
         * Peforms the click action on the "Index Schemas" button on the left side menu
         */
        public void clickIndexSchemas() {
                browser.findElement(By.cssSelector("a[href=\"#/manageSchemas\"]")).click();
            }

        /**
         * Performs the click action on the "Create New" button in the Index Schemas page
         */
        public void createNewIndexSchema() {
                browser.findElement(By.cssSelector("i[class=\"fa fa-plus-circle\"]")).click();
            }

        /**
         * Performs the click action on the "single cabinet" radio button in the "Create New Schema" menu
         */
        public void newSchemaTypeSingleCabinet(){
                browser.findElement(By.cssSelector("input[name=\"Schema type1\"]")).click();
            }

        /**
         * Performs the click action on the "multiple cabinet" radio button in the "Create New Schema" menu
         */
        public void newSchemaTypeMultipleCabinet(){
                browser.findElement(By.cssSelector("input[name=\"Schema type2\"]")).click();
            }

        /**
         * Selects the desired cabinet from the "Cabinet" drop-down menu
         * @param value String of the cabinet to be selected
         */
        public void selectSingleCabinet(String value){
        Select select = new Select(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/select")));
        select.selectByVisibleText(value);
        }

        /**
         * Enters the desired name in the "Index Schema Name" field
         * @param name Name to be entered
         */
        public void indexSchemaName(String name){
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).sendKeys(name);
        }

        /**
         * Enters the desired description in the "Index Schema Description" field
         * @param description Description to be entered
         */
        public void indexSchemaDescription(String description){
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input")).sendKeys(description);
        }

        /**
         * Performs the check action on the "Lite Search" checkbox
         * @param check true = checked, false = leave unchecked
         */
        public void checkLiteSearch(Boolean check){
        if(check==true) {
            browser.findElement(By.cssSelector("input[value=\"3\"]")).click();
        }else if(check==false){}
        }

        /**
         * Selects the desired field from the "Fields" section one at a time
         * @param text Name of the item to be selected
         */
        public void selectSchemaFields(String text){
        List<WebElement> tableList = browser.findElements(By.cssSelector("p[class=\"false\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(text)){
                row.findElement(By.cssSelector("input[type=\"checkbox\"")).click();
                break;
            }
        }
    }
}
