package di.gen.appium.Tests;


import di.gen.appium.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SimilarApps extends TestBase {


    @Test
    public static void similarApps(){
         app.fill(By.xpath("//android.widget.ImageView[@resource-id='com.android.vending:id/search_box_idle_text']"),"Whatsapp");
         app.enter();


    }

}


