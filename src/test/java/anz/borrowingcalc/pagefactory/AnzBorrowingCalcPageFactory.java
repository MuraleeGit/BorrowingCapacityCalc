package anz.borrowingcalc.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Global file for locating the elements for ANZ Borrowing calculator page
 * 
 * @author Muralee
 *
 */
public class AnzBorrowingCalcPageFactory {

	@FindBy(css = "label[for='application_type_single']")
	public WebElement single;

	@FindBy(css = "select[title='Number of dependants']")
	public WebElement dependants;

//	@FindBy(xpath = "//select[contains(@title,'Number of dependants')]")
//	public WebElement dependents;

	@FindBy(css = "label[for='borrow_type_home']")
	public WebElement home;

	@FindBy(xpath = "//label[normalize-space()='Residential investment']")
	public WebElement residential;

	@FindBy(xpath = "//input[@aria-labelledby='q2q1']")
	public WebElement your_income;
	
	@FindBy(xpath = "//input[@aria-labelledby='q2q2']")
	public WebElement other_income;

	@FindBy(css = "#expenses")
	public WebElement expenses;

	@FindBy(css = "#homeloans")
	public WebElement homeloan;

	@FindBy(css = "#otherloans")
	public WebElement otherloans;

	@FindBy(xpath = "//input[@aria-labelledby='q3q4']")
	public WebElement commitments;

	@FindBy(css = "#credit")
	public WebElement credit;

	@FindBy(css = "#btnBorrowCalculater")
	public WebElement borrowcalculatorBtn;
	
	@FindBy(css = "span#borrowResultTextAmount")
	public WebElement borrowingCapacityResult;
	
	@FindBy(xpath = "//button[contains(text(),'Start over')]")
	public WebElement startOverBtnOld;
	
	//this is just a trial
	@FindBy(xpath = "//div[@class='borrow__result text--white clearfix']//div[@class='box--right']")
	//@FindBy(css = "a.start-over")
	public WebElement startOverBtn;
}
