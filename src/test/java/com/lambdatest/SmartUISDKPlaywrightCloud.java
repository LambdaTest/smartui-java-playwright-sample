package com.lambdatest;

import com.google.gson.JsonObject;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.github.lambdatest.SmartUISnapshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SmartUISDKPlaywrightCloud {
  Page page;
  Browser browser;

  @BeforeMethod
  public void setup(Method m, ITestContext ctx) throws MalformedURLException, UnsupportedEncodingException {
    Playwright playwright = Playwright.create();
    JsonObject capabilities = new JsonObject();
    JsonObject ltOptions = new JsonObject();

    String user = System.getenv("LT_USERNAME");
    String accessKey = System.getenv("LT_ACCESS_KEY");
    capabilities.addProperty("browsername",
      "Chrome"); // Browsers allowed: `Chrome`, `MicrosoftEdge`, `pw-chromium`, `pw-firefox` and `pw-webkit`
    capabilities.addProperty("browserVersion", "latest");
    ltOptions.addProperty("platform", "Windows 10");
    ltOptions.addProperty("name", "SmartUI Playwright Test");
    ltOptions.addProperty("build", "SmartUI Playwright Java Build");
    ltOptions.addProperty("user", user);
    ltOptions.addProperty("accessKey", accessKey);
    capabilities.add("LT:Options", ltOptions);

    BrowserType chromium = playwright.chromium();
    String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + capabilities;
    browser = chromium.connect(cdpUrl);
    page = browser.newPage();
  }

  @Test
  public void basicTest() throws Exception {
    System.out.println("Loading Url");
    page.navigate("https://www.lambdatest.com/visual-regression-testing");
    SmartUISnapshot.smartuiSnapshot(page, "SmartUI");
  }

  @AfterMethod
  public void tearDown() {
    browser.close();
  }

}
