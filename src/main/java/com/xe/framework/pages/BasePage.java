package com.xe.framework.pages;

import com.xe.framework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
        this.driver = driver;
    }
}