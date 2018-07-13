package com.billjc.pdrc.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrizeService {

	public void dispatchBsm(WebDriver driver, String projectNewNo) {

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");
		// 1、根据项目编号找到记录行

		// Table table = new Table(driver);
		// By by = By.id("myTable");
		// String address = "0.2";
		//
		// System.out.println(table.getCellText(by, address));
		//
		WebElement tableElement1 = driver
				.findElement(By.xpath(".//*[@id=\"tbody\"]"));
		System.out.println("tableElement1: " + tableElement1);

		// WebElement child = driver.findElement(By.linkText("P06211624"));
		//
		WebElement tableElement2 = driver
				.findElement(By.xpath("//*[@id=\"grid\"]"));
		System.out.println("tableElement2: " + tableElement2);
		List<WebElement> rows = tableElement1.findElements(By.tagName("tr"));
		System.out.println("rows size: " + rows.size());
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				System.out.print(cols.get(j).getText() + "\t");

				// *[@id="tbody"]/tr[2]/td[11]/a
			}
			String col1String = cols.get(1).getText();
			System.out.println("i" + i + "; col1String: " + col1String);
			int index = i + 1;
			if (projectNewNo.equals(col1String)) {

				// 链接文字
				String xpath = ".//*[@id=\"tbody\"]/tr[" + index + "]/td[11]/a";
				WebElement child = driver.findElement(By.xpath(xpath));// .click();
				child.click();
				break;
			}
			System.out.println("");
		}

		// String linkText = "分配BSM ";
		// // 链接文字
		// WebElement child = driver.findElement(By.linkText(linkText));//
		// .click();
		// System.out.println("child: " + child);
	}

	// B-33161
	// driver.findElement(By.xpath("//span[text()='确定']")) grid1
	public void bsmDetail(WebDriver driver, String projectNewNo) {

		// 进入id=""frame_content""的frame中
		// driver.switchTo().frame("frame_content");
		// 1、根据项目编号找到记录行

		// Table table = new Table(driver);
		// By by = By.id("myTable");
		// String address = "0.2";
		//
		// System.out.println(table.getCellText(by, address));
		//
		WebElement tableElement1 = driver
				.findElement(By.xpath(".//*[@id=\"grid1\"]"));
		System.out.println("tableElement1: " + tableElement1);

		// WebElement child = driver.findElement(By.linkText("P06211624"));
		//
		List<WebElement> rows = tableElement1.findElements(By.tagName("tr"));
		System.out.println("rows size: " + rows.size());
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			System.out.println("cols size: " + cols.size());
			for (int j = 0; j < cols.size(); j++) {
				System.out.print(j + ":" + cols.get(j).getText() + "\t");

				// *[@id="tbody"]/tr[2]/td[11]/a
			}
			// String col1String = cols.get(1).getText();
			// System.out.println("i" + i + "; col1String: " + col1String);
			// int index = i + 1;
			// if (projectNewNo.equals(col1String)) {
			// // 链接文字
			// String xpath = ".//*[@id=\"tbody\"]/tr[" + index + "]/td[11]/a";
			// WebElement child = driver.findElement(By.xpath(xpath));//
			// .click();
			// child.click();
			// }
			System.out.println("");
		}

		List<WebElement> tbodys = tableElement1
				.findElements(By.tagName("tbody"));
		System.out.println("tbodys size: " + tbodys.size());
		for (int i = 0; i < tbodys.size(); i++) {
			List<WebElement> tbodyTrs = tbodys.get(i)
					.findElements(By.tagName("tr"));
			System.out.println("rows size: " + tbodyTrs.size());
			for (int k = 0; k < tbodyTrs.size(); k++) {
				List<WebElement> cols = tbodyTrs.get(k)
						.findElements(By.tagName("td"));
				System.out.println("cols size: " + cols.size());
				// for (int j = 0; j < cols.size(); j++) {
				// System.out.print(j + ":" + cols.get(j).getText() + "\t");
				//
				// // *[@id="tbody"]/tr[2]/td[11]/a
				// }

				// 预计退出项目日期*
				WebElement webElement0 = cols.get(0);

				String workId = "";// .get(0).getText();
				// String workId = webElement0.getText();
				// System.out.println("webElement0: " + webElement0.getText());
				WebElement cols00 = webElement0
						.findElement(By.className("controls"));
				WebElement webElement00 = cols00
						.findElement(By.className("select2-choice"));
				// WebElement webElement000 = webElement00.get(0)
				// .findElement(By.className("select2-choice"));
				// System.out.println("webElement00: " +
				// webElement00.getText());
				workId = webElement00.getText();

				// 名字
				WebElement webElement1 = cols.get(1);
				String name = webElement1.getText();

				// 预计退出项目日期*
				WebElement webElement2 = cols.get(2);
				String projectReleaseDateTime = webElement2
						.findElements(By.tagName("input")).get(0)
						.getAttribute("value");
				// 评价( 标准人)
				WebElement webElement3 = cols.get(3);
				String bSM = webElement3.findElements(By.tagName("input"))
						.get(0).getAttribute("value");

				// 质量分
				WebElement webElement4 = cols.get(4);
				String quality = webElement4.findElements(By.tagName("input"))
						.get(0).getAttribute("value");

				// 历史EV
				WebElement webElement5 = cols.get(5);
				String historyEV = webElement5.findElements(By.tagName("input"))
						.get(0).getAttribute("value");
				System.out.println(
						workId + ":" + name + ":" + projectReleaseDateTime + ":"
								+ bSM + ":" + quality + ":" + historyEV);

				// String col1String = cols.get(1).getText();
				// System.out.println("i" + i + "; col1String: " + col1String);
				// int index = i + 1;
				// if (projectNewNo.equals(col1String)) {
				// // 链接文字
				// String xpath = ".//*[@id=\"tbody\"]/tr[" + index +
				// "]/td[11]/a";
				// WebElement child = driver.findElement(By.xpath(xpath));//
				// .click();
				// child.click();
				// }
				// System.out.println("");
			}
		}

		// String linkText = "分配BSM ";
		// // 链接文字
		// WebElement child = driver.findElement(By.linkText(linkText));//
		// .click();
		// System.out.println("child: " + child);
	}

}
