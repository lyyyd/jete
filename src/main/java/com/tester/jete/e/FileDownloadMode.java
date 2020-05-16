package com.tester.jete.e;

/**
 * @EnumName FileDownloadMode
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 17:29
 */
public enum FileDownloadMode {
    /**
     * Download files via direct http request.
     * Works only for {@code <a href></a>} elements.
     * Sends GET request to "href" with all cookies from current browser session.
     */
    HTTPGET,

    /**
     * Download files via selenide embedded proxy server.
     * Works for any elements (e.g. form submission).
     * Doesn't work if you are using custom webdriver without selenide proxy server.
     */
    PROXY
}
