package com.seleniumtest;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Suite.class)
@SuiteClasses({AppTest.class})
public class AppTestSuite {

  private static WebDriver driver;

  @BeforeClass
  public static void setUpBeforeTestClass(){
    // initialize a browser driver, connect to servers
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    ArrayList<String> chromeConfigs = new ArrayList<String>();
    chromeConfigs.add("--use-fake-ui-for-media-stream");
    chromeConfigs.add("--use-fake-device-for-media-stream");
    ChromeOptions options = new ChromeOptions();
    options.addArguments(chromeConfigs);
    driver = new ChromeDriver(options);
  }

  public static WebDriver getDriver() {
    return driver;
  }

  @AfterClass
  public static void tearDownAfterTestClass() {
    // close connections, close browser as needed
    driver.quit();
  }
}
