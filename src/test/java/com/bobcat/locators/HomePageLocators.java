package com.bobcat.locators;

import org.openqa.selenium.By;

import com.bobcat.baseclass.BaseClass;

public class HomePageLocators extends BaseClass{
	
	public static By waitClose = By.xpath("//div[@id='onetrust-close-btn-container']");
	public static By backoeLoader = By.xpath("//ul[@id='main-nav']//child::li[1]");
	public static By backoeLoaderProdName = By.xpath("(//div[@class='scrollable'])[2]//child::img//following::div[1]");
	public static By backoeLoaderProdWeight = By.xpath("(//div[@class='scrollable'])[2]//child::img//following::p[1]");
	public static By loaders = By.xpath("(//div[@class='container'])[6]/ancestor::li/a");
	public static By loadersSkid = By.xpath("(//div[@class='product-family'])[1]/a/span");
	public static By loadersSkidClick = By.xpath("(//div[@class='product-family'])[1]/a");
	public static By loadersSkidName = By.xpath("(//div[@class='scrollable'])[3]//child::img//following::div[1]");
	public static By loadersSkidWeight = By.xpath("(//div[@class='scrollable'])[3]//child::img//following::p[1]");
	public static By clickBack = By.xpath("(//a[@class='back'])[1]");
	public static By loadersCompact = By.xpath("(//div[@class='product-family'])[2]/a/span");
	public static By loadersCompactName = By.xpath("(//div[@class='scrollable'])[4]//child::img//following::div[1]");
	public static By loadersCompactWeight = By.xpath("(//div[@class='scrollable'])[4]//child::img//following::p[1]");
	public static By compactExcavators = By.xpath("//ul[@id='main-nav']//child::li[3]");
	public static By compactExcavatorsProdName = By.xpath("(//div[@class='scrollable'])[5]//child::img//following::div[1]");
	public static By compactExcavatorsProdWeight = By.xpath("(//div[@class='scrollable'])[5]//child::img//following::p[1]");
	public static By clickNext = By.xpath("(//div[@class='scrollable'])[5]//following::div[16]/child::i[1]");
	public static By nextName = By.xpath("(//div[@class='h5 dtm-pro-grp-lst-name'])[13]");
	public static By nextKg = By.xpath("(//div[@class='h5 dtm-pro-grp-lst-name'])[13]//following-sibling::p");
	public static By attachment = By.xpath("(//div[@class='container'])[8]/ancestor::li/a");
	public static By attachmentName = By.xpath("(//div[@class='scrollable'])[6]/child::div[2]/child::div/div/a/div");
	
}
