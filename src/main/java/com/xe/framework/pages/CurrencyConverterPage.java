package com.xe.framework.pages;

import com.xe.framework.utils.WaitHelper;
import com.xe.framework.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyConverterPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Accept')]")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//div[@id='yie-overlay-wrapper-749de0f2-3f6e-5008-bf8c-28aa5e076785']//yld-tag-host-campaign")
    public WebElement popUpPromotedToSignup;
    @FindBy(id = "amount")
    public WebElement amountInput;

    @FindBy(xpath = "//input[@id='midmarketFromCurrency']")
    public WebElement fromCurrencySelect;

    @FindBy(xpath = "//input[@id='midmarketToCurrency']")
    public WebElement toCurrencySelect;

    @FindBy(xpath = "//button[normalize-space()='Convert']")
    public WebElement convertButton;

    @FindBy(xpath = "//p[@class='result__BigRate-sc-1bsijpp-1 iGrAod']")
    public WebElement resultLabel;

    public CurrencyConverterPage(WebDriver driver) {
        super(driver);
    }

    // Page-specific methods and utilities
    public void acceptCookies() {
        if (WaitHelper.hasCondition(d -> acceptCookiesButton.isDisplayed(), 1)) {
            acceptCookiesButton.click();
        }
    }

    //ToDo need to implement if popup will often affect the tests results
    //public void closePopup() {}

    public void enterAmount(String amount) {
        amountInput.click();
        amountInput.sendKeys(amount);
    }

    public void clickOnFromCurrenciesList() {
        fromCurrencySelect.click();
    }

    public void clickOnToCurrenciesList() {
        toCurrencySelect.click();
    }

    public void selectCurrency(String currencyValue) {

        String currencyLocatorInDropDownList = String.format("//span[normalize-space()='%s']", currencyValue);
        WebElement currency = WebDriverFactory.getWebDriver().findElement(By.xpath(currencyLocatorInDropDownList));
        currency.click();
    }

    public void clickConvertButton() {
        convertButton.click();
    }

    public String getResult() {
        WaitHelper.waitUntil(d -> resultLabel.isDisplayed(), 2);
        return resultLabel.getText();
    }
}
