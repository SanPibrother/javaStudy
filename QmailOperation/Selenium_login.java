package QmailOperation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
/*
 * 使用Selenium来登录qq邮箱，并发送邮件
 * 注意，有的操作之间要设置等待：有三种，隐式，显示，Thread.sleep，需要等浏览器将元素加载出来
 * 对于进入一个Frame，注意后面的操作，需不需出Frame，才能定位到元素进行其它操作（如：邮箱登录后，一定要跳出登录的Frame，不然webDriver无法获得登录后面的页面内容）
 * 对于自动打开新的一个网页的情况，需要进行句柄操作
 * 对于Xpath定位，可以直接通过浏览器复制选项中获得
 * 如果不想让浏览器打开的操作（slenium支持无界面操作，HtmlUnit（对js不大好）和PhantomJs，效率比较快）：htmlUnit是java实现的类浏览器程序，包含在selenium server中，无须驱动，直接实例化就行。
 */
public class Selenium_login {
	
	public void login(WebDriver webdriver){
		 //登录框在一个Frame中，所以需要下面这一句，否则找不到对应的登录框元素
		 webdriver.switchTo().frame("login_frame");
		 //选择账号密码登录
		 webdriver.findElement(By.id("switcher_plogin")).click();
		 //账号密码输入
		 WebElement userName = webdriver.findElement(By.id("u"));
		 WebElement passWord = webdriver.findElement(By.id("p"));
		 userName.clear();
		 passWord.clear();
		 userName.sendKeys("1402369208@qq.com");
		 passWord.sendKeys("@zb19921010zb@");
		 System.out.println("等待浏览器加载");
//		 webdriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS); //隐式等待3s
		 webdriver.findElement(By.id("login_button")).click();
		 //前面先进入了frame中，所以这一步很重要，不然跳不出来，得不到后面的内容
		 webdriver.switchTo().defaultContent();
		 System.out.println("浏览器登录中。。。");



	}
	
}
