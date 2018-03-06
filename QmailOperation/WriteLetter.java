package QmailOperation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteLetter {
	private WebDriver driver;
	private WebElement sendButton;
	private WebElement toUser;
	private WebElement title;
	private WebElement content;
	
	public WriteLetter(WebDriver driver){
		this.driver=driver;
		driver.switchTo().frame("mainFrame");//整个写信页面
//		sendButton=driver.findElement(By.linkText("发送")); //此处获得的发送按钮，在后面使用会报错，这里选择在后面重新去获取
		toUser=driver.findElement(By.xpath(".//*[@id='toAreaCtrl']/div[2]/input"));//从根节点找id=toAreaCtrl下的第二个div下的input
		title=driver.findElement(By.id("subject"));
	}
	
	//写信
	public void writeLetter(ArrayList<String> toUsers,String tiltle,String Content){
		for(String user:toUsers)
		{
			toUser.sendKeys(user);
		}
		title.sendKeys(tiltle);
		
		//此处一定要强制等待，不然输入指针加载不到写信的框中，会直接输入到标题栏
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));//写信区域在mainFrame的子frame中
		content=driver.findElement(By.tagName("body"));
		content.sendKeys(Content);
		
		driver.switchTo().parentFrame();//退出内容编辑的iframe

		//在第一次进入mianFrame中获得的发送按钮链接，在此处使用，会报错，所以在此处退回到mainFrame，再去获取发送按钮
		sendButton=driver.findElement(By.linkText("发送"));
		System.out.println("开始发送");
		sendButton.click();
		
	}
}
