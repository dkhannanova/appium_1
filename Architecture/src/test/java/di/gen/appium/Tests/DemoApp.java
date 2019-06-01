package di.gen.appium.Tests;


import di.gen.appium.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.offset.PointOption.point;

public class DemoApp extends TestBase {

    //@Test
    public static void demoApp() {
        app.goToDragDrop();
        app.dragAndDrop("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']", "//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']");

    }
    //@Test
    public static void demoAppSwipe(){
        app.goToViews();
        app.scroll("Spinner");
    }

    @Test
    public static void checkDropdown(){
        app.goToViews();
        app.scroll("Lists");
        app.clickByLocator(By.xpath("//android.widget.TextView[@text='Lists']"));
        app.clickByLocator(By.xpath("//android.widget.TextView[@text='11. Multiple choice list']"));
        app.select("Children");

    }

}


