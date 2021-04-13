package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Users_Module_Page extends Base_Page {

  @FindBy(xpath = "//a[@href='tpl/add-user.html']")
  public WebElement linkAddUser;

  @FindBy(xpath = "//form[@id='add_user_form']//input[@name='full_name']")
  public WebElement inputNewFullName;

  @FindBy(xpath = "//form[@id='add_user_form']//input[@name='password']")
  public WebElement inputNewPassword;

  @FindBy(xpath = "//form[@id='add_user_form']//input[@name='email']")
  public WebElement inputNewEmail;

  @FindBy(xpath = "//form[@id='add_user_form']//select[@name='user_group_id']")
  public WebElement dropdownNewUserGroup;

  @FindBy(xpath = "//form[@id='add_user_form']//select[@name='status']")
  public WebElement dropdownNewStatus;

  @FindBy(xpath = "//form[@id='add_user_form']//textarea[@name='address']")
  public WebElement textareaNewAddress;

  @FindBy(xpath = "//form[@id='add_user_form']//button[.='Save changes']")
  public WebElement buttonSubmit;

  @FindBy(xpath = "//form[@id='add_user_form']//button[.='Close']")
  public WebElement buttonClose;

  @FindBy(xpath = "//table[@id='tbl_users']//tbody/tr[1]/td[3]")
  public WebElement newUserNameFromTable;

  @FindBy(xpath = "//div[@id='ajax']")
  public WebElement formAddNewUser;

  @FindBy(xpath = "//form[@id='edit_user_form']//button[.='Save changes']")
  public WebElement buttonEditSubmit;

  @FindBy(xpath = "//table[@id='tbl_users']//tbody/tr[1]/td[1]")
  public WebElement buttonEdinUserFromTable;

  @FindBy(xpath = "//form[@id='edit_user_form']//input[@name='full_name']")
  public WebElement inputEditUserName;

  @FindBy(xpath = "//select[@name='tbl_users_length']")
  public WebElement dropdownShowRecords;

  @FindBy(xpath = "//table//th")
  public List<WebElement> tableHeadColumns;

  @FindBy(xpath = "//select[@id='book_categories']")
  public WebElement dropdownBookCategories;

  @FindBy(xpath = "//table[@id='tbl_books']//tbody/tr[1]/td[5]")
  public WebElement bookCategoryFromTable;

  @FindBy(id = "user_count")
  public WebElement userCount;

  @FindBy(xpath = "//input[@type='search']")
  public WebElement inputSearch;

  @FindBy(xpath = "//table[@id='tbl_users']//thead/tr[1]/th[2]")
  public WebElement adjustOrder;

  @FindBy(xpath = "//table[@id='tbl_users']//tr[1]/td[1]/a")
  public WebElement buttonEditFirstUser;

  @FindBy(xpath = "//div[@id='edit_user_modal']")
  public WebElement editUserPopup;
}
