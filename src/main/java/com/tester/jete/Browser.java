package com.tester.jete;

import static com.tester.jete.i.Browsers.CHROME;
import static com.tester.jete.i.Browsers.EDGE;
import static com.tester.jete.i.Browsers.FIREFOX;
import static com.tester.jete.i.Browsers.IE;
import static com.tester.jete.i.Browsers.INTERNET_EXPLORER;
import static com.tester.jete.i.Browsers.LEGACY_FIREFOX;
import static com.tester.jete.i.Browsers.OPERA;
/**
 * @ClassName Browser
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 19:04
 */
public class Browser {
    public final String name;
    public final boolean headless;

    public Browser(String name, boolean headless) {
        this.name = name;
        this.headless = headless;
    }

    public boolean isHeadless() {
        return headless;
    }

    public boolean isChrome() {
        return CHROME.equalsIgnoreCase(name);
    }

    public boolean isFirefox() {
        return FIREFOX.equalsIgnoreCase(name);
    }

    public boolean isLegacyFirefox() {
        return LEGACY_FIREFOX.equalsIgnoreCase(name);
    }

    public boolean isIE() {
        return INTERNET_EXPLORER.equalsIgnoreCase(name) || IE.equalsIgnoreCase(name);
    }

    public boolean isEdge() {
        return EDGE.equalsIgnoreCase(name);
    }

    public boolean isOpera() {
        return OPERA.equalsIgnoreCase(name);
    }

    public boolean supportsInsecureCerts() {
        return !isIE() && !isEdge();
    }
}
