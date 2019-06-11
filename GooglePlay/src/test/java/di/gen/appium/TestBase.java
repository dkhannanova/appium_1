package di.gen.appium;


import di.gen.appium.AppManager.Application;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//@Listeners(MyTestListener.class)
public class TestBase {

  protected static final Application app = new Application(System.getProperty("target", "local"));

  @BeforeSuite
  public void setUP() throws IOException {
    app.init();
  }

  @AfterSuite
  public void tearDown()  {
    app.stop();
  }


}

