package test.java;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Base {

	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();
	    
	@Rule
	public LoggerRule log = new LoggerRule();



	@Before
	    public void beforeTest() throws MalformedURLException {
			ChromeOptions dc = new ChromeOptions();

	        String host = System.getProperty("seleniumHubHost");

			System.out.println("-------------------------------------------------"+ host);

	        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://"+host+":4444/wd/hub"), dc);
			WebDriverRunner.setWebDriver(driver);

	        Selenide.open("https://www.demoblaze.com/");
	        //driver.get("https://www.demoblaze.com/");

	    }


	@After
	    public synchronized void afterTest() throws IOException {
	        log.printf();
	    	Selenide.closeWebDriver();
	    }


	@Attachment(type = "image/png")
	public byte[] screenshot() throws IOException {
		File screenshot = Screenshots.getLastScreenshot();
		return Files.toByteArray(screenshot);
	}
}
