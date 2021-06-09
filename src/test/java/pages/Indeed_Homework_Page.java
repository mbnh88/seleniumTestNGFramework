package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class Indeed_Homework_Page {
	public Indeed_Homework_Page(){
	PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id="text-input-what")
	public WebElement whatInput;
	
	@FindBy (id="text-input-where")
	public WebElement whereInput;
	
	@FindBy (xpath="//button[@class='icl-Button icl-Button--primary icl-Button--md icl-WhatWhere-button']")
	public WebElement searchButton;
	
	@FindBy (id="jobsInLocation")
	public WebElement jobsInLocation;
	
	@FindBy (xpath="//a[@class='jobtitle turnstileLink ']")
	public List <WebElement> searchResultTitle;
}
