package com.tester.jete.i;

/**
 * @InterfaceName Browsers
 * @Description Constants for all browsers supported by Jete out of the box
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 17:16
 */
public interface Browsers {
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    public static final String INTERNET_EXPLORER = "internet explorer";
    public static final String EDGE = "edge";
    public static final String FIREFOX = "firefox";
    /*
     * @Description //It is only supported for some ESR versions of Firefox up to ESR 52
     * @Date 2020/05/16 17:17
     * @param null
     * @return
     */
    public static final String LEGACY_FIREFOX = "legacy_firefox";
    /*
     * @Description //To use OperaDriver, you need to include extra dependency to your project: &lt;dependency org="com.opera" name="operadriver" rev="1.5" conf="test-&gt;default"/&gt;
     * @Date 2020/05/16 17:17
     * @param null
     * @return
     */
    public static final String OPERA = "opera";
}
