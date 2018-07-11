package com.billjc.pdrc.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.billjc.pdrc.util.PropertyUtil;

public class LoginService {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 打开登录页面
	 */
	public void openLoginPage() {
		String baseUrl = PropertyUtil.getValue("config.properties", "base_url");// "http://10.100.254.162:8099/common-rbac/function/";
		driver.get(baseUrl);
	}

	/**
	 * 输入员工号密码，登录系统
	 * 
	 * @param workId
	 * @param password
	 * @throws Exception
	 */
	public void login(String workId, String password) throws Exception {
		// 1、输入员工号密码
		driver.findElement(By.id("SignName")).clear();
		driver.findElement(By.id("SignName")).sendKeys(workId);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);

		// 2、暂停2秒
		Thread.sleep(2000);

		// 3、点击【登录】按钮
		driver.findElement(By.id("btn_SignIn")).click();
	}

}
