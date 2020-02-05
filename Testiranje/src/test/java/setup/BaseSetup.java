package setup;

import constants.CapabilityName;
import constants.MobileCapabilityConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private AndroidDriver<AndroidElement> driver;
    private DesiredCapabilities capabilities;

    private void initCapability(){
        capabilities = new DesiredCapabilities();
    }

    private void setCapability(){
        capabilities.setCapability(CapabilityName.APP, MobileCapabilityConstants.APP);
        capabilities.setCapability(CapabilityName.VERSION, MobileCapabilityConstants.VERSION);
        capabilities.setCapability(CapabilityName.DEVICE_NAME, MobileCapabilityConstants.DEVICE_NAME);
        capabilities.setCapability(CapabilityName.PLATFORM_NAME, MobileCapabilityConstants.PLATFORM_NAME);
        capabilities.setCapability(CapabilityName.PACKAGE_NAME, MobileCapabilityConstants.APP_PACKAGE);
    }

    private void initDriver(){
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<AndroidElement>(url, capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public AndroidDriver<AndroidElement> getDriver(){
        return driver;
    }

    @BeforeClass
    public void setup(){
        initCapability();
        setCapability();
        initDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
