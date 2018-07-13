# automated-testing




----------
V20180712
```
Runtime.getRuntime().exec("taskkill /F /im " + "chromedriver.exe");
Runtime.getRuntime().exec("taskkill /F /im " + "chrome.exe");
// 结束进程。以上是用于在发生异常时结束chromedriver进程，避免chromedriver占用内存资源。close()，和quit()方法有时候是无法结束chromedriver进程的。
```


----------
V20180711



1. 新增进入登录页面测试用例
2. 新增输入员工号和密码，进入系统的测试用例



----------

# 基于Selenium 2的自动化测试 - 第3章 + 示例源码(部分) #

https://github.com/selenium2014/selenium2014

20180711




----------


下载chromedriver地址 - ChromeDriver Mirror
http://npm.taobao.org/mirrors/chromedriver/


selenium之 chromedriver与chrome版本映射表（更新至v2.40）
