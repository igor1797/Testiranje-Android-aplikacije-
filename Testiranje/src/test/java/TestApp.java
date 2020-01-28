import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestApp{
    AndroidDriver driver;
    //Change the news title based on the current news that is displayed
    String newsTitle1 = "Trump releases long-awaited Mid-East peace plan";
    String newsTitle2 = "China coronavirus: Misinformation spreads online";
    String newsTitle3 = "Watch President Trump's impeachment trial";
    String appName = "Factory News";

    @BeforeClass()
    public void setUp() throws MalformedURLException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Users\\Igor\\Documents\\Android_projekti\\Testiranje-Android-aplikacije-\\APK\\app-debug.apk");
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName","emulator");
        capabilities.setCapability("platformName","Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testCal() throws Exception {
        MobileElement newsTitle= (MobileElement)
                driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]\n"));
        newsTitle.click();

        //This tests whether the clicked news is open
        //Assert.assertEquals(driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView\n").getText(), newsTitle1);

        MobileElement backButton= (MobileElement)
                driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        backButton.click();

        //This tests whether the name of the application is displayed
        //Assert.assertEquals(driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView").getText(), appName);

        MobileElement newsImage = (MobileElement)
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.ImageView\n"));
        newsImage.click();

        //This tests whether the clicked news is open
        //Assert.assertEquals(driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView\n").getText(), newsTitle2);

        TouchAction swipe = new TouchAction(driver);
        swipe.press(new PointOption().withCoordinates(984,951))
                .moveTo(new PointOption().withCoordinates(71,942))
                .release()
                .perform();

        //This tests whether the swiped news is open
        //Assert.assertEquals(driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView\n").getText(), newsTitle3);

        MobileElement backButtonAgain= (MobileElement)
                driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        backButtonAgain.click();

        teardown();
    }
    public void teardown(){
        driver.quit();
    }}