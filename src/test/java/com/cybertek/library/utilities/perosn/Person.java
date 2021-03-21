package com.cybertek.library.utilities.perosn;

import com.github.javafaker.Faker;

public class Person {

  private static final Faker faker = new Faker();
  protected static String fulName = "", password = "", email = "", fulAddress = "";

  public static void setValues() {
    fulName = faker.name().fullName();
    password = faker.internet().password();
    email = faker.internet().emailAddress();
    fulAddress = faker.address().fullAddress();
  }

  public static String getFulName(){
    return fulName;
  }

  public static String getPassword() {
    return password;
  }

  public static String getEmail() {
    return email;
  }

  public static String getFulAddress() {
    return fulAddress;
  }
}
