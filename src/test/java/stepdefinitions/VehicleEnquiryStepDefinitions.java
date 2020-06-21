package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.VehicleEnquirySteps;

public class VehicleEnquiryStepDefinitions {

    @Steps
    VehicleEnquirySteps vehicleEnquirySteps;
    @Given("^I parse list of Car Registration Numbers from the \"([^\"]*)\"$")
    public void vehicleDetailsAreThereInThe(String filePath) throws Throwable {
        vehicleEnquirySteps.vehicleDetailsAreThereInThe(filePath);
    }
    @And("^I parse expected car details from the \"([^\"]*)\"$")
    public void vehicleDetailsAreVerifiedOnTheCartaxCheckWebsite(String outputFile) throws Throwable {
        vehicleEnquirySteps.vehicleDetailsVerifiedWithWebsite(outputFile);
    }

    @When("^I check car details in the car tax check website$")
    public void navigateCarCheckSite() {
        vehicleEnquirySteps.navigateCarCheckSite();
    }

    @Then("^Actual vehicle details are verified with expected details$")
    public void vehicleDetailsShouldMatchTheDetailsInThe() throws Throwable {
        vehicleEnquirySteps.vehicleDetailsShouldMatchTheDetailsInThe();
    }

}
