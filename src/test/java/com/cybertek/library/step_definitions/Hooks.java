package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

  @After
  public void closeDriver(){
    Driver.closeDriver();
  }
}
