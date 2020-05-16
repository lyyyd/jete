package com.tester.jete.i;

import com.tester.jete.e.AssertionMode;
import com.tester.jete.e.FileDownloadMode;
import com.tester.jete.e.SelectorMode;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @InterfaceName Config
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 17:24
 */
public interface Config {
    String browser();
    boolean headless();
    String remote();
    String browserSize();
    String browserVersion();
    String browserPosition();
    boolean startMaximized();
    boolean driverManagerEnabled();
    String browserBinary();
    String pageLoadStrategy();
    DesiredCapabilities browserCapabilities();

    String baseUrl();
    long timeout();
    long pollingInterval();
    boolean holdBrowserOpen();
    boolean reopenBrowserOnFail();
    boolean clickViaJs();
    boolean screenshots();
    boolean savePageSource();
    String reportsFolder();
    String downloadsFolder();
    String reportsUrl();
    boolean fastSetValue();
    boolean versatileSetValue();
    SelectorMode selectorMode();
    AssertionMode assertionMode();
    FileDownloadMode fileDownload();
    boolean proxyEnabled();
    String proxyHost();
    int proxyPort();
}
