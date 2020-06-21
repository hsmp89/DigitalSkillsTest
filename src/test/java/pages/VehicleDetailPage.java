package pages;

import net.serenitybdd.core.pages.PageObject;

public class VehicleDetailPage extends PageObject {

    String REGISTRATION = "//*[contains(text(),'Registration')]/parent::*/dd";
    String MAKE = "//*[contains(text(),'Make')]/parent::*/dd";
    String MODEL = "//*[contains(text(),'Model')]/parent::*/dd";
    String COLOUR = "//*[contains(text(),'Colour')]/parent::*/dd";
    String YEAR = "//*[contains(text(),'Year')]/parent::*/dd";

    public String getWebpageRegistration() {
        return waitFor(REGISTRATION).$(REGISTRATION).getText();
    }

    public String getWebpageCarMake() {
        return waitFor(MAKE).$(MAKE).getText();
    }

    public String getWebpageCarModel() {
        return waitFor(MODEL).$(MODEL).getText();
    }

    public String getWebpageCarColour() {
        return waitFor(COLOUR).$(COLOUR).getText();
    }

    public String getWebpageCarYear() {
        return waitFor(YEAR).$(YEAR).getText();
    }

}
