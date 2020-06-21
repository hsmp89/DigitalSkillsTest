package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.FreeCarCheckHomePage;
import pages.VehicleDetailPage;
import utils.CsvParser;
import utils.Util;

import java.util.List;
import java.util.Map;

public class VehicleEnquirySteps extends ScenarioSteps {

    @Steps
    FreeCarCheckHomePage freeCarCheckHomePage;

    @Steps
    VehicleDetailPage vehicleDetailPage;

    List<String> inputVehicleRegNumbers;
    Map<String, CsvParser> listOfOuptVehicleDetails;

//    SoftAssertions softAssertions = new SoftAssertions();

    @Step("Parsing list of Car Registration Numbers from the car_input.txt")
    public void vehicleDetailsAreThereInThe(String filePath) throws Throwable {
        String fileContent = Util.parseInputFileAsString(filePath);
        inputVehicleRegNumbers = Util.getDataOnRegx(fileContent);
    }

    @Step("Parsing list of expected car details from the car_output.txt")
    public void vehicleDetailsVerifiedWithWebsite(String outputFile) throws Throwable {
        listOfOuptVehicleDetails = Util.getCarOutputFileDataFromCSV(outputFile);
    }

    @Step("Navigate to car check website")
    public void navigateCarCheckSite() {
        freeCarCheckHomePage.navigateToFreeCarCheckWebSite();
    }

    @Step("Verifying Actual vehicle details against expected details")
    public void vehicleDetailsShouldMatchTheDetailsInThe() throws Throwable {
        getActualVechicleDataAndAssertWithOutputCSVData(listOfOuptVehicleDetails);
    }

    // Parse Vehicle Details From the OutPut CSV File and Assert with displayed vehicle details page
    private void getActualVechicleDataAndAssertWithOutputCSVData(Map<String, CsvParser> map) throws Exception {

        for (String regNumbFromInputText : inputVehicleRegNumbers) {

            CsvParser csvData = map.get(regNumbFromInputText);
            if (csvData == null) {
                System.out.println("No vehicle output data found for Vehicle Reg :  " + regNumbFromInputText);
            } else {
                freeCarCheckHomePage.enterCarRegistrationNumber(regNumbFromInputText);

                waitABit(2000);

                Assert.assertEquals("Verifying Registration Number", csvData.getREGISTRATION(), vehicleDetailPage.getWebpageRegistration());
                Assert.assertEquals("Verifying Make", csvData.getMAKE(), vehicleDetailPage.getWebpageCarMake());
                Assert.assertEquals("Verifying Model", csvData.getMODEL(), vehicleDetailPage.getWebpageCarModel());
                Assert.assertEquals("Verifying Colour", csvData.getCOLOR(), vehicleDetailPage.getWebpageCarColour());
                Assert.assertEquals("Verifying Year", csvData.getYEAR(), vehicleDetailPage.getWebpageCarYear());
            }
            if (regNumbFromInputText != null) freeCarCheckHomePage.navigateToFreeCarCheckWebSite();
        }
    }

}
