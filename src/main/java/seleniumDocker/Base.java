package seleniumDocker;

import static com.codeborne.selenide.Selenide.open;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import com.codeborne.selenide.Selenide;

public class Base {


	    @Rule
	    public ErrorCollector errorCollector = new ErrorCollector();
	    
	    @Rule
	    public LoggerRule log = new LoggerRule();

	    @Before
	    public void beforeTest() throws MalformedURLException {

//	        DesiredCapabilities dc = DesiredCapabilities.chrome();
//
//	        if (System.getProperty("browser").equals("firefox"))
//	            dc = DesiredCapabilities.firefox();
//
//	        String host = System.getProperty("seleniumHubHost");
//
//	        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);


	        open("https://www.demoblaze.com/");
	        //driver.get("https://www.demoblaze.com/");

	    }

	    @After
	    public synchronized void afterTest()
	    {
	        Selenide.closeWebDriver();
	    }
}
