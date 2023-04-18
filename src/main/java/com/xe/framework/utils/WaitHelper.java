package com.xe.framework.utils;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    public static <T> boolean hasCondition(Function<WebDriver, T> condition, long timeoutInSeconds) {
        try {
            waitUntil(condition, timeoutInSeconds);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static <T> T waitUntil(Function<WebDriver, T> condition, long timeoutInSeconds) {
        return webDriverWait(timeoutInSeconds).until(condition);
    }

    private static WebDriverWait webDriverWait(long timeoutInSeconds) {
        try {
            WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), (timeoutInSeconds));
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(ElementNotInteractableException.class);
            return wait;
        } finally {
            WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
