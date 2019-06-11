package di.gen.appium.AppManager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NavigationManager {


    private AndroidDriver driver;

    public NavigationManager(AndroidDriver driver) {

        this.driver = driver;
    }

    public void clickByLocator (By locator){
        //создаем элементы, первый - который тащим, второй - куда тащим
        driver.findElement(locator).click();
    }

    public void goToDragDrop(){
        goToViews();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
    }

    public void goToViews(){
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
    }

    public void scroll(final String scrollTotext){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + scrollTotext + "\"));");
    }
}
