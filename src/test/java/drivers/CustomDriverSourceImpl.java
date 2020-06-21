package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.Util;

import java.util.ArrayList;
import java.util.List;

public class CustomDriverSourceImpl implements CustomDriverSource {

    public CustomDriverSourceImpl() {
    }

    public WebDriver newDriver() {
        WebDriver driver = null;
        String browserName = Util.getSystemPropertyValue("browser", DriverType.CHROME.name()).toUpperCase();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        boolean externalDrivers = Boolean.parseBoolean(System.getProperty("externalDrivers", "true"));
        DriverType driverType = DriverType.valueOf(browserName);
        List<String> arguments = new ArrayList();
        if (headless) {
            arguments.add("--headless");
        }
        switch(driverType) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(arguments);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
            case IEXPLORER:
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            case OPERA:
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments(arguments);
                driver = new OperaDriver(operaOptions);
                break;
            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                //safariOptions.se.addArguments(arguments);
                driver = new SafariDriver(safariOptions);
                break;
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments(arguments);
                driver = new ChromeDriver(options);
        }

        return (WebDriver)driver;
    }

    public boolean takesScreenshots() {
        return true;
    }
}
