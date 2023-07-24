package core;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {
  protected static WebDriver driver;
  public static void setDriver(WebDriver actualDriver){
   driver = actualDriver;
  }
}
