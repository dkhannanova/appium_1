package di.gen.appium.Tests;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.android.AndroidKeyCode.BACK;

public class First {

    @Test
    public static void first() {
//инициализация андроид драйвера
        AndroidDriver<AndroidElement> driver = null;
        //настройки "фикстуры"
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // - название устройства(эмулятора)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "claclaguruemulatornexus5");
        //- адрес запускаемого приложения
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\appiumAutomation\\apk\\ApiDemos-debug.apk");

        //пример capabilities встроенного приложения "calculator"
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("noReset", "true");

        //capabilities.setCapability("appPackage", "com.android.settings");
        //capabilities.setCapability("appActivity", "com.android.settings.Settings");
        //capabilities.setCapability("noReset", "true");

        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        String a = "5";
        String b = "7";

        driver.findElementByXPath(String.format("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_%s']",a)).click();

        List<AndroidElement> buttins = driver.findElementsByXPath("//android.widget.Button");
        for(AndroidElement element:buttins){
            if(element.getAttribute("text").equals("+")){element.click();}
                    }
        driver.findElementByXPath(String.format("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_%s']",b)).click();
        driver.findElementByAndroidUIAutomator("text(\"=\")").click();
        driver.findElementById("com.android.calculator2:id/clr").click();
        //вводим значение в поле
        driver.findElementById("com.android.calculator2:id/formula").sendKeys("987");
        //используем "базовые" команды андроида, home back etc.
        driver.pressKeyCode(AndroidKeyCode.HOME);


    }
}

