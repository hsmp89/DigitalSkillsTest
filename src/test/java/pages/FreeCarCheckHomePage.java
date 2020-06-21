package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class FreeCarCheckHomePage extends PageObject {

    public void enterCarRegistrationNumber(String regNumber) {
        $(By.id("vrm-input")).type(regNumber);
        evaluateJavascript("arguments[0].click()", $("//button[text()='Free Car Check']"));
    }

    public void navigateToFreeCarCheckWebSite() {
        open();
    }
}
