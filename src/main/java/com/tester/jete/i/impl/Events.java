package com.tester.jete.i.impl;

import com.tester.jete.i.Driver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Arrays.asList;

/**
 * @ClassName Events
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:21
 */
public class Events {
    public static Events events = new Events(LoggerFactory.getLogger(Events.class));

    private final Logger log;

    Events(Logger log) {
        this.log = log;
    }

    private static final String JS_CODE_TO_TRIGGER_EVENT =
            "var webElement = arguments[0];\n" +
                    "var eventNames = arguments[1];\n" +
                    "for (var i = 0; i < eventNames.length; i++) {" +
                    "  if (document.createEventObject) {\n" +  // IE
                    "    var evt = document.createEventObject();\n" +
                    "    webElement.fireEvent('on' + eventNames[i], evt);\n" +
                    "  }\n" +
                    "  else {\n" +
                    "    var evt = document.createEvent('HTMLEvents');\n " +
                    "    evt.initEvent(eventNames[i], true, true );\n " +
                    "    webElement.dispatchEvent(evt);\n" +
                    "  }\n" +
                    '}';

    public void fireEvent(Driver driver, WebElement element, String... event) {
        try {
            executeJavaScript(driver, element, event);
        }
        catch (StaleElementReferenceException ignore) {
        }
        catch (Exception e) {
            log.warn("Failed to trigger events {}: {}", asList(event), Cleanup.of.webdriverExceptionMessage(e));
        }
    }

    void executeJavaScript(Driver driver, WebElement element, String... event) {
        driver.executeJavaScript(JS_CODE_TO_TRIGGER_EVENT, element, event);
    }
}
