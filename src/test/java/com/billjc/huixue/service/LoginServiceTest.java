package com.billjc.huixue.service;

import com.billjc.huixue.service.LoginService;
import com.billjc.util.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginServiceTest {

	private WebDriver driver;
	private LoginService loginService;

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverUtil.getDriver();
		loginService = new LoginService();
	}

	@Test
	public void login() throws Exception {
		String loginPageUrl = "";
		loginService.openPage(driver, loginPageUrl);

		String[] students = {
				"1086502957",
				"1002794164",
				"1064431834",//2
//				"1011441251",//2
	//			"1096781798",//2
//				"1035786771",
				"1074684825",
				"1022313842",
				"1037585236",
				"1051451108",
				"1038279609",
				"1033293082",
				"1034474484",
				"1061974525",
				"1089572526", //
				"1030936930",
			//	"1086202556", // TODO 无成绩
				"1052631543",
				"1016665517",
				"1005340883",
				"1010031095",
				"1090271405",
				"1034633278",
				"1026945220",
				"1071433947",
				"1017389994",
				"1082578076",
				"1001899049",
				"1046638709", // Done
				//"1052130705", //　TODO
				"1009083134",
				"1015305826",
				"1086193030",
				"1072216208",
				"1086969942",
				"1020420128",
				"1042064655",
				"1034907138",
				"1007195943",// DONE
				"1078295709",
				"1043218854",
				"1086253398",
				"1033578422",
				"1059594935",
				"1054857108",
				"1040765726",
				"1051784308",
				//"1021641820",// 2
				"1070829680",
				"1015022556",
				"1084958448",
				"1058582334",
				"1003873446",
				"1044213951"
		};

		Thread.sleep(5000);
		String username = "1086502957";
		String password = "12345678";

		for (int i = 0; i < students.length; i++) {
			username = students[i];
			loginService.login(driver, username, password);
			//driver.quit();
		}

		//loginService.login(driver, username, password);

		// Thread.sleep(3000);
		// 项目BSM分配 /PDRC_Project/PDRC_ProjectList
		//String linkText = "项目BSM分配";
		//loginService.openPageByLinkText(driver, linkText);

		// D-00105-20161230-60
		//String projectNewNo = "D-00105-20161230-60";
		//prizeService.dispatchBsm(driver, projectNewNo);

		//prizeService.bsmDetail(driver, projectNewNo);

		//

	}

	@AfterClass
	public void tearDown() throws Exception {
		//Thread.sleep(3000);
		driver.quit();
		//Runtime.getRuntime().exec("taskkill /F /im " + "chromedriver.exe");
		// Runtime.getRuntime().exec("taskkill /F /im " + "chrome.exe");
		// 结束进程。以上是用于在发生异常时结束chromedriver进程，避免chromedriver占用内存资源。close()，和quit()方法有时候是无法结束chromedriver进程的。
	}
}
