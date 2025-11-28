package com.lambdatest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.github.lambdatest.SmartUISnapshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmartUISDKPlaywrightLocal {
  private Playwright playwright;
  private Browser browser;
  private Page page;

  // Setup Playwright and Browser
  @BeforeMethod
  public void setup() {
    playwright = Playwright.create();
    BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
      .setHeadless(false);
    browser = playwright.chromium().launch(launchOptions);
    page = browser.newPage();
    System.out.println("Playwright Browser initiated");
  }

  @Test
  public void basicTest() throws Exception {
    page.navigate("https://www.lambdatest.com");
    SmartUISnapshot.smartuiSnapshot(page, "screenshot");
  }

  @AfterMethod
  public void tearDown() {
    if (browser != null) {
      browser.close();
    }
    if (playwright != null) {
      playwright.close();
    }
  }

}
