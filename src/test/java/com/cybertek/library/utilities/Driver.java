package com.cybertek.library.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

  private Driver(){}

  private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

  public static WebDriver getDriver(){

    if(driverPool.get() == null){

      synchronized (Driver.class) {

        try {
          URL url = new URL("http://localhost:4444/wd/hub");
          DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
          desiredCapabilities.setBrowserName("chrome");
          driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
        } catch (Exception e) {
          e.printStackTrace();
        }

        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverPool.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
      }

    }
    return driverPool.get();
  }

  public static void closeDriver(){
    if(driverPool.get() != null){
      driverPool.get().quit();
      driverPool.remove();
    }
  }
}
