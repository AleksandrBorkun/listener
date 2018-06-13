package myprojects.automation.assignment3;

import myprojects.automation.assignment3.listener.DriverEventListener;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final Integer IMPLICIT_WAIT = 30;
    private static final Integer PAGE_LOAD_WAIT = 60;
    private WebDriver driver;
    private WebDriverEventListener driverEventListener;
    private EventFiringWebDriver eventFiringWebDriver;


    private final static DriverFactory INSTANCE = new DriverFactory();

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        return INSTANCE;
    }

    public EventFiringWebDriver getDriverListener() {
        if (eventFiringWebDriver != null) {
            return eventFiringWebDriver;
        }
        eventFiringWebDriver = new EventFiringWebDriver(getDriver());
        driverEventListener = new DriverEventListener();
        eventFiringWebDriver.register(driverEventListener);
        return eventFiringWebDriver;
    }

    private WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        switch (Properties.getBrowser()) {
            case BrowserType.CHROME:
                System.setProperty("webdriver.chome.driver", DriverFactory.class.getResource("chromedriver.exe").getPath());
                driver = new ChromeDriver();
                break;
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", DriverFactory.class.getResource("geckodriver.exe").getPath());
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Wrong Browser Type");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
        return driver;
    }

    public void driverClose() {
        driver.quit();
        driver = null;
        driverEventListener = null;
    }
}
