package com.seleniumtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {

  WebDriver driver;

  @Before
  public void initDriver(){
    driver = AppTestSuite.getDriver();
  }

  @Test
  public void testVideoPlayBack() {
    driver.get("https://webrtc.github.io/samples/src/content/getusermedia/gum/");

    WebElement showVideoButton = driver.findElement(By.id("showVideo"));
    WebElement video = driver.findElement(By.id("gum-local"));

    Assert.assertEquals(video.getAttribute("videoHeight"), "0");
    Assert.assertEquals(video.getAttribute("videoWidth"), "0");
    Assert.assertEquals(video.getAttribute("paused"), "true");

    showVideoButton.click();

    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.attributeToBe(video, "readyState", "4"));

    Assert.assertEquals(video.getAttribute("videoHeight"), "480");
    Assert.assertEquals(video.getAttribute("videoWidth"), "640");
    Assert.assertNull(video.getAttribute("paused"));

    driver.quit();Assert.assertTrue(true);
  }
}
