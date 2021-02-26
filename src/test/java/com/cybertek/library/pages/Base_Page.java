package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {

  public Base_Page(){
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(id = "menu_item")
  public WebElement navLinksContainer;

  @FindBy(id = "navbarDropdown")
  public WebElement dropdownLogout;

  @FindBy(linkText = "Log Out")
  public WebElement linkLogout;

}
