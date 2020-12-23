package test.java;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class OpenBrowserTests extends Base {

    @Test
    @DisplayName("Test Open Browser and select a MacBook air")
    public void testOpenBrowser() throws Exception
    {
        Allure.step("Click menu item 'Laptops'");
        System.out.println("Click menu item 'Laptops'");
        $(withText("Laptops")).click();
        Allure.step("Select Item 'MacBook air'");
        System.out.println("openBrowser - Select a MacBook air");
        $(withText("MacBook air")).click();
    }


    @Test
    public void testOpenBrowserAndFailTest()
    {
            Allure.step("I want to fail the test");
            errorCollector.checkThat(false, IsEqual.equalTo(true));
    }

    @Test
    public void testWithchOnlyPrintInConsole()
    {
        System.out.println("------------------------:1");
        System.out.println("------------------------:2");
        System.out.println("------------------------:3");
    }
}
