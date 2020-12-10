package test.java;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	    public synchronized void afterTest()
	    {
	        log.printf();
	    	Selenide.closeWebDriver();
	    }
}
