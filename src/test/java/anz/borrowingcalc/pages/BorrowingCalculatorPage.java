package anz.borrowingcalc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import anz.borrowingcalc.library.ThinkTime;
import anz.borrowingcalc.pagefactory.AnzBorrowingCalcPageFactory;
import junit.framework.Assert;

public class BorrowingCalculatorPage {

	WebDriver driver = null;
	private AnzBorrowingCalcPageFactory pageFactory;
	private ThinkTime thinkTime;

	/*
	 * Constructor declaration
	 * 
	 * 
	 */
	public BorrowingCalculatorPage() {

	}

	/*
	 * This method initializes the Webdriver
	 * 
	 * 
	 * 
	 */
	public BorrowingCalculatorPage(WebDriver driver) {

		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, AnzBorrowingCalcPageFactory.class);
		thinkTime = new ThinkTime();
	}

	/*
	 * This method selects the values  and enter the values on borrowing calculator page.
	 * 
	 * 
	 * 
	 */

	public void enterBorrowingCalcDetails(String appType, String dependants, String propType, String income,
			String otherIncome, String expenses, String homeLoanRepayments, String otherLoanRepayments,
			String commitments, String creditCardLimit) {
		pageFactory.single.click();
		pageFactory.dependants.click();
		Select drpDependants = new Select(pageFactory.dependants);
		drpDependants.selectByVisibleText(dependants);
		pageFactory.home.click();
		pageFactory.your_income.sendKeys(income);
		pageFactory.other_income.sendKeys(otherIncome);
		pageFactory.expenses.sendKeys(expenses);
		pageFactory.homeloan.sendKeys(homeLoanRepayments);
		pageFactory.otherloans.sendKeys(otherLoanRepayments);
		pageFactory.commitments.sendKeys(commitments);
		pageFactory.credit.sendKeys(creditCardLimit);
	}

	/*
	 * This method clicks the borrowing calculation button
	 * 
	 */
	public void clickBorrowCalcBtn() throws InterruptedException {
		pageFactory.borrowcalculatorBtn.click();
		Thread.sleep(4000);
	}

	/*
	 * This method is for asserting the actual value with the expected value.
	 * 
	 */
	public void validateBorrowCapacity(String expectedBorrowingCapacity) {
		Assert.assertTrue(expectedBorrowingCapacity.equalsIgnoreCase(pageFactory.borrowingCapacityResult.getText()));
	}

	/*
	 * This method is to click on the start over button
	 * 
	 */
	public void clickOnStartOver() {
		thinkTime.waitUntillElementClickable(driver, driver.findElement(
				By.xpath("//div[@class='borrow__result text--white clearfix']//div[@class='box--right']")));
		driver.findElement(
				By.xpath("//div[@class='borrow__result text--white clearfix']//div[@class='box--right']")).click();
	}
	
	/*
	 * This method is to do the assertion on the page with actual and expected once the start over button is clicked
	 */
	public void validateStartOverDetails() {
	
		Assert.assertEquals("",pageFactory.your_income.getText());
		Assert.assertEquals("",pageFactory.other_income.getText());
		Assert.assertEquals("",pageFactory.expenses.getText());
		Assert.assertEquals("",pageFactory.homeloan.getText());
		Assert.assertEquals("",pageFactory.otherloans.getText());
		Assert.assertEquals("",pageFactory.commitments.getText());
		Assert.assertEquals("",pageFactory.credit.getText());
	}
	

}
