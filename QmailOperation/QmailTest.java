package QmailOperation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QmailTest {
	private  ArrayList<String> toUsers=new ArrayList<String>();
	private  String title;
	private  String Content;
	private  static WebDriver webdriver;
	
	static{
		 System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 webdriver = new FirefoxDriver();
		// webdriver.getWindowHandle(); //这里不用使用句柄操作
		 webdriver.get("https://mail.qq.com/");
		 webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void setContent(){
		toUsers.add("2971775661@qq.com");
		title="Selenium-LoginTest";
		Content="1001110110011101001111101010110101101110100110001";
	}
	public void run(){
		setContent();
		Selenium_login sl=new Selenium_login();
		sl.login(webdriver);
		System.out.println("登录成功");
	
		Mainpage mainpage=new Mainpage(webdriver);
		mainpage.toWrite();
		WriteLetter starWriteletter=new WriteLetter(webdriver);
		starWriteletter.writeLetter(toUsers, title, Content);
	}
	public static void main(String[] args) {
		new QmailTest().run();
		System.out.println(webdriver.getPageSource());

	}
}
