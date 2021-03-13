package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.Base_Page;
import com.cybertek.library.pages.Login_Page;
import com.cybertek.library.pages.Users_Module_Page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class All_StepDefinitions implements BrowserUtils {

  public Login_Page login_page = new Login_Page();
  public Base_Page base_page = new Base_Page();
  public Users_Module_Page users_module_page = new Users_Module_Page();
  public Faker faker = new Faker();
  public String newUserName = "";
  public WebElement dropdown;

  private String getCurrentPage(){
    String url = Driver.getDriver().getCurrentUrl();
    return url.substring(url.lastIndexOf("/") + 1);
  }

  @Given("User is on Library login {string} page")
  public void user_is_on_library_login_page(String environment) {
    Driver.getDriver().get(
            ConfigurationReader.getProperty(environment)
    );
  }

  @Given("User login as a {string}")
  public void user_login_as_a(String role){
    String userName = "";
    String password = "";
    switch (role){
      case "student":
        userName = ConfigurationReader.getProperty("student17Email");
        password = ConfigurationReader.getProperty("student17Password");
        break;
      case "librarian":
        userName = ConfigurationReader.getProperty("librarian13");
        password = ConfigurationReader.getProperty("librarian13Password");
        break;
    }
    login_page.inputEmail.sendKeys(userName);
    login_page.inputPassword.sendKeys(password);
    sleep(1);
    login_page.signInButton.click();
  }

  @Then("User is on {string} page")
  public void user_is_on_page(String expectedPage) {
    sleep(1);
    String actualPage = getCurrentPage();
    Assert.assertEquals(expectedPage, actualPage);
  }

  @When("User is on {string} module")
  public void user_is_on_module(String module) {
    base_page.navLinksContainer.findElement(By.xpath(
            ".//a[   .//span[.='" + module + "']    ]"
    )).click();
  }

  @When("User loges out from app")
  public void user_loges_out_from_app() {
    base_page.dropdownLogout.click();
    sleep(1);
    base_page.linkLogout.click();
  }

  @Then("User is on Login page")
  public void user_is_on_login_page() {
    String expectedPage = "login.html";
    String actualPage = getCurrentPage();
    Assert.assertEquals(expectedPage, actualPage);
  }

  @Given("User login with credentials {string} and {string}:")
  public void user_login_with_credentials_and(String userName, String password) {
    login_page.inputEmail.sendKeys(userName);
    login_page.inputPassword.sendKeys(password);
    sleep(1);
    login_page.signInButton.click();
  }

  @Then("User should see following modules:")
  public void user_should_see_following_modules(List<String> expectedModules) {
    List<WebElement> modules = base_page.navLinksContainer.findElements(By.xpath(
            "//span[@class='title']"
    ));
    List<String> actualModules = getElementsText(modules);
    Assert.assertEquals(expectedModules, actualModules);
  }

  @When("User opened add new user form")
  public void user_opened_add_new_user_form() {
    users_module_page.linkAddUser.click();
  }

  @When("User adds new User with valid info")
  public void user_adds_new_user_with_valid_info() {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
    wait.until(ExpectedConditions.visibilityOf(users_module_page.inputNewFullName));
    newUserName = faker.name().fullName();
    users_module_page.inputNewFullName.sendKeys(
            newUserName
    );
    users_module_page.inputNewPassword.sendKeys(
            faker.internet().password()
    );
    users_module_page.inputNewEmail.sendKeys(
            faker.internet().emailAddress()
    );
    Select userGroup = new Select(users_module_page.dropdownNewUserGroup);
    userGroup.selectByVisibleText("Students");
    Select status = new Select(users_module_page.dropdownNewStatus);
    status.selectByVisibleText("ACTIVE");
    users_module_page.textareaNewAddress.sendKeys(
            faker.address().fullAddress()
    );
    sleep(1);
    users_module_page.buttonSubmit.click();
  }

  @Then("New User is added or updated to records table")
  public void new_user_is_added_or_updated_to_records_table() {
    sleep(1);
    String actualUserName = users_module_page.newUserNameFromTable.getText();
    Assert.assertEquals(newUserName, actualUserName);
  }

  @When("User cancels adding new user")
  public void user_cancels_adding_new_user() {
    sleep(1);
    users_module_page.buttonClose.click();
  }

  @Then("Add new User form is closed")
  public void add_new_user_form_is_closed() {
    sleep(1);
    Assert.assertFalse(users_module_page.formAddNewUser.isDisplayed());
  }

  @When("User tries to edit User info")
  public void user_tries_to_edit_user_info() {
    users_module_page.buttonEdinUserFromTable.click();
    sleep(1);
    newUserName = faker.name().fullName();
    users_module_page.inputEditUserName.clear();
    users_module_page.inputEditUserName.sendKeys(newUserName);
    sleep(1);
    users_module_page.buttonEditSubmit.click();
  }

  @Then("Default records dropdown value is {string}")
  public void default_records_dropdown_value_is(String expectedRecordsNum) {
    Select select = new Select(users_module_page.dropdownShowRecords);
    String actualRecordsNum = select.getFirstSelectedOption().getText();
    Assert.assertEquals(expectedRecordsNum, actualRecordsNum);
  }

  @When("User clicks {string} dropdown")
  public void user_clicks_dropdown(String dropdownLabel) {
    dropdown = Driver.getDriver().findElement(By.xpath(
            "//select[./ancestor-or-self::label[contains(text(), '" +
                    dropdownLabel + "')] or ./../label[.='" +
                    dropdownLabel + "']]"
    ));
    dropdown.click();
  }

  @Then("User should see the following dropdown options:")
  public void user_should_see_the_following_dropdown_options(List<String> expectedDropdownOptions) {
    Select select = new Select(dropdown);
    List<String> actualDropdownOptions = getElementsText(select.getOptions());
    Assert.assertEquals(expectedDropdownOptions, actualDropdownOptions);
  }

  @Then("User should see the following table column names:")
  public void user_should_see_the_following_table_column_names(List<String> expectedTableColumnNames) {
    List<String> actualTableColumnNames = getElementsText(
            users_module_page.tableHeadColumns
    );
    Assert.assertEquals(expectedTableColumnNames, actualTableColumnNames);
  }

  @When("User selects a {string} from search by category dropdown")
  public void user_selects_a_from_search_by_category_dropdown(String category) {
    Select select = new Select(users_module_page.dropdownBookCategories);
    select.selectByVisibleText(category);
  }

  @Then("Books table should show books by {string}")
  public void books_table_should_show_books_by(String expectedCategory) {
    sleep(1);
    String actualCategory = users_module_page.bookCategoryFromTable.getText();
    Assert.assertEquals(expectedCategory, actualCategory);
  }
}