package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.DB_Utilities;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

  @After
  public void closeDriver(){
    Driver.closeDriver();
  }

  @After(value = "@db")
  public void closeConnection(){
    DB_Utilities.closeConnection();
    System.out.println("DB connection closed");
  }

  @Before(value = "@db")
  public void createConnection(){
    String url = ConfigurationReader.getProperty("library1.database.url");
    String username = ConfigurationReader.getProperty("library1.database.username");
    String password = ConfigurationReader.getProperty("library1.database.password");

    DB_Utilities.createConnection(url, username, password);
  }
}
