package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AmazonHomePage {

	public AmazonHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//if there is an element ID, just create element abstract object
	
	public WebElement twotabsearchtextbox;
	@FindBy(id= "nav-search-submit-button")
	public WebElement searchButton;
	
	//@FindBy (xpath=" a[@href='signInButton']")
	@FindBy(xpath = "//a[text()='Sign in securely']")
	public WebElement signInButton;
	
	@FindBy(id="searchDropdownBox")
	public WebElement departmentsDropdown;
	
	@FindBy (xpath="//span[@class='a-price']//span[@class='a-price-whole']")
	public List <WebElement> itemPrices;
	
	@FindBy (xpath="//span[@class='a-color-state a-text-bold']")
	public WebElement searchedItem;
}

