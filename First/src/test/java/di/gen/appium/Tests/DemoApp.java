package di.gen.appium.Tests;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.android.AndroidKeyCode.BACK;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class DemoApp {

    @Test
    public static void demoApp() {
//инициализация андроид драйвера
        AndroidDriver<AndroidElement> driver = null;
        //настройки "фикстуры"
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // - название устройства(эмулятора)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "claclaguruemulatornexus5");
        //- адрес запускаемого приложения
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\appiumAutomation\\apk\\ApiDemos-debug.apk");

        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

        //создаем элементы, первый - который тащим, второй - куда тащим
        MobileElement dragdot1 = driver.findElementByXPath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']");
        MobileElement dragdot2 = driver.findElementByXPath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']");

        //выявлем координаты этих элементов
        Point center1 = dragdot1.getCenter();
        Point center2 = dragdot2.getCenter();

       //создаем объект, перетягивающий элемент dragdot1 на место dragdot2
        TouchAction dragdrop = new TouchAction(driver).
                longPress(longPressOptions()
                        .withPosition(point(center1.x,center1.y))
                        .withDuration(Duration.ofSeconds(2)))
                        .moveTo(point(center2.x,center2.y))
                        .release();
        //выполняем функцию perform объекта
        dragdrop.perform();




        //используем "базовые" команды андроида, home back etc.
        driver.pressKeyCode(AndroidKeyCode.HOME);


    }
}


