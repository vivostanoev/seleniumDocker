package seleniumDocker;

import java.net.MalformedURLException;
import java.net.URL;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class Base {

		WebDriver driver;

	    @Rule
	    public ErrorCollector errorCollector = new ErrorCollector();
	    
	    @Rule
	    public seleniumDocker.LoggerRule log = new LoggerRule();

	    @Before
	    public void beforeTest() throws MalformedURLException {

	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        String host = System.getProperty("seleniumHubHost");

			System.out.println("-------------------------------------------------"+ host);

	        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
			WebDriverRunner.setWebDriver(driver);

	        Selenide.open("https://www.demoblaze.com/");
	        //driver.get("https://www.demoblaze.com/");

	    }


	@After
	    public synchronized void afterTest()
	    {
	        Selenide.closeWebDriver();
	    }
}
