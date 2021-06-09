package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class demoqa_page {
	public  demoqa_page() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
@FindBy (id= "alertButton")
public WebElement firstAlert;

@FindBy (id="timerAlertButton")
public WebElement secondAlert;

@FindBy (id="confirmButton")
public WebElement thirdAlert;

@FindBy (id="promtButton")
public WebElement fourthAlert;

}

