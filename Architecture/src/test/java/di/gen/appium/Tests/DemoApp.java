package di.gen.appium.Tests;


import di.gen.appium.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class DemoApp extends TestBase {

    @Test
    public static void demoApp() {
        app.goToDragDrop();
        app.dragAndDrop("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']", "//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']");

    }
    @Test
    public static void demoAppSwipe(){
        app.goToViews();
        app.swipe();

    }

}


