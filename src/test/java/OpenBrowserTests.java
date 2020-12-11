package test.java;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class OpenBrowserTests extends Base {

    @Test
    @DisplayName("First Test")
    public void testOpenBrowser() throws Exception
    {
        log.addLog("openBrowser - Click menu item Laptop");
        Allure.step("Click menu item 'Laptops'");
        System.out.println("Click menu item 'Laptops'");
        $(withText("Laptops")).click();
        log.addLog("openBrowser - Select a MacBook air");
        System.out.println("openBrowser - Select a MacBook air");
        $(withText("MacBook air")).click();
    }


//    @Test
//    public void testOpenBrowserAndFailTest()
//    {
//            log.addLog("openBrowserAndFailTest- assert true true");
//            Allure.step("I want to fail the test");
//            errorCollector.checkThat(false, IsEqual.equalTo(true));
//            log.addLog("openBrowserAndFailTest - second test finished");
//    }

    @Test
    public void testWithchOnlyPrintInConsole()
    {
        log.addLog("testWithchOnlyPrintInConsole - first print");
        log.addLog("testWithchOnlyPrintInConsole - second print");
        log.addLog("testWithchOnlyPrintInConsole - third print");
    }
}
