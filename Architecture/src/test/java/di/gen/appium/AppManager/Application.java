package di.gen.appium.AppManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Application {
    private static Properties properties;
    private String target;
    private static AndroidDriver driver;

    public Application(String target) {

        this.target = target;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
        mobileSession(setCababilies(properties.getProperty("app"),properties.getProperty("device")));
            }

    public static DesiredCapabilities setCababilies(String appPath, String devicename) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // - название устройства(эмулятора)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
        //- адрес запускаемого приложения
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        return capabilities;
    }

    public static AndroidDriver<AndroidElement> mobileSession(DesiredCapabilities capabilities) {

        try {
            driver = new AndroidDriver<AndroidElement>(new URL(properties.getProperty("appiumserver")), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

    public void goToDragDrop(){
        goToViews();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
    }

    public void goToViews(){
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
    }

    public void swipe(){
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Spinner\"));");
    }


    public MobileElement createElement(By locator){
        //создаем элементы, первый - который тащим, второй - куда тащим
        MobileElement element = (MobileElement) driver.findElement(locator);
        return element;
    }

    public void dragAndDrop(String element1,String element2){
        MobileElement dragdot1 = createElement(By.xpath(element1));
        MobileElement dragdot2 = createElement(By.xpath(element2));
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



    public void stop() {
        driver.quit();

    }

    public void select(){
        //Locate all drop down list elements

        List<MobileElement> dropdownlist = driver.findElementsById("android:id/text1");
        //Extract text from each element of drop down list one by one
        for(MobileElement list: dropdownlist){
            if (list.getText().equals("Children")){
                list.click();
            }
        }

    }
}
