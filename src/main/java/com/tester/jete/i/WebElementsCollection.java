package com.tester.jete.i;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @InterfaceName WebElementsCollection
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 17:45
 */
public interface WebElementsCollection {
    /**
     * get elements of this collection (probably cached).
     */
    List<WebElement> getElements();

    String description();

    Driver driver();
}
