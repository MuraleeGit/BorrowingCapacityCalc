package anz.borrowingcalc.steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anz.borrowingcalc.library.GetConfigProperties;
import anz.borrowingcalc.library.SetDrivers;
import anz.borrowingcalc.pagefactory.AnzBorrowingCalcPageFactory;
import anz.borrowingcalc.pages.BorrowingCalculatorPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StepDefinition {

	public static Logger log = LogManager.getLogger(StepDefinition.class.getName());

	/*
	 * Constructor declaration
	 * 
	 */
	public StepDefinition() {

	}

	WebDriver driver;

	AnzBorrowingCalcPageFactory anzBorrowingCalcPageFactory;
	@Steps
	BorrowingCalculatorPage borrowingCalculatorPage;

	GetConfigProperties getProps = new GetConfigProperties();
	SetDrivers setDrivers = new SetDrivers();
	Properties prop = new Properties();

	/*
	 * This method initializes the webdriver and login in to ANZ borrowing
	 * calculation page
	 * 
	 * 
	 */
	@Before
	public void init() {
		prop = getProps.getConfigProperty();
		String runEnv = System.getProperty("runEnv");
		driver = setDrivers.setDrivers(runEnv);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("ANZ Init");
	}

	@Given("^User is on how much could I borrow page$")
	public void user_is_on_how_much_could_I_borrow_page() {
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("I am in ANZ borrowing calculator page");
	}

	@When("^User enters borrowing calculation details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")

	public void user_enters_borrowing_calculation_details(String appType, String dependants, String propType,
			String income, String otherIncome, String expenses, String homeLoanRepayments, String otherLoanRepayments,
			String commitments, String creditCardLimit) {

		borrowingCalculatorPage = new BorrowingCalculatorPage(driver);
		borrowingCalculatorPage.enterBorrowingCalcDetails(appType, dependants, propType, income, otherIncome, expenses,
				homeLoanRepayments, otherLoanRepayments, commitments, creditCardLimit);
		log.info("Entering borrowing calculation details");
	}

	@When("^I click on how much I could borrow button$")

	public void i_click_on_how_much_i_could_borrow_button() throws InterruptedException {
		borrowingCalculatorPage.clickBorrowCalcBtn();
		log.info("click on how much I could borrow buttons");
	}

	@Then("^I validate borrowing capacity details$")

	public void i_validate_borrowing_capacity_details() {
		String expectedBorrowingCapacity = prop.getProperty("expectedBorrowingCapacity");
		borrowingCalculatorPage.validateBorrowCapacity(expectedBorrowingCapacity);
		log.info("validate borrowing capacity details");
	}

	@And("^I click on start over button$")

	public void i_click_on_start_over_button() throws InterruptedException {
		
		borrowingCalculatorPage.clickOnStartOver();
		log.info("click on start over button");
	}

	@Then("^I validate for reset calculation details$")

	public void i_validate_for_reset_calculation_details() {
		borrowingCalculatorPage.validateStartOverDetails();
		log.info("validate for reset calculation details");
	}

	@After
	public void quitBrowsers() {
		driver.quit();
		log.info("Quit Browser");
	}

}
