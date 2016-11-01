package Tests;

import TestFramework.Constants;
import TestFramework.FirefoxBrowser;
import TestFramework.Ingestion;
import org.testng.annotations.Test;

public class NewCabinetType extends TestConfig {

    @Test
    public void testNewCabinetType(){

        Ingestion driver = new Ingestion();
        driver.goToURL(Constants.url);
        driver.clickIngestionButton();
        driver.advancedMasterField();
        driver.manageCabinetTypes();
        driver.newCabinetType();
        driver.enterCabinetName("Cabinet Name Auto 4");
        driver.enterCabinetDescription("Cabinet Description Auto 3");
        driver.searchCabinetFieldBox();
        driver.addSchemaFields("Index Field Disp Name Auto 5");
        driver.okMasterField();
        driver.saveIndexField();


    }
}
