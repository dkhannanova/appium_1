package di.gen.appium.Tests;


import di.gen.appium.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SimilarApps extends TestBase {


    @Test
    public static void similarApps(){
        app.clickByLocator(By.id("com.android.vending:id/search_box_idle_text"));
        app.fill(By.xpath("//android.widget.FrameLayout[@resource-id='com.android.vending:id/text_container']"),"whatsapp");
        app.enter();
        app.clickByLocator(By.xpath("//android.widget.Button[@text='MORE INFO']"));

    }

}


