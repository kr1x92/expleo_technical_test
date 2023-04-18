package com.xe.framework.stepdifinitions;


import com.xe.framework.pages.CurrencyConverterPage;
import com.xe.framework.utils.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class CurrencyConverterSteps {

    WebDriver driver;
    private CurrencyConverterPage currencyConverterPage;

    @Given("I am on the Currency Converter page and accept cookies")
    public void i_am_on_the_currency_converter_page_and_accept_cookies() {
        driver = WebDriverFactory.getWebDriver();
        currencyConverterPage = new CurrencyConverterPage(driver);
        driver.manage().deleteAllCookies();
        driver.get("http://www.xe.com/currencyconverter/");
        currencyConverterPage.acceptCookies();
    }

    @When("I enter {string} in the amount field")
    public void i_enter_amount_in_the_amount_field(String amount) {
        currencyConverterPage.enterAmount(amount);
    }

    @When("I select {string} from the 'From' currency dropdown")
    public void i_select_from_currency_from_the_from_currency_dropdown(String currency) {
        currencyConverterPage.clickOnFromCurrenciesList();
        currencyConverterPage.selectCurrency(currency);
    }

    @When("I select {string} from the 'To' currency dropdown")
    public void i_select_to_currency_from_the_to_currency_dropdown(String currency) {
        currencyConverterPage.clickOnToCurrenciesList();
        currencyConverterPage.selectCurrency(currency);
    }

    @When("I click on the Convert button")
    public void i_click_on_the_convert_button() {
        currencyConverterPage.clickConvertButton();
    }

    @Then("I should see the converted amount in the result")
    public void i_should_see_the_converted_amount_in_the_result() {
        String result = currencyConverterPage.getResult();
        Assert.assertNotNull(result, "The result is Null. Please, double check the scenario on the website.");
        System.out.println(result);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}