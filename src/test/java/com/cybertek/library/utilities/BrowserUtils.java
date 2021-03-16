package com.cybertek.library.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public interface BrowserUtils {

  default void sleep(int seconds){
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  default WebElement waitForvisibility(WebElement webElement, int timeToWaitInSec){
    WebDriverWait wait = new  WebDriverWait(Driver.getDriver(), timeToWaitInSec);
    return wait.until(ExpectedConditions.visibilityOf(webElement));
  }

  default List<String> getElementsText(List<WebElement> list){
    List<String> elementsTexts = new ArrayList<>();
    for (WebElement webElement : list) {
      elementsTexts.add(webElement.getText());
    }
    return elementsTexts;
  }
}
