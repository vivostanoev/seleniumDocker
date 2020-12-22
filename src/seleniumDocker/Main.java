package seleniumDocker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.java.OpenBrowserTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OpenBrowserTests.class
})
public class Main {	
	
}
