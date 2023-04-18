package com.xe.framework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverFactory {

    private static WebDriver DRIVER;

    public static WebDriver getWebDriver() {
        if (DRIVER == null) {
            DRIVER = initDriver();
        }
        return DRIVER;
    }

    private static WebDriver initDriver() {
        Duration duration = Duration.ofSeconds(10);
        long timeout = duration.toSeconds();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
