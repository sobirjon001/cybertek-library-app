package com.cybertek.library.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

  private Driver(){}

  private static WebDriver driver;

  public static WebDriver getDriver(){

    if(driver == null){

        try {
          URL url = new URL("http://127.0.0.1:4444/wd/hub");
          DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
          desiredCapabilities.setBrowserName("chrome");
          driver = new RemoteWebDriver(url, desiredCapabilities);
        } catch (Exception e) {
          e.printStackTrace();
        }


      }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    return driver;
  }

  public static void closeDriver(){
    if(driver != null){
      driver.quit();
      driver = null;
    }
  }
}