package com.bobcat.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter reportPath;
	public static ExtentReports extend;

	@BeforeClass
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		reportPath = new ExtentHtmlReporter("./automationreport.html");
		extend = new ExtentReports();
		extend.attachReporter(reportPath);
	}

	public static void getUrl(String url) {
		driver.get(url);
	}
	
	@After
	public void after() {
		extend.flush();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}

	public static WebElement byId(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement byName(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement byXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	// abstract method
	public static WebElement findElementBy(By by) {
		return driver.findElement(by);
	}

	public static void inputData(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void clickElement(WebElement element) {
		element.click();
	}

	public static void clearElement(WebElement element) {
		element.clear();
	}

	public static String getAttributeByValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public static void dropdownByIndex(WebElement element, int values) {
		Select s = new Select(element);
		s.selectByIndex(values);
	}

	public static void dropdownByValue(WebElement element, String values) {
		Select s = new Select(element);
		s.selectByValue(values);
	}

	public static void dropdownByVisibleText(WebElement element, String values) {
		Select s = new Select(element);
		s.selectByVisibleText(values);
	}

	public static void movetoElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static void windowHandle(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li = new LinkedList<String>(windowHandles);
		driver.switchTo().window(li.get(i));
	}

	public static void scrollToPageEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToPageTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public static String getAttribute(WebElement element, String... attribute) {
		String text = attribute.length < 1 ? "value" : attribute[0];
		String attributevalue = null;
		try {
			attributevalue = text;
		} catch (NullPointerException e) {
			throw new RuntimeException("Warning : Failure detected when requesting the element property:value");
		}
		return attributevalue;
	}

	@AfterClass
	public static void screenShot() {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File("location" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void impWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void expWaitElementClickable(WebElement element) {
		WebDriverWait exp = new WebDriverWait(driver, 30);
		exp.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void textPresentInElementLocated(By by, String s) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, s));
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public static String excelRead(int r, int c) {
		String value = null;
		try {
			File f = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\UserDetail\\AdactinUserDetail.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
//				System.out.println(value);
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sc = new SimpleDateFormat("dd-MM-yyyy");
					value = sc.format(dateCellValue);
//					System.out.println(value);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
//					System.out.println(value);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void excelwrite(String value) {
		try {
			File f = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\UserDetail\\AdactinUserDetail.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet cs = wb.getSheet("Sheet1");
			Row cr = cs.createRow(12);
			Cell cc = cr.createCell(0);
			cc.setCellValue("Order Number");
			Row r = cs.createRow(13);
			Cell c = r.createCell(0);
			c.setCellValue(value);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String propertyFile(String value) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		String data = null;
		try {
			File f = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\UserDetail\\UserCredential.properties");
			FileReader read = new FileReader(f);
			Properties prop = new Properties();
			prop.load(read);
			data = (String) prop.getProperty(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public static String getTextByElement(By by) {
		WebElement findElement = driver.findElement(by);
		return findElement.getText();
	}
	
	public static List<WebElement> findElementsBys(By by) {
		List<WebElement> findElements = driver.findElements(by);
		return findElements;
	}
	
}

