package Tests;

import TestFramework.Constants;
import TestFramework.FirefoxBrowser;
import TestFramework.Ingestion;
import org.testng.annotations.Test;

public class NewIndexField extends TestConfig {

    @Test
    public void testNewIndexField(){

        Ingestion driver = new Ingestion();
        driver.goToURL(Constants.url);
        driver.clickIngestionButton();
        driver.advancedMasterField();
        driver.manageIndexFields();
        driver.newIndexField();
        driver.enterNewIndexFieldDisplayName("Index Field Disp Name Auto 5");
        driver.enterIndexFieldName("indexfieldnameauto3");

        driver.searchableCheckbox(true);
        driver.retrievableCheckbox(true);
        driver.sortableCheckbox(false);
        driver.filterableCheckbox(false);

        /* TO DO assertion
        div[text()="Media Files"] */

        driver.saveIndexField();

    }
}
