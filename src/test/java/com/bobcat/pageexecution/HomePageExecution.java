package com.bobcat.pageexecution;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import com.bobcat.baseclass.BaseClass;
import com.bobcat.locators.HomePageLocators;

public class HomePageExecution extends HomePageLocators {
	public static void waitClose() {
		BaseClass.waitForElement(HomePageLocators.waitClose);
		BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.waitClose));
	}

	public static void backoeLoader() {
		BaseClass.waitForElement(HomePageLocators.backoeLoader);
		String head = BaseClass.getTextByElement(HomePageLocators.backoeLoader);
		System.out.println(head);
		BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.backoeLoader));
	}

	public static void backoeLoaderProduct() {
		try {
			Thread.sleep(2000);
//		    BaseClass.impWait();
//			BaseClass.textPresentInElementLocated(HomePageLocators.backoeLoaderProdName, "Bobcat B900 CEV Stage IV Backhoe Loader");
			String name = BaseClass.getTextByElement(HomePageLocators.backoeLoaderProdName);
//			BaseClass.textPresentInElementLocated(HomePageLocators.backoeLoaderProdName, "Operating Wt :7990 Kg");
			String kg = BaseClass.getTextByElement(HomePageLocators.backoeLoaderProdWeight);
//			BaseClass.impWait();
			System.out.println(name + "\t\t" + kg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void loaders() {
		BaseClass.waitForElement(HomePageLocators.loaders);
		String head = BaseClass.getTextByElement(HomePageLocators.loaders);
		System.out.println("\n" + head);
		BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.loaders));
	}

	public static void loadersSkid() {
		try {
			Thread.sleep(2000);
//			BaseClass.waitForElement(HomePageLocators.loadersSkid);
//		    impWait();
			String head = BaseClass.getTextByElement(HomePageLocators.loadersSkid);
			impWait();
			System.out.println(head);
			BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.loadersSkid));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void loadersSkidProductList() {
		try {
			Thread.sleep(4000);
			List<WebElement> name = BaseClass.findElementsBys(HomePageLocators.loadersSkidName);
			List<WebElement> kg = BaseClass.findElementsBys(HomePageLocators.loadersSkidWeight);
			Map<String, String> m = new LinkedHashMap<String, String>();
			for (int i = 0; i < name.size(); i++) {
				String namelist = name.get(i).getText();
				String kglist = kg.get(i).getText();
				m.put(namelist, kglist);
			}
			for (Map.Entry<String, String> entry : m.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				System.out.println(key + "\t\t" + val);
			}
			BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.clickBack));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void loadersCompact() {
		BaseClass.waitForElement(HomePageLocators.loadersCompact);
		String head = BaseClass.getTextByElement(HomePageLocators.loadersCompact);
		System.out.println("\n" + head);
		BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.loadersCompact));
	}

	public static void loadersCompactProductList() {
		try {
			Thread.sleep(4000);
			List<WebElement> name = BaseClass.findElementsBys(HomePageLocators.loadersCompactName);
			List<WebElement> kg = BaseClass.findElementsBys(HomePageLocators.loadersCompactWeight);
			Map<String, String> m = new LinkedHashMap<String, String>();
			for (int i = 0; i < name.size(); i++) {
				String namelist = name.get(i).getText();
				String kglist = kg.get(i).getText();
				m.put(namelist, kglist);
			}
			for (Map.Entry<String, String> entry : m.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				System.out.println(key + "\t\t" + val);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void compactExcavators() {
		BaseClass.waitForElement(HomePageLocators.compactExcavators);
		String head = BaseClass.getTextByElement(HomePageLocators.compactExcavators);
		System.out.println("\n" + head);
		BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.compactExcavators));
	}

	public static void compactExcavatorsProduct() {
		try {
			Thread.sleep(4000);
			List<WebElement> name = BaseClass.findElementsBys(HomePageLocators.compactExcavatorsProdName);
			List<WebElement> kg = BaseClass.findElementsBys(HomePageLocators.compactExcavatorsProdWeight);
			Map<String, String> m = new LinkedHashMap<String, String>();
			for (int i = 0; i < name.size() - 1; i++) {
				String namelist = name.get(i).getText();
				String kglist = kg.get(i).getText();
				m.put(namelist, kglist);
			}
			for (Map.Entry<String, String> entry : m.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				System.out.println(key + "\t\t" + val);
			}
			BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.clickNext));
			String nam = BaseClass.getTextByElement(HomePageLocators.nextName);
			String kgs = BaseClass.getTextByElement(HomePageLocators.nextKg);
			System.out.println(nam + "\t\t" + kgs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void attachments() {
		BaseClass.waitForElement(HomePageLocators.attachment);
		String head = BaseClass.getTextByElement(HomePageLocators.attachment);
		System.out.println("\n" + head);
		BaseClass.clickElement(BaseClass.findElementBy(HomePageLocators.attachment));
	}

	public static void attachmentList() {
		try {
			Thread.sleep(4000);
			List<WebElement> name = BaseClass.findElementsBys(HomePageLocators.attachmentName);
			for (WebElement webElement : name) {
				System.out.println(webElement.getText());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
