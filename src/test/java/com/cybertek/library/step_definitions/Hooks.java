package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.DB_Utilities;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

  @After(order = 1)
  public void takeScreenShot(Scenario scenario){
    if(scenario.isFailed()){
      byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenShot, "image/png", scenario.getName());
    }
  }

  @After(order = 2)
  public void closeDriver(){
    Driver.closeDriver();
  }

  @After(value = "@db")
  public void closeConnection(){
    DB_Utilities.closeConnection();
  }

  @Before(value = "@db")
  public void createConnection(){
    String url = ConfigurationReader.getProperty("library1.database.url");
    String username = ConfigurationReader.getProperty("library1.database.username");
    String password = ConfigurationReader.getProperty("library1.database.password");

    DB_Utilities.createConnection(url, username, password);
  }
}
