package di.gen.appium.Tests;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.android.AndroidKeyCode.BACK;

public class AndroidSettings {

    @Test
    public static void androidSettings() {
//инициализация андроид драйвера
        AndroidDriver<AndroidElement> driver = null;
        //настройки "фикстуры"
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // - название устройства(эмулятора)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "claclaguruemulatornexus5");
        //- адрес запускаемого приложения
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\appiumAutomation\\apk\\ApiDemos-debug.apk");

        capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("appActivity", "com.android.settings.Settings");
        capabilities.setCapability("noReset", "true");

        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        driver.findElementByXPath("//android.widget.LinearLayout[6]//android.widget.LinearLayout").click();
       // items2.get(6).click();
        if(driver.findElementById("android:id/switch_widget").getAttribute("checked").equals("false"))
        {driver.findElementById("android:id/switch_widget").click();
      Assert.assertEquals((driver.findElementById("android:id/switch_widget").getAttribute("checked")),"true");}
        else{
            driver.findElementById("android:id/switch_widget").click();
            Assert.assertEquals((driver.findElementById("android:id/switch_widget").getAttribute("checked")),"false");

        }



    }
}

