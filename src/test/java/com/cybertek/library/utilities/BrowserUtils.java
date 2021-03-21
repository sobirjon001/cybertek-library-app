package com.cybertek.library.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

  public void sleep(int seconds){
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void waitForVisibilityOf(WebElement webElement, int timeToWaitInSec){
    WebDriverWait wait = new  WebDriverWait(Driver.getDriver(), timeToWaitInSec);
    wait.until(ExpectedConditions.visibilityOf(webElement));
  }

  public List<String> getElementsText(List<WebElement> list){
    List<String> elementsTexts = new ArrayList<>();
    for (WebElement webElement : list) {
      elementsTexts.add(webElement.getText());
    }
    return elementsTexts;
  }
}
