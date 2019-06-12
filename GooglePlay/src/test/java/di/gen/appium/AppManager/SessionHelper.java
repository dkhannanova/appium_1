package di.gen.appium.AppManager;

import io.appium.java_client.android.AndroidDriver;

public class SessionHelper {
    private AndroidDriver driver;

    public SessionHelper(AndroidDriver driver) {

        this.driver = driver;
    }


}
