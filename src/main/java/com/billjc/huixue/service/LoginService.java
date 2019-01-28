package com.billjc.huixue.service;

import com.billjc.util.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginService {

	/**
	 * 输入员工号密码，登录系统
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @throws Exception 未知异常
	 */
	public void login(WebDriver driver, String username, String password)
			throws Exception {
		// 1、输入员工号密码
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		// 2、暂停2秒
		Thread.sleep(2000);

		// 3、点击【登录】按钮
		// "//*[@id=\"loginForm\"]/div/div[1]/div/input"
		// driver.findElement(By.cssSelector("m_btn submit")).click();

		//找到按钮元素
		String xpath = "//*[@id=\"loginForm\"]/div/div[1]/div/input";
		WebElement addButton = driver.findElement(By.xpath(xpath));

		// 点击按钮
		addButton.click();

		//String spanContent = "武汉教育资源公共服务平台"; // TODO 有4个学生登陆时需要选择平台
//		String spanPath = "//*[@id=\"420100,normal,http://www.wuhaneduyun.cn:10013/aamif/rest,\"]";
//		WebElement spanWebElement = driver.findElement(By.xpath(spanPath));
//		if (null != spanWebElement) {
//			// 选择登陆平台
//			WebElement logoutButton = driver.findElement(By.className("platform-ok"));
//
//			// 点击按钮
//			logoutButton.click();
//		}
		//
		String xpathTotalScore = "/html/body/div[3]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/ul/li/p/span/strong";
		WebElement totalScoreWebElement = driver.findElement(By.xpath(xpathTotalScore));
		System.out.print(username + "\t" + totalScoreWebElement.getText());


		String xpathGetReport = "/html/body/div[3]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/ul/li/a[2]/span";
		WebElement getReportButton = driver.findElement(By.xpath(xpathGetReport));

		// 点击按钮
		getReportButton.click();

		//
		String xpathFrame = "//*[@id=\"mainFrame\"]";
		WebElement frameWebElement = driver.findElement(By.xpath(xpathFrame));

		//System.out.println("frameWebElement： " + frameWebElement);
		//System.out.println("frameWebElement： " + frameWebElement.getText());

		driver.switchTo().frame(frameWebElement);

		String xpathScoreStart = "//*[@id=\"general\"]/div[2]/div/dl/dd/ul/li[";
		String xpathScoreEnd = "]/div/p[1]";
//		for (int i = 1; i < 6; i++) {
//			WebElement englishWebElement = driver.findElement(By.xpath(xpathScoreStart + i + xpathScoreEnd));
//			System.out.print("\t" + englishWebElement.getText());
//		}

		// 2、暂停2秒
		// Thread.sleep(3000);

		//
		//其实，用CSS属性大法，就可以搞定：class=可以支持空格

//		//driver.find_element_by_css_selector("[class='j-inputtext dlemail']").send_keys("yoyo")
//		WebElement rightButton = driver.findElement(By.cssSelector("[class='rightArrow icon_right']"));
//
//		// 点击按钮
//		rightButton.click();

		// ul path //*[@id="general"]/div[2]/div/dl/dd/ul
		// "//*[@id=\"general\"]/div[2]/div/dl/dd/ul";
		//String ulPath ="//*[@id=\"general\"]/div[2]/div/dl/dd";


		WebElement studentReport = driver.findElement(By.id("studentReport"));

		WebElement div1 = studentReport.findElement(By.cssSelector("[class='gs_scoresAnalyze clearfix']"));
		//WebElement ddWebElement = ddWebElement;
		WebElement rightButton = div1.findElement(By.cssSelector("[class='rightArrow icon_right']"));


		WebElement div2 = div1.findElement(By.className("dlWp"));
		WebElement ddWebElement = div2.findElement(By.className("get_grade_wp"));
		if (null != rightButton && null != ddWebElement) {
			// 子元素 class c3cce99 grade
			for (int i = 0; i < 5; i++) {
				String text_1 = ddWebElement.findElements(By.cssSelector("[class='c3cce99 grade']")).get(i)
						.getText();
				System.out.print("\t" + text_1);
			}

			// 点击按钮
			rightButton.click();

			// 2、暂停2秒
			Thread.sleep(3000);

			// 子元素 class c3cce99 grade
			for (int i = 5; i < 9; i++) {
				String text_1 = ddWebElement.findElements(By.cssSelector("[class='c3cce99 grade']")).get(i)
						.getText();
				System.out.print("\t" + text_1);
			}

	//		for (int i = 6; i < 10; i++) {
	//			WebElement englishWebElement = driver.findElement(By.xpath(xpathScoreStart + i + xpathScoreEnd));
	//			System.out.print("\t" + englishWebElement.getText());
	//		}
			System.out.println();
			// /html/body/div[2]/div/div/a[1]/i
			// icon_headerClose
		}

		// 2、暂停2秒
		Thread.sleep(3000);

		driver.switchTo().parentFrame();
		WebElement logoutButton = driver.findElement(By.className("icon_headerClose"));

		// 点击按钮
		logoutButton.click();
	}

	/**
	 * 打开指定页面
	 * 
	 * @param pageUrl 页面路径
	 */
	public void openPage(WebDriver driver, String pageUrl) {
		String baseUrl = PropertyUtil.getValue("config.properties", "huixue_url");// "http://10.100.254.162:8099/common-rbac/function/";
		driver.get(baseUrl + pageUrl);
	}

	public void openPageByLinkText(WebDriver driver, String linkText) {
		// 链接文字
		driver.findElement(By.linkText(linkText)).click();
	}

}
